package Controller;

import Dao.CancelamentoDao;
import Dao.CancelamentoDaoImp;
import Model.Cancelamento;
import Model.Venda;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "cancelamentoController", eager = true)
@SessionScoped
public class CancelamentoController implements Serializable {

    @ManagedProperty(value = "#{vendaController}")
    private VendaController vendaBean;
    private Venda venda;
    private Cancelamento cancelamento;

    public VendaController getVendaBean() {
        return vendaBean;
    }

    public void setVendaBean(VendaController vendaBean) {
        this.vendaBean = vendaBean;
    }

    public Venda getVenda() {
        if (vendaBean != null) {
            venda = vendaBean.getVenda();
        }
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Cancelamento getCancelamento() {
        return cancelamento;
    }

    public void setCancelamento(Cancelamento cancelamento) {
        this.cancelamento = cancelamento;
    }

    public String prepararAdicionarCancelamento(Venda venda) {
        cancelamento = new Cancelamento();
        cancelamento.setVenda(venda);
        this.venda = venda;
        this.vendaBean.setVenda(venda);
        return "cancelamento";
    }
    
    public String adicionarCancelamento(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(!this.cancelamento.getSenha().equals("password")){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha errada", ""));
            return "cancelamento";
        }
        CancelamentoDao dao = new CancelamentoDaoImp();
        dao.save(cancelamento);
        return "listarVenda";
    }
}
