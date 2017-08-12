package DAO;

import bean.Employee;
import static catcherr.err.copyFile;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class employeeDAO {

    public static Session getSession() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        return session;
    }

    public Employee[] getListNhanVien() {
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            String sql = "from Employee";
            Query query = session.createQuery(sql);
            List list = query.list();
            Employee[] result = new Employee[list.size()];
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

    public boolean deleteEmployee(int MaNV) {
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            Employee e = (Employee) session.get(Employee.class, MaNV);
            session.delete(e);

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

    public boolean updateEmployee(Employee emp, String path, String path2) {
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            session.update(emp);
            session.flush();
            if (emp.getPhoto().equals("") == false && path.equals("") == false && path2.equals("") == false) {
                copyFile(path, path2, emp.getPhoto());
            }

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

    public boolean addEmployee(Employee emp, String path, String path2) {
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            session.save(emp);
            session.flush();
            if (emp.getPhoto().equals("") == false && path.equals("") == false && path.equals("") == false) {
                copyFile(path, path2, emp.getPhoto());
            }
            trans.commit();
            return true;
        } catch (Exception ex) {
            if (trans.isActive()) {
                trans.rollback();
            }
            ex.printStackTrace();
        }

        return false;
    }

    public Employee getEmp(int id) {
        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            Employee emp = (Employee) session.get(Employee.class, id);
            session.flush();
            trans.commit();
            return emp;
        } catch (Exception ex) {
            if (trans.isActive()) {
                trans.rollback();
            }
            ex.printStackTrace();
        }
        return null;
    }

    public Employee[] top10employee() {

        Session session = getSession();
        Transaction trans = session.getTransaction();
        try {
            trans.begin();
            String sql = "from Employee";
            Query query = session.createQuery(sql);
            List<Employee> list = query.list();
            Collections.sort(list, new Comparator<Employee>() {

                public int compare(Employee emp1, Employee emp2) {
                    int point1 = emp1.getRewardetailses().size() - emp1.getDisciplinedetailses().size();
                    int point2 = emp2.getRewardetailses().size() - emp2.getDisciplinedetailses().size();
                    if (point1 > point2) {
                        return -1;
                    } else if (point1 == point2) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            }
            );
            Employee[] result = new Employee[10];
            for (int i = 0; i < 10; i++) {
                result[i] = list.get(i);
            }
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

    

    public static void main(String[] args) {
        employeeDAO dao = new employeeDAO();
        Date date ; // your date
        System.out.println(Calendar.getInstance().getTime().getYear());
        
    }
}
