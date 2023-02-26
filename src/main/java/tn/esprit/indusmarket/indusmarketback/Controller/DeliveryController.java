package tn.esprit.indusmarket.indusmarketback.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.indusmarket.indusmarketback.Entities.Delivery;
import tn.esprit.indusmarket.indusmarketback.ServicesImplementation.DeliveryServiceImpl;

import javax.security.auth.Destroyable;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/deliveries")
public class DeliveryController {
    @Autowired
    private DeliveryServiceImpl deliveryService;

    @GetMapping(path = "/show")
    public List<Delivery> findAll() {
        return deliveryService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Delivery> findById(@PathVariable("id") Long id) {
        Optional<Delivery> delivery = deliveryService.findById(id);
        return delivery.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Delivery> create(@RequestBody Delivery delivery) {
        Delivery savedDelivery = deliveryService.save(delivery);
        return ResponseEntity.created(URI.create("/api/deliveries/" + savedDelivery.getIdDelivery()))
                .body(savedDelivery);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Delivery> update(@PathVariable("id") Long id, @RequestBody Delivery delivery) {
        if (!id.equals(delivery.getIdDelivery())) {
            return ResponseEntity.badRequest().build();
        }
        Delivery updatedDelivery = deliveryService.save(delivery);
        return ResponseEntity.ok(updatedDelivery);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        deliveryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public List<Delivery> rechercherDeliveryList(@RequestParam ("dest") String dest){
      return deliveryService.rechercherDeliveryList(dest);
    }
}