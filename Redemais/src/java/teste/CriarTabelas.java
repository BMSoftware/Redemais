package teste;

import Model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 *
 * @author Bruno
 */
public class CriarTabelas {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        try {
            AnnotationConfiguration ac = new AnnotationConfiguration();
            ac.addAnnotatedClass(Empresa.class);
            ac.addAnnotatedClass(Cliente.class);
            ac.addAnnotatedClass(Venda.class);
            ac.addAnnotatedClass(Cancelamento.class);
            ac.addAnnotatedClass(Usuario.class);
            ac.addAnnotatedClass(Autorizacao.class);
            sessionFactory = ac.configure().buildSessionFactory();
            SchemaExport se = new SchemaExport(ac);
            se.create(true, true);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }
}
