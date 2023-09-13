package com.example.APIBazar.Service;

import com.example.APIBazar.DTO.MayorVentaDTO;
import com.example.APIBazar.DTO.MontoYCantidadDTO;
import com.example.APIBazar.Model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaServices {

    public void saveVenta (Venta venta);

    public List<Venta> getVentas ();

    public Venta getVenta (Long id);

    public void editVenta (Venta venta);

    public void deleteVenta (Long id);

    public double sumatoriaMonto (LocalDate fechaVenta);

    public int cantidadVentas(LocalDate fechaVenta);

    public MontoYCantidadDTO sumatoriaYCantidadDeVentasXDia (LocalDate fechaVenta);

    public Venta ventaMontoMasAlto ();

    public MayorVentaDTO ventaMayorDTO ();

}
