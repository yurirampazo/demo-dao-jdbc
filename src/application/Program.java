package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
//        Department obj = new Department(1, "Books");
//        System.out.println(obj);
//
//        Seller s = new Seller(3, "Bob", "bob@test.com", new Date(), 3000.0, obj);
//        System.out.println(s);


        // Injeção de dependências sem explicitar a implementação.
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("--------Test 1: seller findById--------");
        Seller seller = sellerDao.findById(6);
        System.out.println(seller);

        System.out.println("\n--------Test 2: seller findByDepartment--------");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller sel : list) {
            System.out.println(sel);
        }

        System.out.println("\n--------Test 3: seller findAll--------");
       list = sellerDao.findAll();
        for (Seller sel : list) {
            System.out.println(sel);
        }

        System.out.println("\n--------Test 4: seller insert--------");
        Seller newSeller = new Seller(null, "Greg",
                "greg@gmail.com", new Date(),
                4000.0, department);
               sellerDao.insert(newSeller);
            System.out.println("Inserted! New id: " + newSeller.getId());


        System.out.println("\n--------Test 5: seller update--------");
        seller = sellerDao.findById(1);
        seller.setName("Jonas Wayne");
        sellerDao.update(seller);
        System.out.println("Update Completed!");

        System.out.println("\n--------Test 6: seller delete--------");
        System.out.println("Type a valid Id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed!");
        sc.close();
    }
}
