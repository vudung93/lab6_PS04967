package bean;
// Generated Jun 2, 2017 3:55:32 PM by Hibernate Tools 4.3.1



import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Employee generated by hbm2java
 */
public class Employee implements java.io.Serializable{


     private int employeeId;
     public Department department;
     private String name;
     private Boolean gender;
     private Date birthday;
     private String photo;
     private String email;
     private Double salary;
     private String notes;
     private String address;
     private String phone;
     private Set<Rewardetails> rewardetailses = new HashSet<Rewardetails>(0);
     private Set<Disciplinedetails> disciplinedetailses = new HashSet<Disciplinedetails>(0);
     
    public Employee() {
    }

	
    public Employee(int employeeId, Department department) {
        this.employeeId = employeeId;
        this.department = department;
    }
    public Employee(int employeeId, Department department, String name, Boolean gender, Date birthday, String photo, String email, Double salary, String notes,String address,String phone, Set<Rewardetails> rewardetailses, Set<Disciplinedetails> disciplinedetailses) {
       this.employeeId = employeeId;
       this.department = department;
       this.name = name;
       this.gender = gender;
       this.birthday = birthday;
       this.photo = photo;
       this.email = email;
       this.salary = salary;
       this.notes = notes;
       this.address=address;
       this.phone=phone;
       this.rewardetailses = rewardetailses;
       this.disciplinedetailses = disciplinedetailses;
      
       
    }
   
    public int getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public Department getDepartment() {
        return this.department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Boolean getGender() {
        return this.gender;
    }
    
    public void setGender(Boolean gender) {
        this.gender = gender;
    }
    public Date getBirthday() {
        return this.birthday;
    }
    @Temporal(TemporalType.DATE)
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getPhoto() {
        return this.photo;
    }
    
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Double getSalary() {
        return this.salary;
    }
    
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public Set<Rewardetails> getRewardetailses() {
        return this.rewardetailses;
    }
    
    public void setRewardetailses(Set<Rewardetails> rewardetailses) {
        this.rewardetailses = rewardetailses;
    }
    public Set<Disciplinedetails> getDisciplinedetailses() {
        return this.disciplinedetailses;
    }
    
    public void setDisciplinedetailses(Set<Disciplinedetails> disciplinedetailses) {
        this.disciplinedetailses = disciplinedetailses;
    }

    
}


