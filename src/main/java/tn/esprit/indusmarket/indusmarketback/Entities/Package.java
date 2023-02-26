package tn.esprit.indusmarket.indusmarketback.Entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Package implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPackage")
    private  long idpackage ;
    private String adresseLivraison;
    private  int nbrpproduct ;
    private String etat;
    private float prixTotal;


}
