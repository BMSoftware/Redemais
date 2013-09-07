package Controller;

import Dao.ClienteDaoImp;
import Model.Cliente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "cliente", eager = true)
@RequestScoped
public class ClienteController {

    private String clienteNome;

    public String getClienteNome() {
        Cliente cliente = new ClienteDaoImp().getCliente(1);
        clienteNome = cliente.getNome();
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }
}
