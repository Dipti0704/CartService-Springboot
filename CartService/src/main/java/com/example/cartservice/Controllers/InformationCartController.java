package com.example.carservice.Controllers;

import com.example.carservice.Modals.InformationCart;
import com.example.carservice.Service.cartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class InformationCartController {
    private InformationCart informationCart;

    public InformationCartController(InformationCart informationCart) {
        this.informationCart = informationCart;
    }
    @GetMapping("/cart")
    public List<InformationCart> getAllCart() {
        //InformationCart CartService = null;
        return InformationCart.getAllCart();
    }
    @GetMapping("/cart/{id}")
    public InformationCart getaSingleCart(@PathVariable("id") Long id) {
        return InformationCart.getaSingleCart(id);
    }

    @PostMapping("/cart")
    public InformationCart createCart(@RequestBody cartService cart) {
        return cartService.createCart(cart);
    }

    @PutMapping("/products/{id}")
    public InformationCart updateCart(@RequestBody cartService cart, @PathVariable("id") Long id) {
        return cartService.updateCart(cart);
    }

    @DeleteMapping("/products/{id}")
    public void deleteCart(@PathVariable("id") Long id) {
        cartService.deleteCart(id);
    }



}
