package seu.lar.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import seu.lar.api.model.immobile.Immobile;
import seu.lar.api.model.immobile.ImmobileDTO;
import seu.lar.api.model.immobile.ImmobileRepository;

@Service
public class ImmobileService {

    @Autowired
    private ImmobileRepository immobileRepository;

    @Autowired
    private StorageFileService storageFileService;

    public String saveImmobile(ImmobileDTO immobileDTO) {

        String immobileUrl = storageFileService.uploadFile(
                immobileDTO.immobile_file(),
                immobileDTO.user_id()
        );

        Immobile immobile = new Immobile(immobileDTO.title(), immobileDTO.description(), immobileDTO.district(), immobileDTO.city(), immobileDTO.state(), immobileDTO.price(), immobileDTO
                .status(), immobileDTO.type(), immobileDTO.purpose(), immobileDTO.user_id(), immobileUrl);

        immobileRepository.save(immobile);

        return immobileUrl;
    }
}
