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

    @Override
    public void run(String... args) throws Exception {
        //CLIENT 1
        Client c1 = new Client();
        c1.setClientCode("C-0001");
        c1.setPersonId("0936453679");
        c1.setName("Diana");
        c1.setLastname("Mendoza");
        c1.setAge(30);
        clientRepository.save(c1);

        //CLIENT 2
        Client c2 = new Client();
        c2.setClientCode("C-0002");
        c2.setPersonId("0936453678");
        c2.setName("Yomaira");
        c2.setLastname("Villamar");
        c2.setAge(25);
        clientRepository.save(c2);

        //CLIENT 3
        Client c3 = new Client();
        c3.setClientCode("C-0003");
        c3.setPersonId("0936453680");
        c3.setName("Carlos");
        c3.setLastname("Gonzalez");
        c3.setAge(40);
        clientRepository.save(c3);


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


        //SUPPLIERS
        Supplier supplier1 = new Supplier();
        supplier1.setName("CORPORACION ROSADO S.A");
        supplier1.setContactInfo("contact@supplierA.com");
        supplier1.setPhoneNumber("123-456-7890");
        supplierRepository.save(supplier1);

        Supplier supplier2 = new Supplier();
        supplier2.setName("DEPRATI");
        supplier2.setContactInfo("contact@supplierB.com");
        supplier2.setPhoneNumber("987-654-3210");
        supplierRepository.save(supplier2);

        //PRODUCTS

        Product product1 = new Product();
        product1.setProductId("P001");
        product1.setName("Zapatos Nike");
        product1.setPrice(100.0);
        product1.setInterestRate(5.0);
        product1.setSupplier(supplier1);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setProductId("P002");
        product2.setName("Vestido Ejecutivo");
        product2.setPrice(150.0);
        product2.setInterestRate(10.0);
        product2.setSupplier(supplier2);
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setProductId("P003");
        product3.setName("Set de Aseo Personal Completo");
        product3.setPrice(20);
        product3.setInterestRate(5.0);
        product3.setSupplier(supplier1);
        productRepository.save(product3);

        Product product4 = new Product();
        product4.setProductId("P004");
        product4.setName("Zapatos Formal");
        product4.setPrice(25);
        product4.setInterestRate(12.0);
        product4.setSupplier(supplier2);
        productRepository.save(product4);

        PaymentMeth pay1 = new PaymentMeth();
        pay1.setMethod("Money");
        paymentMethRepository.save(pay1);

        PaymentMeth pay2 = new PaymentMeth();
        pay2.setMethod("Debit Card");
        paymentMethRepository.save(pay2);

        //INVOICE
        Invoice invo1 = new Invoice();
        invo1.setSerial("INV-001");
        invo1.setDate(new Date(System.currentTimeMillis()));
        invo1.setClient(c1);
        invo1.setProduct(product1);
        invo1.setPaymentMeth(pay1);
        invo1.setTotalPrice(105);
        invoiceRepository.save(invo1);


        Invoice invo2 = new Invoice();
        invo2.setSerial("INV-002");
        invo2.setDate(new Date(System.currentTimeMillis()));
        invo2.setClient(c2);
        invo2.setProduct(product2);
        invo2.setPaymentMeth(pay2);
        invo2.setTotalPrice(165);
        invoiceRepository.save(invo2);

        Invoice invo3 = new Invoice();
        invo3.setSerial("INV-003");
        invo3.setDate(new Date(System.currentTimeMillis()));
        invo3.setClient(c3);
        invo3.setProduct(product3);
        invo3.setPaymentMeth(pay1);
        invo3.setTotalPrice(21);
        invoiceRepository.save(invo3);

        //INVOICE DETAILS
        InvoiceDetail detail1 = new InvoiceDetail();
        detail1.setInvoice(invo1);
        detail1.setBranch(branch1);
        detail1.setStore(store1);
        detail1.setEmployee(e1);
        detail1.setClient(c2);
        detail1.setProduct(product1);
        detail1.setSupplier(supplier1);
        detail1.setInterestRate(5.0);
        detail1.setQuantity(1);
        detail1.setPaymentMeth(pay1);
        detail1.setTotal(105);
        invoiceDetailRepository.save(detail1);

        InvoiceDetail detail2 = new InvoiceDetail();
        detail2.setInvoice(invo2);
        detail2.setBranch(branch2);
        detail2.setStore(store2);
        detail2.setEmployee(e2);
        detail2.setClient(c1);
        detail2.setProduct(product2);
        detail2.setSupplier(supplier2);
        detail2.setInterestRate(10.0);
        detail2.setQuantity(1);
        detail2.setPaymentMeth(pay2);
        detail2.setTotal(165);
        invoiceDetailRepository.save(detail2);

        InvoiceDetail detail3 = new InvoiceDetail();
        detail3.setInvoice(invo3);
        detail3.setBranch(branch3);
        detail3.setStore(store3);
        detail3.setEmployee(e3);
        detail3.setClient(c3);
        detail3.setProduct(product3);
        detail3.setSupplier(supplier1);
        detail3.setInterestRate(5.0);
        detail3.setQuantity(1);
        detail3.setPaymentMeth(pay1);
        detail3.setTotal(21);
        invoiceDetailRepository.save(detail3);

        Person person1 = new Person();
        person1.setPersonId("0955889191");
        person1.setName("Daniel");
        person1.setLastname("Diaz");
        person1.setAge(21);
        personRepository.save(person1);

        System.out.println("--------- Started BootstrapData -------------");
        System.out.println("Number of Clients: " + clientRepository.count());
        System.out.println("Number of Employees: " + employeeRepository.count());
        System.out.println("Number of People: " + personRepository.count());
        System.out.println("Number of Branches: " + branchRepository.count());
        System.out.println("Number of Store: " + storeRepository.count());
        System.out.println("Number of Products:" + productRepository.count());
        System.out.println("Number of Suppliers: " + supplierRepository.count());
        System.out.println("Number of PaymentMeth: " + paymentMethRepository.count());
        System.out.println("Number of Invoices: " + invoiceRepository.count());
        System.out.println("Number of Invoice Details: " + invoiceDetailRepository.count());


    }

}
