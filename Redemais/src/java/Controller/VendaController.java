package Controller;

import Dao.ClienteDao;
import Dao.ClienteDaoImp;
import Dao.VendaDao;
import Dao.VendaDaoImp;
import Model.Cliente;
import Model.Empresa;
import Model.Venda;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "vendaController", eager = true)
@SessionScoped
public class VendaController implements Serializable {

    @ManagedProperty(value = "#{clienteController}")
    private ClienteController clienteBean;
    private Cliente cliente;
    @ManagedProperty(value = "#{empresaController}")
    private EmpresaController empresaBean;
    private Empresa empresa;
    private Venda venda;
    private DataModel listaVendas;
    private String cfpTemp;
    private String nomeTemp;

    public DataModel getListarVendas() {
        List<Venda> lista = new VendaDaoImp().list();
        listaVendas = new ListDataModel(lista);
        return listaVendas;
    }

    public ClienteController getClienteBean() {
        return clienteBean;
    }

    public void setClienteBean(ClienteController clienteBean) {
        this.clienteBean = clienteBean;
    }

    public Cliente getCliente() {
        if (clienteBean != null) {
            cliente = clienteBean.getCliente();
        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EmpresaController getEmpresaBean() {
        return empresaBean;
    }

    public void setEmpresaBean(EmpresaController empresaBean) {
        this.empresaBean = empresaBean;
    }

    public Empresa getEmpresa() {
        if(empresaBean != null){
            empresa = empresaBean.getEmpresa();
        }
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public String prepararAdicionarVenda() {
        venda = new Venda();
        return "venda";
    }

    public void prepararAlterarVenda(ActionEvent actionEvent) {
        venda = (Venda) (listaVendas.getRowData());
    }

    public String prepararListarVenda() {
        return "listarVenda";
    }

    public void validarCliente() {
        if (venda.getIdCliente() != 0) {
            ClienteDao dao = new ClienteDaoImp();
                Cliente clienteTemp = dao.getCliente(venda.getIdCliente());
                if (clienteTemp != null) {
                    setNomeTemp(clienteTemp.getNome());
                } else {
                    setNomeTemp("");
                }
        } else {
            if (venda.getCpfCliente() != null && !venda.getCpfCliente().equals("")) {
                ClienteDao dao = new ClienteDaoImp();
                Cliente clienteTemp = dao.getCliente(venda.getCpfCliente());
                if (clienteTemp != null) {
                    setNomeTemp(clienteTemp.getNome());
                } else {
                    setNomeTemp("");
                }
            } else {
                setNomeTemp("");
            }
        }
    }

    public String excluirVenda() {
        Venda vendaTemp = (Venda) (listaVendas.getRowData());
        VendaDao dao = new VendaDaoImp();
        dao.remove(vendaTemp);
        return "venda";
    }

    public String adicionarVenda() {
        setNomeTemp("");
        FacesContext context = FacesContext.getCurrentInstance();
        if (this.venda.getValor() != this.venda.getConfirmaValor()) {
            //venda = new Venda();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Os valores inseridos não são iguais", ""));
            return "venda";
        }
        VendaDao dao = new VendaDaoImp();
        try {
            dao.save(venda);
        } catch (ConstraintViolationException npe) {
            venda = new Venda();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi encontrado nenhum cliente com esse código ou CPF", ""));
            return "venda";
        }
        return prepararAdicionarVenda();
    }

    public void alterarVenda(ActionEvent actionEvent) {
        VendaDao dao = new VendaDaoImp();
        dao.update(venda);
    }

    public String getCfpTemp() {
        return cfpTemp;
    }

    public void setCfpTemp(String cfpTemp) {
        this.cfpTemp = cfpTemp;
    }

    public String getNomeTemp() {
        return nomeTemp;
    }

    public void setNomeTemp(String nomeTemp) {
        this.nomeTemp = nomeTemp;
    }
}
