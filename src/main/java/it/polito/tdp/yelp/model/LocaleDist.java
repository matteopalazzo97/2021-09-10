package it.polito.tdp.yelp.model;

public class LocaleDist {
	
	private VerticiLatLng locale;
	private Double dist;
	
	public LocaleDist(VerticiLatLng locale, Double dist) {
		super();
		this.locale = locale;
		this.dist = dist;
	}

	@Override
	public String toString() {
		return locale + "   DIST: " + dist;
	}
	
	

}
