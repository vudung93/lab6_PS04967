package controller;

import DAO.departmentDAO;
import DAO.disciplineDetailsDAO;
import DAO.employeeDAO;
import DAO.rewardDetailsDAO;
import bean.Department;
import bean.Employee;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class homeController {

    departmentDAO depdao = new departmentDAO();
    employeeDAO empdao=new employeeDAO();
    rewardDetailsDAO rewdetailsdao=new rewardDetailsDAO();
    disciplineDetailsDAO disdetailsdao=new disciplineDetailsDAO();
    @RequestMapping("")
    public String home(HttpSession session, ModelMap model) {
        session.setAttribute("webName", "Dashboard");
       ////////////////chart.
        Department[] deplist = depdao.getListDepartment();
        ArrayList<Integer> arrdata1 = new ArrayList<Integer>();
        ArrayList<Integer> arrdata2 = new ArrayList<Integer>();
        String[] color={"window.chartColors.red","window.chartColors.orange","window.chartColors.yellow",
                "window.chartColors.green",
                "window.chartColors.blue",
                "window.chartColors.purple",
                "window.chartColors.grey",
                "window.chartColors.Teal",
                "window.chartColors.color1",
                "window.chartColors.color2",
                "window.chartColors.color3"
        };
        String data1="";
        String data2 = "";
        String data3 = "";
        Date date=Calendar.getInstance().getTime();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int yearBeau = cal.get(Calendar.YEAR);
        model.addAttribute("yearNew", yearBeau);
        model.addAttribute("yearOld", yearBeau-1);
        int year=date.getYear();
        
        for (Department dep : deplist) {
            arrdata1.add(depdao.getpoint(dep,year));
            arrdata2.add(depdao.getpoint(dep,year-1));
            data1=data1+dep.getEmployees().size()+",";
            data2=data2+"\""+dep.getDepName()+"\",";
        }
        for(int i=0;i<deplist.length;i++){
            data3=data3+color[i]+",";
        }
        String data4="";
        String data5="";
        for(int i:arrdata1){
            data4=data4+i+",";
            
        }
        for(int i:arrdata2){
            data5=data5+i+",";
        }
        
        model.addAttribute("data1", data1);
        model.addAttribute("data2", data2);
        model.addAttribute("data3", data3);
        ///////////////
        
        model.addAttribute("data4", data4);
        model.addAttribute("data5", data5);
        model.addAttribute("quantitiesEmp",empdao.getListNhanVien().length);
        model.addAttribute("quantitiesDep",depdao.getListDepartment().length);
        model.addAttribute("quantitiesRew", rewdetailsdao.getList().length);
        model.addAttribute("quantitiesDis", disdetailsdao.getlist().length);
        
        Employee[] top10=empdao.top10employee();
        model.addAttribute("top10", top10);
        
        return "Dashboard";
    }

    /*public String tinhtoan(ArrayList<Integer> arr) {

        boolean a = true;
        for (int i : arr) {
            if (i <= 0) {
                a = false;
                break;
            }
        }
        String result = "";
        if (a == true) {
            
            for (int i : arr) {
                result = result + i + ",";
            }
           
        } else {
            int min = Math.abs(Collections.min(arr)) + 1;

            for (int i = 0; i < arr.size(); i++) {
                int k = arr.get(i) + min;
                arr.set(i, k);
            }
            for (int i : arr) {
                result=result+i+",";
            }
        }

        return result;
    }*/
    

}
