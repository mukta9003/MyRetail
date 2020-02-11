package com.target.myretail.extdatamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalProduct {
	@JsonProperty
	private Item item;

	public ExternalProduct() {

	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Product [item=" + item + "]";
	}
}

class Response {
	@JsonProperty
	private ExternalProduct product;

	public ExternalProduct getProduct() {
		return product;
	}

	public void setProduct(ExternalProduct prod) {
		product = prod;
	}

	public Response() {
		System.out.println("constructor:: Response");
	}

	@Override
	public String toString() {
		return "Response [RestResponse=" + product + "]";
	}
}
