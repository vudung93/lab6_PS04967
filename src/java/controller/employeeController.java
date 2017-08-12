package controller;

import DAO.departmentDAO;
import DAO.employeeDAO;
import bean.Department;
import bean.Employee;
import catcherr.err;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/employee")
public class employeeController {

    @Autowired
    ServletContext context;

    employeeDAO dao = new employeeDAO();
    departmentDAO depdao = new departmentDAO();
    Employee[] list;
    Department[] listdep;

    String path="";
    String path2="";
    
    UUID id;
    String name;
    @RequestMapping("show")
    public String employee(ModelMap model, HttpSession session) {
        session.setAttribute("webName", "Employee");
        employeeDAO dao = new employeeDAO();
        list = dao.getListNhanVien();
        model.addAttribute("empre", list);
        return "Employee";
    }

    @RequestMapping("edit")
    public String edit(ModelMap model, HttpServletRequest request) {
        name="";
        path="";
        path2="";
        
        int manv = Integer.parseInt(request.getParameter("txtManv"));
        
        listdep = depdao.getListDepartment();
        Employee emp = dao.getEmp(manv);

        model.addAttribute("employee", emp);
        model.addAttribute("src","");
        model.addAttribute("listdep", listdep);
        return "employee/EmployeeView";
    }

    @RequestMapping(params = "btnUpdate")
    public String update(ModelMap model, @ModelAttribute("employee") Employee e, HttpServletRequest request) throws ParseException {
        
        model.addAttribute("listdep", listdep);
        model.addAttribute("src", name);
        String txtDate = request.getParameter("txtDate");
        if(txtDate.equals("")==false){
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(txtDate);
            e.setBirthday(date);
        }
        
        String depId = request.getParameter("department.depId");
        if (depId.equals("0")) {
            model.addAttribute("depIderr", "please select Department");
            return "employee/EmployeeView";
        }
        e.setDepartment(depdao.getdep(Integer.parseInt(depId)));
        ////////////
        String name = request.getParameter("name");
        if (name.trim().equals("")) {
            model.addAttribute("nameerr", "please enter name");
            return "employee/EmployeeView";
        }
        e.setName(name);
        ////////////
        String gender = request.getParameter("gender");
        if (gender.equals("")) {
            model.addAttribute("gendererr", "please select gender");
            return "employee/EmployeeView";
        } else if (gender.equals("true")) {
            e.setGender(true);
        } else if (gender.equals("false")) {
            e.setGender(false);
        }
        ////////////
        String address = request.getParameter("address");
        if (address.trim().equals("")) {
            model.addAttribute("addresserr", "Please enter address");
            return "employee/EmployeeView";
        }

        String salary = request.getParameter("salary");
        String salaryerr = err.onlyNumber(salary);
        if (salaryerr.equals("") == false) {
            model.addAttribute("salaryerr", salaryerr);
            return "employee/EmployeeView";
        }
        e.setSalary(Double.parseDouble(salary));
        ////////////
        
        if (txtDate.equals("")) {
            model.addAttribute("dateerr", "Please select birthday");
            return "employee/EmployeeView";
        }
        
            
       
        ////////////
        String phone = request.getParameter("phone");
        if (phone.equals("")) {
            model.addAttribute("phoneerr", "Please enter phone number");
            return "employee/EmployeeView";
        }
        e.setPhone(phone);
        ////////////
        String email = request.getParameter("email");
        if (email.equals("")) {
            model.addAttribute("emailerr", "Please enter email");
            return "employee/EmployeeView";
        }
        e.setEmail(email);

        e.setNotes(request.getParameter("notes"));
        //model.addAttribute("employee", e);
        
        boolean b=dao.updateEmployee(e,path,path2);
        
        model.addAttribute("test",e.getBirthday());
        list = dao.getListNhanVien();
        model.addAttribute("empre", list);
        
        
        
        
        return "Employee";
    }
    @RequestMapping(params = "btnUploadUpdate")
    public String uploadupdate(HttpServletRequest request,@ModelAttribute("employee") Employee e,ModelMap model,@RequestParam("image2") MultipartFile image) throws IOException, InterruptedException, ParseException{
        model.addAttribute("listdep", listdep);
        String txtDate = request.getParameter("txtDate");
        if(txtDate.equals("")==false){
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(txtDate);
            e.setBirthday(date);
        }
        
        if (image.isEmpty()) {

        } else {
            if(e.getPhoto().equals("")==false){
                name=e.getPhoto();
                
            }else if(name.equals("")==false){
                
            }else{
                id = UUID.randomUUID();
                name=id+"";
            }
            
            
            path = context.getRealPath("/upload/" + name);
            path2=context.getRealPath("/assets/img/faces/"+name);
            System.out.println(path2);
            image.transferTo(new File(path));           
            e.setPhoto(name);
            Thread.sleep(5000);

        }
        model.addAttribute("src", name);
        model.addAttribute("employee", e);
        
        
        return "employee/EmployeeView";
    }

