/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

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
        
        @ManyToOne
        @JoinColumn(name="id_periodo_letido")
        private PeriodoLetivo id_periodo_letido;
        
        @ManyToOne
        @JoinColumn(name="matriz_id")
        private MatrizCurricular matriz_id;
        
        @Column(name="turno")
        private String turno;
        
        @OneToOne(mappedBy="id_turma",fetch=FetchType.EAGER)
        @Cascade(org.hibernate.annotations.CascadeType.ALL)
        private Classe classe;

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public MatrizCurricular getMatriz_id() {
        return matriz_id;
    }

    public void setMatriz_id(MatrizCurricular matriz_id) {
        this.matriz_id = matriz_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PeriodoLetivo getId_periodo_letido() {
        return id_periodo_letido;
    }

    public void setId_periodo_letido(PeriodoLetivo id_periodo_letido) {
        this.id_periodo_letido = id_periodo_letido;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
}
