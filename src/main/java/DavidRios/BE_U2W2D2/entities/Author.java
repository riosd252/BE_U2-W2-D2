package DavidRios.BE_U2W2D2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "authors")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;
    @JsonIgnore
    @OneToMany(mappedBy = "author")
    @ToString.Exclude
    private List<BlogPost> blogPosts;

    public Author(String nome, String cognome, String email, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.avatar = "https://i.pravatar.cc/150";
    }
}
