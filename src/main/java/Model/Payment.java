/* package Model;

import com.mercadopago.client.common.PhoneRequest;
import com.mercadopago.client.payment.*;
import com.mercadopago.resources.payment.PaymentAdditionalInfo;
import com.mercadopago.resources.payment.PaymentPayer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Payment {
    private PaymentAdditionalInfo additionalInfo;
    private Integer installments;
    private String issuerId;
    private PaymentPayer payer;
    private String description;
    private PaymentOrderRequest order;
    private String paymentMethodId;
    private String token;
    private BigDecimal transactionAmount;

    public Payment(PaymentAdditionalInfo additionalInfo, Integer installments, String issuerId, PaymentPayer payer, String description, PaymentOrderRequest order, String paymentMethodId, String token, BigDecimal transactionAmount) {
        this.additionalInfo = additionalInfo;
        this.installments = installments;
        this.issuerId = issuerId;
        this.payer = payer;
        this.description = description;
        this.order = order;
        this.paymentMethodId = paymentMethodId;
        this.token = token;
        this.transactionAmount = transactionAmount;
    }

    public PaymentAdditionalInfo getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(PaymentAdditionalInfo additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public PaymentPayer getPayer() {
        return payer;
    }

    public void setPayer(PaymentPayer payer) {
        this.payer = payer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PaymentOrderRequest getOrder() {
        return order;
    }

    public void setOrder(PaymentOrderRequest order) {
        this.order = order;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public PaymentCreateRequest convert(){
        List<PaymentItemRequest> items = new ArrayList<>();

        PaymentItemRequest item =
                PaymentItemRequest.builder()
                        .id(additionalInfo.getItems().get(0).getId())
                        .title(additionalInfo.getItems().get(0).getTitle())
                        .description(additionalInfo.getItems().get(0).getDescription())
                        .pictureUrl(
                                additionalInfo.getItems().get(0).getPictureUrl())
                        .categoryId(additionalInfo.getItems().get(0).getCategoryId())
                        .quantity(additionalInfo.getItems().get(0).getQuantity())
                        .unitPrice(additionalInfo.getItems().get(0).getUnitPrice())
                        .build();

        items.add(item);

        PaymentAdditionalInfoPayerRequest payer = PaymentAdditionalInfoPayerRequest.builder()
                .firstName(additionalInfo.getPayer().getFirstName())
                .lastName(additionalInfo.getPayer().getLastName())
                .phone(
                        PhoneRequest.builder().areaCode(additionalInfo.getPayer().getPhone().getAreaCode()).number(additionalInfo.getPayer().getPhone().getNumber()).build())
                .build();

        PaymentAdditionalInfoRequest PaymentAdditionalInfo = PaymentAdditionalInfoRequest.builder()
                .items(items)
                .payer(
                        payer)
                .build();

        PaymentPayerRequest paymentPayer = PaymentPayerRequest.builder()
                .entityType(this.payer.getEntityType())
                .type(this.payer.getType())
                .email(this.payer.getEmail())
                .build();

        return PaymentCreateRequest.builder()
                .issuerId(this.issuerId)
                .additionalInfo(
                        PaymentAdditionalInfo)
                .description(this.description)
                .installments(this.installments)
                .payer(paymentPayer)
                .paymentMethodId(this.paymentMethodId)
                .token(this.token)
                .transactionAmount(this.transactionAmount)
                .build();
    }
}
*/