package com.example.EmployeeApplication2.repositories;

import com.example.EmployeeApplication2.entities.Employee;
import org.hibernate.sql.Delete;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {


    //JPQL Queries

    @Query("from Employee") //Employee is class name
    List<Employee> findAllEmployee();

    @Query("select e.firstName,e.lastName from Employee e WHERE salary> (select  AVG(salary) from Employee )ORDER BY age ASC,salary DESC")
    List<Object[]> findFirstAndLastname();

    @Modifying
    @Query("update Employee set salary=sal WHERE salary< (select AVG(salary))")
    void updateSalary(@Param("sal") int sal);

    @Modifying
    @Query("delete from Employee where salary=:min")
    void deleteMinSalaryemployee(@Param("min") int min);


    //NATIVE SQL
    @Query(value = "select empid,empFirstname,empAge from employee where empLastname =:lastName", nativeQuery = true)
    List<Object[]> findAllEmployeeByLastName(@Param("lastName") String lastName);

    @Modifying
    @Query(value = "delete from employee where empAge >:age", nativeQuery = true)
    void deleteAgeGreaterThan(@Param("age") int age);


}

