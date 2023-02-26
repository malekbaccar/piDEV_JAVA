package tn.esprit.indusmarket.indusmarketback.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.indusmarket.indusmarketback.Entities.Livreur;
@Repository
public interface LivreurRepository extends JpaRepository<Livreur,Long> {



}
