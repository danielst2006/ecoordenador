package beans;

import java.util.Date;
import javax.persistence.*;

@Entity
@SequenceGenerator(allocationSize= 1, name = "idgen", sequenceName = "servidor_seq")
@Table(name = "servidor")
public class Servidor extends Pessoa {
 
        @Column(name="matricula_siape",length=10)
	private String matricula_siape;
	 
        @Column(name="cargo",length=30,nullable=false)
	private String cargo;
	 
        @Column(name="mandato_funcao",length=30,nullable=false)
	private String mandato_funcao;
	 
        @Column(name="data_inicio",nullable=false)
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date data_inicio;
	 
        @Column(name="data_termino")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date data_termino;
	 
        @Column(name="unidade_ensino",length=30,nullable=false)
	private String unidade_ensino;
	 
        @Column(name="regime_juridico",length=30,nullable=false)
	private String regime_juridico;
	 
        @Column(name="situacao",length=30,nullable=false)
	private String situacao;
	 
        @Column(name="data_admissao",nullable=false)
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date data_admissao;
	 
        @Column(name="banco",length=45,nullable=false)
	private String banco;
	 
        @Column(name="agencia",length=10,nullable=false)
	private String agencia;
	 
        @Column(name="conta",length=20,nullable=false)
	private String conta;
	 
        @Column(name="classe",length=30,nullable=false)
	private String classe;
	 
        @Column(name="nivel_funcional",length=30,nullable=false)
	private String nivel_funcional;
        
        @Column(name="area_conhecimento",length=30)
	private String area_conhecimento;
	 
        @Column(name="regime_trabalho",length=30)
	private String regime_trabalho;
	 
        @Column(name="classificacao",length=30)
	private String classificacao;
	 
        @Column(name="ato_autorizativo_tipo",length=30)
	private String ato_autorizativo_tipo;
	 
        @Column(name="numero", insertable=false, updatable=false)
	private int numero;
	 
        @Column(name="data_expedicao")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date data_expedicao;
	 
        @Column(name="data_diario_oficial")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date data_diario_oficial;
	 
        @Column(name="orgao_origem_matricula",length=12)
	private String orgao_origem_matricula;
	 
        @Column(name="orgao_origem",length=30)
	private String orgao_origem;
	 
        @Column(name="orgao_origem_cargo",length=30)
	private String orgao_origem_cargo;
	 
        @Column(name="servidor_rede")
	private Boolean servidor_rede=true;
	 
        @Column(name="carga_horaria_semanal")
	private int carga_horaria_semanal;

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getArea_conhecimento() {
        return area_conhecimento;
    }

    public void setArea_conhecimento(String area_conhecimento) {
        this.area_conhecimento = area_conhecimento;
    }

    public String getAto_autorizativo_tipo() {
        return ato_autorizativo_tipo;
    }

    public void setAto_autorizativo_tipo(String ato_autorizativo_tipo) {
        this.ato_autorizativo_tipo = ato_autorizativo_tipo;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public int getCarga_horaria_semanal() {
        return carga_horaria_semanal;
    }

    public void setCarga_horaria_semanal(int carga_horaria_semanal) {
        this.carga_horaria_semanal = carga_horaria_semanal;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Date getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(Date data_admissao) {
        this.data_admissao = data_admissao;
    }

    public Date getData_diario_oficial() {
        return data_diario_oficial;
    }

    public void setData_diario_oficial(Date data_diario_oficial) {
        this.data_diario_oficial = data_diario_oficial;
    }

    public Date getData_expedicao() {
        return data_expedicao;
    }

    public void setData_expedicao(Date data_expedicao) {
        this.data_expedicao = data_expedicao;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_termino() {
        return data_termino;
    }

    public void setData_termino(Date data_termino) {
        this.data_termino = data_termino;
    }

    public String getMandato_funcao() {
        return mandato_funcao;
    }

    public void setMandato_funcao(String mandato_funcao) {
        this.mandato_funcao = mandato_funcao;
    }

    public String getMatricula_siape() {
        return matricula_siape;
    }

    public void setMatricula_siape(String matricula_siape) {
        this.matricula_siape = matricula_siape;
    }

    public String getNivel_funcional() {
        return nivel_funcional;
    }

    public void setNivel_funcional(String nivel_funcional) {
        this.nivel_funcional = nivel_funcional;
    }

    public String getOrgao_origem() {
        return orgao_origem;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setOrgao_origem(String orgao_origem) {
        this.orgao_origem = orgao_origem;
    }

    public String getOrgao_origem_cargo() {
        return orgao_origem_cargo;
    }

    public void setOrgao_origem_cargo(String orgao_origem_cargo) {
        this.orgao_origem_cargo = orgao_origem_cargo;
    }

    public String getOrgao_origem_matricula() {
        return orgao_origem_matricula;
    }

    public void setOrgao_origem_matricula(String orgao_origem_matricula) {
        this.orgao_origem_matricula = orgao_origem_matricula;
    }

    public String getRegime_juridico() {
        return regime_juridico;
    }

    public void setRegime_juridico(String regime_juridico) {
        this.regime_juridico = regime_juridico;
    }

    public String getRegime_trabalho() {
        return regime_trabalho;
    }

    public void setRegime_trabalho(String regime_trabalho) {
        this.regime_trabalho = regime_trabalho;
    }

    public Boolean getServidor_rede() {
        return servidor_rede;
    }

    public void setServidor_rede(Boolean servidor_rede) {
        this.servidor_rede = servidor_rede;
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
	 
}
 
