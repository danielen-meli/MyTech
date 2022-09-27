package Service;

import Model.PaymentDto;
import com.google.gson.Gson;
import com.mercadopago.client.merchantorder.MerchantOrderClient;
import com.mercadopago.client.merchantorder.MerchantOrderCreateRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;

import static Model.PaymentDto.createOrderPayment;


public class PaymentService {
    public static String createPayment() {
        try{
        Token.authoToken();
        PaymentClient paymentClient = new PaymentClient();
        PaymentCreateRequest paymentCreateRequest = PaymentDto.createOrderPayment();
        return new Gson().toJson(paymentClient.create(paymentCreateRequest));
        } catch (Exception err){
            System.out.println(err);
            return null;
        }
    }


}
