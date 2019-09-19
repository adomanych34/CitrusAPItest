package models.productmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class SomeModel {

    @JsonProperty("price_type")
    private String price_type;

    @JsonProperty("product_id")
    private String id;

    @JsonProperty("qty")
    private String countOfProduct;
}
