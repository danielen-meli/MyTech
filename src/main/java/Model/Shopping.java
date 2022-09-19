package Model;

import com.mercadopago.client.customer.CustomerCardCreateRequest;
import com.mercadopago.resources.customer.CustomerCardIssuer;

public class Shopping {
    private String token;
    private CustomerCardIssuer issuer;
    private String paymentMethodId;

    public Shopping(String token, CustomerCardIssuer issuer, String paymentMethodId) {
        this.token = token;
        this.issuer = issuer;
        this.paymentMethodId = paymentMethodId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public CustomerCardIssuer getIssuer() {
        return issuer;
    }

    public void setIssuer(CustomerCardIssuer issuer) {
        this.issuer = issuer;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public CustomerCardCreateRequest convert() {
        return CustomerCardCreateRequest.builder()
                .token(this.token)
                .issuer(this.issuer)
                .paymentMethodId(this.paymentMethodId)
                .build();
    }
}
