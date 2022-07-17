package br.com.wishlist.persistence.repository;

import br.com.wishlist.persistence.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepository extends MongoRepository<Product, String> {
}
