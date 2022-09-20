package Model;

import Service.Token;
import com.google.gson.Gson;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Preference {

   static PreferenceClient client = new PreferenceClient();
    //Token token = new Token(); nao precisa instanciar pq usa a classe direto

    public static List<PreferenceItemRequest> addItems() {
        List<PreferenceItemRequest> items = new ArrayList<>();
        PreferenceItemRequest item =
                PreferenceItemRequest.builder()
                        .title("Meu produto")
                        .quantity(1)
                        .unitPrice(new BigDecimal("100"))
                        .build();
        items.add(item);

        PreferenceItemRequest item2 =
                PreferenceItemRequest.builder()
                        .title("Meu produto2")
                        .quantity(1)
                        .unitPrice(new BigDecimal("100"))
                        .build();
        items.add(item2);
        PreferenceRequest request = PreferenceRequest.builder().items(items).build();
        return items;
    }

    public static String createPreference() throws MPException, MPApiException {
        Token.authoToken();
        List<PreferenceItemRequest> listPreference = addItems();
        PreferenceRequest request = PreferenceRequest.builder().items(listPreference).build();
        return new Gson().toJson(client.create(request));
    }

}
