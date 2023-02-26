package tn.esprit.indusmarket.indusmarketback.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.indusmarket.indusmarketback.Entities.Product;
import tn.esprit.indusmarket.indusmarketback.Entities.Shop;

import java.util.List;

public interface ShopRepo extends JpaRepository<Shop,Integer> {
    @Query("select s from Shop s join s.user u where u.idUser =?1")
    public List<Shop> ShowAllShops(int idUser);
    @Query("select p from Product p order by p.category")
    public List<Product> GenerateCatalog();
    @Query("select s from Shop s ")
    public List<Shop> ShowAllShops();
}
