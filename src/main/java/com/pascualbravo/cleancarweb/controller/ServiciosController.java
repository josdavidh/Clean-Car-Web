package com.pascualbravo.cleancarweb.controller;

import com.pascualbravo.cleancarweb.models.entity.Servicios;
import com.pascualbravo.cleancarweb.service.iface.ServiciosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Servicios")
public class ServiciosController {
    
    @Autowired 
    ServiciosService serviciosService;
    
    @GetMapping
    public List<Servicios> getAll(){
        return serviciosService.getAll();
    }
    
    @PutMapping("/{idServicios}")
    public void update (@PathVariable int idServicios, @RequestBody Servicios servicios){
        serviciosService.update(idServicios, servicios);
    }
    
}
