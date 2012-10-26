package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

@ManagedBean(name="atividade_complementar")
@SessionScoped

@Entity
@Table(schema="public",name="atividade_complementar")
public class AtividadeComplementar implements Serializable {
 
        @Id
        @Column(name="id")
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @SequenceGenerator(name="atv_seq", sequenceName="atv_seq", allocationSize=1)
	private Integer id;
 
        @ManyToOne
        @JoinColumn(name="id_tipo_atividade")
	private AtividadeComplementarTipo id_tipo_atividade;
	 
        @Column(name="atividade",length=15)
	private String atividade;
	 
        @Column(name="pontuacao")
	private int pontuacao;
        
        @OneToOne(mappedBy="id_atividade_complementar",fetch= FetchType.LAZY)
        @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
        private EntradaAtividade entrada_atividade;

    public EntradaAtividade getEntrada_atividade() {
        return entrada_atividade;
    }

    public void setEntrada_atividade(EntradaAtividade entrada_atividade) {
        this.entrada_atividade = entrada_atividade;
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

    public AtividadeComplementarTipo getId_tipo_atividade() {
        return id_tipo_atividade;
    }

    public void setId_tipo_atividade(AtividadeComplementarTipo id_tipo_atividade) {
        this.id_tipo_atividade = id_tipo_atividade;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
	 
}
 
