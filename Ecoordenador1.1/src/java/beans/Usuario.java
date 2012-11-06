/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;


@ManagedBean(name="usuario")
@SessionScoped

@Entity
@SequenceGenerator(allocationSize= 1, name = "idgen", sequenceName = "usuario_seq")
@Table(name = "usuario")
public class Usuario implements Serializable {
    
        @Id
        @Column(name="id")
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="idgen")
        private Integer id;
    
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
        
        @OneToMany(mappedBy="id_usuario",fetch=FetchType.LAZY)
        @Cascade(org.hibernate.annotations.CascadeType.ALL)
        Set<UsuarioPermissao> usu_perm = new HashSet<UsuarioPermissao>();
        
        @OneToOne(mappedBy="usuario_id",fetch=FetchType.EAGER)
        @Cascade(org.hibernate.annotations.CascadeType.ALL)
        private Aluno aluno;
        
        @OneToOne(mappedBy="usuario_id",fetch=FetchType.EAGER)
        @Cascade(org.hibernate.annotations.CascadeType.ALL)
        private Servidor servidor;
        
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
        
    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public String getSenha2() {
        return senha2;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public void setSenha2(String senha2) {
        this.senha2 = MD5(senha2);
    }
         
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = MD5(senha);
    }

    public Set<UsuarioPermissao> getUsu_perm() {
        return usu_perm;
    }

    public void setUsu_perm(Set<UsuarioPermissao> usu_perm) {
        this.usu_perm = usu_perm;
    }
    
}
