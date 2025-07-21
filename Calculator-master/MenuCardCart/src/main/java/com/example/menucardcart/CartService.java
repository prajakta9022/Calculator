
package com.example.menucardcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public CartItem addToCart(CartItem item) {
        item.setAddedTime(LocalDateTime.now());
        return cartRepository.save(item);
    }

    public void removeFromCart(Long id) {
        cartRepository.deleteById(id);
    }

    public List<CartItem> getCartItems() {
        return cartRepository.findAll();
    }
}
