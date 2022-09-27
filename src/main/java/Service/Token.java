package Service;

import com.mercadopago.MercadoPagoConfig;

public class Token {
    public static String getToken() {
        return "TEST-6688518569707536-091413-969051e7d99d7c2b3af3fac162761973-1197139545";
    }

    public static void authoToken() {
        MercadoPagoConfig.setAccessToken(Token.getToken());
    }
}

