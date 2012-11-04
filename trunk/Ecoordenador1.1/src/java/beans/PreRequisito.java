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
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @SequenceGenerator(name="pre_seq", sequenceName="pre_seq", allocationSize=1)
        private Integer id;
        
        @ManyToOne
        @JoinColumn(name="id_disciplina")
        private Disciplina id_disciplina;
        
        @ManyToOne
        @JoinColumn(name="id_disciplina_requisitada")
        private Disciplina id_disciplina_requisitada;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Disciplina getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(Disciplina id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public Disciplina getId_disciplina_requisitada() {
        return id_disciplina_requisitada;
    }

    public void setId_disciplina_requisitada(Disciplina id_disciplina_requisitada) {
        this.id_disciplina_requisitada = id_disciplina_requisitada;
    }
    
}
