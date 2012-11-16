/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

@ManagedBean(name="pre_requisito")
@SessionScoped

@Entity
@SequenceGenerator(allocationSize= 1, name = "idgen", sequenceName = "pre_seq")
@Table(name = "pre_requisito")
public class PreRequisito implements Serializable {
    
        @Id
        @Column(name="id")
        @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="idgen")
        private Integer id;
        
        @ManyToOne
        @JoinColumn(name="disc_pk")
        private Disciplina disc_pk;
        
        @ManyToOne
        @JoinColumn(name="disc_eq")
        private Disciplina disc_eq;

    public Disciplina getDisc_eq() {
        return disc_eq;
    }

    public void setDisc_eq(Disciplina disc_eq) {
        this.disc_eq = disc_eq;
    }

    public Disciplina getDisc_pk() {
        return disc_pk;
    }

    public void setDisc_pk(Disciplina disc_pk) {
        this.disc_pk = disc_pk;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
