package beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@MappedSuperclass
public abstract class Pessoa implements Serializable{
 
        @Id
        @Column(name="id")
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="idgen")
        private Integer id;
     
        @Column(name="nome",length=80,nullable=false)
	private String nome;
	 
	@Column(name="foto")
        private byte[] foto;
	 
        @Column(name="genero",length=3)
	private String genero;
	 
        @Column(name="etnia",length=15)
	private String etnia;
	 
        @Column(name="necessidade_especial")
	private Boolean necessidade_especial;
	 
        @Column(name="data_nascimento",nullable=false)
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date data_nascimento;
	 
        @Column(name="naturalidade",length=20,nullable=false)
	private String naturalidade;
	 
        @Column(name="uf_naturalidade",length=2,nullable=false)
	private String uf_naturalidade;
	 
        @Column(name="nacionalidade",length=20,nullable=false)
	private String nacionalidade;
	 
        @Column(name="tipo_sanguineo")
	private String tipo_sanguineo;
	 
        @Column(name="fator_rh")
	private String fator_rh;
	 
        @Column(name="grau_formacao",length=30,nullable=false)
	private String grau_formacao;
	 
        @Column(name="estado_civil",length=25,nullable=false)
	private String estado_civil;
	 
        @Column(name="numero_filhos")
	private int numero_filhos;
	 
        @Column(name="email",length=40)
	private String email;
	 
        @Column(name="end_curriculo_lattes",length=50)
	private String end_curriculo_lattes;
	 
        @Column(name="ddd")
	private int ddd;
	 
        @Column(name="numero_telefone")
	private int numero_telefone;
	 
        @Column(name="ramal")
	private int ramal;
	 
        @Column(name="filiacao")
	private Boolean filiacao=true;
	 
        @Column(name="nome_mae",length=80,nullable=false)
	private String nome_mae;
	 
        @Column(name="nome_pai",length=80)
	private String nome_pai;
	 
        @Column(name="zona_procedencia",length=20,nullable=false)
	private String zona_procedencia;
	 
        @Column(name="cep",nullable=false)
	private int cep;
	 
        @Column(name="logradouro",length=40,nullable=false)
	private String logradouro;
	 
        @Column(name="numero",nullable=false)
	private int numero_lote;
	 
        @Column(name="complemento",length=100)
	private String complemento;
	 
        @Column(name="bairro",length=50,nullable=false)
	private String bairro;
	 
        @Column(name="cidade",length=40,nullable=false)
	private String cidade;
	 
        @Column(name="uf",length=2,nullable=false)
	private String uf;
	 
        @Column(name="cpf",length=12)
	private String cpf;
	 
        @Column(name="rg_numero",length=25)
	private String rg_numero;
	 
        @Column(name="rg_expedidor",length=10)
	private String rg_expedidor;
	 
        @Column(name="rg_data_expedicao")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date rg_data_expedicao;
	
        @Column(name="cnasc_numero")
	private int cnasc_numero;
	 
        @Column(name="cnasc_folha")
	private int cnasc_folha;
	 
        @Column(name="cnasc_cartorio",length=80)
	private String cnasc_cartorio;
	 
        @Column(name="cnasc_data_expedicao")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date cnasc_data_expedicao;
	 
        @Column(name="ctps_numero")
	private int ctps_numero;
	 
        @Column(name="ctps_serie")
	private int ctps_serie;
	 
        @Column(name="pis_pasep")
	private int pis_pasep;
	 
        @Column(name="chabilitacao_numero")
	private int chabilitacao_numero;
	 
        @Column(name="chabilitacao_data_expedicao")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date chabilitacao_data_expedicao;
	 
        @Column(name="chabilitacao_data_validade")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date chabilitacao_data_validade;
	 
        @Column(name="dmilitar_tipo",length=30)
	private String dmilitar_tipo;
	 
        @Column(name="dmilitar_numero")
	private int dmilitar_numero;
	 
        @Column(name="dmilitar_regiao",length=20)
	private String dmilitar_regiao;
	 
        @Column(name="teleitor_numero")
	private int teleitor_numero;
	 
        @Column(name="teleitor_zona")
	private int teleitor_zona;
	 
        @Column(name="teleitor_uf",length=2)
	private String teleitor_uf;
	 
        @Column(name="teleitor_data_expedicao")
        @Temporal(javax.persistence.TemporalType.DATE)
	private Date teleitor_data_expedicao;
            
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public Date getChabilitacao_data_expedicao() {
        return chabilitacao_data_expedicao;
    }

    public void setChabilitacao_data_expedicao(Date chabilitacao_data_expedicao) {
        this.chabilitacao_data_expedicao = chabilitacao_data_expedicao;
    }

    public Date getChabilitacao_data_validade() {
        return chabilitacao_data_validade;
    }

    public void setChabilitacao_data_validade(Date chabilitacao_data_validade) {
        this.chabilitacao_data_validade = chabilitacao_data_validade;
    }

    public int getChabilitacao_numero() {
        return chabilitacao_numero;
    }

    public void setChabilitacao_numero(int chabilitacao_numero) {
        this.chabilitacao_numero = chabilitacao_numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCnasc_cartorio() {
        return cnasc_cartorio;
    }

    public void setCnasc_cartorio(String cnasc_cartorio) {
        this.cnasc_cartorio = cnasc_cartorio;
    }

    public Date getCnasc_data_expedicao() {
        return cnasc_data_expedicao;
    }

    public void setCnasc_data_expedicao(Date cnasc_data_expedicao) {
        this.cnasc_data_expedicao = cnasc_data_expedicao;
    }

    public int getCnasc_folha() {
        return cnasc_folha;
    }

    public void setCnasc_folha(int cnasc_folha) {
        this.cnasc_folha = cnasc_folha;
    }

    public int getCnasc_numero() {
        return cnasc_numero;
    }

    public void setCnasc_numero(int cnasc_numero) {
        this.cnasc_numero = cnasc_numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getCtps_numero() {
        return ctps_numero;
    }

    public void setCtps_numero(int ctps_numero) {
        this.ctps_numero = ctps_numero;
    }

    public int getCtps_serie() {
        return ctps_serie;
    }

    public void setCtps_serie(int ctps_serie) {
        this.ctps_serie = ctps_serie;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getDmilitar_numero() {
        return dmilitar_numero;
    }

    public void setDmilitar_numero(int dmilitar_numero) {
        this.dmilitar_numero = dmilitar_numero;
    }

    public String getDmilitar_regiao() {
        return dmilitar_regiao;
    }

    public void setDmilitar_regiao(String dmilitar_regiao) {
        this.dmilitar_regiao = dmilitar_regiao;
    }

    public String getDmilitar_tipo() {
        return dmilitar_tipo;
    }

    public void setDmilitar_tipo(String dmilitar_tipo) {
        this.dmilitar_tipo = dmilitar_tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnd_curriculo_lattes() {
        return end_curriculo_lattes;
    }

    public void setEnd_curriculo_lattes(String end_curriculo_lattes) {
        this.end_curriculo_lattes = end_curriculo_lattes;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getFator_rh() {
        return fator_rh;
    }

    public void setFator_rh(String fator_rh) {
        this.fator_rh = fator_rh;
    }

    public Boolean getFiliacao() {
        return filiacao;
    }

    public void setFiliacao(Boolean filiacao) {
        this.filiacao = filiacao;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGrau_formacao() {
        return grau_formacao;
    }

    public void setGrau_formacao(String grau_formacao) {
        this.grau_formacao = grau_formacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public Boolean getNecessidade_especial() {
        return necessidade_especial;
    }

    public void setNecessidade_especial(Boolean necessidade_especial) {
        this.necessidade_especial = necessidade_especial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_mae() {
        return nome_mae;
    }

    public void setNome_mae(String nome_mae) {
        this.nome_mae = nome_mae;
    }

    public String getNome_pai() {
        return nome_pai;
    }

    public void setNome_pai(String nome_pai) {
        this.nome_pai = nome_pai;
    }

    public int getNumero_lote() {
        return numero_lote;
    }

    public void setNumero_lote(int numero_lote) {
        this.numero_lote = numero_lote;
    }

    public int getNumero_filhos() {
        return numero_filhos;
    }

    public void setNumero_filhos(int numero_filhos) {
        this.numero_filhos = numero_filhos;
    }

    public int getNumero_telefone() {
        return numero_telefone;
    }

    public void setNumero_telefone(int numero_telefone) {
        this.numero_telefone = numero_telefone;
    }

    public int getPis_pasep() {
        return pis_pasep;
    }

    public void setPis_pasep(int pis_pasep) {
        this.pis_pasep = pis_pasep;
    }

    public int getRamal() {
        return ramal;
    }

    public void setRamal(int ramal) {
        this.ramal = ramal;
    }

    public Date getRg_data_expedicao() {
        return rg_data_expedicao;
    }

    public void setRg_data_expedicao(Date rg_data_expedicao) {
        this.rg_data_expedicao = rg_data_expedicao;
    }

    public String getRg_expedidor() {
        return rg_expedidor;
    }

    public void setRg_expedidor(String rg_expedidor) {
        this.rg_expedidor = rg_expedidor;
    }

    public String getRg_numero() {
        return rg_numero;
    }

    public void setRg_numero(String rg_numero) {
        this.rg_numero = rg_numero;
    }

    public Date getTeleitor_data_expedicao() {
        return teleitor_data_expedicao;
    }

    public void setTeleitor_data_expedicao(Date teleitor_data_expedicao) {
        this.teleitor_data_expedicao = teleitor_data_expedicao;
    }

    public int getTeleitor_numero() {
        return teleitor_numero;
    }

    public void setTeleitor_numero(int teleitor_numero) {
        this.teleitor_numero = teleitor_numero;
    }

    public String getTeleitor_uf() {
        return teleitor_uf;
    }

    public void setTeleitor_uf(String teleitor_uf) {
        this.teleitor_uf = teleitor_uf;
    }

    public int getTeleitor_zona() {
        return teleitor_zona;
    }

    public void setTeleitor_zona(int teleitor_zona) {
        this.teleitor_zona = teleitor_zona;
    }

    public String getTipo_sanguineo() {
        return tipo_sanguineo;
    }

    public void setTipo_sanguineo(String tipo_sanguineo) {
        this.tipo_sanguineo = tipo_sanguineo;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getUf_naturalidade() {
        return uf_naturalidade;
    }

    public void setUf_naturalidade(String uf_naturalidade) {
        this.uf_naturalidade = uf_naturalidade;
    }

    public String getZona_procedencia() {
        return zona_procedencia;
    }

    public void setZona_procedencia(String zona_procedencia) {
        this.zona_procedencia = zona_procedencia;
    }
	 
}
 
