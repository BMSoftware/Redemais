package Dao;

import Model.Cliente;
import java.util.List;

/**
 *
 * @author Bruno
 */
public interface ClienteDao {
    
    public void save(Cliente cliente);

    public Cliente getCliente(int idCliente);
    
    public Cliente getCliente(String cpfCliente);

    public List<Cliente> list();

    public void remove(Cliente cliente);

    public void update(Cliente cliente);
}
