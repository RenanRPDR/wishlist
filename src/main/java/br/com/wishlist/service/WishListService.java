package br.com.wishlist.service;

import br.com.wishlist.model.WishListRequest;
import br.com.wishlist.model.WishListResponse;
import br.com.wishlist.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

public interface WishListService {

    WishListResponse create(WishListRequest request);

    List<WishListResponse> getAll();

    Optional<Product> getProductById(String id);
}
