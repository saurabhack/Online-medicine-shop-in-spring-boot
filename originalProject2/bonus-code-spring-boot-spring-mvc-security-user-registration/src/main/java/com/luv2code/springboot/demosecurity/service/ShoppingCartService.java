package com.luv2code.springboot.demosecurity.service;

import com.luv2code.springboot.demosecurity.dao.CartItemRepository;
import com.luv2code.springboot.demosecurity.entity.CartItem;
import com.luv2code.springboot.demosecurity.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {
    @Autowired
    private CartItemRepository cartItemRepository;

    public List<CartItem> getCartItems(){
        return cartItemRepository.findAll();
    }

    public void addToCart(Products product, int quantity) {
        // Check if the product is already in the cart
        CartItem existingCartItem = cartItemRepository.findByProducts(product);

        if (existingCartItem != null) {
            // If the product is already in the cart, update the quantity
            int updatedQuantity = existingCartItem.getQuantity() + quantity;
            existingCartItem.setQuantity(updatedQuantity);
            cartItemRepository.save(existingCartItem);
        } else {
            // If the product is not in the cart, create a new cart item
            CartItem newCartItem = new CartItem();
            newCartItem.setProducts(product);
            newCartItem.setQuantity(quantity);
            cartItemRepository.save(newCartItem);
        }
    }
    public double calculateSubtotal() {
        List<CartItem> cartItems = getCartItems();
        double subtotal = 0.0;

        for (CartItem cartItem : cartItems) {
            Products product = cartItem.getProducts();

            // Check for null product
            if (product != null) {
                subtotal += product.getPrice() * cartItem.getQuantity();
            }
        }

        return subtotal;
    }

}
