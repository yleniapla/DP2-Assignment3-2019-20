package it.polito.dp2.BIB.sol3.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.ws.rs.core.UriInfo;

import it.polito.dp2.BIB.sol3.db.BadRequestInOperationException;
import it.polito.dp2.BIB.sol3.db.ConflictInOperationException;
import it.polito.dp2.BIB.sol3.db.DB;
import it.polito.dp2.BIB.sol3.db.ItemPage;
import it.polito.dp2.BIB.sol3.db.MyLocalDB;
import it.polito.dp2.BIB.sol3.db.Neo4jDB;
import it.polito.dp2.BIB.sol3.service.jaxb.Citation;
import it.polito.dp2.BIB.sol3.service.jaxb.Item;
import it.polito.dp2.BIB.sol3.service.jaxb.Items;
import it.polito.dp2.BIB.sol3.service.jaxb.MyBookshelfType;
import it.polito.dp2.BIB.sol3.service.jaxb.MyBookshelves;
import it.polito.dp2.BIB.sol3.service.util.ResourseUtils;

public class BiblioService {
	private DB n4jDb = Neo4jDB.getNeo4jDB();
	private MyLocalDB myDB = MyLocalDB.getMyLocalDB();
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
			Item i = n4jDb.getItem(id);
			
			if(i != null)
			{
				this.myDB.deleteItemFromAllBookshelf(i);
				return n4jDb.deleteItem(id);
			} else
				throw new ConflictServiceException();
			
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

	public synchronized MyBookshelfType createBookshelf(String name) {
		return this.myDB.newBookshelf(name);		
	}
		
	public synchronized MyBookshelves getBookshelves(String name) {
		return this.myDB.searchBookshelves(name);
	}
	
	public synchronized int addItemToBookshelf (Item item, String name) throws Exception{

		if(this.getItem(ResourseUtils.SelfToId(item.getSelf()))==null){ //check if the item exists int the biblio
			return -2;
		}

		return this.myDB.addItemToBookshelf(item, name);
	}
		
	public synchronized boolean deleteBookshelf (String name){	
		return this.myDB.removeBookshelf(name);
	}
	
	public synchronized int getBookshelfReads (String name){
		return this.myDB.getBookshelfReads(name);		
	}
	
	public synchronized boolean deleteItemFromBookshelf (String name, BigInteger item) throws Exception{	
		Item i = this.getItem(item);
		return this.myDB.deleteItemFromBookshelf(name, i);
	}
	
	public synchronized Items getItemsFromBookshelf (String name) throws Exception {
		
		Items items = this.getItems(SearchScope.ALL, "", 10000, 0, BigInteger.ONE);
		return this.myDB.getItemsFromBookshelf(name, items);
	}
			
	
}
