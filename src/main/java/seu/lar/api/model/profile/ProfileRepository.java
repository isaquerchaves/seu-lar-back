package seu.lar.api.model.profile;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByUserId(String userId);
    Optional<Profile> findByCreci(String creci);
    boolean existsByUserId(String userId);
    boolean existsByCreci(String creci);
}