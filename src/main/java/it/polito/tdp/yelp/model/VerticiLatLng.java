package it.polito.tdp.yelp.model;

import java.util.Objects;

import com.javadocmd.simplelatlng.LatLng;

public class VerticiLatLng {
	
	private String businessId;
	private String fullAddress;
	private String active;
	private String categories;
	private String city;
	private int reviewCount;
	private String businessName;
	private String neighborhoods;
	private double latitude;
	private double longitude;
	private String state;
	private double stars;
	private LatLng pos;
	
	public VerticiLatLng(String businessId, String fullAddress, String active, String categories, String city,
			int reviewCount, String businessName, String neighborhoods, double latitude, double longitude, String state,
			double stars) {
		super();
		this.businessId = businessId;
		this.fullAddress = fullAddress;
		this.active = active;
		this.categories = categories;
		this.city = city;
		this.reviewCount = reviewCount;
		this.businessName = businessName;
		this.neighborhoods = neighborhoods;
		this.latitude = latitude;
		this.longitude = longitude;
		this.state = state;
		this.stars = stars;
		this.pos = new LatLng(latitude, longitude);
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getNeighborhoods() {
		return neighborhoods;
	}

	public void setNeighborhoods(String neighborhoods) {
		this.neighborhoods = neighborhoods;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getStars() {
		return stars;
	}

	public void setStars(double stars) {
		this.stars = stars;
	}

	public LatLng getPos() {
		return pos;
	}

	public void setPos(LatLng pos) {
		this.pos = pos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(active, businessId, businessName, categories, city, fullAddress, latitude, longitude,
				neighborhoods, pos, reviewCount, stars, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VerticiLatLng other = (VerticiLatLng) obj;
		return Objects.equals(active, other.active) && Objects.equals(businessId, other.businessId)
				&& Objects.equals(businessName, other.businessName) && Objects.equals(categories, other.categories)
				&& Objects.equals(city, other.city) && Objects.equals(fullAddress, other.fullAddress)
				&& Double.doubleToLongBits(latitude) == Double.doubleToLongBits(other.latitude)
				&& Double.doubleToLongBits(longitude) == Double.doubleToLongBits(other.longitude)
				&& Objects.equals(neighborhoods, other.neighborhoods) && Objects.equals(pos, other.pos)
				&& reviewCount == other.reviewCount
				&& Double.doubleToLongBits(stars) == Double.doubleToLongBits(other.stars)
				&& Objects.equals(state, other.state);
	}

	@Override
	public String toString() {
		return businessName;
	}
	
	

}
