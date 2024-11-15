package seu.lar.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seu.lar.api.immobile.Immobile;
import seu.lar.api.immobile.ImmobileRepository;

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
}
