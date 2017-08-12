/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import bean.Rewardetails;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author vudung
 */
public class rewardDetailsDAO {
    public static Session getSession() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        return session;
    }
    public Rewardetails[] getList(){
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            String sql = "from Rewardetails";
            Query query = session.createQuery(sql);
            List list = query.list();
            Rewardetails[] result = new Rewardetails[list.size()];
            list.toArray(result);
            session.flush();
            trans.commit();
            return result;
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }
    public Rewardetails getRewdetails(int id){
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            Rewardetails rewdetails=(Rewardetails)session.get(Rewardetails.class, id);
            session.flush();
            trans.commit();
            return rewdetails;
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }
    public boolean update(Rewardetails rewdetails){
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            session.update(rewdetails);
            session.flush();
            trans.commit();
            return true;
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
    public boolean delete(int id){
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            Rewardetails rewdetails=(Rewardetails)session.get(Rewardetails.class, id);
            session.delete(rewdetails);
            session.flush();
            trans.commit();
            return true;
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
    public boolean add(Rewardetails rewdetails){
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            session.save(rewdetails);
            session.flush();
            trans.commit();
            return true;
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
}
