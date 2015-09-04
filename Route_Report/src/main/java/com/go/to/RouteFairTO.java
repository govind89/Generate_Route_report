package com.go.to;

public class RouteFairTO {
	private String route_id;
	private String fair_id;
	public String getFair_id() {
		return fair_id;
	}

	public void setFair_id(String fair_id) {
		this.fair_id = fair_id;
	}

	private String route_short_name;
	private String route_long_name;
	private double price;

	public String getRoute_id() {
		return route_id;
	}

	public void setRoute_id(String route_id) {
		this.route_id = route_id;
	}

	public String getRoute_short_name() {
		return route_short_name;
	}

	public void setRoute_short_name(String route_short_name) {
		this.route_short_name = route_short_name;
	}

	public String getRoute_long_name() {
		return route_long_name;
	}

	public void setRoute_long_name(String route_long_name) {
		this.route_long_name = route_long_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
