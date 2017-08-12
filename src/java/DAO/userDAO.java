/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import bean.Users;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author vudung
 */
public class userDAO {

    public static Session getSession() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        return session;
    }

    public Users getUser(String username, String password) {
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            Users user = (Users) session.get(Users.class, username);
            if(user==null){
               return null; 
            }
            else if(user.getPassword().equals(password)==false){
                return null;
            }
            else if(user.getPassword().equals(password)){
                return user;
            }
            session.flush();
            trans.commit();
            
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }
    public Users[] getList(){
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            String sql = "from Users";
            Query query = session.createQuery(sql);
            List list = query.list();
            Users[] result = new Users[list.size()];
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
    public Users getUser2(String username){
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            Users user=(Users)session.get(Users.class, username);
            session.flush();
            trans.commit();
            return user;
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }
    public boolean resetPass(String username){
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            Users user=(Users)session.get(Users.class, username);
            user.setPassword("123");
            session.save(user);
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
    public boolean delete(String username){
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            Users user=(Users)session.get(Users.class, username);
            
            session.delete(user);
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
