package models.usermodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import models.BaseModels;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAfterRegisterModel extends BaseModels {

    @JsonProperty("data")
    private Data data;

    @Override
    public int getCode() {
        return super.getCode();
    }

    @Override
    public boolean isSuccess() {
        return super.isSuccess();
    }

}

