package com.luv2code.springboot.demosecurity.controller;

import com.luv2code.springboot.demosecurity.dao.AddressReoisitory;
import com.luv2code.springboot.demosecurity.dao.CartItemRepository;
import com.luv2code.springboot.demosecurity.dao.ProductsRepository;
import com.luv2code.springboot.demosecurity.entity.*;
import com.luv2code.springboot.demosecurity.service.*;
import com.luv2code.springboot.demosecurity.entity.Products;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

@Controller
public class DemoController {
    @Autowired
    private ProductsRepository repo;
    @Autowired
    private CartItemRepository rett;
    private contactUsService ContactUsService;
    private FeedBackService feedBackService;

    @Autowired
    private AddressReoisitory addre;

    private OnlinePayService onlinePayService;
    private AddressService addressService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    private CardDetailsService cardDetailsService;
    public DemoController(FeedBackService theFeedBackService, contactUsService theContactUsService, OnlinePayService theOnlinePayService,AddressService theAddressService,CardDetailsService theCardDetailsService){
        feedBackService=theFeedBackService;
        ContactUsService=theContactUsService;
        onlinePayService=theOnlinePayService;
        addressService=theAddressService;
        cardDetailsService=theCardDetailsService;

    }
    @GetMapping("/")
    public String showHome() {

        return "home";
    }

    // add a request mapping for /leaders



    @GetMapping("/feedBack")
    public String ShowFeedBackForm(Model theModel){
        FeedBack theFeedBack=new FeedBack();
        theModel.addAttribute("feed",theFeedBack);
        return "feedBack";
    }

