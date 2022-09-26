package Service;

import com.google.gson.Gson;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import com.mercadopago.resources.payment.PaymentAdditionalInfo;


public class PaymentService {
    static PaymentAdditionalInfo paymentAdditionalInfo = new PaymentAdditionalInfo();
    static PaymentClient paymentClient = new PaymentClient();
    static Payment payment = new Payment();
    // MercadoPagoConfig.setAccessToken("TEST-3400945058736804-081210-23eb23642d6ccff5d60584729fd2488f-1006640405");
    public static String createPayment()  throws MPException, MPApiException {
        Token.authoToken();
        PaymentCreateRequest request = PaymentCreateRequest.builder().build();
        return new Gson().toJson(paymentClient.create(request));
    }

}
