package beans;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

@ManagedBean(name="curso")
@SessionScoped

@Entity
@SequenceGenerator(allocationSize= 1, name = "idgen", sequenceName = "curso_seq")
@Table(name = "curso")
public class Curso implements Serializable {
 
        @Id
        @Column(name="id")
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="idgen")
	private Integer id;
	 
        @Column(name="instituicao",nullable=false)
	private String instituicao;
	 
        @Column(name="unidade_ensino",nullable=false)
	private String unidade_ensino;
	 
        @Column(name="unidade_organizacional",nullable=false)
	private String unidade_organizacional;
	 
        @Column(name="nome",length=50,nullable=false)
	private String nome;
	 
        @Column(name="nome_reduzido",length=10,nullable=false)
	private String nome_reduzido;
	 
        @Column(name="finalidade")
	private String finalidade;
	 
        @Column(name="ato_autorizativo_tipo",nullable=false)
	private String ato_autorizativo_tipo;
	 
        @Column(name="ato_autorizativo_numero",nullable=false)
	private int ato_autorizativo_numero;
	 
        @Column(name="ato_autorizativo_data_expedicao",nullable=false)
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date ato_autorizativo_data_expedicao;
	 
        @Column(name="ato_autorizacao_ato_dou",nullable=false)
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date ato_autorizacao_ato_dou;
	 
        @Column(name="periodicidade_ingresso",nullable=false)
	private String periodicidade_ingresso;
	 
        @Column(name="data_inicio",nullable=false)
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date data_inicio;
	 
        @Column(name="data_fim",nullable=false)
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date data_fim;
	 
        @Column(name="periodo_minimo_numero_integralizacao",nullable=false)
	private int periodo_minimo_numero_integralizacao;
	 
        @Column(name="periodo_maximo_numero_integralizacao")
	private int periodo_maximo_numero_integralizacao;
	 
        @Column(name="area_conhecimento",nullable=false)
	private String area_conhecimento;
	 
        @Column(name="regime_competencia",nullable=false)
	private Boolean regime_competencia;
	 
        @Column(name="regime_matricula",nullable=false)
	private String regime_matricula;
	 
        @Column(name="situacao",nullable=false)
	private String situacao;
	 
        @Column(name="nivel_ensino")
	private String nivel_ensino;
	 
        @Column(name="etapa_ensino")
	private String etapa_ensino;
	 
        @Column(name="modalidade_ensino")
	private String modalidade_ensino;
	 
        @Column(name="formacao_profissional")
	private String formacao_profissional;
	 
        @Column(name="formacao_academica")
	private String formacao_academica;
	 
        @Column(name="eja")
	private Boolean eja;
	 
        @Column(name="ato_reconhecimento_tipo")
	private String ato_reconhecimento_tipo;
	 
        @Column(name="ato_reconhecimento_numero")
	private String ato_reconhecimento_numero;
	
        @Column(name="data_expedicao_reconhecimento")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date data_expedicao_reconhecimento;
	 
        @Column(name="data_dou_reconhecimento")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date data_dou_reconhecimento;
	 
        @Column(name="projeto_pedagogico")
	private byte[] projeto_pedagogico;
	 
        @Column(name="nome_arquivo_proj_pedagogico")
	private String nome_arquivo_proj_pedagogico;
	 
        @Column(name="data_projeto_pedagogico",nullable=false)
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date data_projeto_pedagogico;
        
        @OneToMany(mappedBy="id_curso",fetch=FetchType.LAZY)
        @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
        Set<Aluno> alunos = new HashSet<Aluno>();

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getArea_conhecimento() {
        return area_conhecimento;
    }

    public void setArea_conhecimento(String area_conhecimento) {
        this.area_conhecimento = area_conhecimento;
    }

    public Date getAto_autorizacao_ato_dou() {
        return ato_autorizacao_ato_dou;
    }

    public void setAto_autorizacao_ato_dou(Date ato_autorizacao_ato_dou) {
        this.ato_autorizacao_ato_dou = ato_autorizacao_ato_dou;
    }

    public Date getAto_autorizativo_data_expedicao() {
        return ato_autorizativo_data_expedicao;
    }

    public void setAto_autorizativo_data_expedicao(Date ato_autorizativo_data_expedicao) {
        this.ato_autorizativo_data_expedicao = ato_autorizativo_data_expedicao;
    }

    public int getAto_autorizativo_numero() {
        return ato_autorizativo_numero;
    }

    public void setAto_autorizativo_numero(int ato_autorizativo_numero) {
        this.ato_autorizativo_numero = ato_autorizativo_numero;
    }

    public String getAto_autorizativo_tipo() {
        return ato_autorizativo_tipo;
    }

    public void setAto_autorizativo_tipo(String ato_autorizativo_tipo) {
        this.ato_autorizativo_tipo = ato_autorizativo_tipo;
    }

    public String getAto_reconhecimento_numero() {
        return ato_reconhecimento_numero;
    }

    public void setAto_reconhecimento_numero(String ato_reconhecimento_numero) {
        this.ato_reconhecimento_numero = ato_reconhecimento_numero;
    }

    public String getAto_reconhecimento_tipo() {
        return ato_reconhecimento_tipo;
    }

    public void setAto_reconhecimento_tipo(String ato_reconhecimento_tipo) {
        this.ato_reconhecimento_tipo = ato_reconhecimento_tipo;
    }

    public Date getData_dou_reconhecimento() {
        return data_dou_reconhecimento;
    }

    public void setData_dou_reconhecimento(Date data_dou_reconhecimento) {
        this.data_dou_reconhecimento = data_dou_reconhecimento;
    }

    public Date getData_expedicao_reconhecimento() {
        return data_expedicao_reconhecimento;
    }

    public void setData_expedicao_reconhecimento(Date data_expedicao_reconhecimento) {
        this.data_expedicao_reconhecimento = data_expedicao_reconhecimento;
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

    public Date getData_projeto_pedagogico() {
        return data_projeto_pedagogico;
    }

    public void setData_projeto_pedagogico(Date data_projeto_pedagogico) {
        this.data_projeto_pedagogico = data_projeto_pedagogico;
    }

    public Boolean getEja() {
        return eja;
    }

    public void setEja(Boolean eja) {
        this.eja = eja;
    }

    public String getEtapa_ensino() {
        return etapa_ensino;
    }

    public void setEtapa_ensino(String etapa_ensino) {
        this.etapa_ensino = etapa_ensino;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public String getFormacao_academica() {
        return formacao_academica;
    }

    public void setFormacao_academica(String formacao_academica) {
        this.formacao_academica = formacao_academica;
    }

    public String getFormacao_profissional() {
        return formacao_profissional;
    }

    public void setFormacao_profissional(String formacao_profissional) {
        this.formacao_profissional = formacao_profissional;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getModalidade_ensino() {
        return modalidade_ensino;
    }

    public void setModalidade_ensino(String modalidade_ensino) {
        this.modalidade_ensino = modalidade_ensino;
    }

    public String getNivel_ensino() {
        return nivel_ensino;
    }

    public void setNivel_ensino(String nivel_ensino) {
        this.nivel_ensino = nivel_ensino;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_arquivo_proj_pedagogico() {
        return nome_arquivo_proj_pedagogico;
    }

    public void setNome_arquivo_proj_pedagogico(String nome_arquivo_proj_pedagogico) {
        this.nome_arquivo_proj_pedagogico = nome_arquivo_proj_pedagogico;
    }

    public String getNome_reduzido() {
        return nome_reduzido;
    }

    public void setNome_reduzido(String nome_reduzido) {
        this.nome_reduzido = nome_reduzido;
    }

    public String getPeriodicidade_ingresso() {
        return periodicidade_ingresso;
    }

    public void setPeriodicidade_ingresso(String periodicidade_ingresso) {
        this.periodicidade_ingresso = periodicidade_ingresso;
    }

    public int getPeriodo_maximo_numero_integralizacao() {
        return periodo_maximo_numero_integralizacao;
    }

    public void setPeriodo_maximo_numero_integralizacao(int periodo_maximo_numero_integralizacao) {
        this.periodo_maximo_numero_integralizacao = periodo_maximo_numero_integralizacao;
    }

    public int getPeriodo_minimo_numero_integralizacao() {
        return periodo_minimo_numero_integralizacao;
    }

    public void setPeriodo_minimo_numero_integralizacao(int periodo_minimo_numero_integralizacao) {
        this.periodo_minimo_numero_integralizacao = periodo_minimo_numero_integralizacao;
    }

    public byte[] getProjeto_pedagogico() {
        return projeto_pedagogico;
    }

    public void setProjeto_pedagogico(byte[] projeto_pedagogico) {
        this.projeto_pedagogico = projeto_pedagogico;
    }

    public Boolean getRegime_competencia() {
        return regime_competencia;
    }

    public void setRegime_competencia(Boolean regime_competencia) {
        this.regime_competencia = regime_competencia;
    }

    public String getRegime_matricula() {
        return regime_matricula;
    }

    public void setRegime_matricula(String regime_matricula) {
        this.regime_matricula = regime_matricula;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getUnidade_ensino() {
        return unidade_ensino;
    }

    public void setUnidade_ensino(String unidade_ensino) {
        this.unidade_ensino = unidade_ensino;
    }

    public String getUnidade_organizacional() {
        return unidade_organizacional;
    }

    public void setUnidade_organizacional(String unidade_organizacional) {
        this.unidade_organizacional = unidade_organizacional;
    }
	 
}
 
