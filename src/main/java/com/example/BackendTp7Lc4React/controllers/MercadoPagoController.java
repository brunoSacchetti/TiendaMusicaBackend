package com.example.BackendTp7Lc4React.controllers;

import com.example.BackendTp7Lc4React.entities.Dto.PreferenceItemDto;
import com.example.BackendTp7Lc4React.services.MercadoPagoService;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/pagos")
public class MercadoPagoController {
    @Autowired
    private MercadoPagoService mercadoPagoService;

    @PostMapping("/crear-preferencia")
    public Preference createPreference(@RequestBody List<PreferenceItemDto> items) throws MPApiException, MPException {
        return mercadoPagoService.createPreference(items);
    }
}
