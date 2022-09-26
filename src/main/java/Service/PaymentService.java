package Service;

import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;

import java.math.BigDecimal;


public class PaymentService {
    public static Model.Payment processPayment(Model.Payment payment)  throws MPException, MPApiException{
        Token.authoToken();
        PaymentClient paymentClient = new PaymentClient();
        PaymentCreateRequest paymentCreateRequest =
                PaymentCreateRequest.builder()
                        .transactionAmount( new BigDecimal(50))
                        .description("Pagamento Mercado Pago")
                        .paymentMethodId("bolbradesco")
                        .installments(1)
                        .payer( PaymentPayerRequest.builder()
                                .email("teste@gmail.com")
                                .firstName("TesteNome").lastName("TesteSobrenome")
                                .identification(
                                        IdentificationRequest.builder()
                                        .type("CPF").number("19119119100").build())
                                .build()

                        ).build();

        Payment createdPayment = paymentClient.create(paymentCreateRequest);
        return new Model.Payment(
                createdPayment.getId(),
                String.valueOf(createdPayment.getStatus()),
                createdPayment.getStatusDetail());
    }


}
