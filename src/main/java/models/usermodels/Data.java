package models.usermodels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import models.usermodels.EmailsItem;
import models.usermodels.PhonesItem;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Data {


    @JsonProperty("provider")
    private String provider;

    @JsonProperty("api_token")
    private String apiToken;

    @JsonProperty("phones")
    private List<PhonesItem> phones;

    @JsonProperty("emails")
    private List<EmailsItem> emails;

    @JsonProperty("name")
    private String name;

//    @JsonProperty("name")
//    private String name;


}