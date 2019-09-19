package models.productmodels.productincartmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import models.productmodels.productincartmodel.ProductsItem;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Data {
    @JsonProperty("total_price")
    private int totalPrice;

    @JsonProperty("products_count")
    private int quantity;

    @JsonProperty("total_base_price")
    private int basePrice;
    @JsonProperty("products")
    private List<ProductsItem> products;
}