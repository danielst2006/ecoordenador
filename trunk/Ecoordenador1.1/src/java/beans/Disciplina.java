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
import org.hibernate.annotations.Cascade;

@ManagedBean(name="disciplina")
@SessionScoped

@Entity
@SequenceGenerator(allocationSize= 1, name = "idgen", sequenceName = "disc_seq")
@Table(name = "disciplina")
public class Disciplina implements Serializable {
    
        @Id
        @Column(name="id")
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @SequenceGenerator(name="disc_seq", sequenceName="disc_seq", allocationSize=1)
        private Integer id;

        @ManyToOne
        @JoinColumn(name="id_matriz")
        private MatrizCurricular id_matriz;

        @Column(name="unidade_curricular")
        private String unidade_curricular;

        @Column(name="codigo")
        private String codigo;

        @Column(name="descricao")
        private String descricao;

        @Column(name="objetivos")
        private String objetivos;

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
        
        @OneToMany(mappedBy="id_disciplina",fetch=FetchType.LAZY)
        @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
        Set<PreRequisito> requisitos = new HashSet<PreRequisito>();
        
        @OneToMany(mappedBy="id_disciplina_requisitada",fetch=FetchType.LAZY)
        @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
        Set<PreRequisito> requisitos_requisitados = new HashSet<PreRequisito>();
        
        @OneToMany(mappedBy="disciplina_id",fetch=FetchType.LAZY)
        @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
        Set<DisciplinaEquivalente> disciplinas = new HashSet<DisciplinaEquivalente>();
        
        @OneToMany(mappedBy="disciplina_equivalente_id",fetch=FetchType.LAZY)
        @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
        Set<DisciplinaEquivalente> equivalentes = new HashSet<DisciplinaEquivalente>();

    public Set<DisciplinaEquivalente> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Set<DisciplinaEquivalente> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Set<DisciplinaEquivalente> getEquivalentes() {
        return equivalentes;
    }

    public void setEquivalentes(Set<DisciplinaEquivalente> equivalentes) {
        this.equivalentes = equivalentes;
    } 

    public Set<PreRequisito> getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(Set<PreRequisito> requisitos) {
        this.requisitos = requisitos;
    }

    public Set<PreRequisito> getRequisitos_requisitados() {
        return requisitos_requisitados;
    }

    public void setRequisitos_requisitados(Set<PreRequisito> requisitos_requisitados) {
        this.requisitos_requisitados = requisitos_requisitados;
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

    public MatrizCurricular getId_matriz() {
        return id_matriz;
    }

    public void setId_matriz(MatrizCurricular id_matriz) {
        this.id_matriz = id_matriz;
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
    
}
