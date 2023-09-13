package com.example.APIBazar.Service;

import com.example.APIBazar.Model.Producto;

import java.util.List;

public interface IProductoServices {

    public void saveProducto (Producto producto);

    public List<Producto> getProductos ();

    public Producto getProducto (Long id);

    public void editProducto (Producto producto);

    public void deleteProducto (Long id);

    public List<Producto> faltaStock();
}
