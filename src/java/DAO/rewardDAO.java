/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.userDAO.getSession;
import bean.Reward;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author vudung
 */
public class rewardDAO {
    public static Session getSession() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        return session;
    }
    public Reward[] getList(){
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            String sql = "from Reward";
            Query query = session.createQuery(sql);
            List list = query.list();
            Reward[] result = new Reward[list.size()];
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
    public Reward getRew(int id){
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            Reward rew=(Reward)session.get(Reward.class, id);
            session.flush();
            trans.commit();
            return rew;
        }catch(Exception e){
            if (trans.isActive()) {
                trans.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }
    public boolean update(Reward rew){
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            session.update(rew);
            session.flush();            
            trans.commit();
            return true;
        }catch(Exception e){
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
            Reward rew=(Reward)session.get(Reward.class, id);
            session.delete(rew);
            session.flush();            
            trans.commit();
            return true;
        }catch(Exception e){
            if (trans.isActive()) {
                trans.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
    public boolean add(Reward rew){
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            session.save(rew);
            session.flush();            
            trans.commit();
            return true;
        }catch(Exception e){
            if (trans.isActive()) {
                trans.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
}
