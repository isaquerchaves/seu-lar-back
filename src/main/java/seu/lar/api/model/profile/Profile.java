package seu.lar.api.model.profile;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import seu.lar.api.model.user.User;

@Entity
@Table(name = "profile", schema = "public")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String creci;
    private Long phone;
    private String city;
    private String state;

    @Column(name = "user_id")
    private String userId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User userData;

    public Profile(ProfileDTO profileDTO) {
        this.creci = profileDTO.creci();
        this.phone = profileDTO.phone();
        this.city = profileDTO.city();
        this.state = profileDTO.state();
        this.userId = profileDTO.user_id();
    }

    public void updateInfo(ProfileDTO profileDTO) {
        if (profileDTO.creci() != null) {
            this.creci = profileDTO.creci();
        }
        if (profileDTO.phone() != null) {
            this.phone = profileDTO.phone();
        }
        if (profileDTO.city() != null) {
            this.city = profileDTO.city();
        }
        if (profileDTO.state() != null) {
            this.state = profileDTO.state();
        }
    }
}
