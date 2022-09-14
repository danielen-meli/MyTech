package Controller;

import Model.Item;
import Model.StandardResponse;
import Model.StatusResponse;
import Service.ItemService;
import com.google.gson.Gson;

import static spark.Spark.*;

public class ItemController {

    public static void main(String[] args) {
        post("/items", (request, response) -> {
            response.type("application/json");
            Item item = new Gson().fromJson(request.body(), Item.class);
                ItemService.addItem(item);

                return new Gson()
                        .toJson(new StandardResponse(StatusResponse.SUCCESS));
        });

        get("/items", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(
                new StandardResponse(StatusResponse.SUCCESS,new Gson()
                        .toJsonTree(ItemService.getItems())));

        });

        get("/items/:id", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, String.valueOf(new Gson()
                            .toJsonTree(ItemService.getItem(request.params(":id"))))));

        });

    }

}
