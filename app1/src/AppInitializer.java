import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.security.auth.login.AppConfigurationEntry;

public class AppInitializer {
    public static void main(String[] args) {
        AppInitializer app= new AppInitializer();
        app.saveCustomer();
    }
    
    private void saveCustomer(){
        Customer c1 = new Customer("1","Nimal","Colombo",25000);
        org.hibernate.cfg.Configuration configuration =new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction =session.beginTransaction();
        session.save(c1);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    private void findCustomer(){}
    private void deleteCustomer(){}
    private void modifyCustomer(){}
    private void allCustomers(){}

    
}
