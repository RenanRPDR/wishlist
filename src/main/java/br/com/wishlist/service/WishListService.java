package br.com.wishlist.service;

import br.com.wishlist.model.WishListRequest;
import br.com.wishlist.model.WishListResponse;

import java.util.List;

public interface WishListService {

    WishListResponse create(WishListRequest request);

    List<WishListResponse> getAll();
}
