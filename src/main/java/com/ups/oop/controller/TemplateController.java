package com.ups.oop.controller;
import com.ups.oop.entity.InvoiceDetail;
import com.ups.oop.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class TemplateController {
    private final PersonService personService;
    private final ClientService clientService;
    private final EmployeeService employeeService;
    private final BranchService branchService;
    private final StoreService storeService;
    private final SupplierService supplierService;
    private final ProductService productService;
    private final PaymentMethService paymentMethService;
    private final InvoiceService invoiceService;
    private final InvoiceDetailService invoiceDetailService;


    public TemplateController(PersonService personService, ClientService clientService, EmployeeService employeeService, BranchService branchService, StoreService storeService, SupplierService supplierService, ProductService productService, PaymentMethService paymentMethService, InvoiceService invoiceService, InvoiceDetailService invoiceDetailService) {
        this.personService = personService;
        this.clientService = clientService;
        this.employeeService = employeeService;
        this.branchService = branchService;
        this.storeService = storeService;
        this.supplierService = supplierService;
        this.productService = productService;
        this.paymentMethService = paymentMethService;
        this.invoiceService = invoiceService;
        this.invoiceDetailService = invoiceDetailService;
    }

    @GetMapping("/template")
    public String getTemplate(Model model){
        return "template";
    }
    @GetMapping("/people")
    public String getPeople(Model model){
        model.addAttribute("people",  personService.getAllPeople());
        return "person/list";
    }

    @GetMapping("/clients")
    public String getClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients());
        return "client/list";
    }
    @GetMapping("/employees")
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employee/list";
    }
    @GetMapping("/branches")
    public String getBranches(Model model) {
        model.addAttribute("branches", branchService.getAllBranches());
        return "branch/list";
    }
    @GetMapping("/stores")
    public String getStores(Model model) {
        model.addAttribute("stores", storeService.getAllStores());
        return "store/list";
    }
    @GetMapping("/suppliers")
    public String getSuppliers(Model model) {
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "supplier/list";
    }
    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product/list";
    }
    @GetMapping("/paymentMeths")
    public String getPaymentMeths(Model model) {
        model.addAttribute("paymentMeths", paymentMethService.getAllPayment());
        return "paymentMeth/list";
    }
    @GetMapping("/invoice")
    public String getInvoice(Model model) {
        model.addAttribute("invoices", invoiceService.getAllInvoices());
        return "invoice/list";
    }
    @GetMapping("/invoice-details")
    public String getInvoiceDetails(Model model) {
        model.addAttribute("invoicesDetails", invoiceDetailService.getAllInvoiceDetails());
        return "invoice-details/list";
    }
}