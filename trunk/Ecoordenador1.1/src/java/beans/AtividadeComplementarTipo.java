package beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

@ManagedBean(name="atividade_complementar_tipo")
@SessionScoped

@Entity
@Table(schema="public",name="atividade_complementar_tipo")
public class AtividadeComplementarTipo implements Serializable {
 
        @Id
        @Column(name="id")
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @SequenceGenerator(name="tp_atv_seq", sequenceName="tp_atv_seq", allocationSize=1)
	private Integer id;
	 
        @Column(name="tipo_atividade",length=20)
	private String tipo_atividade;
        
        @OneToMany(mappedBy="id_tipo_atividade",fetch=FetchType.LAZY)
        @Cascade(org.hibernate.annotations.CascadeType.ALL)
        Set<AtividadeComplementar> atv_comp = new HashSet<AtividadeComplementar>();

    public Integer getId() {
        return id;
    }

    public Set<AtividadeComplementar> getAtv_comp() {
        return atv_comp;
    }

    public void setAtv_comp(Set<AtividadeComplementar> atv_comp) {
        this.atv_comp = atv_comp;
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
 
