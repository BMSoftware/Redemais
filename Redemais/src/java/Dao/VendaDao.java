package Dao;

import Model.Venda;
import java.util.List;

/**
 *
 * @author Bruno
 */
public interface VendaDao {

    public void save(Venda venda);

    public Venda getVenda(int idVenda);

    public List<Venda> list();

    public void remove(Venda venda);

    public void update(Venda venda);
}
