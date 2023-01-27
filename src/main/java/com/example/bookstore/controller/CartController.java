package com.example.bookstore.controller;

import com.example.bookstore.dao.CustomerDao;
import com.example.bookstore.ds.BookDto;
import com.example.bookstore.entity.Customer;
import com.example.bookstore.service.CartService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CartService cartService;

    @GetMapping("/add-to-cart")
    public String addToCart(@RequestParam("id") int id) {
        cartService.addToCart(id);
        return "redirect:/user/book?id=" + id;

    }


    private List<Integer> bookQuantityList=new ArrayList<>();
    @PostMapping("/checkout")
    public String checkOut(BookDto bookDto){
        this.bookQuantityList=bookDto.getItemList();
        System.out.println("============"+bookQuantityList);
        return "redirect:/cart/register-form";
    }

    @GetMapping("/view")
    public String viewCart(Model model) {
        model.addAttribute("bookDto",new BookDto());
        model.addAttribute("carts", cartService.listCart());
        return "cart-view";
    }

    @GetMapping("/delete")
    public String deleteFromCart(@RequestParam("id") int id) {
        cartService.removeFromCart(findBookDtoById(id));
        return "redirect:/cart/view";
    }

    private BookDto findBookDtoById(int id) {
        return cartService.listCart()
                .stream()
                .filter(b -> b.getId() == id)
                .findFirst().get();
    }

    @GetMapping("/clear")
    public String clearCart(){
        cartService.clearCart();
        return "redirect:/cart/view";
    }


    @GetMapping("/register-form")
    public String registerForm(Model model){
        model.addAttribute("customer",new Customer());
        return "register";
    }
    @PostMapping("/register")
    public String saveRegisterCustomer(@Valid Customer customer, BindingResult result){
        if(result.hasErrors()){
            return "register";
        }
        Set<BookDto> carts=cartService.listCart();
        int index=0;
        for(BookDto bookDto: carts){
            bookDto.setQuantity(bookQuantityList.get(index));
            index++;
        }

        System.out.println("--------------------------------" + carts);
        return "redirect:/login";
    }

    @ModelAttribute("carts")
    public Set<BookDto> bookDto(){
        return cartService.listCart();
    }


}
