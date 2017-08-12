/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.rewardDAO;
import bean.Reward;
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
@RequestMapping("reward")
public class rewardController {
    rewardDAO dao=new rewardDAO();
    Reward[] rewardlist;
    @RequestMapping("show")
    public String reward(HttpSession session,ModelMap model){
        session.setAttribute("webName","Reward");
        session.setAttribute("webName3", "Reward");
        rewardlist=dao.getList();
        model.addAttribute("rewardlist", rewardlist);
        return "Reward";
    }
    @RequestMapping("details")
    public String details(HttpServletRequest request,ModelMap model){
        int ID=Integer.parseInt(request.getParameter("RewardID"));
        model.addAttribute("reward", dao.getRew(ID));
        
        return "reward/details";
    }
    @RequestMapping(params = "btnUpdate")
    public String update(@ModelAttribute("reward") Reward rew,HttpServletRequest request,ModelMap model){
        String rewname=request.getParameter("rewname");
        if(rewname.trim().equals("")){
            model.addAttribute("rewnameerr", "Please enter Reward name");
            return "reward/details";
        }
        dao.update(rew);
        rewardlist=dao.getList();
        model.addAttribute("rewardlist", rewardlist);
        return "Reward";
    }
    @RequestMapping("delete")
    public String delete(HttpServletRequest request, ModelMap model){
        int id=Integer.parseInt(request.getParameter("rewID"));
        dao.delete(id);
        rewardlist=dao.getList();
        model.addAttribute("rewardlist", rewardlist);
        return "Reward";
    }
    @RequestMapping("add")
    public String add(ModelMap model){
        Reward rew=new Reward();
        model.addAttribute("reward", rew);
        return "reward/insert";
    }
    @RequestMapping(value="add",params = "btnSave")
    public String save(@ModelAttribute("reward") Reward rew,ModelMap model,HttpServletRequest request){
        String rewname=request.getParameter("rewname");
        if(rewname.trim().equals("")){
            model.addAttribute("rewnameerr", "Please enter Reward name");
            return "reward/insert";
        }
        dao.add(rew);
        rewardlist=dao.getList();
        model.addAttribute("rewardlist", rewardlist);
        return "Reward";
    }
}
