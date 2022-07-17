package br.com.wishlist.controller;

import br.com.wishlist.model.WishListRequest;
import br.com.wishlist.model.WishListResponse;
import br.com.wishlist.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

    @Autowired
    private WishListService service;

    @GetMapping(path = "/hello")
    private String helloWorld () {
        return "aaaddddddddddaaaa";
    }

    @PostMapping
    public ResponseEntity<WishListResponse> create(@RequestBody WishListRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<WishListResponse>> getAll() { return ResponseEntity.ok(service.getAll()); }
}