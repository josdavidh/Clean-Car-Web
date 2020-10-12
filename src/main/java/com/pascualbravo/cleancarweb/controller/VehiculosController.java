package com.pascualbravo.cleancarweb.controller;

import com.pascualbravo.cleancarweb.models.entity.Vehiculos;
import com.pascualbravo.cleancarweb.service.iface.VehiculosService;
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
@RequestMapping("/vehiculos")
public class VehiculosController {
    @Autowired
    private VehiculosService vehiculosService;
    
    @GetMapping
    public List<Vehiculos> getAll(){
        return vehiculosService.getAll();
    }
    @PostMapping
    public void create(@RequestBody Vehiculos vehiculos){
        vehiculosService.create(vehiculos);
    }
    @PutMapping("/{placa}")
    public void update(@PathVariable String placa,@RequestBody Vehiculos vehiculos){
        vehiculosService.update(placa, vehiculos);
    }
    @DeleteMapping("/{placa}")
    public void delete(@PathVariable String placa){
        vehiculosService.delete(placa);
    }
}
