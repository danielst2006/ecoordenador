package beans;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

@ManagedBean(name="entrada_atividade")
@SessionScoped

@Entity
@Table(schema="public",name="entrada_atividade")
public class Entrada_atividade implements Serializable {
 
        @Id
        @Column(name="id")
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @SequenceGenerator(name="entrada_seq", sequenceName="entrada_seq", allocationSize=1)
	private Long id;
	 
        @ManyToOne
        @JoinColumn(name="id_aluno")
	private Aluno id_aluno;
	 
        @OneToOne
        @JoinColumn(name="id_atividade_complementar")
        @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
	private Atividade_complementar id_atividade_complementar;
	 
	@Column(name="anexo",nullable=false)
        private byte[] anexo;
	 
        @Column(name="data_entrada",nullable=false)
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date data_entrada;
	 
        @Column(name="aprovado")
	private Boolean aprovado = false;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(Aluno id_aluno) {
        this.id_aluno = id_aluno;
    }

    public Atividade_complementar getId_atividade_complementar() {
        return id_atividade_complementar;
    }

    public void setId_atividade_complementar(Atividade_complementar id_atividade_complementar) {
        this.id_atividade_complementar = id_atividade_complementar;
    }
	 
}
 
