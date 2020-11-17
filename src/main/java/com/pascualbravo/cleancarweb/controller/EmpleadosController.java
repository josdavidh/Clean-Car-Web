package com.pascualbravo.cleancarweb.controller;

import com.pascualbravo.cleancarweb.service.iface.EmpleadosService;
import com.pascualbravo.cleancarweb.models.entity.Empleados;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleados")
@CrossOrigin("*")
public class EmpleadosController {
    
    @Autowired
    private EmpleadosService empleadosService;
    
    @GetMapping
    public List<Empleados> getAll(){
        return empleadosService.getAll();
    }
    
    @PostMapping
    public void create(@RequestBody Empleados empleado){
        empleadosService.create(empleado);
    }
    
    @PutMapping("/{cc}")
    public void update(@PathVariable int cc, @RequestBody Empleados empleados) {
        empleadosService.update(cc, empleados);
    }
    
    @DeleteMapping("/{cc}")
    public void delete(@PathVariable int cc) {
        empleadosService.delete(cc);
    }
}
