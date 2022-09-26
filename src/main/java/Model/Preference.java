package Model;

import com.mercadopago.client.preference.PreferenceItemRequest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Preference {
    public static List<PreferenceItemRequest> addItems() {
        List<PreferenceItemRequest> items = new ArrayList<>();
        PreferenceItemRequest item =
                PreferenceItemRequest.builder()
                        .title("Item 01")
                        .quantity(1)
                        .unitPrice(new BigDecimal("10"))
                        .build();
        items.add(item);

        PreferenceItemRequest item2 =
                PreferenceItemRequest.builder()
                        .title("Item 02")
                        .quantity(2)
                        .unitPrice(new BigDecimal("20"))
                        .build();
        items.add(item2);
        return items;
    }
}
