/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@ManagedBean(name="horario")
@SessionScoped

@Entity
@SequenceGenerator(allocationSize= 1, name = "idgen", sequenceName = "horario_seq")
@Table(name = "horario")
public class Horario implements Serializable {
    
        @Id
        @Column(name="id_classe", unique=true, nullable=false)
        @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="gen")
        @GenericGenerator(name="gen", strategy="foreign", parameters=@org.hibernate.annotations.Parameter(name="property", value="classe"))
        private Integer id_classe;
        
        @OneToOne
        @PrimaryKeyJoinColumn
        private Classe classe;
        
        @Temporal(TemporalType.TIME)
        private Date horario_inicio;
        
        @Temporal(TemporalType.TIME)
        private Date horario_fim;
        
        @Column(name="dia_semana",length=15)
        private String dia_semana;

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
        
    public String getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    public Date getHorario_fim() {
        return horario_fim;
    }

    public void setHorario_fim(Date horario_fim) {
        this.horario_fim = horario_fim;
    }

    public Date getHorario_inicio() {
        return horario_inicio;
    }

    public void setHorario_inicio(Date horario_inicio) {
        this.horario_inicio = horario_inicio;
    }

    public Integer getId_classe() {
        return id_classe;
    }

    public void setId_classe(Integer id_classe) {
        this.id_classe = id_classe;
    }

}
