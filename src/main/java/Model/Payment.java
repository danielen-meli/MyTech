package Model;

import com.mercadopago.client.common.IdentificationRequest;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;

import java.math.BigDecimal;

public class Payment {
    public static PaymentCreateRequest paymentObj() {

    PaymentCreateRequest createRequest = PaymentCreateRequest.builder()
            .transactionAmount( new BigDecimal(50))
            .description("Pagamento Mercado Pago")
            .paymentMethodId("bolbradesco")
            .installments(1)
            .payer( PaymentPayerRequest.builder().email("teste@gmail.com")
                            .firstName("TesteNome").lastName("TesteSobrenome")
                .identification(IdentificationRequest.builder()
                    .type("CPF").number("19119119100").build())
                        .build()

            ).build();

        return createRequest;
    }

}
