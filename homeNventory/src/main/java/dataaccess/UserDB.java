/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import models.User;

/**
 *
 * @author Bryan
 */
public class UserDB {
    public List<User> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Query query = em.createNamedQuery("User.findAll");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public User get(String email) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            User user = em.find(User.class, email);
            return user;
        } finally {
            em.close();
        }
    }
    
    public User getByActivationUuid(String uuid) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Query query = em.createNamedQuery("User.findByActivationUuid");
            query.setParameter("uuid", uuid);
            return (User) query.getSingleResult();
        } finally {
            em.close();
        }
    }

    public boolean insert(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        try {
            et.begin();
            em.persist(user);
            em.merge(user);
            et.commit();
            return true;
        } catch (Exception ex) {
            et.rollback();
            return false;
        } finally {
            em.close();
        }
    }

    public boolean update(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        try {
            et.begin();
            em.merge(user);
            et.commit();
            return true;
        } catch (Exception ex) {
            et.rollback();
            return false;
        } finally {
            em.close();
        }
    }

    public boolean delete(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        try {
            et.begin();
            em.remove(em.merge(user));
            et.commit();
            return true;
        } catch (Exception ex) {
            et.rollback();
            return false;
        } finally {
            em.close();
        }
    }
}
