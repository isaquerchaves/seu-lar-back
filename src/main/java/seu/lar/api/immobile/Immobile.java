package seu.lar.api.immobile;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

}
