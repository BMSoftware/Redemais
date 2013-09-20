package Dao;

import Model.Cliente;
import Utils.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bruno
 */
public class ClienteDaoImp implements ClienteDao {

    @Override
    public void save(Cliente cliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(cliente);
        t.commit();
    }

    @Override
    public Cliente getCliente(int idCliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("idCliente", idCliente));
        Cliente cliente = (Cliente) criteria.uniqueResult();
        t.commit();
        return cliente;
    }

    @Override
    public Cliente getCliente(String cpfCliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("cpf", cpfCliente));
        Cliente cliente = (Cliente) criteria.uniqueResult();
        t.commit();
        return cliente;
    }

    @Override
    public List<Cliente> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Cliente").list();
        t.commit();
        return lista;
    }

    @Override
    public void remove(Cliente cliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(cliente);
        t.commit();
    }

    @Override
    public void update(Cliente cliente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.merge(cliente);
        t.commit();

    }
}
