package com.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dominio.Person;

public class Main {
    
    public static void main(String[] args) {

        /*
         *  ***IMPORTANT***
         * 
         * FOR DIDATIC CONTENT
         * I'VE CHANGED IN './resources/META-INF/persistence.xml'
         * THE METHOD TO GENERATE DATABASE, I PUT TO CREATE A NEW
         * DATA BASE EVERY TIME THIS PROGRAM RUNS.
        */

        /*
         * THIS IS A LITTLE PROJECT JUST TO
         * INTRODUCE MAVEN, JPA AND HIBERNATE
         * AND LEARN HOW TO CONFIGURATE 'pom.xml'
         * AND 'persistance.xml' 
        */

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-project");
        EntityManager em = emf.createEntityManager();
        Person p, p1, p2, p3;

        //Part 1 - Include objects into data base:
        p1 = new Person(null, "Pedro", "pedro@gmail.com");
        p2 = new Person(null, "Valdir", "valdir@gmail.com");
        p3 = new Person(null, "Luciane", "luciane@gmail.com");

        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();

        //--------------------------------------------------------------------------------

        //Part 2 - Recover object from data base:
        p = em.find(Person.class, 1);
        System.out.println(p);

        //--------------------------------------------------------------------------------
        //Part 3 - Update object from data base:
        em.getTransaction().begin();
        p = em.find(Person.class, 1);
        p.setName("newPedro");
        em.getTransaction().commit();
        p = em.find(Person.class, 1);
        System.out.println(p); // JUST TO SEE IN CONSOLE IF WAS TRULY UPDATED

        //--------------------------------------------------------------------------------
        //Part 4 - Delete object from data base:
        em.getTransaction().begin();
        p = em.find(Person.class, 1);
        em.remove(p);
        em.getTransaction().commit();

        //--------------------------------------------------------------------------------
        System.out.println("Done!");

        em.close();
        emf.close();
    }
}