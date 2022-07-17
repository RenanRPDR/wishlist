package br.com.wishlist.service;

import br.com.wishlist.model.WishListRequest;
import br.com.wishlist.model.WishListResponse;
import br.com.wishlist.persistence.entity.Product;
import br.com.wishlist.persistence.repository.WishListRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishListServiceImpl implements WishListService {

    private WishListRepository repository;

    @Override
    public WishListResponse create(WishListRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setQuantity(request.getQuantity());
        repository.save(product);

        return createResponse(product);
    }

    @Override
    public List<WishListResponse> getAll() {
        List<WishListResponse> response = new ArrayList<>();

        List<Product> products = repository.findAll();
        if(!products.isEmpty()) {
            products.forEach(product -> response.add(createResponse(product)));
        }
        return response;
    }

    private WishListResponse createResponse(Product product) {
        WishListResponse response = new WishListResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setQuantity(product.getQuantity());

        return response;
    }
}
