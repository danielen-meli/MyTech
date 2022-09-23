package Routes;

import Model.Preference;
import Service.PreferenceService;
import com.google.gson.Gson;


import static spark.Spark.*;

public class PreferenceRoutes {
        public void routes(){
            // testar sem o before!
            before("/*", (request, response) -> response.type("application/json"));


            post("/preferences", (request, response) -> {
                response.type("application/json");
                Preference preference = new Gson().fromJson(request.body(), Preference.class);
                return PreferenceService.createPreference(); // ja retorna certinho toda a preferencia - mas o DTO pode melhorar esse retorno.
                   // return new Gson().toJson(preference);
            });

            get("/feedback", (request, response) -> {
                response.type("application/json");
                return null;
            });


    }

}
