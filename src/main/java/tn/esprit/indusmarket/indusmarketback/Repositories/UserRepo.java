package tn.esprit.indusmarket.indusmarketback.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.indusmarket.indusmarketback.Entities.User;

public interface UserRepo extends JpaRepository<User,Integer> {
}
