package Controller;

import Dao.VendaDao;
import Dao.VendaDaoImp;
import Model.Cliente;
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
    private Venda venda;
    private DataModel listaVendas;

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
    
    public String prepararListarVenda(){
        return "listarVenda";
    }

    public String excluirVenda() {
        Venda vendaTemp = (Venda) (listaVendas.getRowData());
        VendaDao dao = new VendaDaoImp();
        dao.remove(vendaTemp);
        return "venda";
    }

    public String adicionarVenda() {
        FacesContext context = FacesContext.getCurrentInstance();
        if(this.venda.getValor()!= this.venda.getConfirmaValor()){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Os valores inseridos não são iguais", ""));
            return "venda";
        }
        VendaDao dao = new VendaDaoImp();
        dao.save(venda);
        return "venda";
    }

    public void alterarVenda(ActionEvent actionEvent) {
        VendaDao dao = new VendaDaoImp();
        dao.update(venda);
    }
}
