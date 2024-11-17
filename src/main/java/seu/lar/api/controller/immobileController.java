package seu.lar.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seu.lar.api.immobile.Immobile;
import seu.lar.api.immobile.ImmobileRepository;
import seu.lar.api.exception.ResourceNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/immobiles")
public class immobileController {

    private final ImmobileRepository immobileRepository;

    public immobileController(ImmobileRepository immobileRepository) {
        this.immobileRepository = immobileRepository;
    }

    @GetMapping
    public List<Immobile> getAllImmobiles() {
        return immobileRepository.findAll();
    }

    @GetMapping("/{id}")
    public Immobile getImmobileById(@PathVariable Long id) {
        return immobileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Imóvel não encontrado"));
    }
}