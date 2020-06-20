package inc.sneid.kvantoForm.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Profile {

    public enum Kvantum{
        IT, BIO, HI_TECH, VR
    }

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String patronymic;
    @Enumerated(EnumType.STRING)
    private Profile.Kvantum kvantum;
    @DateTimeFormat(pattern = "dd.MM.yy")
    private LocalDate birthday;
}