    @PostMapping("/save")
    public String saveFeed(@ModelAttribute("feed") FeedBack theFeedBack, @ModelAttribute("con") contactUs theContactUs ){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Assuming you have a UserDetails implementation
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();


            // Get the username and set it in the FeedBack object
            String username = userDetails.getUsername();
            theFeedBack.setName(username);

            // Save the feedback and contact details
            feedBackService.save(theFeedBack);
        }
        return "redirect:/";
    }

    @GetMapping("/review")
    public String review(Model theModel){
        List<FeedBack> theFeedBack = feedBackService.findAll();

        theModel.addAttribute("feed",theFeedBack);

        return "review";
    }

    @GetMapping("/medicine")
    public String medicine(Model theModel){
        List<Products> products=repo.findAll();
        theModel.addAttribute("product",products);
        return "medicine";

    }


    @PostMapping("/OnlineDetails")
    public String online(@ModelAttribute("on")OnlinePay theOnlinePay){
        onlinePayService.save(theOnlinePay);
        return "redirect:/";
    }
    @GetMapping("/contact")
    public String contact(Model theModel){
        contactUs theContactUs = new contactUs();
        theModel.addAttribute("con",theContactUs);
        return "contact";
    }

    @PostMapping("/contactSave")
    public String saveContact(@ModelAttribute("con") contactUs theContactUs){
        ContactUsService.save(theContactUs);
        return "redirect:/";
    }

    /*@GetMapping("/cart")
    public String cart(){
        return "cart";
    }*/

    @GetMapping("/admin")
    public String admin(Model model){
        List<Products> products=repo.findAll();
        model.addAttribute("products",products);

        return "Admin/admin";
    }
    @GetMapping("/feedbacks")
    public String FeedBacks(Model model){
        List<FeedBack> feedBacks=feedBackService.findAll();
        model.addAttribute("feedback",feedBacks);

        return "Admin/allfeed";
    }
    @GetMapping("/create")
    public String showCreatePage(Model model){
        ProductDTO productDTO = new ProductDTO();
        model.addAttribute("productDTO",productDTO);
        return "Admin/createProduct";
    }
    @GetMapping("/AllOrders")
    public String allOrders(Model theModel){
        List<Address> addresses=addressService.findAll();
        List<CartItem> cartItems=shoppingCartService.getCartItems();
        theModel.addAttribute("address",addresses);
        theModel.addAttribute("cart",cartItems);
        return "Admin/orders";
    }
    @PostMapping("/add")
    public String createProduct(@Valid @ModelAttribute ProductDTO productDTO, BindingResult result)
    {
        if(productDTO.getImageFile().isEmpty()){
            result.addError(new FieldError("productDTO","imageFile","the image file is required"));

        }
        if(result.hasErrors()){
            return "createProduct";
        }

        MultipartFile image=productDTO.getImageFile();
        Date createAt=new Date();
        String storageFileName=createAt.getTime() + "_"+image.getOriginalFilename();
        try {
            String UploadDr = "public/images/";
            Path uploadPath = Paths.get(UploadDr);
            if(!Files.exists(uploadPath)){
                Files.createDirectories(uploadPath);
            }
            try(InputStream inputStream=image.getInputStream()){
                Files.copy(inputStream,Paths.get(UploadDr+storageFileName), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception ex) {
            System.out.println("Exception: "+ex.getMessage());
        }
        Products product = new Products();
        product.setName(productDTO.getName());
        product.setBrand(productDTO.getBrand());
        product.setCategory(productDTO.getCategory());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setCreateAt(createAt);
        product.setImageFileName(storageFileName);
        repo.save(product);
        return "redirect:/admin";
    }
    @GetMapping("/edit")
    public String ShowEditPage(Model model,@RequestParam int id){
        try{
            Products products=repo.findById(id).get();
            model.addAttribute("products",products);
            ProductDTO productDTO=new ProductDTO();
            model.addAttribute("productDTO",productDTO);
            productDTO.setName(products.getName());
            productDTO.setBrand(products.getBrand());
            productDTO.setCategory(products.getCategory());
            productDTO.setPrice(products.getPrice());
            productDTO.setDescription(products.getDescription());

        }
        catch (Exception ex){
            System.out.println("Exception:"+ex.getMessage());
            return "redirect:/products";
        }

        return "Admin/editpro";
    }
    @PostMapping("/update")
    public String Update(Model model,@RequestParam int id, @Valid @ModelAttribute ProductDTO productDTO,BindingResult result){
        try {
            Products products=repo.findById(id).get();
            model.addAttribute("products",products);
            if(result.hasErrors()){
                return "/editpro";
            }
            if(!productDTO.getImageFile().isEmpty()){
                String uploadDir="public/images/";
                Path oldImagePath=Paths.get(uploadDir+products.getImageFileName());
                try{
                    Files.delete(oldImagePath);
                }
                catch (Exception ex){
                    System.out.println("Exception: "+ex.getMessage());
                }

                MultipartFile image = productDTO.getImageFile();
                Date createAt=new Date();
                String storageFileName=createAt.getTime()+"_"+image.getOriginalFilename();
                try (InputStream inputStream = image.getInputStream()) {
                    Files.copy(inputStream,Paths.get(uploadDir+storageFileName), StandardCopyOption.REPLACE_EXISTING);

                }
                products.setImageFileName(storageFileName);
            }
            products.setName(productDTO.getName());
            products.setBrand(productDTO.getBrand());
            products.setPrice(productDTO.getPrice());
            products.setDescription(productDTO.getDescription());
            repo.save(products);
        }
        catch (Exception ex){
            System.out.println("Exception : "+ex.getMessage());
        }
        return "redirect:/admin";

    }
    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id){

        try{
            Products products = repo.findById(id).get();
            Path imagePath=Paths.get("public/images/"+products.getImageFileName());
            try{
                Files.delete(imagePath);
            }
            catch (Exception ex){
                System.out.println("Exception: "+ex.getMessage());
            }
            repo.delete(products);
        }catch (Exception ex){

        }
        return "redirect:/";
    }


    /*@GetMapping("/addToCart")
    public String AddTo(Model model,@RequestParam int id){
        Products products=repo.findById(id).get();
        model.addAttribute("product",products);
        return "cart";
    }*/

    @GetMapping("/cart")
    public String getCartItems(Model model){
        List<CartItem> cartItems=shoppingCartService.getCartItems();
        double add=shoppingCartService.calculateSubtotal();
        model.addAttribute("cartItem",cartItems);
        model.addAttribute("add",add);
        return "cart";
    }

    @GetMapping("/add-to-cart")
    public String addToCart(@RequestParam int id,@RequestParam int quantity){
        Products products=repo.findById(id).get();
        shoppingCartService.addToCart(products,quantity);
        return "redirect:/medicine";
    }
    @GetMapping("/deleteCart")
    public String deleteCart(@RequestParam int id){
        CartItem cartItem=rett.findById(id).get();
        rett.delete(cartItem);
        return "redirect:/cart";
    }
    @GetMapping("/address")
    public String ad(Model theModel){

        List<Address> angry=addressService.findAll();

        double add=shoppingCartService.calculateSubtotal();

        theModel.addAttribute("address",angry);
        theModel.addAttribute("add",add);
        return "address";

    }


    @GetMapping("/addAddress")
    public String addAddress(Model theModel){
        Address theAddress=new Address();
        theModel.addAttribute("add",theAddress);
        return "addAddress";
    }
    @PostMapping("/saveAs")
    public String save(@Valid @ModelAttribute("add") Address theAddress, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "addAddress";
        }else{
            addressService.save(theAddress);
            return "redirect:/address";
        }

    }

    @GetMapping("/Summery")
    public String summery(Model model){
        List<CartItem> cartItems=shoppingCartService.getCartItems();
        List<Address> addresses=addressService.findAll();
        double total=shoppingCartService.calculateSubtotal();
        model.addAttribute("items",cartItems);
        model.addAttribute("addresses",addresses);
        model.addAttribute("total",total);
        return "summery";
    }

    @GetMapping("/payment")
    public String pay(Model theModel){
        double total=shoppingCartService.calculateSubtotal();
        theModel.addAttribute("total",total);
        return "Payment";

    }

    @GetMapping("/cardDetails")
    public String cardDetails(Model theModel){
        CardDetails theCardDetails=new CardDetails();
        theModel.addAttribute("card",theCardDetails);
        return "credit_Info";
    }

    @PostMapping("/saveor")
    public String saveOr(@Valid @ModelAttribute("card") CardDetails cardDetails, BindingResult result){
        if(result.hasErrors()){
            return "credit_Info";
        }else{
            return "redirect:/successFull";
        }

    }
    @GetMapping("/successFull")
    public String successFull(){
        return "success";
    }


    @PostMapping("/success")
    public String success(HttpServletRequest request) {
        String paymentOption = request.getParameter("option");

        if ("Cash_on_delivery".equals(paymentOption)) {
            return "redirect:/";
        } else if ("UPI".equals(paymentOption)) {
            return "qrcode";
        } else {
            return "redirect:/cardDetails";
        }
    }
    @GetMapping("/aboutUs")
    public String aboutUs(){
        return "about";
    }

    @GetMapping("/messages")
    public String messages(Model theModel){
      List<contactUs> contact  =ContactUsService.findAll();
      theModel.addAttribute("contact",contact);
        return "Admin/message";
    }
    @GetMapping("/adminL")
    public String adminL(){
        return "Admin/adminLogin";
    }
    @PostMapping("/submit")
    public String sub(HttpServletRequest request,Model theModel){
        String username = request.getParameter("username");
        String password= request.getParameter("password");

        if(username.equals("Admin") && password.equals("Admin")){
            return "redirect:/admin";
        }else{
            theModel.addAttribute("error","username or password does not match");
            return "Admin/adminLogin";
        }
    }
}