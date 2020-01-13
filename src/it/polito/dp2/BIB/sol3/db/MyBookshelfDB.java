package it.polito.dp2.BIB.sol3.db;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import it.polito.dp2.BIB.sol3.service.jaxb.Item;
import it.polito.dp2.BIB.sol3.service.jaxb.MyBookshelfType;

public class MyBookshelfDB {
	
	private ConcurrentHashMap<Integer, MyBookshelfType> bs = new ConcurrentHashMap<>();
	private ConcurrentHashMap<Integer, Integer> reads = new ConcurrentHashMap<>(); //id, num letture
	protected int bs_count = 0;
	private DB n4jDb = Neo4jDB.getNeo4jDB();
	
	
	public synchronized MyBookshelfType createBookshelf(String name) throws Exception {
		bs_count++;
		MyBookshelfType b = new MyBookshelfType();
		b.setId(bs_count);
		b.setName(name);
		bs.put(bs_count, b);
		reads.put(bs_count, 0);
		return b;
	}
	
	public synchronized List<MyBookshelfType> getBookshelf(String name){
		
		List<MyBookshelfType> list = new ArrayList<>();
		for(MyBookshelfType b : bs.values()){
			if(b.getName().contains(name)){
				list.add(b);
				int x = reads.get(b.getId());
				reads.replace(b.getId(), x+1);
			}
		}
		return list;
	}
	
	public synchronized boolean deleteBookshelf(MyBookshelfType b) {
		if(bs.contains(b))
		{
			bs.remove(b).getId();
			reads.remove(b.getId());
			return true;
		}
		return false;
	}
	
	public synchronized MyBookshelfType addItemToBookshelf(BigInteger item, int bs_id) throws Exception{
		MyBookshelfType b = bs.get(bs_id);
		Item i = n4jDb.getItem(item);
		b.getItem().add(i);
		
		return b;
	}
	
	public synchronized MyBookshelfType deleteItemFromBookshelf(BigInteger item, int bs_id) throws Exception{
		MyBookshelfType b = bs.get(bs_id);
		Item i = n4jDb.getItem(item);
		b.getItem().remove(i);
		
		return b;
	}
	
	public synchronized Item getItemFromBookshelf(BigInteger item, int bs_id) throws Exception{
		MyBookshelfType b = bs.get(bs_id);
		Item i = n4jDb.getItem(item);
		if(b.getItem().contains(i)){
			int x = reads.get(b.getId());
			reads.replace(b.getId(), x+1);
			return i;
		}
		else
			return null;
	}
	
	public synchronized int getBookshelfReads(int bs_id) {
		if(reads.contains(bs_id))
			return reads.get(bs_id);
		else
		return -1;
	}

}
