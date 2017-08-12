/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.userDAO;
import bean.Users;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {    
    userDAO dao=new userDAO();
    Users user;
    @RequestMapping("login")
    public String login(HttpSession session){
        user=new Users("", "", "");
        session.setAttribute("user", user);
        session.setAttribute("check", "false");
        return "login";
    }
    @RequestMapping(value="login", params = "btnSubmit")
   public String submit(HttpServletRequest request, HttpSession session){
       String username=request.getParameter("user");
       String password=request.getParameter("password");
       if(username.trim().equals("") || password.trim().equals("")){
           return "login";
       }
       Users user=dao.getUser(username, password);
       if(user==null){
           //session.setAttribute("user", null);
       }else{
           session.setAttribute("user23", user);
       }
       
      // String redirectUrl = request.getScheme() + "/home.htm";
       return "redirect:" + "/home.htm";
   }
   @RequestMapping("logout")
   public String logout(HttpSession session){
       session.removeAttribute("user23");
       return "login";
   }
}
