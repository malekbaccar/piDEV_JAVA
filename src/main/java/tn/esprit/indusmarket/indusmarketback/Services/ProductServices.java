package tn.esprit.indusmarket.indusmarketback.Services;

import tn.esprit.indusmarket.indusmarketback.Entities.Product;
import tn.esprit.indusmarket.indusmarketback.Entities.Shop;

import java.util.List;

public interface ProductServices {
    public Product AddProduct(Product p);
    public Product AddProductAndAssignToShop(Product p ,int ShopId);
    public Product editProduct(Product product,int shopId,int productId);
    public Shop deleteProduct(int idShop, int idProduct);
    public List<Product> ShowAllProductsWithoutDiscount();
    public List<Product> ShowAllProductsWithDiscount();
    public Product ApplicateDiscount(int Discount,int idProd);
    public List<Product> ShowAllProducts();

    public List<Product> SortProductByCategory(String category);


}
