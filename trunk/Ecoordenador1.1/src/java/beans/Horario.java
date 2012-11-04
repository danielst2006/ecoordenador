/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

@ManagedBean(name="horario")
@SessionScoped

@Entity
@SequenceGenerator(allocationSize= 1, name = "idgen", sequenceName = "horario_seq")
@Table(name = "horario")
public class Horario implements Serializable {
    
        @Id
        @Column(name="id")
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="idgen")
        private Integer id;
        
        @OneToOne
        @JoinColumn(name="id_classe",nullable=false)
        private Classe id_classe;
        
        @Column(name="horario_inicio",length=6,nullable=false)
        private String horario_inicio;
        
        @Column(name="horario_inicio",length=6,nullable=false)
        private String horario_fim;
        
        @Column(name="dia_semana",length=8,nullable=false)
        private String dia_semana;

    public String getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    public String getHorario_fim() {
        return horario_fim;
    }

    public void setHorario_fim(String horario_fim) {
        this.horario_fim = horario_fim;
    }

    public String getHorario_inicio() {
        return horario_inicio;
    }

    public void setHorario_inicio(String horario_inicio) {
        this.horario_inicio = horario_inicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Classe getId_clase() {
        return id_classe;
    }

    public void setId_clase(Classe id_classe) {
        this.id_classe = id_classe;
    }
    
}
