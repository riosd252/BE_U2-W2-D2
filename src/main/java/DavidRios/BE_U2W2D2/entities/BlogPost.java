package DavidRios.BE_U2W2D2.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "blog_posts")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private long id;
    private String categoria;
    private String titolo;
    private String coverUrl;
    private String contenuto;
    private Double tempoDiLettura;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
