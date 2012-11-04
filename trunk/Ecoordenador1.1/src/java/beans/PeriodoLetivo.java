/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

@ManagedBean(name="periodo_letivo")
@SessionScoped

@Entity
@SequenceGenerator(allocationSize= 1, name = "idgen", sequenceName = "pl_seq")
@Table(name = "periodo_letivo")
public class PeriodoLetivo implements Serializable {
    
        @Id
        @Column(name="id")
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="idgen")
        private Integer id;
        
        @Column(name="ano")
        private Integer ano;
        
        @Column(name="semestre")
        private Integer semestre;
        
        @Column(name="data_inicio")
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date data_inicio;
        
        @Column(name="data_fim")
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date data_fim;
        
        @OneToMany(mappedBy="id_periodo_letido",fetch=FetchType.LAZY)
        @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
        Set<Turma> turmas = new HashSet<Turma>();

    public Set<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(Set<Turma> turmas) {
        this.turmas = turmas;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }
    
}
