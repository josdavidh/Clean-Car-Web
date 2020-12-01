package com.pascualbravo.cleancarweb.models.repository;

import com.pascualbravo.cleancarweb.models.entity.Administradores;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface AdministradoresRepository extends CrudRepository<Administradores,Integer>{
    Optional<Administradores> findByCedulaAdminAndPassword(int cedulaAdmin,String password);
}
