package com.example.BackendTp7Lc4React.services;

import com.example.BackendTp7Lc4React.entities.Dto.PreferenceItemDto;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferencePayerRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import com.mercadopago.resources.preference.PreferenceItem;
import com.mercadopago.resources.preference.PreferencePayer;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MercadoPagoService {
    @Value("${mercado.pago.access.token}")
    private String mercadoPagoAccessToken;

    @PostConstruct
    public void init() {
        MercadoPagoConfig.setAccessToken(mercadoPagoAccessToken);
    }

    public Preference createPreference(List<PreferenceItemDto> items) throws MPApiException, MPException {
        List<PreferenceItemRequest> preferenceItems = items.stream()
                .map(item -> PreferenceItemRequest.builder()
                        .id(item.getId())
                        .title(item.getTitle())
                        .description(item.getDescription())
                        .pictureUrl(item.getPictureUrl())
                        .categoryId(item.getCategoryId())
                        .quantity(item.getQuantity())
                        .currencyId(item.getCurrencyId())
                        .unitPrice(item.getUnitPrice())
                        .build())
                .collect(Collectors.toList());

        PreferencePayerRequest payer = PreferencePayerRequest.builder()
                .email("test_user@test.com")
                .build();

        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .items(preferenceItems)
                .payer(payer)
                .build();

        PreferenceClient client = new PreferenceClient();
        return client.create(preferenceRequest);
    }
}
