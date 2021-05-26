import entities.*;

import javax.persistence.*;
import javax.transaction.*;
import java.util.*;

public class TestHarness2 {

    static EntityManagerFactory factory;
    static EntityManager em;

    //STEP 1 - parameters
    private static long getNumberOfCustomersByCountry(String country) {
        TypedQuery<Long> query = em.createQuery("Select count(c) from Customer c where c.country = :country", Long.class);
        query.setParameter("country", country);
        long result = query.getSingleResult();
        return result;
    }

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory ("invoiceManagerPersistenceUnit");
        em = factory.createEntityManager();

        long countOfCustomers = getNumberOfCustomersByCountry("USA");
        System.out.println("There are " + countOfCustomers + " customers in the USA");
               
        Customer newCustomer = new Customer (null, "Supersonic Planes Inc", "2033 East Something Street", "NY", null, "12345", "USA", null, null);
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(newCustomer);

        tx.commit();

        em.close();
        //Note that newCustomer is now not managed...

        em = factory.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
        newCustomer.setEmail("superplanes@notvalidemail");
        //em.persist(newCustomer); //this will give an error
        em.merge(newCustomer);
        tx.commit();


        //STEP 4 - rollbacks

        tx.begin();
        String veryLongString = new String(new char[300]).replace('\0', 'x');
        System.out.println(veryLongString);
        newCustomer.setName(veryLongString);
        em.merge(newCustomer);

        try {
            tx.commit();
        }
        catch (Exception e) {
            System.out.println("Something went wrong "+e);
            tx.rollback();
        }


        em.close();
        factory.close();


    }
}
