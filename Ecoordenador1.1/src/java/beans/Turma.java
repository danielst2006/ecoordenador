/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

@ManagedBean(name="turma")
@SessionScoped

@Entity
@SequenceGenerator(allocationSize= 1, name = "idgen", sequenceName = "turma_seq")
@Table(name = "turma")
public class Turma implements Serializable {
    
        @Id
        @Column(name="id")
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="idgen")
        private Integer id;
        
        @Column(name="numero_turma")
        private Integer numero_turma;
        
        @Column(name="turno")
        private String turno;
        
        @ManyToOne
        @JoinColumn(name="matrizcurricular")
        private MatrizCurricular matrizcurricular;
        
        @ManyToOne
        @JoinColumn(name="periodoletivo")
        private PeriodoLetivo periodoletivo;
        
        @OneToMany(mappedBy="turma")
        Set<Classe> classes;

        
    public Integer getNumero_turma() {
        return numero_turma;
    }

    public void setNumero_turma(Integer numero_turma) {
        this.numero_turma = numero_turma;
    }

    public PeriodoLetivo getPeriodoletivo() {
        return periodoletivo;
    }

    public void setPeriodoletivo(PeriodoLetivo periodoletivo) {
        this.periodoletivo = periodoletivo;
    }

    public MatrizCurricular getMatrizcurricular() {
        return matrizcurricular;
    }

    public void setMatrizcurricular(MatrizCurricular matrizcurricular) {
        this.matrizcurricular = matrizcurricular;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
}
