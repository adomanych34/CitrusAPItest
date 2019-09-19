package models.productmodels.productincartmodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import models.BaseModels;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class ProductInCartModel extends BaseModels {

    @JsonProperty("data")
    private Data data;

    @Override
    public boolean isSuccess() {
        return super.isSuccess();
    }

    @Override
    public int getCode() {
        return super.getCode();
    }
}