/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.disciplineDAO;
import DAO.disciplineDetailsDAO;
import DAO.employeeDAO;
import bean.Disciplinedetails;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vudung
 */
@Controller
@RequestMapping("disciplinedetails")
public class disciplineDetailsController {
    disciplineDetailsDAO dao=new disciplineDetailsDAO();
    employeeDAO empdao=new employeeDAO();
    disciplineDAO disdao=new disciplineDAO();
    Disciplinedetails[] disdetailsList;
    
    @RequestMapping("show")
    public String show(ModelMap model,HttpSession session){
        session.setAttribute("webName2", "DisciplineDetails");
        disdetailsList=dao.getlist();
        model.addAttribute("disdetailsList",disdetailsList);
        return "DisciplineDetails";
    }
    @RequestMapping("edit")
    public String edit(ModelMap model,HttpServletRequest request){
        int ID=Integer.parseInt(request.getParameter("disdetailsID"));
        model.addAttribute("disdetails", dao.getDisdetails(ID));
        model.addAttribute("emplist", empdao.getListNhanVien());
        model.addAttribute("dislist", disdao.getlistDis());
        return "disciplineDetails/edit";
    }
    @RequestMapping(params = "btnUpdate")
    public String update(@ModelAttribute("disdetails") Disciplinedetails disdetails,ModelMap model,HttpServletRequest request) throws ParseException{
        String txtDate=request.getParameter("txtDate");
        model.addAttribute("emplist", empdao.getListNhanVien());
        model.addAttribute("dislist", disdao.getlistDis());
        if(txtDate.equals("")==false){
             Date date = new SimpleDateFormat("yyyy-MM-dd").parse(txtDate);
             disdetails.setDate(date);
        }
        if(disdetails.getEmployee().getEmployeeId()==0){
            model.addAttribute("employeeerr", "Please select Employee name");
            return "disciplineDetails/edit";
        }
        if(disdetails.getDiscipline().getDisId()==0){
            model.addAttribute("disciplineerr", "Please select Discipline name");
            return "disciplineDetails/edit";
        }
        if(disdetails.getFormality().trim().equals("")){
            model.addAttribute("formalityerr", "Please enter Fomality");
            return "disciplineDetails/edit";
        }
        if(txtDate.equals("")){
            model.addAttribute("dateerr", "Please select date");
            return "disciplineDetails/edit";
        }
        if(disdetails.getReason().trim().equals("")){
            model.addAttribute("reasonerr", "Please enter reason");
            return "disciplineDetails/edit";
        }
        dao.update(disdetails);
        
        
        disdetailsList=dao.getlist();
        model.addAttribute("disdetailsList",disdetailsList);
        return "DisciplineDetails";
    }
    
    @RequestMapping("add")
    public String add(ModelMap model){
        model.addAttribute("emplist", empdao.getListNhanVien());
        model.addAttribute("dislist", disdao.getlistDis());
        Disciplinedetails disdetails=new Disciplinedetails();
        
        model.addAttribute("disdetails", disdetails);
        return "disciplineDetails/insert";
    }
    @RequestMapping(value="add",params = "btnSave")
    public String save(ModelMap model, @ModelAttribute("disdetails") Disciplinedetails disdetails,HttpServletRequest request  ) throws ParseException{
        String txtDate=request.getParameter("txtDate");
        model.addAttribute("emplist", empdao.getListNhanVien());
        model.addAttribute("dislist", disdao.getlistDis());
        if(txtDate.equals("")==false){
             Date date = new SimpleDateFormat("yyyy-MM-dd").parse(txtDate);
             disdetails.setDate(date);
        }
        String employeeId=request.getParameter("employee.employeeId");
        if(employeeId.equals("0")){
            model.addAttribute("employeeerr", "Please select Employee name");
            return "disciplineDetails/insert";
        }
        disdetails.setEmployee(empdao.getEmp(Integer.parseInt(employeeId)));
        /////////
        String disId=request.getParameter("discipline.disId");
        if(disId.equals("0")){
            model.addAttribute("disciplineerr", "Please select Discipline name");
            return "disciplineDetails/insert";
        }
        disdetails.setDiscipline(disdao.getDis(Integer.parseInt(disId)));
        if(disdetails.getFormality().trim().equals("")){
            model.addAttribute("formalityerr", "Please enter Formality");
            return "disciplineDetails/insert";
        }
        if(txtDate.equals("")){
            model.addAttribute("dateerr", "Please select Date");
            return "disciplineDetails/insert";
        }
        if(disdetails.getReason().trim().equals("")){
            model.addAttribute("reasonerr", "Please enter Reason");
            return "disciplineDetails/insert";
        }
        
        dao.add(disdetails);
        disdetailsList=dao.getlist();
        model.addAttribute("disdetailsList",disdetailsList);
        return "DisciplineDetails";
    }
    
    
    @RequestMapping("delete")
    public String delete(ModelMap model, HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("txtDisdetailsID"));
        dao.delete(id);      
        disdetailsList=dao.getlist();
        model.addAttribute("disdetailsList",disdetailsList);
        return "DisciplineDetails";
    }
}
