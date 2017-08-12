/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.departmentDAO;
import bean.Department;
import catcherr.arrangement;


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
 * @author Administrator
 */
@Controller
@RequestMapping("/department")
public class departmentController {
    departmentDAO dao=new departmentDAO();
    Department[] deplist;
    
    @RequestMapping("show")
    public String department(HttpSession session, ModelMap model){
        session.setAttribute("webName","Department");
        deplist= dao.getListDepartment();
        model.addAttribute("deplist",deplist);
        return "Department";
    }
    @RequestMapping("details")
    public String details(HttpServletRequest request,ModelMap model){
        int depID=Integer.parseInt(request.getParameter("DepID"));
        int stt=Integer.parseInt(request.getParameter("STT"));
        deplist=dao.getListDepartment();
        model.addAttribute("department", deplist[stt-1]);
        
        return "department/details";
    }
    @RequestMapping(params ="btnUpdatedep")
    public String update(ModelMap model, @ModelAttribute("department") Department dep,HttpServletRequest request) throws ParseException {
        int ID=Integer.parseInt(request.getParameter("depId"));
        dep.setEmployees(dao.getdep(ID).getEmployees());
        String txtFounding = request.getParameter("txtFounding");
        if(txtFounding.equals("")==false){
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(txtFounding);
            dep.setFounding(date);
        }
        String depName=request.getParameter("depName");
        if(depName.equals("")){
            model.addAttribute("depNameerr","Please enter department name");
            return "department/details";
        }
        dep.setDepName(depName);
        //////////////////////
        String depPhone=request.getParameter("depPhone");
        if(depPhone.equals("")){
            model.addAttribute("depPhoneerr","Please enter department phone");
            return "department/details";
        }
        dep.setDepPhone(depPhone);
        //////////////////////
        String location=request.getParameter("location");
        if(location.equals("")){
            model.addAttribute("locationerr","Please enter department location");
            return "department/details";
        }
        dep.setLocation(location);
        ///////////////////////
        if(txtFounding.equals("")){
            model.addAttribute("foundingerr","Please select department founding date");
            return "department/details";
        }
        
        ///////////////////////
        
        String functions=request.getParameter("functions");
        if(functions.equals("")){
            model.addAttribute("functionserr","Please enter department function");
            return "department/details";
        }
        dep.setFunctions(functions);
        
        model.addAttribute("department",dep);
        dao.updateDepartment(dep);

        deplist= dao.getListDepartment();
        model.addAttribute("deplist",deplist);
        return "Department";
    }
    
    @RequestMapping("add")
    public String add(ModelMap model){
        Department dep=new Department();
        model.addAttribute("department",dep);
        
        return "department/Insert";
    }
    @RequestMapping(value="add", params = "btnSave")
    public String save(@ModelAttribute("department") Department dep, ModelMap model,HttpServletRequest request) throws ParseException{
        
        String txtFounding=request.getParameter("txtFounding");
        if(txtFounding.equals("")==false){
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(txtFounding);
            dep.setFounding(date);
        }
        String depName=request.getParameter("depName");
        if(depName.equals("")){
            model.addAttribute("depNameerr","Please enter department name");
            return "department/Insert";
        }
        dep.setDepName(depName);
        //////////////////
        String depPhone=request.getParameter("depPhone");
        if(depPhone.equals("")){
            model.addAttribute("depPhoneerr","Please enter department phone");
            return "department/Insert";
        }
        dep.setDepPhone(depPhone);
        //////////////////
        String location=request.getParameter("location");
        if(location.equals("")){
            model.addAttribute("locationerr","Please enter department location");
            return "department/Insert";
        }
        dep.setLocation(location);
        //////////////////
        if(txtFounding.equals("")){
            model.addAttribute("foundingerr","Please select department founding date");
            return "department/Insert";
        }
        //////////////////
        String functions=request.getParameter("functions");
        if(functions.equals("")){
            model.addAttribute("functionserr","Please enter department function");
            return "department/Insert";
        }
        dep.setFunctions(functions);
        dao.insertDepartment(dep);
        deplist=dao.getListDepartment();
        model.addAttribute("deplist",deplist);
        return "Department";
    }
    @RequestMapping("delete")
    public String delete(HttpServletRequest request,ModelMap model){
        int id=Integer.parseInt(request.getParameter("txtdepID"));
        dao.deleteDepartment(id);
        deplist= dao.getListDepartment();
        model.addAttribute("deplist",deplist);
        
        return "Department";
        
    }
}
