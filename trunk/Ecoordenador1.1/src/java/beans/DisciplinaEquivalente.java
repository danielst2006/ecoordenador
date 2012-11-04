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
@SequenceGenerator(allocationSize= 1, name = "idgen", sequenceName = "eqv_seq")
@Table(name = "disciplina_equivalente")
public class DisciplinaEquivalente implements Serializable {
    
        @Id
        @Column(name="id")
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @SequenceGenerator(name="eqv_seq", sequenceName="eqv_seq", allocationSize=1)
        private Integer id;
        
        @ManyToOne
        @JoinColumn(name="disciplina_id")
        private Disciplina disciplina_id;
        
        @ManyToOne
        @JoinColumn(name="disciplina_equivalente_id")
        private Disciplina disciplina_equivalente_id;

    public Disciplina getDisciplina_equivalente_id() {
        return disciplina_equivalente_id;
    }

    public void setDisciplina_equivalente_id(Disciplina disciplina_equivalente_id) {
        this.disciplina_equivalente_id = disciplina_equivalente_id;
    }

    public Disciplina getDisciplina_id() {
        return disciplina_id;
    }

    public void setDisciplina_id(Disciplina disciplina_id) {
        this.disciplina_id = disciplina_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
