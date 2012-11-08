 package beans;

import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

@ManagedBean(name="aluno")
@SessionScoped
 
@Entity
@SequenceGenerator(allocationSize= 1, name = "idgen", sequenceName = "aluno_seq")
@Table(name = "aluno")
public class Aluno extends Pessoa {
            
        @Column(name="nome_responsavel",length=80)
	private String nome_responsavel;
	 
        @Column(name="cpf_responsavel",length=12)
	private String cpf_responsavel;
		 
        @Column(name="parentesco",length=20)
	private String parentesco;
	 
        @Column(name="renda",nullable=false)
	private Boolean renda=false;
	 
        @Column(name="renda_familiar")
	private Double renda_familiar;
	 
        @Column(name="tamanho_familia")
	private Integer tamanho_familia;
	 
        @Column(name="trabalha")
	private Boolean trabalha=false;
	 
        @Column(name="local_trabalho",length=80)
	private String local_trabalho;
	 
        @Column(name="telefone_trabalho")
	private Integer telefone_trabalho;
	 
        @Column(name="profissao",length=45)
	private String profissao;
	 
        @Column(name="escola_formacao_anterior",length=100,nullable=false)
	private String escola_formacao_anterior;
	 
        @Column(name="ano_formacao_anterior",nullable=false)
	private Integer ano_formacao_anterior;
	 
        @Column(name="tipo_escola_anterior",length=15)
	private String tipo_escola_anterior;
	 
        @Column(name="etapa_ensino_anterior",length=13)
	private String etapa_ensino_anterior;
	 
        @Column(name="cidade_instituicao_ensino",length=40)
	private String cidade_instituicao_ensino;
	 
        @Column(name="uf_instituicao_ensino",length=2)
	private String uf_instituicao_ensino;
        
        @OneToMany(mappedBy="id_aluno",fetch=FetchType.LAZY)
        @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
        Set<EntradaAtividade> ent_atv = new HashSet<EntradaAtividade>();
        
        @OneToOne
        @JoinColumn(name="usuario_id")
        private Usuario usuario_id;
        
        @ManyToOne
        @JoinColumn(name="id_curso")
	private Curso id_curso;

    public Integer getAno_formacao_anterior() {
        return ano_formacao_anterior;
    }

    public void setAno_formacao_anterior(Integer ano_formacao_anterior) {
        this.ano_formacao_anterior = ano_formacao_anterior;
    }

    public String getCidade_instituicao_ensino() {
        return cidade_instituicao_ensino;
    }

    public void setCidade_instituicao_ensino(String cidade_instituicao_ensino) {
        this.cidade_instituicao_ensino = cidade_instituicao_ensino;
    }

    public String getCpf_responsavel() {
        return cpf_responsavel;
    }

    public void setCpf_responsavel(String cpf_responsavel) {
        this.cpf_responsavel = cpf_responsavel;
    }

    public Set<EntradaAtividade> getEnt_atv() {
        return ent_atv;
    }

    public void setEnt_atv(Set<EntradaAtividade> ent_atv) {
        this.ent_atv = ent_atv;
    }

    public String getEscola_formacao_anterior() {
        return escola_formacao_anterior;
    }

    public void setEscola_formacao_anterior(String escola_formacao_anterior) {
        this.escola_formacao_anterior = escola_formacao_anterior;
    }

    public String getEtapa_ensino_anterior() {
        return etapa_ensino_anterior;
    }

    public void setEtapa_ensino_anterior(String etapa_ensino_anterior) {
        this.etapa_ensino_anterior = etapa_ensino_anterior;
    }

    public Curso getId_curso() {
        return id_curso;
    }

    public void setId_curso(Curso id_curso) {
        this.id_curso = id_curso;
    }

    public String getLocal_trabalho() {
        return local_trabalho;
    }

    public void setLocal_trabalho(String local_trabalho) {
        this.local_trabalho = local_trabalho;
    }

    public String getNome_responsavel() {
        return nome_responsavel;
    }

    public void setNome_responsavel(String nome_responsavel) {
        this.nome_responsavel = nome_responsavel;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Boolean getRenda() {
        return renda;
    }

    public void setRenda(Boolean renda) {
        this.renda = renda;
    }

    public Double getRenda_familiar() {
        return renda_familiar;
    }

    public void setRenda_familiar(Double renda_familiar) {
        this.renda_familiar = renda_familiar;
    }

    public Integer getTamanho_familia() {
        return tamanho_familia;
    }

    public void setTamanho_familia(Integer tamanho_familia) {
        this.tamanho_familia = tamanho_familia;
    }

    public Integer getTelefone_trabalho() {
        return telefone_trabalho;
    }

    public void setTelefone_trabalho(Integer telefone_trabalho) {
        this.telefone_trabalho = telefone_trabalho;
    }

    public String getTipo_escola_anterior() {
        return tipo_escola_anterior;
    }

    public void setTipo_escola_anterior(String tipo_escola_anterior) {
        this.tipo_escola_anterior = tipo_escola_anterior;
    }

    public Boolean getTrabalha() {
        return trabalha;
    }

    public void setTrabalha(Boolean trabalha) {
        this.trabalha = trabalha;
    }

    public String getUf_instituicao_ensino() {
        return uf_instituicao_ensino;
    }

    public void setUf_instituicao_ensino(String uf_instituicao_ensino) {
        this.uf_instituicao_ensino = uf_instituicao_ensino;
    }

    public Usuario getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Usuario usuario_id) {
        this.usuario_id = usuario_id;
    }

}
 
