package com.pascualbravo.cleancarweb.service.impl;

import com.pascualbravo.cleancarweb.models.entity.Empleados;
import com.pascualbravo.cleancarweb.models.entity.Recibo;
import com.pascualbravo.cleancarweb.models.entity.Servicios;
import com.pascualbravo.cleancarweb.models.repository.EmpleadosRepository;
import com.pascualbravo.cleancarweb.models.repository.ReciboRepository;
import com.pascualbravo.cleancarweb.models.repository.ServiciosRepository;
import com.pascualbravo.cleancarweb.service.iface.ReciboService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReciboServiceImpl implements ReciboService {

    @Autowired
    private ReciboRepository reciboRepository;

    @Autowired
    private EmpleadosRepository empleadosRepository;

    @Autowired
    private ServiciosRepository serviceRepository;

    @Override
    public List<Recibo> getAll() {
        List<Recibo> recibo = new ArrayList<>();
        reciboRepository.findAll().forEach(recibo::add);
        return recibo;
    }

    @Override
    public void create(Recibo recibo) {
        Optional<Empleados> existEmpleado
                = empleadosRepository.findById(recibo.getCedulaEmp().getCcEmpleado());
        Optional<Servicios> exitsService
                = serviceRepository.findById(recibo.getIdServico().getIdServicios());

        if (existEmpleado.isPresent() && exitsService.isPresent()) {
            reciboRepository.save(recibo);
        }
    }

    @Override
    public void update(int cod, Recibo recibo) {
        Optional<Recibo> existRecibo = reciboRepository.findById(cod);
        if (existRecibo.isPresent()) {
            existRecibo.get().setTotal(recibo.getTotal());
            Optional<Empleados> existEmpleado
                    = empleadosRepository.findById(recibo.getCedulaEmp().getCcEmpleado());
            Optional<Servicios> exitsService
                    = serviceRepository.findById(recibo.getIdServico().getIdServicios());
            if(existEmpleado.isPresent() && exitsService.isPresent()){
                existRecibo.get().setIdServico(recibo.getIdServico());
                existRecibo.get().setCedulaEmp(recibo.getCedulaEmp());
                reciboRepository.save(existRecibo.get());
            }

        }
    }

    @Override
    public void delete(int cod) {
      Optional<Recibo> existRecibo = reciboRepository.findById(cod);
        if (existRecibo.isPresent()) {
            reciboRepository.delete(existRecibo.get());
        }
    }

}
