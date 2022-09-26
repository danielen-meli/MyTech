package Routes;

import Model.Payment;
import Model.Preference;
import Service.PaymentService;
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

            post("/payment", (request, response) -> {
                response.type("application/json");
                Payment payment = new Gson().fromJson(request.params(id), Payment.class);
                return PaymentService.createPayment();
            });


    }

}
