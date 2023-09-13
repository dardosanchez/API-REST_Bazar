package com.example.APIBazar.Controller;

import com.example.APIBazar.DTO.MayorVentaDTO;
import com.example.APIBazar.DTO.MontoYCantidadDTO;
import com.example.APIBazar.Model.Producto;
import com.example.APIBazar.Model.Venta;
import com.example.APIBazar.Service.IVentaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VentaController {

    @Autowired
    private IVentaServices interVenta;

    @PostMapping("/ventas/crear")
    public String crearVenta (@RequestBody Venta venta){
        interVenta.saveVenta(venta);
        return "Venta cargada correctamente";
    }

    @GetMapping("/ventas")
    public List<Venta> getVentas (){
        return interVenta.getVentas();
    }

    @GetMapping("/ventas/{codigo_venta}")
    public Venta getVenta (@PathVariable Long codigo_venta){
        return interVenta.getVenta(codigo_venta);
    }

    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deleteVenta (@PathVariable Long codigo_venta){
         interVenta.deleteVenta(codigo_venta);
        return "Venta eliminada correctamente";
    }

    @PutMapping("/ventas/editar/{codigo_venta}")
    public Venta editVenta (@PathVariable Long codigo_venta, @RequestBody Venta venta){
        venta.setCodigo_venta(codigo_venta);
        interVenta.editVenta(venta);
        return interVenta.getVenta(codigo_venta);
    }

    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> productosDeUnaVenta(@PathVariable Long codigo_venta){
        Venta busquedaVenta = interVenta.getVenta(codigo_venta);
        List<Producto> listaProducto = busquedaVenta.getListaProductos();
        return listaProducto;
    }

    @GetMapping("/ventas/dia/{fechaVenta}")
    public MontoYCantidadDTO TotalVentasPorFecha(@PathVariable("fechaVenta") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fechaVenta) {
        return interVenta.sumatoriaYCantidadDeVentasXDia(fechaVenta);
    }

    @GetMapping("/ventas/mayor_venta")
    public MayorVentaDTO mayorVenta (){
        return interVenta.ventaMayorDTO();
    }
}
