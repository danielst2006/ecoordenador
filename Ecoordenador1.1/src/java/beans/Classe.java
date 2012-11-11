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
        @Column(name="id_classe")
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="idgen")
        private Integer id;
        
        @ManyToOne
        @JoinColumn(name="disciplina")
        private Disciplina disciplina;
        
        @OneToOne(mappedBy="classe",cascade=CascadeType.ALL)
        private Horario horario;
        
        @ManyToOne
        @JoinColumn(name="turma")
        private Turma turma;
        
        @ManyToOne
        @JoinColumn(name="servidor")
        private Servidor servidor;

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
