package br.com.wishlist.service;

import br.com.wishlist.model.WishListRequest;
import br.com.wishlist.model.WishListResponse;
import br.com.wishlist.persistence.entity.Product;
import br.com.wishlist.persistence.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WishListServiceImpl implements WishListService {
    @Autowired
    private WishListRepository repository;

    @Override
    public WishListResponse createProduct(WishListRequest request) {
            Product product = new Product();
            product.setName(request.getName());
            product.setDescription(request.getDescription());
            product.setQuantity(request.getQuantity());
            repository.save(product);

            return createResponse(product);
    }

    @Override
    public List<WishListResponse> getAllProducts() {
        List<WishListResponse> response = new ArrayList<>();
        List<Product> products = repository.findAll();
        if(!products.isEmpty()) {
            products.forEach(product -> response.add(createResponse(product)));
        }
        return response;
    }

    @Override
    public Optional<Product> getProductById(String id) {
        Optional<Product> product = repository.findById(id);
        return product;
    }

    @Override
    public void deleteProductById(String id) {
        repository.deleteById(id);
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
