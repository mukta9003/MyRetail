package com.target.myretail.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductPriceInfo {
	
	public enum currencyType {
		USD, INR, EUR;
	}

	private double currentPrice;
	private currencyType currency;

	public ProductPriceInfo(){}

	public double getCurrentPrice() {
		return currentPrice;
	}

	@Override
	public String toString() {
		return "ProductPriceInfo [currentPrice=" + currentPrice + ", currency=" + currency + "]";
	}

	public void setCurrentPrice(double d) {
		this.currentPrice = d;
	}

	public currencyType getCurrency() {
		return currency;
	}

	public void setCurrency(currencyType currency) {
		this.currency = currency;
	}

}