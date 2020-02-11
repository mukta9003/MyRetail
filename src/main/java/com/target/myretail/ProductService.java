package com.target.myretail;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestBody;

import com.target.myretail.model.Product;

/**
 * REST interface providing CRUD operation for myretail
 * @author mukta
 *
 */
@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
@Path("/productservice")
public interface ProductService {
	
	@Path("/products")
	@GET
	List<Product> getProducts();

	@Path("/products/{id}")
	@GET
	Product getProduct(@PathParam(value = "id") long id);
	
	@Path("/products/title-only/{id}")
	@GET
	Product getProductName(@PathParam(value = "id") long id);
	
	@Path("/products")
	@POST
	Response createProduct(Product product);
	
	@Path("/products/{id}")
	@PUT
	Response updateProduct(@PathParam(value = "id") long id, @RequestBody Product product);
	
	@Path("/products/{id}")
	@DELETE
	Response deleteProduct(@PathParam("id") long id);

}
