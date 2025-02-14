package seu.lar.api.model.immobile;

import org.springframework.web.multipart.MultipartFile;

public record ImmobileDTO(String title, String description, String district, String city, String state, double price, boolean status, String type, String purpose, MultipartFile immobile_file, String user_id) {

}
