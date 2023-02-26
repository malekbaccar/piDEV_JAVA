package tn.esprit.indusmarket.indusmarketback.Controller;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.esprit.indusmarket.indusmarketback.Entities.LiveStreaming;
import tn.esprit.indusmarket.indusmarketback.Entities.Product;
import tn.esprit.indusmarket.indusmarketback.Entities.Shop;
import tn.esprit.indusmarket.indusmarketback.Entities.User;
import tn.esprit.indusmarket.indusmarketback.Repositories.ProductRepo;
import tn.esprit.indusmarket.indusmarketback.Repositories.ShopRepo;
import tn.esprit.indusmarket.indusmarketback.Repositories.UserRepo;
import tn.esprit.indusmarket.indusmarketback.Services.ShopServices;

import java.util.List;

@AllArgsConstructor
@RestController
public class ShopController {
    ShopServices shopServices;
   ProductRepo productRepo;
    UserRepo userRepo;
    ShopRepo shopRepo;

    @PostMapping(path = "/addShopAndAffectToUser/{idUsr}")
    public Shop addShopAndAffectToUser(@RequestBody Shop s,@PathVariable int idUsr){
        return shopServices.addShopAndAffectToUser(s,idUsr);
    }
    @PostMapping(path = "/editShop/{shopId}/{userId}")
        public Shop editShop(@RequestBody Shop s, @PathVariable int shopId, @PathVariable int userId){
       return shopServices.editShop(s,shopId,userId);
    }
    @PostMapping(path = "/deleteShop/{idUser}/{idShop}")
    public Shop deleteShop(@PathVariable int idUser,@PathVariable int idShop){
        return shopServices.deleteShop(idUser,idShop);
    }
    @GetMapping(path = "/ShowAllShopsByUser/{idUser}")
    public List<Shop> ShowAllShopsByUser(@PathVariable int idUser){
        return shopServices.ShowAllShopsByUser(idUser);
    }
    @GetMapping("/GenerateCatalog")
    public List<Product> GenerateCatalog(){
        return shopServices.GenerateCatalog();
    }
    @GetMapping(path ="/ShowAllShops" )
    public List<Shop> ShowAllShops(){return shopServices.ShowAllShops();}




}
