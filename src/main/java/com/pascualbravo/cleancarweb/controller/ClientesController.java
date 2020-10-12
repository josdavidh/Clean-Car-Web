package com.pascualbravo.cleancarweb.controller;

import com.pascualbravo.cleancarweb.models.entity.Clientes;
import com.pascualbravo.cleancarweb.service.iface.ClientesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    @Autowired
    private ClientesService clientesService;
    
    @GetMapping
    public List<Clientes> getAll(){
        return clientesService.getAll();
    }
    @PostMapping
    public void create(@RequestBody Clientes clientes){
        clientesService.create(clientes);
    }
    
    @PutMapping("/{cedula}")
    public void update(@PathVariable int cedula,@RequestBody Clientes clientes){
        clientesService.update(cedula, clientes);
    }
    @DeleteMapping("/{cedula}")
    public void delete(@PathVariable int cedula){
        clientesService.delete(cedula);
    }
    
    
}
