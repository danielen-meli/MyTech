package Routes;

import Model.Preference;
import Model.StandardResponse;
import Model.StatusResponse;
import Service.PreferenceService;
import com.google.gson.Gson;

import static spark.Spark.*;

public class ItemRoute {

    public static void main(String[] args) {
        post("/items", (request, response) -> {
            response.type("application/json");
            Preference item = new Gson().fromJson(request.body(), Preference.class);
                PreferenceService.addItem(item);

                return new Gson()
                        .toJson(new StandardResponse(StatusResponse.SUCCESS));
        });

        get("/items", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(
                new StandardResponse(StatusResponse.SUCCESS,new Gson()
                        .toJsonTree(PreferenceService.getItems())));

        });

        get("/items/:id", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, String.valueOf(new Gson()
                            .toJsonTree(PreferenceService.getItem(request.params(":id"))))));

        });

    }

}
