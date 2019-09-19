package models.productmodels.productincartmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter

public class Prices{

	@JsonProperty("total")
	private int totalPrice;

	@JsonProperty("final")
	private int finalPrice;

	@JsonProperty("base")
	private int basePrice;
}