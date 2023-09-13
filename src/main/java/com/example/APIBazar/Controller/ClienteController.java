package com.example.APIBazar.Controller;

import com.example.APIBazar.Model.Cliente;
import com.example.APIBazar.Service.IClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteServices interCliente;

    @PostMapping("/clientes/crear")
    public String saveCliente (@RequestBody Cliente cliente){
        interCliente.saveCliente(cliente);
        return "Cliente guardado correctamente";
    }

    @GetMapping("/clientes")
    public List<Cliente> getClientes (){
        return interCliente.getClientes();
    }

    @GetMapping("/clientes/{id_cliente}")
    public Cliente getCliente (@PathVariable Long id_cliente){
        return interCliente.getCliente(id_cliente);
    }

    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente (@PathVariable Long id_cliente){
        interCliente.deleteCliente(id_cliente);
        return "Cliente eliminado correctamente";
    }

    @PutMapping("/clientes/editar/{id_cliente}")
    public Cliente editCliente (@PathVariable Long id_cliente, @RequestBody Cliente cliente ){
        cliente.setId_cliente(id_cliente);
        interCliente.editCliente(cliente);
        return interCliente.getCliente(id_cliente);
    }

}
