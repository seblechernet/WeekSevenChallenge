package com.seb.weeksevenchallenge.Controller;

import com.seb.weeksevenchallenge.Model.Department;
import com.seb.weeksevenchallenge.Model.Employee;
import com.seb.weeksevenchallenge.Repository.DepartmentRepository;
import com.seb.weeksevenchallenge.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @RequestMapping("/")
    public String homepage(Model model){

     model.addAttribute("departments",departmentRepository.findAll());

        return "homepage";
    }

    @RequestMapping("/adddepartment")
    public String addDepartment(Model model){


        model.addAttribute("department",new Department());
        return "adddepartmentform";
    }

    @PostMapping("/savedepartment")
    public String saveDepartment(Department department){

     departmentRepository.save(department);

     return "redirect:/";

    }
    @RequestMapping("/addemployee")
    public String addEmployee(Model model){
        model.addAttribute("depatrments",departmentRepository.findAll());

        return "addemployeeform";
    }
    @PostMapping("/saveemployee")
    public String saveEmployee(@RequestParam String name,String jobTitle,Employee employee,String depName){

        employee.setName(name);
        employee.setJobTitle(jobTitle);

        employeeRepository.save(employee);

        return "redirect:/";

    }


}
