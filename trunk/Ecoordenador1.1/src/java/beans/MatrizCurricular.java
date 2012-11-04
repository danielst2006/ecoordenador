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

@ManagedBean(name="matriz_curricular")
@SessionScoped

@Entity
@SequenceGenerator(allocationSize= 1, name = "idgen", sequenceName = "matriz_seq")
@Table(name = "matriz_curricular")
public class MatrizCurricular implements Serializable {
    
        @Id
        @Column(name="id")
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @SequenceGenerator(name="mtz_seq", sequenceName="mtz_seq", allocationSize=1)
        private Integer id;
        
        @ManyToOne
        @JoinColumn(name="ident_curso")
        private Curso ident_curso;

        @Column(name="instituicao")
        private String siatuacao_matriz;

        @Column(name="instituicao")
        private String forma_avaliacao;

        @Column(name="inicio_vigencia")
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date inicio_vigencia;

        @Column(name="fim_vigencia")
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date fim_vigencia;

        @Column(name="tipo_periodo_matriz")
        private String tipo_periodo_matriz;

        @Column(name="numero_pedido")
        private Integer numero_pedido;

        @Column(name="numero_max_elementos")
        private Integer numero_max_elementos;

        @Column(name="periodo")
        private Integer periodo;

        @Column(name="grupo_curricular")
        private String grupo_curricular;

    public Date getFim_vigencia() {
        return fim_vigencia;
    }

    public void setFim_vigencia(Date fim_vigencia) {
        this.fim_vigencia = fim_vigencia;
    }

    public String getForma_avaliacao() {
        return forma_avaliacao;
    }

    public void setForma_avaliacao(String forma_avaliacao) {
        this.forma_avaliacao = forma_avaliacao;
    }

    public String getGrupo_curricular() {
        return grupo_curricular;
    }

    public void setGrupo_curricular(String grupo_curricular) {
        this.grupo_curricular = grupo_curricular;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Curso getIdent_curso() {
        return ident_curso;
    }

    public void setIdent_curso(Curso ident_curso) {
        this.ident_curso = ident_curso;
    }

    public Date getInicio_vigencia() {
        return inicio_vigencia;
    }

    public void setInicio_vigencia(Date inicio_vigencia) {
        this.inicio_vigencia = inicio_vigencia;
    }

    public Integer getNumero_max_elementos() {
        return numero_max_elementos;
    }

    public void setNumero_max_elementos(Integer numero_max_elementos) {
        this.numero_max_elementos = numero_max_elementos;
    }

    public Integer getNumero_pedido() {
        return numero_pedido;
    }

    public void setNumero_pedido(Integer numero_pedido) {
        this.numero_pedido = numero_pedido;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public String getSiatuacao_matriz() {
        return siatuacao_matriz;
    }

    public void setSiatuacao_matriz(String siatuacao_matriz) {
        this.siatuacao_matriz = siatuacao_matriz;
    }

    public String getTipo_periodo_matriz() {
        return tipo_periodo_matriz;
    }

    public void setTipo_periodo_matriz(String tipo_periodo_matriz) {
        this.tipo_periodo_matriz = tipo_periodo_matriz;
    }
    
}
