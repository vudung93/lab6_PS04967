/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import bean.Discipline;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author vudung
 */
public class disciplineDAO {
   public static Session getSession() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        return session;
    }
   public Discipline[] getlistDis(){
       Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            String sql = "from Discipline";
            Query query = session.createQuery(sql);
            List list = query.list();
            Discipline[] result = new Discipline[list.size()];
            list.toArray(result);
            session.flush();
            trans.commit();
            return result;
        }catch(Exception e){
            if (trans.isActive()) {
                trans.rollback();
            }
            e.printStackTrace();
        }
        return null;
   }
   public Discipline getDis(int ID){
       Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            Discipline dis=(Discipline)session.get(Discipline.class, ID);
            session.flush();
            trans.commit();
            return dis;
        }catch(Exception e){
            if (trans.isActive()) {
                trans.rollback();
            }
            e.printStackTrace();
        }
        return null;
   }
   public boolean delete(int id){
       Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            Discipline dis=(Discipline)session.get(Discipline.class, id);
            session.delete(dis);
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
   public boolean add(Discipline dis){
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            
            session.save(dis);
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
   public boolean update(Discipline dis){
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            
            session.update(dis);
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
