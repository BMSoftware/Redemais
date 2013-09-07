package Dao;

import Model.Cliente;
import Utils.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public class ClienteDaoImp implements ClienteDao {

    @Override
    public Cliente getCliente(int idCliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Cliente) session.load(Cliente.class, idCliente);
    }
}
