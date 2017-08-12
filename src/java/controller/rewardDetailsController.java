/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.employeeDAO;
import DAO.rewardDAO;
import DAO.rewardDetailsDAO;
import bean.Rewardetails;
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
@RequestMapping("rewarddetails")
public class rewardDetailsController {
    rewardDetailsDAO dao=new rewardDetailsDAO();
    employeeDAO empdao=new employeeDAO();
    rewardDAO rewdao=new rewardDAO();
    Rewardetails[] rewdetailsList;
    @RequestMapping("show")
    public String show(ModelMap model,HttpSession session){
        session.setAttribute("webName3", "RewardDetails");
        rewdetailsList=dao.getList();
        model.addAttribute("rewdetailsList", rewdetailsList);
        return "RewardDetails";
    }
    @RequestMapping("edit")
    public String edit(HttpServletRequest request,ModelMap model){
        int id=Integer.parseInt(request.getParameter("rewdetailsID"));
        model.addAttribute("rewdetails", dao.getRewdetails(id));
        model.addAttribute("emplist", empdao.getListNhanVien());
        model.addAttribute("rewlist", rewdao.getList());
        return "rewardDetails/edit";
    }
    @RequestMapping(params = "btnUpdate")
    public String update(@ModelAttribute("rewdetails") Rewardetails rewdetails,ModelMap model,HttpServletRequest request) throws ParseException{
        String txtDate=request.getParameter("txtDate");
        model.addAttribute("emplist", empdao.getListNhanVien());
        model.addAttribute("rewlist", rewdao.getList());
        if(txtDate.equals("")==false){
             Date date = new SimpleDateFormat("yyyy-MM-dd").parse(txtDate);
             rewdetails.setDate(date);
        }
        if(rewdetails.getEmployee().getEmployeeId()==0){
            model.addAttribute("employeeerr", "Please select Employee name");
            return "rewardDetails/edit";
        }
        if(rewdetails.getReward().getRewId()==0){
            model.addAttribute("rewarderr", "Please select Reward name");
            return "rewardDetails/edit";
        }
        if(rewdetails.getFormality().trim().equals("")){
            model.addAttribute("formalityerr","Please enter Formality");
            return "rewardDetails/edit";
        }
        if(txtDate.equals("")){
            model.addAttribute("dateerr","Please select Date");
            return "rewardDetails/edit";
        }
        if(rewdetails.getReason().trim().equals("")){
            model.addAttribute("reasonerr","Please enter Reason");
            return "rewardDetails/edit";
        }
        dao.update(rewdetails);
        rewdetailsList=dao.getList();
        model.addAttribute("rewdetailsList", rewdetailsList);
        return "RewardDetails";
    }
    
    @RequestMapping("delete")
    public String delete(HttpServletRequest request,ModelMap model){
        int id=Integer.parseInt(request.getParameter("txtRewdetailsID"));
        dao.delete(id);
        rewdetailsList=dao.getList();
        model.addAttribute("rewdetailsList", rewdetailsList);
        return "RewardDetails";
    }
    @RequestMapping("add")
    public String add(ModelMap model){
        Rewardetails rewdetails=new Rewardetails();
        model.addAttribute("rewdetails", rewdetails);
        model.addAttribute("emplist", empdao.getListNhanVien());
        model.addAttribute("rewlist", rewdao.getList());
        return "rewardDetails/insert";
    }
    @RequestMapping(value="add", params = "btnSave")
    public String save(ModelMap model,HttpServletRequest request,@ModelAttribute("rewdetails") Rewardetails rewdetails) throws ParseException{
        String txtDate=request.getParameter("txtDate");
        model.addAttribute("emplist", empdao.getListNhanVien());
        model.addAttribute("rewlist", rewdao.getList());
        if(txtDate.equals("")==false){
             Date date = new SimpleDateFormat("yyyy-MM-dd").parse(txtDate);
             rewdetails.setDate(date);
        }
        String employeeId=request.getParameter("employee.employeeId");
        if(employeeId.equals("0")){
            model.addAttribute("employeeerr", "Please select Employee name");
            return "rewardDetails/insert";
        }
        rewdetails.setEmployee(empdao.getEmp(Integer.parseInt(employeeId)));
        ////////////////
        String rewId=request.getParameter("reward.rewId");
        if(rewId.equals("0")){
            model.addAttribute("rewarderr", "Please select Reward name");
            return "rewardDetails/insert";
        }
        rewdetails.setReward(rewdao.getRew(Integer.parseInt(rewId)));
        if(rewdetails.getFormality().trim().equals("")){
            model.addAttribute("formalityerr","Please enter Formality");
            return "rewardDetails/insert";
        }
        if(txtDate.equals("")){
            model.addAttribute("dateerr","Please select Date");
            return "rewardDetails/insert";
        }
        if(rewdetails.getReason().trim().equals("")){
            model.addAttribute("reasonerr","Please enter Reason");
            return "rewardDetails/insert";
        }
        dao.add(rewdetails);
        rewdetailsList=dao.getList();
        model.addAttribute("rewdetailsList", rewdetailsList);
        return "RewardDetails";
    }
}
