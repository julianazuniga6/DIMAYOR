package api;

import static spark.Spark.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;


import logic.DimayorLogic;
import model.Team;
import spark.Spark;
import utils.DimayorUtils;

public class DimayorAPI {

	private static final String API_CONTEXT = "/api/v1/teams";

	private static DimayorLogic logic;
	private static DimayorUtils utils;


	public static void main(String[] args) {

		new DimayorAPI();

	}

	public DimayorAPI() {

		logic= new DimayorLogic();
		utils= new DimayorUtils();

		Spark.staticFileLocation("/public");
		enableCORS("*", "*", "*");

		//Retorna la lista de equipos
		get(API_CONTEXT, "application/json", (request, response) -> {

			ArrayList<Team> teamList= logic.getTeamsList();
			return utils.convertToJson(teamList);
		});

		//Retorna la informacion de un equipo
		get(API_CONTEXT+"/:name", "application/json", (request, response) -> {
		    String teamName= request.params(":name");

		    Team team= logic.getTeamIfo(teamName);

		    String info= utils.convertToJson(team);

		    return info;
		});

		//Elimina un equipo
		delete(API_CONTEXT+"/:name", (request, response) -> {

		    String teamName= request.params(":name");

		    return logic.deleteTeam(teamName);
		});

		//Agrega un nuevo equipo
		post(API_CONTEXT, (request, response) -> {

			String body= request.body();

			return logic.addTeam(body);

		});

		//Actualiza la informacion de un equipo
		put(API_CONTEXT, (request, response) -> {

			String body= request.body();

			return logic.editTeam(body);

		});
	}

	private static void enableCORS(final String origin, final String methods, final String headers) {

    options("/*", (request, response) -> {

        String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
        if (accessControlRequestHeaders != null) {
            response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
        }

        String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
        if (accessControlRequestMethod != null) {
            response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
        }

        return "OK";
    });

    before((request, response) -> {
        response.header("Access-Control-Allow-Origin", origin);
        response.header("Access-Control-Request-Method", methods);
        response.header("Access-Control-Allow-Headers", headers);
        // Note: this may or may not be necessary in your particular application
        response.type("application/json");
    });
	}

}
