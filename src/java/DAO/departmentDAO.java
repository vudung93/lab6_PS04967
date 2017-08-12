/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import bean.Department;
import bean.Disciplinedetails;
import bean.Employee;
import bean.Rewardetails;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class departmentDAO {

    public static Session getSession() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        return session;
    }

    public Department[] getListDepartment() {
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            String sql = "from Department";
            Query query = session.createQuery(sql);
            List list = query.list();
            Department[] result = new Department[list.size()];
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

    public Department getdep(int id) {
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            Department dep = (Department) session.get(Department.class, id);
            session.flush();
            trans.commit();
            return dep;
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateDepartment(Department dep1) {
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            Department dep2 = (Department) session.get(Department.class, dep1.getDepId());
            dep2.setDepName(dep1.getDepName());
            dep2.setDepPhone(dep1.getDepPhone());
            dep2.setFounding(dep1.getFounding());
            dep2.setLocation(dep1.getLocation());
            dep2.setFunctions(dep1.getFunctions());
            session.save(dep2);
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

    public boolean insertDepartment(Department dep) {
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            session.save(dep);
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

    public boolean deleteDepartment(int id) {
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            Department dep = (Department) session.get(Department.class, id);
            session.delete(dep);
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


    public int getpoint(Department dep,int year) {
        Date date;
        Calendar cal = Calendar.getInstance();
        Set<Employee> setEmp = dep.getEmployees();
        int point=0;
        for (Employee e : setEmp) {
            Set<Rewardetails> setRew = e.getRewardetailses();
            Set<Disciplinedetails> setDis = e.getDisciplinedetailses();
            Stream<Rewardetails> rewStream = setRew.stream().filter(rew -> rew.getDate().getYear() == year);
            Stream<Disciplinedetails> disStream = setDis.stream().filter(dis -> dis.getDate().getYear() == year);

            Rewardetails[] rewArr = rewStream.toArray(Rewardetails[]::new);
            Disciplinedetails[] disArr = disStream.toArray(Disciplinedetails[]::new);
           int pointEmp=rewArr.length-disArr.length;
            point=point+pointEmp;
        }
        return point;
    }

    public static void main(String[] args) {
        departmentDAO dao = new departmentDAO();
        Department dep = dao.getdep(1);
       

    }
}
