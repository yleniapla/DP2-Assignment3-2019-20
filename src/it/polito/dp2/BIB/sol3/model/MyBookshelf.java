package it.polito.dp2.BIB.sol3.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import it.polito.dp2.BIB.ass3.Bookshelf;
import it.polito.dp2.BIB.ass3.DestroyedBookshelfException;
import it.polito.dp2.BIB.ass3.ItemReader;
import it.polito.dp2.BIB.ass3.ServiceException;
import it.polito.dp2.BIB.ass3.TooManyItemsException;
import it.polito.dp2.BIB.ass3.UnknownItemException;
import it.polito.dp2.BIB.sol3.client.ItemReaderImpl;
import it.polito.dp2.BIB.sol3.service.jaxb.Item;
import it.polito.dp2.BIB.sol3.service.jaxb.Items;
import it.polito.dp2.BIB.sol3.service.util.ResourseUtils;

public class MyBookshelf implements Bookshelf{
	
	private String uri;
	private Client client;
	private WebTarget target;
	
	private String name;
	private int reads=0;
	private Set<ItemReader> items;
	
	public MyBookshelf(String name) {
		this.name = name;
		this.items = new HashSet<ItemReader>();
		this.reads = 0;
		
		this.uri = System.getProperty("it.polito.dp2.BIB.ass3.URL");
		if (this.uri == null || this.uri.equals(""))
			this.uri = "http://localhost:8080/BiblioSystem/rest";
		this.client = ClientBuilder.newClient();
		this.target = client.target(uri).path("biblio");
	}
	
	@Override
	public synchronized String getName() throws DestroyedBookshelfException {
		if(this.reads==-1)
			throw new DestroyedBookshelfException();
		return this.name;
	}

	@Override
	public synchronized void addItem(ItemReader item)
			throws DestroyedBookshelfException, UnknownItemException, TooManyItemsException, ServiceException {
		if(this.reads==-1)
			throw new DestroyedBookshelfException();
		
		if(this.items.size() >= 20)
			throw new TooManyItemsException();
		
		if (item == null)
			throw new UnknownItemException();
		if(item.getTitle() == null || item.getTitle().equals(""))
			throw new UnknownItemException();
		
		this.target = this.client.target(this.uri).path("biblio").path("items").queryParam("keyword", item.getTitle());
		Response reply = this.target.request(MediaType.APPLICATION_JSON).get();
		reply.bufferEntity();
		
		if (reply.getStatus() != 200)
			throw new ServiceException();
		
		Items results = reply.readEntity(Items.class);
		Item found = null;
		
		for(Item i : results.getItem()){
			if(item.getTitle()!=null && item.getSubtitle()!=null){
				if(item.getTitle().equals(i.getTitle()) && item.getSubtitle().equals(i.getSubtitle())){
					found = i;
					break;
				}
			} else {
				if(item.getTitle().equals(i.getTitle())){
					found = i;
					break;
				}
			}
		}
		
		if(found == null)
			throw new UnknownItemException();
		
		this.target = this.client.target(this.uri).path("biblio").path("shelves").path(this.name).path("items");
		reply = this.target.request(MediaType.APPLICATION_XML).put(Entity.xml(found));
		reply.bufferEntity();
		if (reply.getStatus() == 200 | reply.getStatus() == 201 | reply.getStatus() == 204 ) {
			this.items.add(item);
		} else if (reply.getStatus() == 404)
			throw new DestroyedBookshelfException();
		else {
			throw new ServiceException();
		}
		
	}

