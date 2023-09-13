package com.example.APIBazar.Service;



import com.example.APIBazar.Model.Cliente;

import java.util.List;

public interface IClienteServices {

    public void saveCliente (Cliente cliente);

    public List<Cliente> getClientes ();

    public Cliente getCliente (Long id);

    public void editCliente (Cliente cliente);

    public void deleteCliente (Long id);

}
