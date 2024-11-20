package seu.lar.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seu.lar.api.model.profile.Profile;
import seu.lar.api.model.profile.ProfileRepository;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class profileController {

    private final ProfileRepository profileRepository;

    public profileController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileRepository.findAll();
        return ResponseEntity.ok(profiles);
    }
}
