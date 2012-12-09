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
        
        @Column(name="dia",nullable=false)
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date dia;
        
        @Temporal(TemporalType.TIME)
        private Date entrada_matutina;
        
        @Temporal(TemporalType.TIME)
        private Date saida_matutina;
        
        @Temporal(TemporalType.TIME)
        private Date entrada_vespertina;
        
        @Temporal(TemporalType.TIME)
        private Date saida_vespertina;
        
        @Temporal(TemporalType.TIME)
        private Date entrada_noturna;
        
        @Temporal(TemporalType.TIME)
        private Date saida_noturna;

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Date getEntrada_matutina() {
        return entrada_matutina;
    }

    public void setEntrada_matutina(Date entrada_matutina) {
        this.entrada_matutina = entrada_matutina;
    }

    public Date getEntrada_noturna() {
        return entrada_noturna;
    }

    public void setEntrada_noturna(Date entrada_noturna) {
        this.entrada_noturna = entrada_noturna;
    }

    public Date getEntrada_vespertina() {
        return entrada_vespertina;
    }

    public void setEntrada_vespertina(Date entrada_vespertina) {
        this.entrada_vespertina = entrada_vespertina;
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

    public Date getSaida_matutina() {
        return saida_matutina;
    }

    public void setSaida_matutina(Date saida_matutina) {
        this.saida_matutina = saida_matutina;
    }

    public Date getSaida_noturna() {
        return saida_noturna;
    }

    public void setSaida_noturna(Date saida_noturna) {
        this.saida_noturna = saida_noturna;
    }

    public Date getSaida_vespertina() {
        return saida_vespertina;
    }

    public void setSaida_vespertina(Date saida_vespertina) {
        this.saida_vespertina = saida_vespertina;
    }

}
