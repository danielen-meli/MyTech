package Service;

import Exceptions.MyTechException;
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

    public static String createPreference() throws MyTechException, MPException, MPApiException {
        try{
            Token.authoToken();
        List<PreferenceItemRequest> listPreference = addItems();
        PreferenceRequest request = PreferenceRequest.builder().items(listPreference).build();
        return new Gson().toJson(client.create(request));
        }
        catch (MPApiException | MPException exception){
            throw new MyTechException("Erro ao criar preferencia");
        }
    }

    public static String getPreference(String id) throws MyTechException {
        try{
            Token.authoToken();
            Preference result = new PreferenceClient().get(id);
            return new Gson().toJson(result);
        }
        catch (MPApiException | MPException exception){
            throw new MyTechException("Erro ao buscar por preferencia");
        }
    }

    public static String updatePreference(String id, PreferenceRequest body) throws MyTechException {
       try{ Token.authoToken();
        Preference pref_up  = new PreferenceClient().update(id, body);
        return new Gson().toJson(pref_up);}
       
       catch (MPApiException | MPException exception){
           throw new MyTechException("Erro ao fazer update de preferencia");
       }
    }

}
