package com.seb.weeksevenchallenge.Repository;

import com.seb.weeksevenchallenge.Model.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department,Integer> {
    Department findAllBydepName(String name);
}
