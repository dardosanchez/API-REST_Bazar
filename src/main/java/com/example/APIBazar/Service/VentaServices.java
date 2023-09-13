package com.example.APIBazar.Service;



import com.example.APIBazar.DTO.MayorVentaDTO;
import com.example.APIBazar.DTO.MontoYCantidadDTO;
import com.example.APIBazar.Model.Producto;
import com.example.APIBazar.Model.Venta;
import com.example.APIBazar.Repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaServices implements IVentaServices{

    @Autowired
    private VentaRepository repoVenta;

    @Override
    public void saveVenta(Venta venta) {
        venta.setTotal(this.calcularTotal(venta));
        repoVenta.save(venta);
    }

    @Override
    public List<Venta> getVentas() {
        return repoVenta.findAll();
    }

    @Override
    public Venta getVenta(Long id) {
        return repoVenta.findById(id).orElse(null);
    }

    @Override
    public void editVenta(Venta venta) {
        this.saveVenta(venta);
    }

    @Override
    public void deleteVenta(Long id) {
        repoVenta.deleteById(id);
    }

    @Override
    public double sumatoriaMonto(LocalDate fechaVenta) {
        List<Venta> listadoVentas = this.getVentas();
        double monto = 0;

        for (Venta venta: listadoVentas ) {
            if(fechaVenta.isEqual(venta.getFecha_venta())){
                monto += venta.getTotal();
            };
        }
        return monto;
    }

    @Override
    public int cantidadVentas(LocalDate fechaVenta) {
        List<Venta> listadoVentas = this.getVentas();
        int cantidadVentas = 0;

        for (Venta venta: listadoVentas ) {
            if(fechaVenta.isEqual(venta.getFecha_venta())){
                cantidadVentas++;
            };
        }
        return cantidadVentas;
    }

    @Override
    public MontoYCantidadDTO sumatoriaYCantidadDeVentasXDia(LocalDate fechaVenta) {

        MontoYCantidadDTO monCant = new MontoYCantidadDTO();

        monCant.setMontoTotal(this.sumatoriaMonto(fechaVenta));
        monCant.setCantidadVentas(this.cantidadVentas(fechaVenta));

        return monCant;
    }

    @Override
    public Venta ventaMontoMasAlto() {
        List<Venta> listadoVenta = this.getVentas();
        Venta MayorVenta = new Venta();
        MayorVenta.setTotal(0.0);

        for (Venta venta :listadoVenta ) {
            if(venta.getTotal() > MayorVenta.getTotal()){
                MayorVenta = venta;
            }
        }

        return MayorVenta;
    }

    @Override
    public MayorVentaDTO ventaMayorDTO() {
        Venta ventaMayor = this.ventaMontoMasAlto();
        int cantidadProd= this.catidadProducto(ventaMayor.getListaProductos());
        MayorVentaDTO ventaDTO = new MayorVentaDTO();

        ventaDTO.setCodigo_venta(ventaMayor.getCodigo_venta());
        ventaDTO.setTotal(ventaMayor.getTotal());
        ventaDTO.setCantProductos(cantidadProd);
        ventaDTO.setNombreCliente(ventaMayor.getUnCliente().getNombre());
        ventaDTO.setApellidoCliente(ventaMayor.getUnCliente().getApellido());

        return ventaDTO;
    }

    public int catidadProducto (List<Producto> listaProducto){
        int cantidadProd=0;
        for (Producto auxProd: listaProducto) {
            cantidadProd++;
        }
        return cantidadProd;
    }

    public Double calcularTotal(Venta venta){
        Double total = 0.0;
        for (Producto prod: venta.getListaProductos() ) {
            total+= prod.getCosto();
        }
        return total;
    }

}
