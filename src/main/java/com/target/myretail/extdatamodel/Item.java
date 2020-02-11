package com.target.myretail.extdatamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
	private String tcin;
	private String dpci;

	@JsonProperty
	private ProductDescription product_description;

	public Item() {
		System.out.println("Constructor:: item");
	}

	public String getTcin() {
		return tcin;
	}

	public void setTcin(String tcin) {
		this.tcin = tcin;
	}

	public String getDpci() {
		return dpci;
	}

	public void setDpci(String dpci) {
		this.dpci = dpci;
	}

	public ProductDescription getProduct_description() {
		return product_description;
	}

	public void setProduct_description(ProductDescription product_description) {
		this.product_description = product_description;
	}

	@Override
	public String toString() {
		return "Item [tcin=" + tcin + ", dpci=" + dpci + ", product_description=" + product_description + "]";
	}

	class ProductDescription {
		private String title;

		public ProductDescription() {

		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		@Override
		public String toString() {
			return "ProductDescription [title=" + title + "]";
		}
	}
}


