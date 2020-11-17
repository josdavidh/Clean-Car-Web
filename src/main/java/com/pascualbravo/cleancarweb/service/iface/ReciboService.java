
package com.pascualbravo.cleancarweb.service.iface;

import com.pascualbravo.cleancarweb.models.entity.Recibo;
import java.util.List;

public interface ReciboService {
    List<Recibo> getAll();
    void create(Recibo recibo);
    void update(int cod, Recibo recibo);
    void delete(int cod);
}
