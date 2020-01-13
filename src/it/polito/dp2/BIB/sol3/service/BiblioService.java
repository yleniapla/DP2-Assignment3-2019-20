package it.polito.dp2.BIB.sol3.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.ws.rs.core.UriInfo;

import it.polito.dp2.BIB.sol3.db.BadRequestInOperationException;
import it.polito.dp2.BIB.sol3.db.ConflictInOperationException;
import it.polito.dp2.BIB.sol3.db.DB;
import it.polito.dp2.BIB.sol3.db.ItemPage;
import it.polito.dp2.BIB.sol3.db.MyBookshelfDB;
import it.polito.dp2.BIB.sol3.db.Neo4jDB;
import it.polito.dp2.BIB.sol3.service.jaxb.Citation;
import it.polito.dp2.BIB.sol3.service.jaxb.Item;
import it.polito.dp2.BIB.sol3.service.jaxb.Items;
import it.polito.dp2.BIB.sol3.service.jaxb.MyBookshelfType;
import it.polito.dp2.BIB.sol3.service.util.ResourseUtils;

public class BiblioService {
	private DB n4jDb = Neo4jDB.getNeo4jDB();
	private MyBookshelfDB bsDB = new MyBookshelfDB();
	ResourseUtils rutil;


	public BiblioService(UriInfo uriInfo) {
		rutil = new ResourseUtils((uriInfo.getBaseUriBuilder()));
	}
	
	public Items getItems(SearchScope scope, String keyword, int beforeInclusive, int afterInclusive, BigInteger page) throws Exception {
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

	public Item getItem(BigInteger id) throws Exception {
			Item item = n4jDb.getItem(id);
			if (item!=null)
				rutil.completeItem(item, id);
			return item;
	}

	public Item updateItem(BigInteger id, Item item) throws Exception {
		Item ret = n4jDb.updateItem(id, item);
		if (ret!=null) {
			rutil.completeItem(item, id);
			return item;
		} else
			return null;
	}

	public Item createItem(Item item) throws Exception {
		BigInteger id = n4jDb.createItem(item);
		if (id==null)
			throw new Exception("Null id");
		rutil.completeItem(item, id);
		return item;
	}

	public BigInteger deleteItem(BigInteger id) throws ConflictServiceException, Exception {
		try {
			return n4jDb.deleteItem(id);
		} catch (ConflictInOperationException e) {
			throw new ConflictServiceException();
		}
	}

	public Citation createItemCitation(BigInteger id, BigInteger tid, Citation citation) throws Exception {
		try {
			return n4jDb.createItemCitation(id, tid, citation);
		} catch (BadRequestInOperationException e) {
			throw new BadRequestServiceException();
		}
	}

	public Citation getItemCitation(BigInteger id, BigInteger tid) throws Exception {
		Citation citation = n4jDb.getItemCitation(id,tid);
		if (citation!=null)
			rutil.completeCitation(citation, id, tid);
		return citation;
	}

	public boolean deleteItemCitation(BigInteger id, BigInteger tid) throws Exception {
		return n4jDb.deleteItemCitation(id, tid);
	}

	public Items getItemCitations(BigInteger id) throws Exception {
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

	public Items getItemCitedBy(BigInteger id) throws Exception {
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

	public MyBookshelfType createBookshelf (MyBookshelfType bs) throws Exception {
		
		int id = bsDB.createBookshelf(bs);
		bs.setId(id);
		return bs;
		
	}
	
	public List<MyBookshelfType> getBookshelves (String name) {

		List<MyBookshelfType> bs = new ArrayList<MyBookshelfType>();
		bs = bsDB.getBookshelf(name);
		if (bs!=null)
			return bs;
		return null;
	}
	
	public MyBookshelfType addItemToBookshelf (BigInteger item, int bs_id) throws Exception{
		return bsDB.addItemToBookshelf(item, bs_id);
	}

	public boolean deleteBookshelf (MyBookshelfType bs) {
		return bsDB.deleteBookshelf(bs);
	}
	
	public int getBookshelfReads (int bs) {
		return bsDB.getBookshelfReads(bs);
	}
	
	public MyBookshelfType deleteItemFromBookshelf (int bs_id, BigInteger i) throws Exception {
		return bsDB.deleteItemFromBookshelf(i, bs_id);
	}
	
	public Item getItemFromBookshelf (int bs_id, BigInteger i) throws Exception {
		return bsDB.getItemFromBookshelf(i, bs_id);
	}
			
	
}
