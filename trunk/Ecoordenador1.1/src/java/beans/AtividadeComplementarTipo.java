package beans;

import java.io.Serializable;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

@ManagedBean(name="atividade_complementar_tipo")
@SessionScoped

@Entity
@Table(schema="public",name="atividade_complementar_tipo")
public class AtividadeComplementarTipo implements Serializable {
 
        @Id
        @Column(name="id_tipo")
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @SequenceGenerator(name="tp_atv_seq", sequenceName="tp_atv_seq", allocationSize=1)
	private Integer id;
	 
        @Column(name="tipo_atividade",length=20)
	private String tipo_atividade;
        
        @OneToMany(mappedBy="atividadecomplementartipo")
        private Set<AtividadeComplementar> atividades;

    public Set<AtividadeComplementar> getAtividades() {
        return atividades;
    }

    public void setAtividades(Set<AtividadeComplementar> atividades) {
        this.atividades = atividades;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo_atividade() {
        return tipo_atividade;
    }

    public void setTipo_atividade(String tipo_atividade) {
        this.tipo_atividade = tipo_atividade;
    }
     
}
 
