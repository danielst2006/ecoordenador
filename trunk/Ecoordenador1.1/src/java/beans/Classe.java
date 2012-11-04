/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

@ManagedBean(name="classe")
@SessionScoped

@Entity
@SequenceGenerator(allocationSize= 1, name = "idgen", sequenceName = "classe_seq")
@Table(name = "classe")
public class Classe implements Serializable {
    
        @Id
        @Column(name="id")
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="idgen")
        private Integer id;
        
        @OneToOne
        @JoinColumn(name="id_turma")
        private Turma id_turma;
        
        @ManyToOne
        @JoinColumn(name="servidor_id")
        private Servidor servidor_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Turma getId_turma() {
        return id_turma;
    }

    public void setId_turma(Turma id_turma) {
        this.id_turma = id_turma;
    }

    public Servidor getServidor_id() {
        return servidor_id;
    }

    public void setServidor_id(Servidor servidor_id) {
        this.servidor_id = servidor_id;
    }
    
}
