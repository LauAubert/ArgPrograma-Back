package ArgProgramaBack.model;

import jakarta.persistence.*;

@Entity
public class Aboutme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition="TEXT")
    private String texto;

    private String lenguaje;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getTexto() {return texto;}
    public void setTexto(String texto) {this.texto = texto;}
    public String getLenguaje() {return lenguaje;}
    public void setLenguaje(String lenguaje) {this.lenguaje = lenguaje;}
}
