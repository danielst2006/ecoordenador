package beans;

import java.io.Serializable;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

@ManagedBean(name="atividade_complementar")
@SessionScoped

@Entity
@Table(schema="public",name="atividade_complementar")
public class AtividadeComplementar implements Serializable {
 
        @Id
        @Column(name="id_atividade")
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @SequenceGenerator(name="atv_seq", sequenceName="atv_seq", allocationSize=1)
	private Integer id;
	 
        @Column(name="atividade",length=15)
	private String atividade;
	 
        @Column(name="pontuacao")
	private int pontuacao;
        
        @ManyToOne
        @JoinColumn(name="id_tipo")
        private AtividadeComplementarTipo atividadecomplementartipo;
        
        @OneToMany(mappedBy="atividadecomplementar")
        private Set<EntradaAtividade> entradas;

    public Set<EntradaAtividade> getEntradas() {
        return entradas;
    }

    public void setEntradas(Set<EntradaAtividade> entradas) {
        this.entradas = entradas;
    }

    public AtividadeComplementarTipo getAtividadecomplementartipo() {
        return atividadecomplementartipo;
    }

    public void setAtividadecomplementartipo(AtividadeComplementarTipo atividadecomplementartipo) {
        this.atividadecomplementartipo = atividadecomplementartipo;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
	 
}
 
