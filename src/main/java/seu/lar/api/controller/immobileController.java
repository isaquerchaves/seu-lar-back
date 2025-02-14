package seu.lar.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seu.lar.api.model.immobile.Immobile;
import seu.lar.api.model.immobile.ImmobileDTO;
import seu.lar.api.model.immobile.ImmobileRepository;
import seu.lar.api.service.ImmobileService;

import java.util.List;

@RestController
@RequestMapping("/immobiles")
@RequiredArgsConstructor
public class immobileController {

    private final ImmobileRepository immobileRepository;
    private final ImmobileService immobileService;

    @GetMapping
    public ResponseEntity<List<Immobile>> getAllImmobiles() {
        List<Immobile> immobiles = immobileRepository.findAll();
        return ResponseEntity.ok(immobiles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Immobile> getImmobileById(@PathVariable Long id) {
        return immobileRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<String> saveImmobile(@ModelAttribute ImmobileDTO immobileDTO) {
        String immobileImageUrl = immobileService.saveImmobile(immobileDTO);
        return ResponseEntity.ok(immobileImageUrl);
    }
}