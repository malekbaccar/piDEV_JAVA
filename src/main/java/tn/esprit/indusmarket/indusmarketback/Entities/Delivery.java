package tn.esprit.indusmarket.indusmarketback.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table( name = "Delivery")
public class Delivery implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDelivery")
    private Long idDelivery;
    private String code;
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;
    @Temporal(TemporalType.DATE)
    private Date deliveredDate;
    @Column(name = "poids")
    private int poids;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
    @Column(nullable = false)
    private String ville;
    @Column(nullable = false)
    private String destinataire;


    @OneToMany(cascade = CascadeType.ALL, mappedBy="deliveryS")
    private Set<Ordre> Orders;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="delivery")
    @JoinColumn(name = "livreur_id")
    private Set<Livreur> livreurs ;
}