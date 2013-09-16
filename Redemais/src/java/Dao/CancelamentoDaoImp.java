package Dao;

import Model.Cancelamento;
import Utils.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Bruno
 */
public class CancelamentoDaoImp implements CancelamentoDao {

    @Override
    public void save(Cancelamento cancelamento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        cancelamento.setDataCancelamento(new Date(System.currentTimeMillis()));
        cancelamento.setHora(new Date(System.currentTimeMillis())); 
        cancelamento.setIdUser(1);
        session.save(cancelamento);
        t.commit();
        cancelamento.getVenda().setStatus('C');
        new VendaDaoImp().update(cancelamento.getVenda());
    }

    @Override
    public Cancelamento getCancelamento(int idCancelamento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Cancelamento) session.load(Cancelamento.class, idCancelamento);
    }

    @Override
    public List<Cancelamento> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List lista = session.createQuery("from Cancelamento").list();
        t.commit();
        return lista;
    }

    @Override
    public void remove(Cancelamento cancelamento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(cancelamento);
        t.commit();
    }

    @Override
    public void update(Cancelamento cancelamento) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.merge(cancelamento);
        t.commit();
    }
}
