package ArgProgramaBack.model;

import jakarta.persistence.*;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int nivel;

    private String nombre;

    private String tipo;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public int getNivel() {return nivel;}
    public void setNivel(int nivel) {this.nivel = nivel;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}
}

