package com.example.EmployeeApplication2;

import com.example.EmployeeApplication2.ComponentMapping.ComponentMapping;
import com.example.EmployeeApplication2.entities.Employee;
import com.example.EmployeeApplication2.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class EmployeeApplication2ApplicationTests {

    @Autowired
    EmployeeRepository repository;

    @Test
    public void testEmployeeCreate() {
        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Ferguson");
        employee.setSalary(9000);
        employee.setAge(30);
        employee.setId(1l);
        repository.save(employee);

        Employee employee1 = new Employee();
        employee1.setFirstName("Hira");
        employee1.setLastName("Mani");
        employee1.setSalary(10000);
        employee1.setAge(29);
        employee1.setId(2l);
        repository.save(employee1);

        Employee employee3 = new Employee();
        employee3.setFirstName("Ahsan");
        employee3.setLastName("Khan");
        employee3.setSalary(8000);
        employee3.setAge(25);
        employee3.setId(3l);
        repository.save(employee3);

        Employee employee4 = new Employee();
        employee4.setFirstName("Kiara");
        employee4.setLastName("singh");
        employee4.setSalary(15000);
        employee4.setAge(28);
        employee4.setId(4l);
        repository.save(employee4);

    }

    @Test
    public void testfindFirstAndLastname() {

        List<Object[]> emp = repository.findFirstAndLastname();
        for (Object[] e : emp)
            System.out.println(e[0] + " " + e[1]);

    }

    @Test
    @Transactional
    public void testfindSalary() {
         repository.updateSalary(10000);

    }

    @Test
    @Transactional
    public void testdeleteMinSalaryemployee(){
        repository.deleteMinSalaryemployee(8000);

    }

    @Test
    public void testByLastName() {
        List<Object[]> emp = repository.findAllEmployeeByLastName("singh");
        for (Object[] employee : emp) {
            System.out.println(employee[0] + " "+employee[1]+" "+ employee[2]);
        }
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testDelete() {
        repository.deleteAgeGreaterThan(45);
    }

    @Test
    public void testEmbedded() {
        ComponentMapping componentMapping = new ComponentMapping();
        componentMapping.setBasicSalary(9000);
        componentMapping.setBonusSalary(6000);
        componentMapping.setSpecialallowancesalary(25000);
        componentMapping.setTaxAmount(8000);
        Employee employee = new Employee();
        employee.setFirstName("Sania");
        employee.setLastName("Kaleem");
        employee.setAge(34);
        employee.setSalary(19000);
        repository.save(employee);
    }


}
