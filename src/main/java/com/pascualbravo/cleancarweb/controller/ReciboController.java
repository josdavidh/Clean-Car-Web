package com.pascualbravo.cleancarweb.controller;

import com.pascualbravo.cleancarweb.models.entity.Recibo;
import com.pascualbravo.cleancarweb.service.iface.ReciboService;
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
@RequestMapping("/recibo")
@CrossOrigin("*")
public class ReciboController {
    @Autowired
    private ReciboService reciboService;
    
    @PostMapping
    public void create(@RequestBody Recibo recibo){
        reciboService.create(recibo);
    }
    @GetMapping
    public List<Recibo> getAll(){
        return reciboService.getAll();
    }
    @PutMapping("/{cod}")
    public void update(@PathVariable int cod, @RequestBody Recibo recibo ){
        reciboService.update(cod, recibo);
    }
    @DeleteMapping("/{cod}")
    public void delete(@PathVariable int cod){
        reciboService.delete(cod);
    }
    
}
