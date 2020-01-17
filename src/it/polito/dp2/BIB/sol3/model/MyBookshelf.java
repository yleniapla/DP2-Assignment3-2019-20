package it.polito.dp2.BIB.sol3.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.dp2.BIB.ass3.Bookshelf;
import it.polito.dp2.BIB.ass3.DestroyedBookshelfException;
import it.polito.dp2.BIB.ass3.ItemReader;
import it.polito.dp2.BIB.ass3.ServiceException;
import it.polito.dp2.BIB.ass3.TooManyItemsException;
import it.polito.dp2.BIB.ass3.UnknownItemException;

public class MyBookshelf implements Bookshelf{
	
	private String name;
	private int reads=0;
	private Set<ItemReader> items;
	
	public MyBookshelf() {
		this.name = "";
		this.items = new HashSet<ItemReader>();
		this.reads = 0;
	}
	
	public MyBookshelf(String name) {
		this.name = name;
		this.items = new HashSet<ItemReader>();
		this.reads = 0;
	}
	
	@Override
	public String getName() throws DestroyedBookshelfException {
		if(this.reads==-1)
			throw new DestroyedBookshelfException();
		return this.name;
	}

	@Override
	public void addItem(ItemReader item)
			throws DestroyedBookshelfException, UnknownItemException, TooManyItemsException, ServiceException {
		if(this.reads==-1)
			throw new DestroyedBookshelfException();
		
		if(this.items.size()==20)
			throw new TooManyItemsException();
		
		this.items.add(item);
	}

	@Override
	public void removeItem(ItemReader item) throws DestroyedBookshelfException, UnknownItemException, ServiceException {
		if(this.reads==-1)
			throw new DestroyedBookshelfException();
		
		this.items.remove(item);
		
	}

	@Override
	public Set<ItemReader> getItems() throws DestroyedBookshelfException, ServiceException {
		if(this.reads==-1)
			throw new DestroyedBookshelfException();
		
		return this.items;
	}

	@Override
	public void destroyBookshelf() throws DestroyedBookshelfException, ServiceException {
		if(this.reads==-1)
			throw new DestroyedBookshelfException();
		
		this.name = null;
		this.reads = -1;
		this.items = null;
	}

	@Override
	public int getNumberOfReads() throws DestroyedBookshelfException, ServiceException {
		if(this.reads==-1)
			throw new DestroyedBookshelfException();
		
		return this.reads;
	}
	
	public void addRead() {
		this.reads++;
	}

}
