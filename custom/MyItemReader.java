package it.polito.dp2.BIB.sol1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.dp2.BIB.ItemReader;

public class MyItemReader implements ItemReader {
	
	private String title, subtitle;
	private int id;
	private List<String> authors;
	private Set<ItemReader> citingItems;
	
	public MyItemReader(){
		this.authors = new ArrayList<>();
		this.citingItems = new HashSet<>();
	}

	@Override
	public String[] getAuthors() {
		return this.authors.toArray(new String[this.authors.size()]);
	}

	@Override
	public Set<ItemReader> getCitingItems() {
		return this.citingItems;
	}

	@Override
	public String getSubtitle() {
		return this.subtitle;
	}

	@Override
	public String getTitle() {
		return this.title;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public void setAuthors(List<String> authors) {
		this.authors.addAll(authors);
	}

	public void setCitingItems(Set<ItemReader> citingItems) {
		this.citingItems.addAll(citingItems);
	}

}
