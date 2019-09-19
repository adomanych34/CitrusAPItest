package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
@Getter
public class FailModel extends BaseModels {
    @JsonProperty("errors")
    private List<String> errors;

    @Override
    public int getCode() {
        return super.getCode();
    }

    @Override
    public boolean isSuccess() {
        return super.isSuccess();
    }
}
