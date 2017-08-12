/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.disciplineDAO;
import bean.Discipline;
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
@RequestMapping("discipline")
public class disciplineController {
    disciplineDAO dao=new disciplineDAO();
    Discipline[] disciplinelist;
    @RequestMapping("show")
    public String discipline(HttpSession session, ModelMap model){
        session.setAttribute("webName","Discipline");
        session.setAttribute("webName2", "Discipline");
        disciplinelist=dao.getlistDis();
        model.addAttribute("disciplinelist",disciplinelist);
        return "Discipline";
    }
    
    @RequestMapping("details")
    public String details(HttpServletRequest request,ModelMap model){
        int ID=Integer.parseInt(request.getParameter("DisciplineID"));
        Discipline dis=dao.getDis(ID);
        model.addAttribute("discipline",dis);
        
        return "discipline/details";
    }
    @RequestMapping("add")
    public String add(ModelMap model){
        Discipline dis=new Discipline();
        model.addAttribute("discipline",dis);
        return "discipline/insert";
    }
    @RequestMapping(value="add", params = "btnSave")
    public String save(@ModelAttribute("discipline") Discipline dis,HttpServletRequest request,ModelMap model){
        String disName= request.getParameter("disName");
        if(disName.equals("")){
            model.addAttribute("disNameerr","Please enter Discipline name");
            return "discipline/insert";
        }
        dao.add(dis);
        disciplinelist=dao.getlistDis();
        model.addAttribute("disciplinelist",disciplinelist);
        return "Discipline";
    }
    @RequestMapping(params = "btnUpdate")
    public String update(@ModelAttribute("discipline") Discipline dis,HttpServletRequest request,ModelMap model ){
        int Id=Integer.parseInt(request.getParameter("disId"));
        dis.setDisciplinedetailses(dao.getDis(Id).getDisciplinedetailses());
        String disName=request.getParameter("disName");
        if(disName.equals("")){
            model.addAttribute("disNameerr", "Please enter Discipline name");
            return "discipline/details";
        }
        dao.update(dis);
        disciplinelist=dao.getlistDis();
        model.addAttribute("disciplinelist",disciplinelist);
        return "Discipline";
    }
    @RequestMapping("delete")
    public String delete(HttpServletRequest request,ModelMap model){
        int ID=Integer.parseInt(request.getParameter("DiscipID"));
        dao.delete(ID);
        
        disciplinelist=dao.getlistDis();
        model.addAttribute("disciplinelist",disciplinelist);
        return "Discipline";
    }
    
}
