package com.pascualbravo.cleancarweb.service.impl;

import com.pascualbravo.cleancarweb.models.repository.AdministradoresRepository;
import com.pascualbravo.cleancarweb.models.repository.EmpleadosRepository;
import com.pascualbravo.cleancarweb.service.iface.EmpleadosService;
import com.pascualbravo.cleancarweb.models.entity.Administradores;
import com.pascualbravo.cleancarweb.models.entity.Empleados;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadosServiceImpl implements EmpleadosService{
    
    @Autowired
    private EmpleadosRepository empleadosRepository;
    
    @Autowired
    private AdministradoresRepository administradoresRepository;

    @Override
    public void create(Empleados empleados){
       Optional<Administradores> exitsAdministradores=administradoresRepository
               .findById(empleados.getIdJefe().getCedulaAdmin());
        if (exitsAdministradores.isPresent()) {
            empleadosRepository.save(empleados);
        }
    }

    @Override
    public List<Empleados> getAll() {
       List<Empleados> empleados=new ArrayList<>();
       empleadosRepository.findAll().forEach(empleados::add);
       return empleados;
    }

    @Override
    public void update(int cc, Empleados empleado) {
        Optional<Empleados> exitsEmpleado=empleadosRepository.findById(cc);
        if (exitsEmpleado.isPresent()) {
            exitsEmpleado.get().setNombre(empleado.getNombre());
            exitsEmpleado.get().setSalario(empleado.getSalario());
            
            Optional<Administradores> exitsAdministrador=administradoresRepository
                    .findById(empleado.getIdJefe().getCedulaAdmin()); 
            if (exitsAdministrador.isPresent()) {
                exitsEmpleado.get().setIdJefe(empleado.getIdJefe());
            }
            empleadosRepository.save(exitsEmpleado.get());
        }
    }

    @Override
    public void delete(int cc) {
        Optional<Empleados> existEmpleado=empleadosRepository.findById(cc);
        if (existEmpleado.isPresent()) {
            empleadosRepository.delete(existEmpleado.get());
        }
    }
            
    
}