	@Override
	public synchronized void removeItem(ItemReader item) throws DestroyedBookshelfException, UnknownItemException, ServiceException {
		if(this.reads==-1)
			throw new DestroyedBookshelfException();
		
		this.target = this.client.target(this.uri).path("biblio").path("items");
		Response reply = this.target.request(MediaType.APPLICATION_JSON).get();
		reply.bufferEntity();
		
		Items results = reply.readEntity(Items.class);
		
		int flag = 0;
		Item found = new Item();
		
		for(Item i : results.getItem()){
			if(item.getTitle()!=null && item.getSubtitle()!=null){
				if(item.getTitle().equals(i.getTitle()) && item.getSubtitle().equals(i.getSubtitle())){
					found = i;
					flag = 1;
				}
			} else {
				if(item.getTitle().equals(i.getTitle())){
					found = i;
					flag = 1;
				}
			}
		}
		
		if(flag == 0)
			throw new ServiceException();
		
		this.target = this.client.target(this.uri).path("biblio").path("shelves").path(this.name).path("items").path(ResourseUtils.SelfToId(found.getSelf()).toString());
		Response reply2 = this.target.request().delete();
		reply2.bufferEntity();
		
		if (reply2.getStatus() == 200 | reply2.getStatus() == 201 | reply2.getStatus() == 204 ) {
			this.items.remove(item);
		} else
			throw new ServiceException();
		
		
		
	}

	@Override
	public synchronized Set<ItemReader> getItems() throws DestroyedBookshelfException, ServiceException {
		if(this.reads==-1)
			throw new DestroyedBookshelfException();
				
		this.target = this.client.target(this.uri).path("biblio").path("shelves").path(this.name).path("items");
		Response reply = this.target.request(MediaType.APPLICATION_JSON).get();
		reply.bufferEntity();
		
		if (reply.getStatus() == 404) {
			throw new DestroyedBookshelfException();
		}
		if (reply.getStatus() != 200) {
			throw new ServiceException();
		}
		
		Items results = reply.readEntity(Items.class);
		
		List<ItemReader> removed = new ArrayList<ItemReader>();
		List<ItemReader> added = new ArrayList<ItemReader>();
		
		for(ItemReader ir : this.items)
		{
			int flag = 0;
			
			for(Item i : results.getItem())
			{
				if(ir.getTitle()!=null && ir.getSubtitle()!=null){
					if(ir.getTitle().equals(i.getTitle()) && ir.getSubtitle().equals(i.getSubtitle())){
						flag = 1;
					}
				} else {
					if(ir.getTitle().equals(i.getTitle())){
						flag = 1;
					}
				}
			}
			if(flag != 1)
				removed.add(ir);
		}
		
		this.items.removeAll(removed);	
		
		for(Item i : results.getItem()){
			int flag = 0;
			
			for(ItemReader ir : this.items){
				
				if(i.getTitle()!=null && i.getSubtitle()!=null){
					if(i.getTitle().equals(ir.getTitle()) && i.getSubtitle().equals(ir.getSubtitle())){
						flag = 1;
					}
				} else {
					if(i.getTitle().equals(ir.getTitle())){
						flag = 1;
					}
				}
			}
			if(flag != 1){
				ItemReaderImpl x = new ItemReaderImpl(i);
				added.add(x);
			}
		}
		
		this.items.addAll(added);
		
		return this.items;
	}

	@Override
	public synchronized void destroyBookshelf() throws DestroyedBookshelfException, ServiceException {
		if(this.reads==-1)
			throw new DestroyedBookshelfException();
		
		this.target = this.client.target(this.uri).path("biblio").path("shelves").queryParam("name", this.name);
		Response reply = this.target.request(MediaType.APPLICATION_XML).delete();
		reply.bufferEntity();
		if (reply.getStatus() == 204 || reply.getStatus() == 404) {
			this.name = null;
			this.reads = -1;
			this.items = null;
			
			this.client = null;
			this.target = null;
			
		} else
			throw new ServiceException();

	}

	@Override
	public synchronized int getNumberOfReads() throws DestroyedBookshelfException, ServiceException {
		if(this.reads==-1)
			throw new DestroyedBookshelfException();

		this.target = this.client.target(this.uri).path("biblio").path("shelves").path(this.name).path("reads");
		Response reply = this.target.request(MediaType.TEXT_PLAIN).get();
		reply.bufferEntity();
		if (reply.getStatus() == 200 | reply.getStatus() == 201 | reply.getStatus() == 204 ) {
			
			Integer results = reply.readEntity(Integer.class);
			return results;
			
		} else
			throw new ServiceException();
	}
	

}
