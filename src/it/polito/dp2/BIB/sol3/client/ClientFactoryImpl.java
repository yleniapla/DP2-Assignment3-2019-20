package it.polito.dp2.BIB.sol3.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import it.polito.dp2.BIB.sol3.model.MyBookshelf;
import it.polito.dp2.BIB.sol3.service.jaxb.MyBookshelves;
import it.polito.dp2.BIB.sol3.service.jaxb.*;
import it.polito.dp2.BIB.ass3.Bookshelf;
import it.polito.dp2.BIB.ass3.Client;
import it.polito.dp2.BIB.ass3.DestroyedBookshelfException;
import it.polito.dp2.BIB.ass3.ItemReader;
import it.polito.dp2.BIB.ass3.ServiceException;
import it.polito.dp2.BIB.ass3.TooManyItemsException;
import it.polito.dp2.BIB.ass3.UnknownItemException;

public class ClientFactoryImpl implements Client {
	javax.ws.rs.client.Client client;
	WebTarget target;
	static String uri = "http://localhost:8080/BiblioSystem/rest";
	static String urlProperty = "it.polito.dp2.BIB.ass3.URL";
	static String portProperty = "it.polito.dp2.BIB.ass3.PORT";
	
	public ClientFactoryImpl(URI uri) {
		this.uri = uri.toString();
		
		client = ClientBuilder.newClient();
		target = client.target(uri).path("biblio");
	}
	

	@Override
	public Bookshelf createBookshelf(String name) throws ServiceException {
		Response reply = target.path("/shelves").queryParam("name", name).request(MediaType.APPLICATION_JSON).post(null);
		reply.bufferEntity();
		if (reply.getStatus() != 201)
			throw new ServiceException();
		else {
			MyBookshelfType res = reply.readEntity(MyBookshelfType.class);
			MyBookshelf bs = new MyBookshelf(res.getName());
			return bs;
		}
	}

	@Override
	public Set<Bookshelf> getBookshelfs(String name) throws ServiceException {
		Set<Bookshelf> result = new HashSet<>();
		Response reply = target.path("/shelves").queryParam("keyword", name).request(MediaType.APPLICATION_JSON).get();
		reply.bufferEntity();
		if (reply.getStatus() != 200)
			throw new ServiceException();
		else {
			MyBookshelves bs = reply.readEntity(MyBookshelves.class);
			for(it.polito.dp2.BIB.sol3.service.jaxb.MyBookshelfType b : bs.getMyBookshelfType()){
				MyBookshelf temp = new MyBookshelf(b.getName());
				for(it.polito.dp2.BIB.sol3.service.jaxb.Item i : b.getItem()){
					ItemReaderImpl item = new ItemReaderImpl(i);
					try {
						temp.addItem(item);
					} catch (DestroyedBookshelfException | UnknownItemException | TooManyItemsException e) {
						e.printStackTrace();
					}
				};
				result.add(temp);
			};
		}
		return result;
	}

	@Override
	public Set<ItemReader> getItems(String keyword, int since, int to) throws ServiceException {
		Set<ItemReader> itemSet=new HashSet<>();
		Items items = target.path("/items")
				.queryParam("keyword", keyword)
				.queryParam("beforeInclusive", to)
				.queryParam("afterInclusive", since)
			 	  .request(MediaType.APPLICATION_JSON_TYPE)
			 	  .get( Items.class);
		
		for (it.polito.dp2.BIB.sol3.client.Items.Item i : items.getItem()) {
			itemSet.add(new ItemReaderImpl(i));
		}
		
		return itemSet;
	}

	
	
	
	private static void printItems() throws ServiceException {
		Set<ItemReader> set = mainClient.getItems("", 0, 3000);
		System.out.println("Items returned: "+set.size());
		
		// For each Item print related data
		for (ItemReader item: set) {
			System.out.println("Title: "+item.getTitle());
			if (item.getSubtitle()!=null)
				System.out.println("Subtitle: "+item.getSubtitle());
			System.out.print("Authors: ");
			String[] authors = item.getAuthors();
			System.out.print(authors[0]);
			for (int i=1; i<authors.length; i++)
				System.out.print(", "+authors[i]);
			System.out.println(";");
			
			Set<ItemReader> citingItems = item.getCitingItems();
			System.out.println("Cited by "+citingItems.size()+" items:");
			for (ItemReader citing: citingItems) {
				System.out.println("- "+citing.getTitle());
			}	
			printLine('-');

		}
		printBlankLine();
	}
	
	


	private static void printBlankLine() {
		System.out.println(" ");
	}

	
	private static void printLine(char c) {
		System.out.println(makeLine(c));
	}
	
	private static StringBuffer makeLine(char c) {
		StringBuffer line = new StringBuffer(132);
		
		for (int i = 0; i < 132; ++i) {
			line.append(c);
		}
		return line;
	}
	
	
	static ClientFactoryImpl mainClient;
	public static void main(String[] args) {
		System.setProperty("it.polito.dp2.BIB.BibReaderFactory", "it.polito.dp2.BIB.Random.BibReaderFactoryImpl");
		String customUri = System.getProperty(urlProperty);
		String customPort = System.getProperty(portProperty);
		if (customUri != null)
			uri = customUri;
		
		try {
			mainClient = new ClientFactoryImpl(new URI(uri));
			printItems();
		} catch (URISyntaxException | ServiceException e) {
			e.printStackTrace();
		}
		
	}
		
}
