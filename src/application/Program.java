package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {

//        Department obj = new Department(1, "Books");
//        System.out.println(obj);
//
//        Seller s = new Seller(3, "Bob", "bob@test.com", new Date(), 3000.0, obj);
//        System.out.println(s);


        // Injeção de dependências sem explicitar a implementação.
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("--------Teste 1: seller findById--------");
        Seller seller = sellerDao.findById(6);
        System.out.println(seller);

        System.out.println("/n--------Teste 2: seller findByDepartment--------");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller sel : list) {
            System.out.println(sel);
        }



    }
}
