package tn.esprit.indusmarket.indusmarketback.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.indusmarket.indusmarketback.Entities.Product;
import tn.esprit.indusmarket.indusmarketback.Entities.Shop;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    @Query("select p.reference,p.name,p.quantity,p.price,p.description,p.brand,p.category,p.pictures from Product p where p.discount is null")
    public List<Product> ShowAllProductsWithoutDiscount();
    @Query("select p from Product p where  p.discount is not null ")
    public List<Product> ShowAllProductsWithDiscount();

    @Query("select p from Product p where p.category =?1")
    public List<Product> SortProductByCategory(String category);


}
