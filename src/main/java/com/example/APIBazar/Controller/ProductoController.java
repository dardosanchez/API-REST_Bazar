package com.example.APIBazar.Controller;

import com.example.APIBazar.Model.Producto;
import com.example.APIBazar.Service.IProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoServices interProducto;

    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto producto){
        interProducto.saveProducto(producto);
        return "Producto guardado correctamente";
    }

    @GetMapping("/productos")
    public List<Producto> getProductos(){
        return interProducto.getProductos();
    }

    @GetMapping("/productos/{codigo_producto}")
    public Producto getProducto(@PathVariable Long codigo_producto){
        return interProducto.getProducto(codigo_producto);
    }

    @PutMapping("/productos/editar/{codigo_producto}")
    public Producto editarProducto (@PathVariable Long codigo_producto, @RequestBody Producto producto){
        this.saveProducto(producto);
        return interProducto.getProducto(codigo_producto);
    }

    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String eliminarProducto (@PathVariable Long codigo_producto){
        interProducto.deleteProducto(codigo_producto);
        return "Producto eliminado correctamente";
    }

    @GetMapping("/productos/falta_stock")
    public List<Producto> getStock (){
        return interProducto.faltaStock();
    }

}
