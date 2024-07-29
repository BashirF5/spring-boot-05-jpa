package az.edu.turing.az.springboot05jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import az.edu.turing.az.springboot05jpa.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
