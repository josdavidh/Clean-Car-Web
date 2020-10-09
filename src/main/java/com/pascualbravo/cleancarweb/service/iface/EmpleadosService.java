package com.pascualbravo.cleancarweb.service.iface;

import com.pascualbravol.cleancarweb.models.entity.Empleados;
import java.util.List;


public interface EmpleadosService {
    void create(Empleados empleados);
    
    List<Empleados> getAll();
    
    void update(int cc, Empleados empleado);
    
    void delete(int cc);
}
