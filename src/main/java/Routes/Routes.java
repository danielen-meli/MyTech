package Routes;

import Model.Payment;
import Model.Preference;
import Service.PaymentService;
import Service.PreferenceService;
import com.google.gson.Gson;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceRequest;


import static spark.Spark.*;

public class Routes {

        public void routes(){ // usa o before pra configurar o response do tipo Json
            before("/*", (request, response) -> response.type("application/json"));


            post("/preferences", (request, response) -> {
                Preference preference = new Gson().fromJson(request.body(), Preference.class);
                return PreferenceService.createPreference(); // ja retorna a preferencia
            });

            get("/preferences/:id", (request, response) ->{
                String prefId = request.params("id");
                return PreferenceService.getPreference(prefId);
            });

            // put("/preferences/:id", (request, response) -> {
            //   return new PreferenceService().updatePreference(request.params(":id"),
                //       new Gson().fromJson(request.body(), PreferenceRequest.class));
            // });


            post("/payment", (request, response) -> {
                response.type("application/json");
                Payment payment = new Gson().fromJson(request.params(":id"), Payment.class);
                return PaymentService.createPayment();
            });


    }

}
