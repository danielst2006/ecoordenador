/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;


@ManagedBean(name="usuario")
@SessionScoped

@Entity
@SequenceGenerator(allocationSize= 1, name = "idgen", sequenceName = "usuario_seq")
@Table(name = "usuario")
public class Usuario implements Serializable {
    
        @Id
        @Column(name="id_usuario")
        @GeneratedValue(strategy=GenerationType.SEQUENCE)
        private Integer id_usuario;
    
        @Column(name="login",length=20,unique=true)
        private String login;
        
        @Column(name="senha",length=35)
        private String senha;
        
        @Transient
        private String senha2;
        
        @Column(name="ativo")
        private Boolean ativo=false;
        
        @Column(name="email",length=65)
        private String email;
        
        @Column(name="apelido",length=20)
        private String apelido;
        
        @Column(name="data_cadastro")
        @Temporal(javax.persistence.TemporalType.DATE)
        private Date data_cadastro;
        
        @OneToMany(mappedBy="usuario")
        Set<UsuarioPermissao> permissoes;
        
        @OneToOne(mappedBy="usuario",cascade=CascadeType.ALL)
        private Pessoa pessoa;
        
        
        ////////////////////////////////////////////////////////////////////////
        // para inserir no banco o MD5 use a sequinte query:
        // insert into usuario(id,login,senha,ativo,email,apelido)
        // values (1,'teste',MD5('123'),true,'bla@gm','Nome');
        // colocar tbm a permissao:
        // insert into usuario_permissao(id,permissao,id_usuario)
        // values (1,'ROLE_ADMINISTRADOR',1);
        
        public static String MD5(String senha) {
            PasswordEncoder encoder = new Md5PasswordEncoder();
            senha = encoder.encodePassword(senha, null);
            return senha;
        }
        
        ////////////////////////////////////////////////////////////////////////

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Set<UsuarioPermissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<UsuarioPermissao> permissoes) {
        this.permissoes = permissoes;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha2() {
        return senha2;
    }

    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }

}
