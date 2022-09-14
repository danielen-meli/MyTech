import com.mercadopago.*;

import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;
import java.math.BigDecimal;

public class MyTech {
    public static void main(String[] args) {
            MercadoPagoConfig.setAccessToken("APP_USR-6688518569707536-091413-315cd4e1eacdc16c7f04db7800e2f5a6-1197139545");

            PaymentClient client = new PaymentClient();

            PaymentCreateRequest createRequest =
                    PaymentCreateRequest.builder()
                            .transactionAmount(new BigDecimal(1000))
                            .token("your_cardtoken")
                            .description("description")
                            .installments(1)
                            .paymentMethodId("visa")
                            .payer(PaymentPayerRequest.builder().email("dummy_email").build())
                            .build();

            try {
                Payment payment = client.create(createRequest);
                System.out.println(payment);
            } catch (MPApiException ex) {
                System.out.printf(
                        "MercadoPago Error. Status: %s, Content: %s%n",
                        ex.getApiResponse().getStatusCode(), ex.getApiResponse().getContent());
            } catch (MPException ex) {
                ex.printStackTrace();
            }
        }
}

