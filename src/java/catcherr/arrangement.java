/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catcherr;

import DAO.departmentDAO;
import bean.Employee;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author vudung
 */
public class arrangement {

    public static ArrayList<Employee> arr(Set<Employee> employees) {
        ArrayList<Employee> arr = new ArrayList<Employee>();
        
        for (Employee e : employees) {
            arr.add(e);
        }
       
        Employee tam;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i+1; j < arr.size(); j++) {
                
                if (arr.get(i).getEmployeeId() < arr.get(j).getEmployeeId()) {
                    
                } else {
                    tam=arr.get(j);
                    arr.set(j, arr.get(i));
                    arr.set(i, tam);
                    
                }
            }
        } 
        return arr;
    }
    public static void main(String[] args) {       
        departmentDAO dao=new departmentDAO();
        arr(dao.getdep(1).getEmployees());
    }
}
