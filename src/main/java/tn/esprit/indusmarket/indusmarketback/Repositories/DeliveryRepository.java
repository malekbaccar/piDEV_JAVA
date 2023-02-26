package tn.esprit.indusmarket.indusmarketback.Repositories;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.indusmarket.indusmarketback.Entities.Delivery;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
   @Query("select d from Delivery d where  d.destinataire like :dest ")
   public List<Delivery> findByDestinataire(@Param("dest") String dest);
   public List<Delivery> findByIdDelivery(Long idDelivery);

   public Optional<Delivery> findById(Long id);
}
