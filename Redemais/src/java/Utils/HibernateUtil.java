package Utils;

import Model.Cancelamento;
import Model.Cliente;
import Model.Empresa;
import Model.Venda;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Bruno
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                AnnotationConfiguration ac = new AnnotationConfiguration();
                ac.addAnnotatedClass(Cancelamento.class);
                ac.addAnnotatedClass(Cliente.class);
                ac.addAnnotatedClass(Empresa.class);
                ac.addAnnotatedClass(Venda.class);
                sessionFactory = ac.configure().buildSessionFactory();
            } catch (Throwable ex) {
                // Log the exception.
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
            return sessionFactory;
        } else {
            return sessionFactory;
        }
    }
}
