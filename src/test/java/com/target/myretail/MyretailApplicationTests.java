package com.target.myretail;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.target.myretail.extdatamodel.ExtDataController;
import com.target.myretail.model.Product;
import com.target.myretail.model.ProductPriceInfo;
import com.target.myretail.model.ProductPriceInfo.currencyType;
import com.target.myretail.model.dataRepo.ProductRepository;

@SpringBootTest
class MyretailApplicationTests {
	private static final Logger LOG = Logger.getLogger(MyretailApplicationTests.class);
	
	@Autowired
	private ProductRepository productRepository;

	public ProductRepository getProductRepository() {
		return productRepository;
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Test
	void contextLoads() {
	}
	
	/**
	 * Queries MongoDb's data access layer to get product's name
	 */
	@Test
	void getProductNameById() {
		LOG.debug("@Test getDbData()");
		
		Product prod = productRepository.findNameById(15117729);
		LOG.info("Product: "+ prod);
		assertTrue(prod!=null, "getProductNameById-SUCCESS");
	}
	
	/**
	 * This is used for adding records in dB initially
	 */
	@Test
	void initData() {
		LOG.debug("@Test initData()");
		List<Product> productList = new ArrayList<Product>();

		Product product = new Product();
		product.setId(15117729);
		product.setName("Super Smash Bros. Ultimate - Nintendo Switch");

		ProductPriceInfo price = new ProductPriceInfo();
		price.setCurrency(currencyType.USD);
		price.setCurrentPrice(12.49);
		product.setPriceDetails(price);
		productList.add(product);
		LOG.info("Adding product -> "+ product);
		productRepository.saveAll(productList);
		}
	/**
	 * This is a junit test to get title from external API
	 * There is a REST client which will read external API data and show title of the product
	 */
	//@Test
	void getDataFromExternalAPI() {
		LOG.debug("@Test getDataFromExternalAPI()");
		String id = "13860428";
		ExtDataController controller = new ExtDataController();
		String title = controller.getProductTitleFromExternalAPI(id);
		LOG.info("Product title for id "+ id + " : "+ title);
		
	}
	

}
