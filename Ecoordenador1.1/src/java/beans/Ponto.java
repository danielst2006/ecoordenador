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


@ManagedBean(name="ponto")
@SessionScoped

@Entity
@SequenceGenerator(allocationSize= 1, name = "idgen", sequenceName = "ponto_seq")
@Table(name = "ponto")
public class Ponto implements Serializable {
    
        @Id
        @Column(name="id")
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="idgen")
        private Integer id;
    
        @ManyToOne
        @JoinColumn(name="id_servidor")
        private Servidor id_servidor;
        
        @Temporal(TemporalType.TIMESTAMP)
        private Date entrada;
        
        @Temporal(TemporalType.TIMESTAMP)
        private Date saida;
        
        @Temporal(TemporalType.TIMESTAMP)
        private Date extra;

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getExtra() {
        return extra;
    }

    public void setExtra(Date extra) {
        this.extra = extra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

    public Servidor getId_servidor() {
        return id_servidor;
    }

    public void setId_servidor(Servidor id_servidor) {
        this.id_servidor = id_servidor;
    }

}
