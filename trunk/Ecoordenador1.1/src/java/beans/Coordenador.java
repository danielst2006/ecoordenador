/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@SequenceGenerator(allocationSize= 1, name = "idgen", sequenceName = "coordenador_seq")
@Table(name = "coordenador")
public class Coordenador implements Serializable {
    
        @Id
        @Column(name="id")
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="idgen")
	private Integer id;
        
        @OneToOne
        @JoinColumn(name="id_servidor")
        private Servidor id_servidor;
        
        @ManyToOne
        @JoinColumn(name="curso_id")
        private Curso curso_id;
        
        @Column(name="data_inicio",nullable=false)
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date data_inicio;
        
        @Column(name="data_fim")
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date data_fim;
        
        private Boolean ativo;

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Curso getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(Curso curso_id) {
        this.curso_id = curso_id;
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

    public Servidor getId_servidor() {
        return id_servidor;
    }

    public void setId_servidor(Servidor id_servidor) {
        this.id_servidor = id_servidor;
    }
    
}
