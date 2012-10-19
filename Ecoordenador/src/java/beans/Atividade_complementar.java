package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

@ManagedBean(name="atividade_complementar")
@SessionScoped

@Entity
@Table(schema="public",name="atividade_complementar")
public class Atividade_complementar implements Serializable {
 
        @Id
        @Column(name="id")
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @SequenceGenerator(name="atv_seq", sequenceName="atv_seq", allocationSize=1)
	private Long id;
	 
        @ManyToOne
        @JoinColumn(name="id_tipo_atividade")
	private Atividade_complementar_tipo id_tipo_atividade;
	 
        @Column(name="atividade",length=15)
	private String atividade;
	 
        @Column(name="pontuacao")
	private int pontuacao;
        
        @OneToOne(mappedBy="id_atividade_complementar",cascade=CascadeType.ALL)
        private Entrada_atividade entrada_atividade;

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Atividade_complementar_tipo getId_tipo_atividade() {
        return id_tipo_atividade;
    }

    public void setId_tipo_atividade(Atividade_complementar_tipo id_tipo_atividade) {
        this.id_tipo_atividade = id_tipo_atividade;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
	 
}
 
