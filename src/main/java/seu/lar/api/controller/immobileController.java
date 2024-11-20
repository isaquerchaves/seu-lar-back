package seu.lar.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seu.lar.api.model.immobile.Immobile;
import seu.lar.api.model.immobile.ImmobileRepository;

import java.util.List;

@RestController
@RequestMapping("/immobiles")
public class immobileController {

    private final ImmobileRepository immobileRepository;

    public immobileController(seu.lar.api.model.immobile.ImmobileRepository immobileRepository) {
        this.immobileRepository = immobileRepository;
    }

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
}