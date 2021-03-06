package Dao;

import Model.Venda;
import Utils.HibernateUtil;
import java.sql.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Bruno
 */
public class VendaDaoImp implements VendaDao {

    @Override
    public void save(Venda venda) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        venda.setDataVenda(new Date(System.currentTimeMillis()));
        venda.setHora(new Date(System.currentTimeMillis()));
        venda.setStatus('A');
        session.save(venda);
        t.commit();
    }

    @Override
    public Venda getVenda(int idVenda) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Venda) session.load(Venda.class, idVenda);
    }

    @Override
    public List<Venda> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Venda v where v.status = 'A'").list();
        t.commit();
        return lista;
    }

    @Override
    public void remove(Venda venda) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(venda);
        t.commit();
    }

    @Override
    public void update(Venda venda) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        session.merge(venda);
        t.commit();
    }
}
