/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Melvin
 */
@Entity
@Table(name = "cep_cec_curso_det")
@NamedQueries({
    @NamedQuery(name = "CepCecCursoDet.findAll", query = "SELECT c FROM CepCecCursoDet c")
    , @NamedQuery(name = "CepCecCursoDet.findByIdCursoDet", query = "SELECT c FROM CepCecCursoDet c WHERE c.idCursoDet = :idCursoDet")
    , @NamedQuery(name = "CepCecCursoDet.findByEstadoCursoDet", query = "SELECT c FROM CepCecCursoDet c WHERE c.estadoCursoDet = :estadoCursoDet")
    , @NamedQuery(name = "CepCecCursoDet.findByModEnsenanza", query = "SELECT c FROM CepCecCursoDet c WHERE c.modEnsenanza = :modEnsenanza")
    , @NamedQuery(name = "CepCecCursoDet.findByHorasLectivas", query = "SELECT c FROM CepCecCursoDet c WHERE c.horasLectivas = :horasLectivas")})
public class CepCecCursoDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_curso_det")
    @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idCursoDet;
    @Column(name = "estado_curso_det")
    private Short estadoCursoDet;
    @Column(name = "mod_ensenanza")
    private Integer modEnsenanza;
    @Column(name = "horas_lectivas")
    private Integer horasLectivas;
    @OneToMany(mappedBy = "cepCecCursoDet")
    private List<CepCecPlan> cepCecPlanList;
    @JoinColumn(name = "id_curso_cab", referencedColumnName = "id_curso_cab")
    @ManyToOne(optional = false)
    private CepCecCursoCab cepCecCursoCab;
    @JoinColumn(name = "id_nivel", referencedColumnName = "id_nivel")
    @ManyToOne
    private CepNivel cepNivel;
    @OneToMany(mappedBy = "cepCecCursoDet")
    private List<CepCecCursoSubdet> cepCecCursoSubdetList;

    public CepCecCursoDet() {
    }

    public CepCecCursoDet(Integer idCursoDet) {
        this.idCursoDet = idCursoDet;
    }

    public Integer getIdCursoDet() {
        return idCursoDet;
    }

    public void setIdCursoDet(Integer idCursoDet) {
        this.idCursoDet = idCursoDet;
    }

    public Short getEstadoCursoDet() {
        return estadoCursoDet;
    }

    public void setEstadoCursoDet(Short estadoCursoDet) {
        this.estadoCursoDet = estadoCursoDet;
    }

    public Integer getModEnsenanza() {
        return modEnsenanza;
    }

    public void setModEnsenanza(Integer modEnsenanza) {
        this.modEnsenanza = modEnsenanza;
    }

    public Integer getHorasLectivas() {
        return horasLectivas;
    }

    public void setHorasLectivas(Integer horasLectivas) {
        this.horasLectivas = horasLectivas;
    }

    public List<CepCecPlan> getCepCecPlanList() {
        return cepCecPlanList;
    }

    public void setCepCecPlanList(List<CepCecPlan> cepCecPlanList) {
        this.cepCecPlanList = cepCecPlanList;
    }

    public CepCecCursoCab getCepCecCursoCab() {
        return cepCecCursoCab;
    }

    public void setCepCecCursoCab(CepCecCursoCab cepCecCursoCab) {
        this.cepCecCursoCab = cepCecCursoCab;
    }

    public CepNivel getCepNivel() {
        return cepNivel;
    }

    public void setCepNivel(CepNivel cepNivel) {
        this.cepNivel = cepNivel;
    }

    public List<CepCecCursoSubdet> getCepCecCursoSubdetList() {
        return cepCecCursoSubdetList;
    }

    public void setCepCecCursoSubdetList(List<CepCecCursoSubdet> cepCecCursoSubdetList) {
        this.cepCecCursoSubdetList = cepCecCursoSubdetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCursoDet != null ? idCursoDet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepCecCursoDet)) {
            return false;
        }
        CepCecCursoDet other = (CepCecCursoDet) object;
        if ((this.idCursoDet == null && other.idCursoDet != null) || (this.idCursoDet != null && !this.idCursoDet.equals(other.idCursoDet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepCecCursoDet[ idCursoDet=" + idCursoDet + " ]";
    }
    
}
