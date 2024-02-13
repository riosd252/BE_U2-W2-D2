package DavidRios.BE_U2W2D2.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BlogPost {
    private long id;
    private String categoria;
    private String titolo;
    private String coverUrl;
    private String contenuto;
    private Double tempoDiLettura;
}
