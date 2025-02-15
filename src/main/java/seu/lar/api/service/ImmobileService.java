package seu.lar.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seu.lar.api.model.immobile.Immobile;
import seu.lar.api.model.immobile.ImmobileDTO;
import seu.lar.api.model.immobile.ImmobileRepository;

import java.util.List;

@Service
public class ImmobileService {

    @Autowired
    private ImmobileRepository immobileRepository;

    @Autowired
    private StorageFileService storageFileService;

    public List<String> saveImmobile(ImmobileDTO immobileDTO) {

        List<String> imageUrls = immobileDTO.immobile_files().stream()
                .map(file -> storageFileService.uploadFile(file, immobileDTO.user_id()))
                .toList();

        Immobile immobile = new Immobile(immobileDTO.title(), immobileDTO.description(), immobileDTO.district(), immobileDTO.city(), immobileDTO.state(), immobileDTO.price(), immobileDTO
                .status(), immobileDTO.type(), immobileDTO.purpose(), immobileDTO.user_id(), imageUrls);

        immobileRepository.save(immobile);

        return imageUrls;
    }
}
