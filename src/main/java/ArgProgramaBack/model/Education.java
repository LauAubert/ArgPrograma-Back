package ArgProgramaBack.model;

import jakarta.persistence.*;

@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ano;

    private String carrera;
    private String institucion;
    private String logo;
    
    @Lob
    @Column(columnDefinition="TEXT")
    private String descripcion;


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getAno() {return ano;}
    public void setAno(String ano) {this.ano = ano;}
    public String getCarrera() {return carrera;}
    public void setCarrera(String carrera) {this.carrera = carrera;}
    public String getInstitucion() {return institucion;}
    public void setInstitucion(String institucion) {this.institucion = institucion;}
    public String getLogo() {return logo;}
    public void setLogo(String logo) {this.logo = logo;}
    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
}
