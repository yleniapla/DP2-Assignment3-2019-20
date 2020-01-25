package it.polito.dp2.BIB.sol3.db;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import it.polito.dp2.BIB.sol3.service.jaxb.Item;
import it.polito.dp2.BIB.sol3.service.jaxb.Items;
import it.polito.dp2.BIB.sol3.service.jaxb.MyBookshelfType;
import it.polito.dp2.BIB.sol3.service.jaxb.MyBookshelves;

public class MyLocalDB {
	
	private static ConcurrentHashMap<String, MyBookshelfType> bs = new ConcurrentHashMap<String, MyBookshelfType>();
	
	private MyLocalDB() {}

	public static MyLocalDB getMyLocalDB() {
		return new MyLocalDB();
	}
	
	public synchronized MyBookshelfType newBookshelf(String name) {
		MyBookshelfType b = new MyBookshelfType();
		b.setName(name);
		b.setReads(0);
		bs.put(b.getName(), b);
		return b;
	}
	
	public synchronized MyBookshelves searchBookshelves(String name){
		MyBookshelves list = new MyBookshelves();

		for(MyBookshelfType b : bs.values()){
			if(b.getName().contains(name)){
				list.getMyBookshelfType().add(b);
				int r = b.getReads();
				b.setReads(r+1);
			}
		}
			return list;
	}
	
	public synchronized int addItemToBookshelf (Item item, String name) throws Exception{

		if(bs.get(name)!=null){
			MyBookshelfType b = bs.get(name);

			for(Item it : b.getItem()){
				if(item.getTitle()!=null && item.getSubtitle()!=null){
					if(item.getTitle().equals(it.getTitle()) && item.getSubtitle().equals(it.getSubtitle())){
						return 0; //item already present
					}
				} else {
					if(item.getTitle().equals(it.getTitle())){
						return 0; //item already present
					}
				}
			}

			if(b.getItem().size()>=20){
				return -3; 	//to many items in the shelf
			} 

			b.getItem().add(item);
			return 0;
		}
		else
			return -1;
	}
	
	public synchronized boolean removeBookshelf (String name){

		if(bs.get(name)!=null){
			bs.remove(name);
			return true;
		}
		else
			return false;
	}
	
	public synchronized int getBookshelfReads (String id){

		if(bs.get(id)!=null){
			MyBookshelfType x = bs.get(id);
			return x.getReads();
		}
		else
			return -1;

	}
	
	public synchronized boolean deleteItemFromBookshelf (String bs_name, Item i) throws Exception{

		if(bs.get(bs_name)!=null){
			MyBookshelfType x = bs.get(bs_name);

			List<Item> removed = new ArrayList<Item>();

			for(Item it : x.getItem())
			{
				if(i.getTitle()!=null && i.getSubtitle()!=null){
					if(i.getTitle().equals(it.getTitle()) && i.getSubtitle().equals(it.getSubtitle())){
						removed.add(it);
						break;
					}
				} else {
					if(i.getTitle().equals(it.getTitle())){
						removed.add(it);
						break;
					}
				}
			}

			return x.getItem().removeAll(removed);

		}
		else
			return false;

	}
	
	public synchronized boolean deleteItemFromAllBookshelf (Item i) throws Exception{

		for(MyBookshelfType mbs : MyLocalDB.bs.values()){
			if(mbs.getItem().contains(i)){
				if(this.deleteItemFromBookshelf(mbs.getName(), i))
						continue;
				else
					return false;
			}
		}
		return true;

	}
	
	public synchronized Items getItemsFromBookshelf (String name, Items items) throws Exception {
		if(bs.get(name)!=null) {
			MyBookshelfType x = bs.get(name);
			
			int r = x.getReads();
			x.setReads(r+1);
			
			List<Item> removed = new ArrayList<Item>();
			
			for(Item i : x.getItem()){
				
				int flag = 0;
				
				for(Item it : items.getItem()){
					
					if(i.getTitle()!=null && i.getSubtitle()!=null){
						if(i.getTitle().equals(it.getTitle()) && i.getSubtitle().equals(it.getSubtitle())){
							flag =1;
						}
					} else {
						if(i.getTitle().equals(it.getTitle())){
							flag =1;
						}
					}
					
				}
				
				if(flag != 1){
					removed.add(i);
				}
			}
			
			x.getItem().removeAll(removed);
			Items result = new Items();
			result.getItem().addAll(x.getItem());
			
			return result;
		}
		else
			throw new Exception();
	}

}
