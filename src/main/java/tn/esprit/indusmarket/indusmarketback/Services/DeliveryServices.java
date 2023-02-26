package tn.esprit.indusmarket.indusmarketback.Services;

import tn.esprit.indusmarket.indusmarketback.Entities.Delivery;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DeliveryServices {
    public List<Delivery> findAll();
    public Optional<Delivery> findById(Long id);
    public Delivery save(Delivery delivery);
    public void deleteById(Long id);
    public List<Delivery> rechercherDeliveryList(String dest);
}
