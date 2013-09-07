package Controller;

import Model.Cliente;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "clienteController", eager = true)
@SessionScoped
public class ClienteController implements Serializable{

    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
