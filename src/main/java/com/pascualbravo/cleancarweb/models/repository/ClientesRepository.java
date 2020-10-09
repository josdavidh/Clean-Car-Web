package com.pascualbravo.cleancarweb.models.repository;

import com.pascualbravo.cleancarweb.models.entity.Clientes;
import org.springframework.data.repository.CrudRepository;

public interface ClientesRepository extends CrudRepository<Clientes,Integer>{
    
}