    @RequestMapping("add")
    public String add(ModelMap model) {
        listdep = depdao.getListDepartment();
        path="";
        path2="";
        name="";
        Employee emp = new Employee();
        model.addAttribute("employeeNew", emp);
        model.addAttribute("listdep", listdep);
        model.addAttribute("src", "");
        return "employee/Insert";
    }

    @RequestMapping(params = "btnSave")
    public String save(HttpServletRequest request, ModelMap model, @ModelAttribute("employeeNew") Employee e) throws ParseException {
        String txtDate = request.getParameter("txtDate");
        if (txtDate.equals("")==false) {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(txtDate);
            e.setBirthday(date);
        }
        
        model.addAttribute("listdep", listdep);
        model.addAttribute("src",name);
        model.addAttribute("employeeNew", e);
        String depId = request.getParameter("department.depId");
        if (depId.equals("0")) {
            model.addAttribute("depIderr", "please select Department");
            return "employee/Insert";
        }
        e.setDepartment(depdao.getdep(Integer.parseInt(depId)));
        ////////////
        String name = request.getParameter("name");
        if (name.trim().equals("")) {
            model.addAttribute("nameerr", "please enter name");
            return "employee/Insert";
        }
        e.setName(name);
        ////////////
        String gender = request.getParameter("gender");
        if (gender.equals("")) {
            model.addAttribute("gendererr", "please select gender");
            return "employee/Insert";
        } else if (gender.equals("true")) {
            e.setGender(true);
        } else if (gender.equals("false")) {
            e.setGender(false);
        }
        ////////////
        String address = request.getParameter("address");
        if (address.trim().equals("")) {
            model.addAttribute("addresserr", "Please enter address");
            return "employee/Insert";
        }

        String salary = request.getParameter("salary");
        String salaryerr = err.onlyNumber(salary);
        if (salaryerr.equals("") == false) {
            model.addAttribute("salaryerr", salaryerr);
            return "employee/Insert";
        }
        e.setSalary(Double.parseDouble(salary));
        ////////////
        
        if (txtDate.equals("")) {
            model.addAttribute("dateerr", "Please select birthday");
            return "employee/Insert";
        }
        
        
       
        ////////////
        String phone = request.getParameter("phone");
        if (phone.equals("")) {
            model.addAttribute("phoneerr", "Please enter phone number");
            return "employee/Insert";
        }
        e.setPhone(phone);
        ////////////
        String email = request.getParameter("email");
        if (email.equals("")) {
            model.addAttribute("emailerr", "Please enter email");
            return "employee/Insert";
        }
        e.setEmail(email);

        e.setNotes(request.getParameter("notes"));
        
        dao.addEmployee(e,path,path2);
        
       model.addAttribute("employeeNew", e);
        list = dao.getListNhanVien();
        model.addAttribute("empre", list);
       
        return "Employee";
    }
    @RequestMapping(params = "btnUpload")
    public String upload2(HttpServletRequest request, @RequestParam("image") MultipartFile image,ModelMap model,@ModelAttribute("employeeNew") Employee e) throws IOException, InterruptedException, ParseException{
        model.addAttribute("listdep", listdep);
        String txtDate = request.getParameter("txtDate");
        if (txtDate.equals("")==false) {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(txtDate);
            e.setBirthday(date);
        }
        if (image.isEmpty()) {

        } else {
            if(name.equals("")){
                id = UUID.randomUUID();
                name=id+"";
            }else{
                
            }
            
            
            path = context.getRealPath("/upload/" + name);
            path2=context.getRealPath("/assets/img/faces/"+name);
            image.transferTo(new File(path));

            e.setPhoto(name);
            Thread.sleep(6000);

        }
        model.addAttribute("src", name);
        model.addAttribute("employeeNew", e);
        return "employee/Insert";
    }

   

    @RequestMapping("delete")
    public String delete(HttpServletRequest request,ModelMap model) {
        int manv = Integer.parseInt(request.getParameter("txtEmployeeID"));
        dao.deleteEmployee(manv);
        model.addAttribute("empre", dao.getListNhanVien());
        return "Employee";
    }
    
}
