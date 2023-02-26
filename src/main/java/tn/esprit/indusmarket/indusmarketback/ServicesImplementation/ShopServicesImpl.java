package tn.esprit.indusmarket.indusmarketback.ServicesImplementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.indusmarket.indusmarketback.Entities.Product;
import tn.esprit.indusmarket.indusmarketback.Entities.Shop;
import tn.esprit.indusmarket.indusmarketback.Entities.User;
import tn.esprit.indusmarket.indusmarketback.Repositories.ShopRepo;
import tn.esprit.indusmarket.indusmarketback.Repositories.UserRepo;
import tn.esprit.indusmarket.indusmarketback.Services.ShopServices;

import java.util.ArrayList;
import java.util.List;

    @Service
    @AllArgsConstructor
public class ShopServicesImpl implements ShopServices {
    ShopRepo shopRepo;
    UserRepo userRepo;


        @Override
        public List<Shop> ShowAllShops() {
            return shopRepo.ShowAllShops();
        }

        @Override
    public Shop addShopAndAffectToUser(Shop s, int idUsr) {
        User u = userRepo.findById(idUsr).get();
        if (u.getShops()==null){
            List<Shop> shops = new ArrayList<>();
            shops.add(s);
            u.setShops(shops);
        }
        else {
            u.getShops().add(s);
        }
        shopRepo.save(s);
        userRepo.save(u);
        return s;
    }




    @Override
    public Shop editShop(Shop s, int shopId, int userId) throws IllegalStateException {
        User user = userRepo.findById(userId).get();
        Shop shop = shopRepo.findById(shopId).orElse(null);
        if(!user.getShops().contains(shop)) {
            throw new IllegalStateException("You aren't the owner of this shop");
        }
        if(shop==null) {
            throw new IllegalStateException("This shop does not exist");

        }
        else {
            shop.setName(s.getName());
            shop.setMail(s.getMail());
            shop.setName(s.getName());
            shop.setUser(s.getUser());
            shop.setPicturesList(s.getPicturesList());
            shop.setProducts(s.getProducts());
            shop.setPhoneNumber(s.getPhoneNumber());

            shopRepo.flush();
            return s;
        }
    }

    @Override
    public Shop deleteShop(int idUser, int idShop) {
        User usr = userRepo.findById(idUser).get();
        Shop s = shopRepo.findById(idShop).orElse(null);
        if(s==null) {
            throw new IllegalStateException("This shop does not exist");
        }
        if(usr.getShops().contains(s)==false) {
            throw new IllegalStateException("You aren't the owner of this shop");
        }
        usr.getShops().remove(s);
        shopRepo.delete(s);
        return s ;

    }

        @Override
        public List<Shop> ShowAllShopsByUser(int idUser) {
            return shopRepo.ShowAllShops(idUser);
        }
        @Override
        public List<Product> GenerateCatalog() {
            return shopRepo.GenerateCatalog();
        }


    }
