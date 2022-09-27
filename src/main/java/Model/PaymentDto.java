package Model;


import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;

import java.math.BigDecimal;

public class PaymentDto {

    public static PaymentCreateRequest createOrderPayment() {

           PaymentCreateRequest orderPayment =  PaymentCreateRequest.builder()
                    .transactionAmount(new BigDecimal(50))
                    .description("Pagamento Mercado Pago")
                    .paymentMethodId("bolbradesco")
                    .installments(1)
                    .payer(PaymentPayerRequest.builder()
                            .email("test_user_@testuser.com")
                            .firstName("TesteNome").lastName("TesteSobrenome")
                            .identification(
                                    IdentificationRequest.builder()
                                            .type("CPF").number("15635614680").build())
                            .build()

                    ).build();

           return orderPayment;
    }
}
