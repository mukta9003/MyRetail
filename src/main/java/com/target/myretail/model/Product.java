package com.target.myretail.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This bean represents an object exchanged for REST CRUD operations Object is
 * serialized/deserialized and used as main entity representing Product in
 * MyRetail
 * 
 * @author mukta
 *
 */
@XmlRootElement(name = "Product")
@Document(collection = "product_db")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Product {

	@Id
	private long id;
	private String name;

	private ProductPriceInfo priceDetails;

	public Product() {
	}

	public ProductPriceInfo getPriceDetails() {
		return priceDetails;
	}

	public void setPriceDetails(ProductPriceInfo priceDetails) {
		this.priceDetails = priceDetails;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", priceDetails=" + priceDetails + "]";
	}

}
