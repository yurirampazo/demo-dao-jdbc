package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("--------Test 1: department findById--------");
        Department dep = departmentDao.findById(6);
        System.out.println(dep);

        System.out.println("\n--------Test 2: department findAll--------");
        List<Department> depList = departmentDao.findAll();
        for (Department department : depList) {
            System.out.println(department);
        }

        System.out.println("\n--------Test 4: department insert--------");
        Department newDepartment = new Department(null, "Calisthenics");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New Id: " + newDepartment.getId());

        System.out.println("\n--------Test 5: seller update--------");
        dep = departmentDao.findById(1);
        dep.setName("Notebooks");
        departmentDao.update(dep);
        System.out.println("Update Completed");

        System.out.println("\n--------Test 6: department delete--------");
        System.out.println("Type a valid Id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed!");
        sc.close();




    }
}
