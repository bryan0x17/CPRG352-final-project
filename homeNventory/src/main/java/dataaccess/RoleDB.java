/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccess;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import models.Role;

/**
 *
 * @author Bryan
 */
public class RoleDB {
    public List<Role> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Query query = em.createNamedQuery("Role.findAll");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Role get(Integer id) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Role role = em.find(Role.class, id);
            return role;
        } finally {
            em.close();
        }
    }

    public boolean insert(Role role) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        try {
            et.begin();
            em.persist(role);
            em.merge(role);
            et.commit();
            return true;
        } catch (Exception ex) {
            et.rollback();
            return false;
        } finally {
            em.close();
        }
    }

    public boolean update(Role role) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        try {
            et.begin();
            em.merge(role);
            et.commit();
            return true;
        } catch (Exception ex) {
            et.rollback();
            return false;
        } finally {
            em.close();
        }
    }

    public boolean delete(Role role) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        try {
            et.begin();
            em.remove(em.merge(role));
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
