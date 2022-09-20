package Routes;

import Model.Preference;
import com.google.gson.Gson;
import spark.Redirect;

import static spark.Spark.*;

public class PreferenceRoutes {
        public void routes(){
            post("/preference", (request, response) -> {
                response.type("application/json");
                Preference preference = new Gson().fromJson(request.body(), Preference.class);
                Preference.createPreference();
                    return new Gson().toJson(preference);
            });
    }

}
