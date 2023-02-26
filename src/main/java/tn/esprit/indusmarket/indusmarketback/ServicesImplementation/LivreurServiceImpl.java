package tn.esprit.indusmarket.indusmarketback.ServicesImplementation;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.indusmarket.indusmarketback.Entities.Delivery;
import tn.esprit.indusmarket.indusmarketback.Entities.Livreur;
import tn.esprit.indusmarket.indusmarketback.Repositories.LivreurRepository;
import tn.esprit.indusmarket.indusmarketback.Services.LivreurServices;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LivreurServiceImpl implements LivreurServices {
    @Autowired
    private LivreurRepository livreurRepository;

    public Livreur enregistrerLivreur(Livreur livreur) {
        return livreurRepository.save(livreur);
    }

    @Override
    public Optional<Livreur> findById(Long id) {
        return Optional.empty();
    }

    public List<Livreur> rechercherLivreurs() {
        return livreurRepository.findAll();
    }

    @Override
    public Delivery attribuerLivreur(Long idDelivery, Long livreurId) {
        return null;
    }


    public List<Delivery> rechercherColisLivreur(Long livreurId) {
        Livreur livreur = livreurRepository.findById(livreurId).orElseThrow(() -> new RuntimeException("Livreur introuvable"));

        return (List<Delivery>) livreur.getDelivery();
    }
}
