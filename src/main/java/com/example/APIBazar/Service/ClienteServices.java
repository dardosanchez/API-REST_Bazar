package com.example.APIBazar.Service;

import com.example.APIBazar.Model.Cliente;
import com.example.APIBazar.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteServices implements IClienteServices{

    @Autowired
    private ClienteRepository repoCliente;

    @Override
    public void saveCliente(Cliente cliente) {
        repoCliente.save(cliente);
    }

    @Override
    public List<Cliente> getClientes() {
        return repoCliente.findAll();
    }

    @Override
    public Cliente getCliente(Long id) {
        return repoCliente.findById(id).orElse(null);
    }

    @Override
    public void editCliente(Cliente cliente) {
        this.saveCliente(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        repoCliente.deleteById(id);
    }
}
