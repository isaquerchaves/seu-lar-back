package seu.lar.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seu.lar.api.model.profile.Profile;
import seu.lar.api.model.profile.ProfileDTO;
import seu.lar.api.model.profile.ProfileRepository;

import java.util.List;

@RestController
@RequestMapping("/profiles")
@RequiredArgsConstructor
public class profileController {

    private final ProfileRepository profileRepository;

    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileRepository.findAll();
        return ResponseEntity.ok(profiles);
    }

    @GetMapping("/active")
    public ResponseEntity<List<Profile>> getActiveProfiles() {
        List<Profile> activeProfiles = profileRepository.findByActiveTrue();
        return ResponseEntity.ok(activeProfiles);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Profile> getProfileByUserId(@PathVariable String userId) {
        return profileRepository.findByUserId(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createProfile(@RequestBody ProfileDTO profileDTO) {
        boolean existsCreci = profileRepository.existsByCreci(profileDTO.creci());
        boolean existsUserId = profileRepository.existsByUserId(profileDTO.user_id());

        if (existsUserId) {
            return ResponseEntity.status(409).body("Perfil já existe para o Usuário informado.");
        }

        if (existsCreci) {
            return ResponseEntity.status(409).body("Perfil já existe com o CRECI informado.");
        }

        profileRepository.save(new Profile(profileDTO) );
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}")
    @Transactional
    public ResponseEntity<String> updateProfile(@PathVariable String userId, @RequestBody @Valid ProfileDTO profileDTO) {
        var optionalProfile = profileRepository.findByUserId(userId);

        if (optionalProfile.isEmpty()) {
            return ResponseEntity.status(404).body("Perfil não encontrado");
        }

        Profile profile = optionalProfile.get();

        if (profileDTO.creci() != null) {
            var existingCreci = profileRepository.findByCreci(profileDTO.creci());
            if (existingCreci.isPresent() && !existingCreci.get().getId().equals(profile.getId())) {
                return ResponseEntity.status(404).body("Creci já está em uso");
            }
        }

        profile.updateInfo(profileDTO);
        return ResponseEntity.ok().build();
    }
}
