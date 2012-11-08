package beans;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

@ManagedBean(name="entrada_atividade")
@SessionScoped

@Entity
@Table(schema="public",name="entrada_atividade")
public class EntradaAtividade implements Serializable {
 
        @Id
        @Column(name="id")
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @SequenceGenerator(name="entrada_seq", sequenceName="entrada_seq", allocationSize=1)
	private Integer id;
	 
	@Column(name="anexo",nullable=false)
        private byte[] anexo;
	 
        @Column(name="data_entrada",nullable=false)
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date data_entrada;
	 
        @Column(name="aprovado")
	private Boolean aprovado = false;
        
        @ManyToOne
        @JoinColumn(name="id_atividade")
        private AtividadeComplementar atividadecomplementar;
        
        @ManyToOne
        @JoinColumn(name="aluno")
        private Aluno aluno;

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public AtividadeComplementar getAtividadecomplementar() {
        return atividadecomplementar;
    }

    public void setAtividadecomplementar(AtividadeComplementar atividadecomplementar) {
        this.atividadecomplementar = atividadecomplementar;
    }

    public byte[] getAnexo() {
        return anexo;
    }

    public void setAnexo(byte[] anexo) {
        this.anexo = anexo;
    }

    public Boolean getAprovado() {
        return aprovado;
    }

    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
 
