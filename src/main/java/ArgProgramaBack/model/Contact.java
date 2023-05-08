package ArgProgramaBack.model;

import jakarta.persistence.*;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;

    private String icono;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getTexto() {return texto;}
    public void setTexto(String texto) {this.texto = texto;}
    public String getIcono() {return icono;}
    public void setIcono(String icono) {this.icono = icono;}
}
