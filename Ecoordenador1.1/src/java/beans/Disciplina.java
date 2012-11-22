/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

@ManagedBean(name="disciplina")
@SessionScoped

@Entity
@SequenceGenerator(allocationSize= 1, name = "idgen", sequenceName = "disc_seq")
@Table(name = "disciplina")
public class Disciplina implements Serializable {
    
        @Id
        @Column(name="id_disciplina")
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @SequenceGenerator(name="disc_seq", sequenceName="disc_seq", allocationSize=1)
        private Integer id;

        @Column(name="unidade_curricular")
        private String unidade_curricular;

        @Column(name="codigo")
        private String codigo;

        @Column(name="descricao")
        private String descricao;

        @Column(name="objetivos")
        private String objetivos;
        
        @Column(name="periodo")
        private Integer periodo;

        @Column(name="carga_horaria")
        private Integer carga_horaria;

        @Column(name="ementa")
        private String ementa;

        @Column(name="competencias")
        private String competencias;

        @Column(name="habilidades")
        private String habilidades;

        @Column(name="base_tecnologica")
        private String base_tecnologica;

        @Column(name="base_cientifica")
        private String base_cientifica;

        @Column(name="base_instrumental")
        private String base_instrumental;

        @Column(name="conteudo")
        private String conteudo;

        @Column(name="referencia_bibliografica")
        private String referencia_bibliografica;
        
        @ManyToOne
        @JoinColumn(name="matrizcurricular")
        private MatrizCurricular matrizcurricular;
        
        /*@ManyToMany(cascade={CascadeType.MERGE},fetch= FetchType.LAZY)
        @JoinTable(name="pre_requisito",
            joinColumns={@JoinColumn(name="id_disciplina")},
            inverseJoinColumns={@JoinColumn(name="id_disciplina_req")})
        private Set<Disciplina> requisitos = new HashSet<Disciplina>();

        @ManyToMany(mappedBy="requisitos")
        private Set<Disciplina> pre_requisitos = new HashSet<Disciplina>();*/
        
        /*@ManyToMany(cascade={CascadeType.MERGE},fetch=FetchType.LAZY)
        @JoinTable(name="disciplina_equivalente",
            joinColumns={@JoinColumn(name="id_disciplina")},
            inverseJoinColumns={@JoinColumn(name="id_disciplina_eqv")})
        private Set<Disciplina> equivalentes = new HashSet<Disciplina>();

        @ManyToMany(mappedBy="equivalentes")
        private Set<Disciplina> disc_eq = new HashSet<Disciplina>();*/
        
        @OneToMany(mappedBy="disciplina_pk")
        Set<DisciplinaEquivalente> disciplina_pk;
        
        @OneToMany(mappedBy="disciplina_eq")
        Set<DisciplinaEquivalente> disciplina_eq;
        
        @OneToMany(mappedBy="disc_pk")
        Set<PreRequisito> disc_pk;
        
        @OneToMany(mappedBy="disc_eq")
        Set<PreRequisito> disc_eq;
        
        @OneToMany(mappedBy="disciplina")
        Set<Classe> classes;

    public Set<PreRequisito> getDisc_eq() {
        return disc_eq;
    }

    public void setDisc_eq(Set<PreRequisito> disc_eq) {
        this.disc_eq = disc_eq;
    }

    public Set<PreRequisito> getDisc_pk() {
        return disc_pk;
    }

    public void setDisc_pk(Set<PreRequisito> disc_pk) {
        this.disc_pk = disc_pk;
    }

    public Set<DisciplinaEquivalente> getDisciplina_eq() {
        return disciplina_eq;
    }

    public void setDisciplina_eq(Set<DisciplinaEquivalente> disciplina_eq) {
        this.disciplina_eq = disciplina_eq;
    }

    public Set<DisciplinaEquivalente> getDisciplina_pk() {
        return disciplina_pk;
    }

    public void setDisciplina_pk(Set<DisciplinaEquivalente> disciplina_pk) {
        this.disciplina_pk = disciplina_pk;
    }
        
    public Set<Classe> getClasses() {
        return classes;
    }

    public void setClasses(Set<Classe> classes) {
        this.classes = classes;
    }

    /*public Set<Disciplina> getDisc_eq() {
        return disc_eq;
    }

    public void setDisc_eq(Set<Disciplina> disc_eq) {
        this.disc_eq = disc_eq;
    }

    public Set<Disciplina> getEquivalentes() {
        return equivalentes;
    }

    public void setEquivalentes(Set<Disciplina> equivalentes) {
        this.equivalentes = equivalentes;
    }*/

    /*public Set<Disciplina> getPre_requisitos() {
        return pre_requisitos;
    }

    public void setPre_requisitos(Set<Disciplina> pre_requisitos) {
        this.pre_requisitos = pre_requisitos;
    }

    public Set<Disciplina> getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(Set<Disciplina> requisitos) {
        this.requisitos = requisitos;
    }*/

    public MatrizCurricular getMatrizcurricular() {
        return matrizcurricular;
    }

    public void setMatrizcurricular(MatrizCurricular matrizcurricular) {
        this.matrizcurricular = matrizcurricular;
    }

    public String getBase_cientifica() {
        return base_cientifica;
    }

    public void setBase_cientifica(String base_cientifica) {
        this.base_cientifica = base_cientifica;
    }

    public String getBase_instrumental() {
        return base_instrumental;
    }

    public void setBase_instrumental(String base_instrumental) {
        this.base_instrumental = base_instrumental;
    }

    public String getBase_tecnologica() {
        return base_tecnologica;
    }

    public void setBase_tecnologica(String base_tecnologica) {
        this.base_tecnologica = base_tecnologica;
    }

    public Integer getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(Integer carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCompetencias() {
        return competencias;
    }

    public void setCompetencias(String competencias) {
        this.competencias = competencias;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getReferencia_bibliografica() {
        return referencia_bibliografica;
    }

    public void setReferencia_bibliografica(String referencia_bibliografica) {
        this.referencia_bibliografica = referencia_bibliografica;
    }

    public String getUnidade_curricular() {
        return unidade_curricular;
    }

    public void setUnidade_curricular(String unidade_curricular) {
        this.unidade_curricular = unidade_curricular;
    }
        public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Disciplina other = (Disciplina) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

}
