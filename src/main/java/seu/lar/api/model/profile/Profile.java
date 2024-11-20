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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
}
