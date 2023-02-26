package tn.esprit.indusmarket.indusmarketback.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table( name = "Product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduct")
    private Integer idProduct;
    private String reference;
    private String name;
    private Integer quantity;
    private float price;
    private String description;
    private Integer discount;
    private float PriceAfterDiscount;
    private String brand;
    private Category category;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Pictures> pictures;
    @ManyToOne
    private Shop shop;

}
