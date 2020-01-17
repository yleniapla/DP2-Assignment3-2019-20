package it.polito.dp2.BIB.sol3.service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.ws.rs.core.UriInfo;

import it.polito.dp2.BIB.ass3.DestroyedBookshelfException;
import it.polito.dp2.BIB.ass3.ServiceException;
import it.polito.dp2.BIB.ass3.UnknownItemException;
import it.polito.dp2.BIB.sol3.db.BadRequestInOperationException;
import it.polito.dp2.BIB.sol3.db.ConflictInOperationException;
import it.polito.dp2.BIB.sol3.db.DB;
import it.polito.dp2.BIB.sol3.db.ItemPage;
import it.polito.dp2.BIB.sol3.db.Neo4jDB;
import it.polito.dp2.BIB.sol3.service.jaxb.Citation;
import it.polito.dp2.BIB.sol3.service.jaxb.Item;
import it.polito.dp2.BIB.sol3.service.jaxb.Items;
import it.polito.dp2.BIB.sol3.service.jaxb.MyBookshelfType;
import it.polito.dp2.BIB.sol3.service.jaxb.MyBookshelves;
import it.polito.dp2.BIB.sol3.service.util.ResourseUtils;

public class BiblioService {
	private DB n4jDb = Neo4jDB.getNeo4jDB();
	private static Map<String, MyBookshelfType> bs = new HashMap<String, MyBookshelfType>();
	ResourseUtils rutil;


	public BiblioService(UriInfo uriInfo) {
		rutil = new ResourseUtils((uriInfo.getBaseUriBuilder()));
	}
	
	public synchronized Items getItems(SearchScope scope, String keyword, int beforeInclusive, int afterInclusive, BigInteger page) throws Exception {
		ItemPage itemPage = n4jDb.getItems(scope,keyword,beforeInclusive,afterInclusive,page);

		Items items = new Items();
		List<Item> list = items.getItem();
		
		Set<Entry<BigInteger,Item>> set = itemPage.getMap().entrySet();
		for(Entry<BigInteger,Item> entry:set) {
			Item item = entry.getValue();
			rutil.completeItem(item, entry.getKey());
			list.add(item);
		}
		items.setTotalPages(itemPage.getTotalPages());
		items.setPage(page);
		return items;
	}

	public synchronized Item getItem(BigInteger id) throws Exception {
			Item item = n4jDb.getItem(id);
			if (item!=null)
				rutil.completeItem(item, id);
			return item;
	}

	public synchronized Item updateItem(BigInteger id, Item item) throws Exception {
		Item ret = n4jDb.updateItem(id, item);
		if (ret!=null) {
			rutil.completeItem(item, id);
			return item;
		} else
			return null;
	}

	public synchronized Item createItem(Item item) throws Exception {
		BigInteger id = n4jDb.createItem(item);
		if (id==null)
			throw new Exception("Null id");
		rutil.completeItem(item, id);
		return item;
	}

	public synchronized BigInteger deleteItem(BigInteger id) throws ConflictServiceException, Exception {
		try {
			return n4jDb.deleteItem(id);
		} catch (ConflictInOperationException e) {
			throw new ConflictServiceException();
		}
	}

	public synchronized Citation createItemCitation(BigInteger id, BigInteger tid, Citation citation) throws Exception {
		try {
			return n4jDb.createItemCitation(id, tid, citation);
		} catch (BadRequestInOperationException e) {
			throw new BadRequestServiceException();
		}
	}

	public synchronized Citation getItemCitation(BigInteger id, BigInteger tid) throws Exception {
		Citation citation = n4jDb.getItemCitation(id,tid);
		if (citation!=null)
			rutil.completeCitation(citation, id, tid);
		return citation;
	}

	public synchronized boolean deleteItemCitation(BigInteger id, BigInteger tid) throws Exception {
		return n4jDb.deleteItemCitation(id, tid);
	}

	public synchronized Items getItemCitations(BigInteger id) throws Exception {
		ItemPage itemPage = n4jDb.getItemCitations(id, BigInteger.ONE);
		if (itemPage==null)
			return null;

		Items items = new Items();
		List<Item> list = items.getItem();
		
		Set<Entry<BigInteger,Item>> set = itemPage.getMap().entrySet();
		for(Entry<BigInteger,Item> entry:set) {
			Item item = entry.getValue();
			rutil.completeItem(item, entry.getKey());
			list.add(item);
		}
		items.setTotalPages(itemPage.getTotalPages());
		items.setPage(BigInteger.ONE);
		return items;
	}

	public synchronized Items getItemCitedBy(BigInteger id) throws Exception {
		ItemPage itemPage = n4jDb.getItemCitedBy(id, BigInteger.ONE);
		if (itemPage==null)
			return null;

		Items items = new Items();
		List<Item> list = items.getItem();
		
		Set<Entry<BigInteger,Item>> set = itemPage.getMap().entrySet();
		for(Entry<BigInteger,Item> entry:set) {
			Item item = entry.getValue();
			rutil.completeItem(item, entry.getKey());
			list.add(item);
		}
		items.setTotalPages(itemPage.getTotalPages());
		items.setPage(BigInteger.ONE);
		return items;
	}

	public synchronized MyBookshelfType createBookshelf(String name) throws Exception {
		
		MyBookshelfType b = new MyBookshelfType();
		b.setName(name);
		b.setReads(0);
		bs.put(b.getName(), b);
		return b;		
	}
		
	public synchronized MyBookshelves getBookshelves(String name) throws ServiceException {
		MyBookshelves list = new MyBookshelves();
		
		for(MyBookshelfType b : bs.values()){
			if(b.getName().contains(name))
				list.getShelf().add(b);
		}
		
		if(!list.getShelf().isEmpty()){
			return list;
		}
		else
			throw new ServiceException();
	}
	
	public synchronized void addItemToBookshelf (String item, String name) throws Exception{
		
		if(bs.get(name)!=null){
			MyBookshelfType b = bs.get(name);
			b.getShelfItem().add(item);
		}
		else
			throw new DestroyedBookshelfException();
	}
		
	public synchronized boolean deleteBookshelf (String name) throws DestroyedBookshelfException, ServiceException {
		
		if(bs.get(name)!=null){
			bs.remove(name);
			return true;
		}
		else
			throw new DestroyedBookshelfException();
	}
	
	public synchronized int getBookshelfReads (int bs_name) throws DestroyedBookshelfException, ServiceException {
		
		if(bs.get(bs_name)!=null){
			MyBookshelfType x = bs.get(bs_name);
			return x.getReads();
		}
		else
			throw new DestroyedBookshelfException();
		
	}
	
	public synchronized void deleteItemFromBookshelf (String bs_name, String item) throws Exception {
		
		if(bs.get(bs_name)!=null){
			MyBookshelfType x = bs.get(bs_name);
			
			if(!x.getShelfItem().contains(item))
				throw new UnknownItemException();
			
			x.getShelfItem().remove(item);
		}
		else
			throw new DestroyedBookshelfException();
		
	}
	
	public synchronized List<String> getItemsFromBookshelf (String bs_name) throws Exception {
		if(bs.get(bs_name)!=null){
			MyBookshelfType x = bs.get(bs_name);
			return x.getShelfItem();
		}
		else
			throw new DestroyedBookshelfException();
	}
			
	
}
