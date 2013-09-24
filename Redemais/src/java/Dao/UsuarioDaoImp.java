package Dao;

import Model.Usuario;
import Utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Bruno
 */
public class UsuarioDaoImp implements UsuarioDao{

    @Override
    public Usuario getUsario(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("username", username));
        return (Usuario) criteria.uniqueResult();
    }
    
}
