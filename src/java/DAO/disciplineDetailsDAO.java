/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import bean.Disciplinedetails;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author vudung
 */
public class disciplineDetailsDAO {

    public static Session getSession() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        return session;
    }

    public Disciplinedetails[] getlist() {
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            String sql = "from Disciplinedetails";
            Query query = session.createQuery(sql);
            List list = query.list();

            Collections.sort(list, new Comparator<Disciplinedetails>() {
                
                public int compare(Disciplinedetails disdetails1, Disciplinedetails disdetails2) {
                    if (disdetails1.getDate() == null || disdetails2.getDate() == null) {
                        return 0;
                    }
                    return disdetails1.getDate().compareTo(disdetails2.getDate());
                }
            }
            );
            Disciplinedetails[] result = new Disciplinedetails[list.size()];
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

    public Disciplinedetails getDisdetails(int id) {
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            Disciplinedetails result = (Disciplinedetails) session.get(Disciplinedetails.class, id);
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

    public boolean update(Disciplinedetails disdetails) {
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            session.update(disdetails);
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

    public boolean delete(int id) {
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            Disciplinedetails disdetails = (Disciplinedetails) session.get(Disciplinedetails.class, id);
            session.delete(disdetails);
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

    public boolean add(Disciplinedetails disdetails) {
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            session.save(disdetails);
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

    public static void main(String[] args) {
        disciplineDetailsDAO dao = new disciplineDetailsDAO();
        Disciplinedetails[] b = dao.getlist();
        for (Disciplinedetails c : b) {
            System.out.println(c.getDate());
        }
    }
}
