package com.example.APIBazar.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MayorVentaDTO {

    private Long codigo_venta;
    private Double total;
    private int cantProductos;
    private String nombreCliente;
    private String apellidoCliente;

    public MayorVentaDTO() {
    }

    public MayorVentaDTO(Long codigo_venta, Double total, int cantProductos, String nombreCliente, String apellidoCliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantProductos = cantProductos;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }
}
