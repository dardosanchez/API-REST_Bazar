package com.example.APIBazar.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MontoYCantidadDTO {

    private Double montoTotal;
    public int cantidadVentas;

    public MontoYCantidadDTO() {
    }

    public MontoYCantidadDTO(Double montoTotal, int cantidadVentas) {
        this.montoTotal = montoTotal;
        this.cantidadVentas = cantidadVentas;
    }
}
