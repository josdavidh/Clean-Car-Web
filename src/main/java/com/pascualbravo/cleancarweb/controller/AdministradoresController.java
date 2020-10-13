package com.pascualbravo.cleancarweb.controller;

import com.pascualbravo.cleancarweb.models.entity.Administradores;
import com.pascualbravo.cleancarweb.service.iface.AdministradoresService;
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
@RequestMapping("/Administradores")
public class AdministradoresController {
    @Autowired
    AdministradoresService administradoresService;
    
    @GetMapping
    public List<Administradores> getAll(){
        return administradoresService.getAll();
    }
    
    @PostMapping
    public void create (@RequestBody Administradores administradores){
        administradoresService.create(administradores);
    }
    
    @PutMapping("/{cedulaAdmin}")
    public void updapte(@PathVariable int cedulaAdmin, @RequestBody Administradores administradores){
        administradoresService.update(cedulaAdmin, administradores);
    }
    
    @DeleteMapping("/{cedulaAdmin}")
    public void delete(@PathVariable int cedulaAdmin){
        administradoresService.delete(cedulaAdmin);
    }
    
}
