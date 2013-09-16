package Controller;

import Dao.ClienteDao;
import Dao.ClienteDaoImp;
import Model.Cliente;
import Model.Empresa;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Marcos
 */
@ManagedBean(name = "clienteController", eager = true)
@SessionScoped
public class ClienteController implements Serializable {

//    @ManagedProperty(value = "#{empresaController}")
//    private EmpresaController empresaBean;
//    private Empresa empresa;
    private Cliente cliente;
    private DataModel listaClientes;

    public DataModel getListarClientes() {
        List<Cliente> lista = new ClienteDaoImp().list();
        listaClientes = new ListDataModel(lista);
        return listaClientes;
    }

//    public EmpresaController getEmpresaBean() {
//        return empresaBean;
//    }
//
//    public void setEmpresaBean(EmpresaController empresaBean) {
//        this.empresaBean = empresaBean;
//    }
//
//    public Empresa getEmpresa() {
//        if (empresaBean != null) {
//            empresa = empresaBean.getEmpresa();
//        }
//        return empresa;
//    }
//
//    public void setEmpresa(Empresa empresa) {
//        this.empresa = empresa;
//    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String prepararAdicionarCliente() {
        cliente = new Cliente();
        return "cliente";
    }

    public String prepararAlterarCliente() {
        cliente = (Cliente) (listaClientes.getRowData());
        return "cliente";
    }

    public String excluirCliente() {
        Cliente clienteTemp = (Cliente) (listaClientes.getRowData());
        ClienteDao dao = new ClienteDaoImp();
        dao.remove(clienteTemp);
        return "index";
    }

    public String adicionarCliente() {
        ClienteDao dao = new ClienteDaoImp();
        dao.save(cliente);
        return "index";
    }

    public String alterarCliente() {
        ClienteDao dao = new ClienteDaoImp();
        dao.update(cliente);
        return "index";
    }
}
