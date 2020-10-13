package com.pascualbravo.cleancarweb.service.iface;

import com.pascualbravo.cleancarweb.models.entity.Administradores;
import java.util.List;

public interface AdministradoresService {
    
    List<Administradores> getAll();
    
    public void create(Administradores administradores);
    
    public void update(int cedulaAdmin, Administradores administradores); 
    
    public void delete(int cedulaAdmin);
}
