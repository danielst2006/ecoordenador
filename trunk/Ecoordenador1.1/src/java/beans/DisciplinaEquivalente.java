/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

@ManagedBean(name="disciplina_equivalente")
@SessionScoped

@Entity
@SequenceGenerator(allocationSize= 1, name = "idgen", sequenceName = "equivalente_seq")
@Table(name = "disciplina_equivalente")
public class DisciplinaEquivalente implements Serializable {
    
        @Id
        @Column(name="id")
        @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="idgen")
        private Integer id;
        
        @ManyToOne
        @JoinColumn(name="disciplina_pk")
        private Disciplina disciplina_pk;
        
        @ManyToOne
        @JoinColumn(name="disciplina_eq")
        private Disciplina disciplina_eq;

    public Disciplina getDisciplina_eq() {
        return disciplina_eq;
    }

    public void setDisciplina_eq(Disciplina disciplina_eq) {
        this.disciplina_eq = disciplina_eq;
    }

    public Disciplina getDisciplina_pk() {
        return disciplina_pk;
    }

    public void setDisciplina_pk(Disciplina disciplina_pk) {
        this.disciplina_pk = disciplina_pk;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
