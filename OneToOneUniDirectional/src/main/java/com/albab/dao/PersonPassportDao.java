package com.albab.dao;

import com.albab.entity.Passport;
import com.albab.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class PersonPassportDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernate");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    public Person insertDetails(Person person, Passport passport){
        try {
            // Begin the transaction
            et.begin();

            // Persist the Passport entity first
            em.persist(passport);

            // Set the Passport entity to the Person object
            person.setPassport(passport);

            // Persist the Person entity
            em.persist(person);

            // Commit the transaction
            et.commit();

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            em.close(); // Close the EntityManager
        }
        return person;
    }
    public List<Person> getAllDetails() {
        List<Person> personList = new ArrayList<>();

        try {
            // Begin transaction
            et.begin();

            // Query to fetch all Person entities (including their associated Passport)
            personList = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();

            // Commit the transaction
            et.commit();

        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();  // Rollback if an error occurs
            }
            e.printStackTrace();
        } finally {
            em.close();  // Close the EntityManager
        }

        return personList;
    }
    public Person getDataById(int id) {
        Person person = null;

        try {
            // Begin transaction
            et.begin();

            // Fetch the Person entity by ID
            person = em.find(Person.class, id);

            // Commit the transaction
            et.commit();

        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback(); // Rollback in case of an error
            }
            e.printStackTrace();
        } finally {
            em.close(); // Close the EntityManager
        }

        return person;
    }


}
