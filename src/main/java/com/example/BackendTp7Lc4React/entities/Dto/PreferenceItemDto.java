package com.example.BackendTp7Lc4React.entities.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PreferenceItemDto {
    private String id;
    private String title;
    private String description;
    private String pictureUrl;
    private String categoryId;
    private int quantity;
    private String currencyId;
    private BigDecimal unitPrice;

    // Getters and Setters
}
