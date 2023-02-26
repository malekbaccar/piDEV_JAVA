package tn.esprit.indusmarket.indusmarketback.ServicesImplementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.indusmarket.indusmarketback.Entities.Product;
import tn.esprit.indusmarket.indusmarketback.Entities.Shop;
import tn.esprit.indusmarket.indusmarketback.Entities.User;
import tn.esprit.indusmarket.indusmarketback.Repositories.ProductRepo;
import tn.esprit.indusmarket.indusmarketback.Repositories.ShopRepo;
import tn.esprit.indusmarket.indusmarketback.Repositories.UserRepo;
import tn.esprit.indusmarket.indusmarketback.Services.ProductServices;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor

public class ProductServicesImpl implements ProductServices {
    ProductRepo productRepo;
    ShopRepo shopRepo;
    private  UserRepo userRepo;

    @Override
    public Product AddProduct(Product p) {
        return productRepo.save(p);
    }

    @Override
    public Product AddProductAndAssignToShop(Product p, int ShopId) {
        Shop s = shopRepo.findById(ShopId).get();
        p.setShop(s);
        return p;
    }
    @Transactional
    @Override
    public Product editProduct(Product product, int shopId, int productId) throws IllegalStateException{
        Shop shop = shopRepo.findById(shopId).get();
        Product p = productRepo.findById(productId).orElse(null);
        if(!shop.getProducts().contains(p)) {
            throw new IllegalStateException("You aren't the owner of this product");
        }
        if(p==null) {
            throw new IllegalStateException("This product does not exist");

        }
        else {
            p.setName(product.getName());
            p.setBrand(product.getBrand());
            p.setCategory(product.getCategory());
            p.setDiscount(product.getDiscount());
            p.setQuantity(product.getQuantity());
            p.setPrice(product.getPrice());
            p.setShop(product.getShop());
            p.setPictures(product.getPictures());
            p.setDescription(product.getDescription());
            p.setReference(product.getReference());


            productRepo.flush();
            return p;
        }
    }

    @Override
    public Shop deleteProduct(int idShop, int idProduct) {
        Product p = productRepo.findById(idProduct).get();
        Shop s = shopRepo.findById(idShop).orElse(null);
        if(p==null) {
            throw new IllegalStateException("This product does not exist");
        }
        if(s.getProducts().contains(p)==false) {
            throw new IllegalStateException("You aren't the owner of this product");
        }
        s.getProducts().remove(p);
        productRepo.delete(p);
        return s ;
    }

    @Override
    public List<Product> ShowAllProductsWithoutDiscount() {
        return productRepo.ShowAllProductsWithoutDiscount();
    }

    @Override
    public List<Product> ShowAllProductsWithDiscount() {
        return productRepo.ShowAllProductsWithDiscount();
    }

    @Override
    public Product ApplicateDiscount(int Discount,int idProd) {
        Product p = productRepo.findById(idProd).get();
        p.setDiscount(Discount);
       float x= p.getPrice()*(100-Discount)/100;
        p.setPriceAfterDiscount(x);

        return productRepo.save(p);
    }

    @Override
    public List<Product> ShowAllProducts() {
        return productRepo.findAll();
    }



    @Override
    public List<Product> SortProductByCategory(String category) {
        return productRepo.SortProductByCategory(category);
    }


}
