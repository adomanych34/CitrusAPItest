package models.productmodels.productincartmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductsItem{


	@JsonProperty("product_in_basket_id")
	private int productInBasketId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("price_type")
	private String priceType;

	@JsonProperty("id")
	private int id;


}