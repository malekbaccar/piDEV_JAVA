package tn.esprit.indusmarket.indusmarketback.Services;

import tn.esprit.indusmarket.indusmarketback.Entities.Delivery;
import tn.esprit.indusmarket.indusmarketback.Entities.Livreur;
import tn.esprit.indusmarket.indusmarketback.Repositories.LivreurRepository;

import java.util.List;
import java.util.Optional;

public interface LivreurServices {


    public Livreur enregistrerLivreur(Livreur livreur) ;

    public Optional<Livreur> findById(Long id);

    public List<Livreur> rechercherLivreurs();
    public Delivery attribuerLivreur(Long idDelivery, Long livreurId);
}
