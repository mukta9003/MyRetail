package com.target.myretail.extdatamodel;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * This is the entrypoint class for reading data from external API This class
 * serves as a REST WS client fetching data hosted on redsky.target.com.
 * Currently it is tested by Junit Test config
 * 
 * @author mukta
 *
 */
public class ExtDataController {
	private static final String url = "https://redsky.target.com/v2/pdp/tcin/{id}";

	private static final String exclude_string = "taxonomy,price,promotion,bulk_ship,"
			+ "rating_and_review_reviews,"
			+ "rating_and_review_statistics,question_answer_statistics,available_to_promise_network";

	public String getProductTitleFromExternalAPI(String id) {
 
		RestTemplate restTemplate = new RestTemplate();

		Map<String, String> urlParams = new HashMap<String, String>();
		urlParams.put("id", id);

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
				// Add query parameter
				.queryParam("excludes", exclude_string);

		Response response = restTemplate.getForObject(builder.buildAndExpand(urlParams).toUriString(), Response.class);
		Item item = response.getProduct().getItem();
		return item.getProduct_description().getTitle();

	}

}
