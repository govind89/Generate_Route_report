package com.go.to;

public class FareAttr {

	private String fare_id;
	private double price;
	private String currency_type;
	private String payment_method;
	private String transfers;
	private String transfer_duration;

	public String getFare_id() {
		return fare_id;
	}
	public void setFare_id(String fare_id) {
		this.fare_id = fare_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCurrency_type() {
		return currency_type;
	}
	public void setCurrency_type(String currency_type) {
		this.currency_type = currency_type;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public String getTransfers() {
		return transfers;
	}
	public void setTransfers(String transfers) {
		this.transfers = transfers;
	}
	public String getTransfer_duration() {
		return transfer_duration;
	}
	public void setTransfer_duration(String transfer_duration) {
		this.transfer_duration = transfer_duration;
	}
}
