package com.ups.oop.bootstrap;

import com.ups.oop.entity.*;
import com.ups.oop.repository.*;
import com.ups.oop.service.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
 public class BootStrapData implements CommandLineRunner {
    private final ClientRepository clientRepository;
    private final PersonRepository personRepository;
    private final EmployeeRepository employeeRepository;
    private final BranchRepository branchRepository;
    private final StoreRepository storeRepository;
    private final SupplierRepository supplierRepository;
    private final ProductRepository productRepository;
    private final PaymentMethRepository paymentMethRepository;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceDetailRepository invoiceDetailRepository;

    public BootStrapData(ClientRepository clientRepository, PersonRepository personRepository, EmployeeRepository employeeRepository, StoreRepository storeRepository, BranchRepository branchRepository, SupplierRepository supplierRepository, ProductRepository productRepository, PaymentMethRepository paymentMethRepository, InvoiceRepository invoiceRepository, InvoiceDetailRepository invoiceDetailRepository ) {
        this.clientRepository = clientRepository;
        this.personRepository = personRepository;
        this.employeeRepository = employeeRepository;
        this.branchRepository = branchRepository;
        this.supplierRepository = supplierRepository;
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
        this.paymentMethRepository = paymentMethRepository;
        this.invoiceRepository = invoiceRepository;
        this.invoiceDetailRepository = invoiceDetailRepository;
    }

    public void createClients() {
        //CLIENT 1
        Client c1 = new Client();
        c1.setClientCode("C-0001");
        c1.setPersonId("0936453679");
        c1.setName("Juan");
        c1.setLastname("Pérez");
        c1.setAge(30);
        clientRepository.save(c1);

        //CLIENT 2
        Client c2 = new Client();
        c2.setClientCode("C-0002");
        c2.setPersonId("0936453678");
        c2.setName("María");
        c2.setLastname("Gómez");
        c2.setAge(25);
        clientRepository.save(c2);

        //CLIENT 3
        Client c3 = new Client();
        c3.setClientCode("C-0003");
        c3.setPersonId("0936453680");
        c3.setName("Carlos");
        c3.setLastname("Ramírez");
        c3.setAge(40);
        clientRepository.save(c3);
    }
    public void createEmployees() {

        // EMPLOYEE 1
        Employee e1 = new Employee();
        e1.setEmployeeCode("EMP100");
        e1.setPersonId("1725698745");
        e1.setName("María");
        e1.setLastname("González");
        e1.setAge(35);

        // EMPLOYEE 2
        Employee e2 = new Employee();
        e2.setEmployeeCode("EMP101");
        e2.setPersonId("1102548963");
        e2.setName("Carlos");
        e2.setLastname("Pérez");
        e2.setAge(29);

        // EMPLOYEE 3
        Employee e3 = new Employee();
        e3.setEmployeeCode("EMP102");
        e3.setPersonId("1305687421");
        e3.setName("Ana");
        e3.setLastname("Rodríguez");
        e3.setAge(42);

        employeeRepository.save(e1);
        employeeRepository.save(e2);
        employeeRepository.save(e3);
    }

    private void createStoresAndBranches() {
        // STORE 1
        Store store1 = new Store();
        store1.setStoreName("MegaStore");
        store1.setStoreLocation("Quito");

        // STORE 2
        Store store2 = new Store();
        store2.setStoreName("SuperMart");
        store2.setStoreLocation("Guayaquil");

        // STORE 3
        Store store3 = new Store();
        store3.setStoreName("QuickShop");
        store3.setStoreLocation("Cuenca");

        // Save stores
        storeRepository.save(store1);
        storeRepository.save(store2);
        storeRepository.save(store3);

        // BRANCH 1
        Branch branch1 = new Branch();
        branch1.setBranchName("MegaStore - Norte");
        branch1.setCity("Quito");
        branch1.setBranchAddress("Avenida 6 de Diciembre");
        branch1.setStore(store1);

        // BRANCH 2
        Branch branch2 = new Branch();
        branch2.setBranchName("SuperMart - Sur");
        branch2.setCity("Guayaquil");
        branch2.setBranchAddress("Avenida de las Américas");
        branch2.setStore(store2);

        // BRANCH 3
        Branch branch3 = new Branch();
        branch3.setBranchName("QuickShop - Centro");
        branch3.setCity("Cuenca");
        branch3.setBranchAddress("Calle Larga");
        branch3.setStore(store3);

        // Save branches
        branchRepository.save(branch1);
        branchRepository.save(branch2);
        branchRepository.save(branch3);
    }
    private void createProductsAndSuppliers(){

        //SUPPLIERS
        Supplier supplier1 = new Supplier();
        supplier1.setName("Supplier A");
        supplier1.setContactInfo("contact@supplierA.com");
        supplier1.setPhoneNumber("123-456-7890");
        supplierRepository.save(supplier1);

        Supplier supplier2 = new Supplier();
        supplier2.setName("Supplier B");
        supplier2.setContactInfo("contact@supplierB.com");
        supplier2.setPhoneNumber("987-654-3210");
        supplierRepository.save(supplier2);

        //PRODUCTS

        Product product1 = new Product();
        product1.setProductId("P001");
        product1.setName("Product 1");
        product1.setPrice(100.0);
        product1.setInterestRate(5.0);
        product1.setSupplier(supplier1);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setProductId("P002");
        product2.setName("Product 2");
        product2.setPrice(150.0);
        product2.setInterestRate(10.0);
        product2.setSupplier(supplier2);
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setProductId("P003");
        product3.setName("Product 3");
        product3.setPrice(200.0);
        product3.setInterestRate(7.5);
        product3.setSupplier(supplier1);
        productRepository.save(product3);

        Product product4 = new Product();
        product4.setProductId("P004");
        product4.setName("Product 4");
        product4.setPrice(250.0);
        product4.setInterestRate(12.0);
        product4.setSupplier(supplier2);
        productRepository.save(product4);
    }
    private void createPaymentMeth(){
        PaymentMeth pay1 = new PaymentMeth();
        pay1.setMethod("Money");
        paymentMethRepository.save(pay1);

        PaymentMeth pay2 = new PaymentMeth();
        pay2.setMethod("Debit Card");
        paymentMethRepository.save(pay2);

    }

    @Override
    public void run(String... args) throws Exception {
        createClients();
        createEmployees();
        createStoresAndBranches();
        createProductsAndSuppliers();
        createPaymentMeth();


        System.out.println("--------- Started BootstrapData -------------");
        System.out.println("Number of Clients: " + clientRepository.count());
        System.out.println("Number of Employees: " + employeeRepository.count());
        System.out.println("Number of People: " + personRepository.count());
        System.out.println("Number of Branches: " + branchRepository.count());
        System.out.println("Number of Store: " + storeRepository.count());
        System.out.println("Number of Products:" + productRepository.count());
        System.out.println("Number of Suppliers: " + supplierRepository.count());
        System.out.println("Number of PaymentMeth: " + paymentMethRepository.count());


    }
}
