package br.com.wishlist.controller;

import br.com.wishlist.model.WishListRequest;
import br.com.wishlist.model.WishListResponse;
import br.com.wishlist.persistence.entity.Product;
import br.com.wishlist.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

    @Autowired
    private WishListService service;

    @PostMapping
    public ResponseEntity<WishListResponse> createProduct(@RequestBody WishListRequest request) {

        return ResponseEntity.ok(service.createProduct(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.getProductById(id));
    }

    @GetMapping
    public ResponseEntity<List<WishListResponse>> getAllProducts() { return ResponseEntity.ok(service.getAllProducts()); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable("id") String id) {
        service.deleteProductById(id);
        return ResponseEntity.ok().build();
    }
}