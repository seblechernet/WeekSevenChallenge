package com.seb.weeksevenchallenge.Controller;


import com.seb.weeksevenchallenge.Model.Department;
import com.seb.weeksevenchallenge.Model.Employee;
import com.seb.weeksevenchallenge.Repository.DepartmentRepository;
import com.seb.weeksevenchallenge.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JsonController {

    @Autowired
    DepartmentRepository departments;
    @Autowired
    EmployeeRepository employees;

    @RequestMapping("/employees")
    public Iterable<Employee> showEmployees(){

        return employees.findAll();
    }
    @RequestMapping("/departments")
    public Iterable<Department> showDepartments(){

        return departments.findAll();
    }
}
