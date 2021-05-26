import entities.*;

import javax.persistence.*;
import java.util.*;

public class TestHarness {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("invoiceManagerPersistenceUnit");
        EntityManager em = factory.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        //STEP 1 - find customers

        //1.1
        //Query query = em.createQuery("select c from Customer c");
        TypedQuery<Customer> getAllCustomersQuery = em.createQuery("select c from Customer c", Customer.class);
        List<Customer> customers = getAllCustomersQuery.getResultList();

        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }

        //1.2
        Customer customer81 = em.find(Customer.class, 81L);
        System.out.println("Customer 81 is " + customer81);

        //1.3
        TypedQuery<Customer> getSpecificCustomerQuery =
                em.createQuery("select c from Customer c where c.phone like '+33%'", Customer.class);
        Customer foundCustomer = getSpecificCustomerQuery.getSingleResult();
        System.out.println("Customer " + foundCustomer );

        //STEP 2 - create a customer

       tx.begin();
       Customer newCustomer = new Customer(null,"Fast Trains Ltd","10 Any Road","Any Town", null, "AB1 2CD", "UK", "someemail@notvalid.com", "+44 123456789");
       em.persist(newCustomer);
       tx.commit();

        System.out.println("The new customer was given an ID of " + newCustomer.getId());

        customers = getAllCustomersQuery.getResultList();

        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }

        //STEP 3 - update a customer

        tx.begin();
        newCustomer.setName("Slow Trains Ltd");
        tx.commit();

        customers = getAllCustomersQuery.getResultList();

        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }


        //STEP 4 - delete a customer
        tx.begin();
        em.remove(newCustomer);
        tx.commit();

//        //STEP 5 - Working with relationships
//
//        tx.begin();
//
//        Customer c = em.find( Customer.class, 80L);
//        List<String> items = List.of("First item", "Second item", "Third item");
//        Invoice i = new Invoice(null, c, 13.22, items);
//        c.setInvoices(List.of(i));
//        em.persist(c);
//        tx.commit();
//
//        c = em.find( Customer.class, 80L);
//        System.out.println( c.getInvoices());
//
//        em.close();
//        factory.close();


    }

}

//    //1.4
//    String desiredCountry="USA";
//    TypedQuery<Customer> findByCountryQuery = em.createQuery("select c from Customer c where c.country = :country", Customer.class);
//        findByCountryQuery.setParameter("country", desiredCountry);
//                System.out.println(" there are " + findByCountryQuery.getResultList().size() + " customers in " + desiredCountry);



//tx.begin();
//        Long id = newCustomer.getId();
//        Query udpdateCustomerQuery = em.createQuery("update Customer c set c.name = 'Stopped Trains Ltd' where c.id = :id");
//        udpdateCustomerQuery.setParameter("id", id);
//        int result = udpdateCustomerQuery.executeUpdate();
//        tx.commit();
//        System.out.println(result + " record was updated");
