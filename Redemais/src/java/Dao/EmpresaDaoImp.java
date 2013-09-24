package Dao;

import Model.Empresa;
import Model.Usuario;
import Utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bruno
 */
public class EmpresaDaoImp implements EmpresaDao {

    @Override
    public Empresa getEmpresa(int idEmpresa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Empresa) session.load(Empresa.class, idEmpresa);
    }

    @Override
    public Empresa getEmpresa(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Empresa.class);
        criteria.add(Restrictions.eq("idEmpresa", usuario.getEmpresa().getIdEmpresa()));
        return (Empresa) criteria.uniqueResult();
    }
    
    
}
