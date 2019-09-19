package models.usermodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
@Getter
public class ErrorsItem{

	@JsonProperty("field")
	private String field;

	@JsonProperty("messages")
	private List<String> messages;
}