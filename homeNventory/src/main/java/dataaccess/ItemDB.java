/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccess;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import models.Item;

/**
 *
 * @author Bryan
 */
public class ItemDB {
    public List<Item> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Query query = em.createNamedQuery("Item.findAll");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Item get(Integer id) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Item item = em.find(Item.class, id);
            return item;
        } finally {
            em.close();
        }
    }

    public boolean insert(Item item) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        try {
            et.begin();
            em.persist(item);
            em.merge(item);
            et.commit();
            return true;
        } catch (Exception ex) {
            et.rollback();
            return false;
        } finally {
            em.close();
        }
    }

    public boolean update(Item item) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        try {
            et.begin();
            em.merge(item);
            et.commit();
            return true;
        } catch (Exception ex) {
            et.rollback();
            return false;
        } finally {
            em.close();
        }
    }

    public boolean delete(Item item) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        try {
            et.begin();
            em.remove(em.merge(item));
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
