package seu.lar.api.model.immobile;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record ImmobileDTO(String title, String description, String district, String city, String state, double price, boolean status, String type, String purpose, List<MultipartFile> immobile_files, String user_id) {

}
