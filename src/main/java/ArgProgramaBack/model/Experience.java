package ArgProgramaBack.model;

import jakarta.persistence.*;

@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ano;
    
    @Lob
    @Column(columnDefinition="TEXT")
    private String descripcion;

    private String imagen;

    private String titulo;
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getAno() {return ano;}
    public void setAno(String ano) {this.ano = ano;}
    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public String getImagen() {return imagen;}
    public void setImagen(String imagen) {this.imagen = imagen;}
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}

}
