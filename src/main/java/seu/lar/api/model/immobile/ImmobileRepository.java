package seu.lar.api.model.immobile;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImmobileRepository extends JpaRepository<Immobile, Long> {
    Optional<Immobile> findById(Long id);
}