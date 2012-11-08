/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@ManagedBean(name="coordenador")
@SessionScoped

@Entity
@SequenceGenerator(allocationSize= 1, name = "idgen", sequenceName = "coordenador_seq")
@Table(name = "coordenador")
public class Coordenador implements Serializable {
    
        @Id
        @Column(name="id_usuario", unique=true, nullable=false)
        @GeneratedValue(generator="gen")
        @GenericGenerator(name="gen", strategy="foreign", parameters=@org.hibernate.annotations.Parameter(name="property", value="servidor"))
        private Integer id_usuario;
        
        @OneToOne
        @PrimaryKeyJoinColumn
        private Servidor servidor;
        
        @Column(name="data_inicio",nullable=false)
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date data_inicio;
        
        @Column(name="data_fim")
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date data_fim;
        
        private Boolean ativo;
        
        @ManyToOne
        @JoinColumn(name="curso")
        private Curso curso;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
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

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
        
}
