/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.userDAO;
import bean.Users;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping("account")
public class accountController {
    userDAO dao=new userDAO();
    Users[] userlist;
    @RequestMapping("")
    public String account(HttpSession session,ModelMap model){
        session.setAttribute("webName","Account");
        userlist=dao.getList();
        model.addAttribute("userlist", userlist);
        return "Account";
    }
    @RequestMapping("reset")
    public String edit(HttpServletRequest request,ModelMap model){
        String username=request.getParameter("username");
        dao.resetPass(username);
        userlist=dao.getList();
        model.addAttribute("userlist", userlist);
        return "Account";
    }
    @RequestMapping("delete")
    public String delete(HttpServletRequest request,ModelMap model){
        String username=request.getParameter("Username");
        dao.resetPass(username);
        userlist=dao.getList();
        model.addAttribute("userlist", userlist);
        return "Account";
    }
}
