package model;

public class Team {

	private String name;
	private int year;
	private int titles;
	
	public Team(String name, int year, int titles) {
		super();
		this.name = name;
		this.year = year;
		this.titles = titles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getTitles() {
		return titles;
	}

	public void setTitles(int titles) {
		this.titles = titles;
	}
	
	
	
	
}
