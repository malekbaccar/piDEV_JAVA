package tn.esprit.indusmarket.indusmarketback.ServicesImplementation;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.indusmarket.indusmarketback.Entities.Delivery;
import tn.esprit.indusmarket.indusmarketback.Entities.Livreur;
import tn.esprit.indusmarket.indusmarketback.Repositories.DeliveryRepository;
import tn.esprit.indusmarket.indusmarketback.Repositories.LivreurRepository;
import tn.esprit.indusmarket.indusmarketback.Services.DeliveryServices;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class DeliveryServiceImpl implements DeliveryServices {
    @Autowired
    private DeliveryRepository deliveryRepository;
    private LivreurRepository livreurRepository;


    public List<Delivery> findAll() {
        return deliveryRepository.findAll();
    }

    public Optional<Delivery> findById(Long id) {
        return deliveryRepository.findById(id);
    }

    public Delivery save(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public void deleteById(Long id) {
        deliveryRepository.deleteById(id);
    }

    @Override
    public List<Delivery> rechercherDeliveryList(String dest) {
        return deliveryRepository.findByDestinataire(dest );
    }

    public Delivery attribuerLivreur(Long idDelivery, Long livreurId) {
        Delivery colis = deliveryRepository.findById(idDelivery).orElseThrow(() -> new RuntimeException("Colis introuvable"));
        Livreur livreur = livreurRepository.findById(livreurId).orElseThrow(() -> new RuntimeException("Livreur introuvable"));


        colis.setDestinataire(new String());

        return deliveryRepository.save(colis);
    }


}
