package seu.lar.api.model.immobile;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import seu.lar.api.model.user.User;

@Entity
@Table(name = "immobile", schema = "public")
@Getter
@Setter
public class Immobile {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String district;
    private String city;
    private String state;
    private double price;
    private boolean status;
    private String type;
    private String purpose;
    private String user_id;
    private String image_url;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "user_id")
//    private User user;

    public Immobile(String title, String description, String district, String city, String state, double price, boolean status, String type, String purpose, String user_id, String image_url) {
        this.title = title;
        this.description = description;
        this.district = district;
        this.city = city;
        this.state = state;
        this.price = price;
        this.status = status;
        this.type = type;
        this.purpose = purpose;
        this.user_id = user_id;
        this.image_url = image_url;
    }

    public Immobile() {

    }
}
