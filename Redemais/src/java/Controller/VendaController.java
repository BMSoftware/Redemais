package Controller;

import Dao.VendaDao;
import Dao.VendaDaoImp;
import Model.Venda;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Bruno
 */
@ManagedBean
@SessionScoped
public class VendaController {

    private Venda venda;
    private DataModel listaVendas;

    public DataModel getListarVendas() {
        List<Venda> lista = new VendaDaoImp().list();
        listaVendas = new ListDataModel(lista);
        return listaVendas;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public String prepararAdicionarVenda() {
        venda = new Venda();
        return "gerenciarVenda";
    }

    public String prepararAlteraVenda() {
        venda = (Venda) (listaVendas.getRowData());
        return "gerenciarVenda";
    }

    public String excluirVenda() {
        Venda vendaTemp = (Venda) (listaVendas.getRowData());
        VendaDao dao = new VendaDaoImp();
        dao.remove(vendaTemp);
        return "index";
    }

    public String adicionarVenda() {
        VendaDao dao = new VendaDaoImp();
        dao.save(venda);
        return "index";
    }

    public String alterarVenda() {
        VendaDao dao = new VendaDaoImp();
        dao.update(venda);
        return "index";
    }
}