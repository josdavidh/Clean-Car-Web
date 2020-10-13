package com.pascualbravo.cleancarweb.service.iface;

import com.pascualbravo.cleancarweb.models.entity.Servicios;
import java.util.List;

public interface ServiciosService {
    
    List<Servicios> getAll();
    
    public void update(int idServicios, Servicios servicios );
        
    
}
