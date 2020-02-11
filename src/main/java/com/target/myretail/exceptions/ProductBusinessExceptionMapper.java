package com.target.myretail.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Custom exception mapper implementation for myRetail utility
 * @author mukta
 *
 */
@Provider
public class ProductBusinessExceptionMapper implements ExceptionMapper<ProductNotFoundBusinessException> {

	/**
	 * Client will be notified with custom image if the product is not found in repository
	 * USed by REST CRUD operation utility class
	 */
	@Override
	//Client will undestand that he is trying to modify record which does not exist
	public Response toResponse(ProductNotFoundBusinessException exception) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"status\":\"error\"");
		sb.append(",");
		sb.append("\"message\":\"Resource does not exist in MyRetail! Try again with existing Id!\"");
		sb.append("}");
		return Response.serverError().entity(sb.toString()).type(MediaType.APPLICATION_JSON).build();
	}

}
