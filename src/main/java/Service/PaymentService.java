package Service;

import Exceptions.MyTechException;
import Model.PaymentDto;
import com.google.gson.Gson;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;


public class PaymentService {
    public static String createPayment() throws MyTechException {
        try{
            Token.authoToken();
            PaymentClient paymentClient = new PaymentClient();
            PaymentCreateRequest paymentCreateRequest = PaymentDto.createOrderPayment();
            return new Gson().toJson(paymentClient.create(paymentCreateRequest));
            // teria que mudar o objeto - um DTO da resposta - para setar os valores da resposta e ai então a resposta

        } catch (MPApiException | MPException exception){
            throw new MyTechException("Erro ao criar ordem de pagamento");
    }
}}
