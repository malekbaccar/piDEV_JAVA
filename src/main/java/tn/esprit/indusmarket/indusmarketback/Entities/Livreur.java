package tn.esprit.indusmarket.indusmarketback.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table( name = "Livreur")
public class Livreur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String secteur;
    @Column(name = "max_poids")
    private int maxPoids;
    @Column(name = "nombres_des_commandes ")
    private int nbrCommande;
    private String listeColis;
    private String listeClient ;
    @ManyToOne
    @JoinColumn(name = "idDelivery")
    private Delivery delivery;


}
