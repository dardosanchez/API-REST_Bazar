package com.example.APIBazar.Service;

import com.example.APIBazar.Model.Producto;
import com.example.APIBazar.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServices implements IProductoServices{
    @Autowired
    private ProductoRepository prodRepository;

    @Override
    public void saveProducto(Producto producto) {
        prodRepository.save(producto);
    }

    @Override
    public List<Producto> getProductos() {
        return prodRepository.findAll();
    }

    @Override
    public Producto getProducto(Long id) {
        return prodRepository.findById(id).orElse(null);
    }

    @Override
    public void editProducto(Producto producto) {
        this.saveProducto(producto);
    }

    @Override
    public void deleteProducto(Long id) {
        prodRepository.deleteById(id);
    }

    @Override
    public List<Producto> faltaStock() {
        List<Producto> listaProductos = this.getProductos();

        List<Producto> listaStock = new ArrayList<Producto>();

        for (Producto produ: listaProductos ) {
            if(produ.getCantidad_disponible()<5){
                listaStock.add(produ);
            }
        }

        return listaStock;
    }
}
