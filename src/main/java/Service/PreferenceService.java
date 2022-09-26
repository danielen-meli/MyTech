package Service;

import com.google.gson.Gson;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;

import java.util.List;

import static Model.Preference.addItems;

public class PreferenceService {
    static PreferenceClient client = new PreferenceClient();
    Token token = new Token();

    public static String createPreference() throws MPException, MPApiException {
        Token.authoToken();
        List<PreferenceItemRequest> listPreference = addItems();
        PreferenceRequest request = PreferenceRequest.builder().items(listPreference).build();
        return new Gson().toJson(client.create(request));
    }

    public static String getPreference(String id) throws MPException, MPApiException {
        Preference preference = new PreferenceClient().get(id);
        return new Gson().toJson(preference);
    }

    public String updatePreference(String id, PreferenceRequest preference) throws MPException, MPApiException {
        Preference result = new PreferenceClient().update(id, preference);
        return new Gson().toJson(result);
    }
}
