/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import models.Category;

/**
 *
 * @author Bryan
 */
public class CategoryDB {
    public List<Category> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Query query = em.createNamedQuery("Category.findAll");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Category get(Integer id) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Category category = em.find(Category.class, id);
            return category;
        } finally {
            em.close();
        }
    }

    public boolean insert(Category category) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        try {
            et.begin();
            em.persist(category);
            em.merge(category);
            et.commit();
            return true;
        } catch (Exception ex) {
            et.rollback();
            return false;
        } finally {
            em.close();
        }
    }

    public boolean update(Category category) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        try {
            et.begin();
            em.merge(category);
            et.commit();
            return true;
        } catch (Exception ex) {
            et.rollback();
            return false;
        } finally {
            em.close();
        }
    }

    public boolean delete(Category category) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        try {
            et.begin();
            em.remove(em.merge(category));
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
