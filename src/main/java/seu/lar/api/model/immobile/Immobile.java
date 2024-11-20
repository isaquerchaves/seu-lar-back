package seu.lar.api.model.immobile;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import seu.lar.api.model.user.User;

@Entity
@Table(name = "immobile", schema = "public")
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

}
