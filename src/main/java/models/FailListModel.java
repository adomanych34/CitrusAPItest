package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import models.usermodels.ErrorsItem;

import java.util.List;
@Getter
public class FailListModel extends BaseModels {

    @JsonProperty("errors")
    private List<ErrorsItem> errors;

    @Override
    public int getCode() {
        return super.getCode();
    }

    @Override
    public boolean isSuccess() {
        return super.isSuccess();
    }
}

