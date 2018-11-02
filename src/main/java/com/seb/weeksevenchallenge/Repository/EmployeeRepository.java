package com.seb.weeksevenchallenge.Repository;

import com.seb.weeksevenchallenge.Model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
