package tn.esprit.indusmarket.indusmarketback.Services;

import tn.esprit.indusmarket.indusmarketback.Entities.Product;
import tn.esprit.indusmarket.indusmarketback.Entities.Shop;
import tn.esprit.indusmarket.indusmarketback.Repositories.ShopRepo;

import java.util.List;

public interface ShopServices {
    public List<Shop> ShowAllShops();
    public Shop addShopAndAffectToUser(Shop s,int idUsr);

    public Shop editShop(Shop s,int shopId,int userId);
    public Shop deleteShop(int idUser, int idShop);
    public List<Shop> ShowAllShopsByUser(int idUser);
    public List<Product> GenerateCatalog();

}
