package Dao;

import Model.Empresa;
import Utils.HibernateUtil;
import org.hibernate.Session;

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
}
