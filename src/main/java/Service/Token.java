package Service;

import com.mercadopago.MercadoPagoConfig;

public class Token {
    public static String getToken() {
        return "APP_USR-6688518569707536-091413-315cd4e1eacdc16c7f04db7800e2f5a6-1197139545";
    }

    public static void authoToken() {
        MercadoPagoConfig.setAccessToken(Token.getToken());
    }
}

