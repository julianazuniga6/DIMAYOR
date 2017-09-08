package utils;

import com.google.gson.Gson;
import model.Team;

public class DimayorUtils {
	
	public String convertToJson(Object object) {
		return new Gson().toJson(object).toString();
	}
	
	public Team teamFromJson(String json) {
		return new Gson().fromJson(json, Team.class);
	}
	
}
