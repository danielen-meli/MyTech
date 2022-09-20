/* package Service;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.payment.*;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.payment.Payment;


public class PaymentService{

    public Payment processPayment(Model.Payment paymentMd) throws MPException, MPApiException {
        MercadoPagoConfig.setAccessToken("APP_USR-6688518569707536-091413-315cd4e1eacdc16c7f04db7800e2f5a6-1197139545");

        PaymentClient client = new PaymentClient();

        PaymentPayerRequest paymentPayer = PaymentPayerRequest.builder()
                .email(paymentMd.getPayer().getEmail()).build();

        PaymentCreateRequest paymentCreateRequest =
                PaymentCreateRequest.builder()
                        .transactionAmount(paymentMd.getTransactionAmount())
                        .token(paymentMd.getToken())
                        .description(paymentMd.getDescription())
                        .installments(paymentMd.getInstallments())
                        .paymentMethodId(paymentMd.getPaymentMethodId())
                        .payer(paymentPayer)
                        .build();

        try {
            Payment payment = client.create(paymentCreateRequest);
            System.out.println(payment);
        } catch (MPApiException ex) {
            System.out.printf(
                    "MercadoPago Error. Status: %s, Content: %s%n",
                    ex.getApiResponse().getStatusCode(), ex.getApiResponse().getContent());
        } catch (MPException ex) {
            ex.printStackTrace();
        }

    }       }
*/