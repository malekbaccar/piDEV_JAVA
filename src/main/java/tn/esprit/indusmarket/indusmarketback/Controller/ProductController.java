package tn.esprit.indusmarket.indusmarketback.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.indusmarket.indusmarketback.Entities.Product;
import tn.esprit.indusmarket.indusmarketback.Entities.Shop;
import tn.esprit.indusmarket.indusmarketback.Services.ProductServices;

import java.util.List;

@AllArgsConstructor
@RestController
public class ProductController {

    ProductServices productServices;
    @PostMapping(path = "/AddProduct")
    public Product AddProduct(@RequestBody Product p){return productServices.AddProduct(p);}
    @PostMapping(path = "/AddProductAndAssignToShop/{ShopId}")
    public Product AddProductAndAssignToShop(@RequestBody Product p,@PathVariable int ShopId) {
        return productServices.AddProductAndAssignToShop(p,ShopId);
    }
    @PostMapping(path ="/editProduct/{shopId}/{productId}" )
    public Product editProduct(@RequestBody Product product,@RequestBody int shopId,@RequestBody int productId){
        return productServices.editProduct(product,shopId,productId);
    }
    @PostMapping(path = "/deleteProduct/{idShop}/{idProduct}")
    public Shop deleteProduct(@PathVariable int idShop,@PathVariable int idProduct){
        return productServices.deleteProduct(idShop,idProduct);
    }
    @GetMapping(path ="/ShowAllProductsWithoutDiscount" )
    public List<Product> ShowAllProductsWithoutDiscount(){
        return productServices.ShowAllProductsWithoutDiscount();
    }
    @GetMapping(path ="/ShowAllProductsWithDiscount" )
        public List<Product> ShowAllProductsWithDiscount(){
            return productServices.ShowAllProductsWithDiscount();
        }
        @PostMapping(path = "/ApplicateDiscount/{Discount}/{idProd}")
    public Product ApplicateDiscount(@PathVariable int Discount,@PathVariable int idProd){
        return productServices.ApplicateDiscount(Discount,idProd);
        }
        @GetMapping(path ="/ShowAllProducts" )
        public List<Product> ShowAllProducts(){
        return productServices.ShowAllProducts();
        }
    @GetMapping(path = "/SortProductByCategory")
    public List<Product> SortProductByCategory(@PathVariable String category){
        return productServices.SortProductByCategory(category);
    }
}
