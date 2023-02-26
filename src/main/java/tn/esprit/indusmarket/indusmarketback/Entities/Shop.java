package tn.esprit.indusmarket.indusmarketback.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table( name = "Shop")
public class Shop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idShop")
    private Integer idShop;
    private String name;
    private String mail;
    private Integer phoneNumber;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "shop")
    private List<Product> products;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Pictures> picturesList;
    @ManyToOne
    User user;

}
