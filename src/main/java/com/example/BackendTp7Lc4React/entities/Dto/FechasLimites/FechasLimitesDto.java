package com.example.BackendTp7Lc4React.entities.Dto.FechasLimites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FechasLimitesDto {
    private Date fechaMinima;
    private Date fechaMaxima;
}
