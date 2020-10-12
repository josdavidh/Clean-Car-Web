package com.pascualbravo.cleancarweb.service.iface;

import com.pascualbravo.cleancarweb.models.entity.Vehiculos;
import java.util.List;

public interface VehiculosService {
    void create(Vehiculos vehiculos);
    
    List<Vehiculos> getAll();
    
    void update(String placa,Vehiculos vehiculos);
    
    void delete(String placa);
}
