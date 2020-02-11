package com.target.myretail;

import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.myretail.exceptions.ProductNotFoundBusinessException;
import com.target.myretail.model.Product;
import com.target.myretail.model.dataRepo.ProductRepository;

/**
 * Service implementation of Create, Read, Update, Delete operations on myRetail's product repository
 * @author mukta
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	private static final Logger LOG = Logger.getLogger(ProductServiceImpl.class);

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(long id) {
		LOG.debug("getProduct{} -> "+ id);
		Product prod = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundBusinessException());
		return prod;
	}

	@Override
	public Response createProduct(Product product) {
		LOG.debug("createProduct{} -> "+ product);
		Product savedProduct = productRepository.save(product);
		return Response.ok(savedProduct).build();
	}


	@Override
	public Response deleteProduct(long id) {
		LOG.debug("deleteProduct{} -> "+ id);
		productRepository.findById(id).orElseThrow(() -> new ProductNotFoundBusinessException());
		productRepository.deleteById(id);
		return Response.ok().build();
	}

	@Override
	public Product getProductName(long id) {
		LOG.debug("getProductName{} -> "+ id);
		return productRepository.findNameById(id);
	}


	@Override
	public Response updateProduct(long id, Product product) {
		LOG.debug("updateProduct{} -> "+ id +" : "+ product);
		Product p = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundBusinessException());
		p.setName(product.getName());
		p.setPriceDetails(product.getPriceDetails());
		Product savedProduct = productRepository.save(p);
		return Response.ok(savedProduct).build();
	}

}
