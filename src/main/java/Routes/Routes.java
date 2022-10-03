package Routes;

import Exceptions.MyTechException;
import Model.PaymentDto;
import Model.Preference;
import Service.PaymentService;
import Service.PreferenceService;
import Service.Token;
import com.google.gson.Gson;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;


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

            put("/preferences/:id", (request, response) -> {
                String prefId = request.params("id");
                PreferenceRequest prefToEdit = new Gson().fromJson(request.body(), PreferenceRequest.class);
                return PreferenceService.updatePreference(prefId, prefToEdit);
            });

            post("/payments", (request, response) -> {
               // PaymentCreateRequest paymentCreateRequest = new Gson().fromJson(request.body(), PaymentCreateRequest.class);
                PaymentDto payment = new Gson().fromJson(request.body(), PaymentDto.class);
                return PaymentService.createPayment();
            });

            exception(MyTechException.class, (exception, request, response)-> {
                String message = exception.getMessage();
                response.status(500);
                response.type("application/json");
                response.body(new Gson().toJson(message));

            });

            exception(MPException.class, (exception, request, response) -> {
                String message = exception.getMessage();
                response.type("application/json");
                response.body(new Gson().toJson(message));
            });

            exception(MPApiException.class, (exception, request, response) -> {
                String message = exception.getMessage();
                response.type("application/json");
                response.body(new Gson().toJson(message));
            });

            notFound((request, response) -> {
                return "{\"message\": \"Not Found: Status 404\"}";
            });
        }

}

