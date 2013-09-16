package Dao;

import Model.Cancelamento;
import java.util.List;

/**
 *
 * @author Bruno
 */
public interface CancelamentoDao {

    public void save(Cancelamento cancelamento);

    public Cancelamento getCancelamento(int idCancelamento);

    public List<Cancelamento> list();

    public void remove(Cancelamento cancelamento);

    public void update(Cancelamento cancelamento);
}
