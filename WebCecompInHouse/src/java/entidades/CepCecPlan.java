/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Melvin
 */
@Entity
@Table(name = "cep_cec_plan")
@NamedQueries({
    @NamedQuery(name = "CepCecPlan.findAll", query = "SELECT c FROM CepCecPlan c")
    , @NamedQuery(name = "CepCecPlan.findByIdPlan", query = "SELECT c FROM CepCecPlan c WHERE c.idPlan = :idPlan")
    , @NamedQuery(name = "CepCecPlan.findByDetalles", query = "SELECT c FROM CepCecPlan c WHERE c.detalles = :detalles")
    , @NamedQuery(name = "CepCecPlan.findByEstadoPlan", query = "SELECT c FROM CepCecPlan c WHERE c.estadoPlan = :estadoPlan")
    , @NamedQuery(name = "CepCecPlan.findByFechaReg", query = "SELECT c FROM CepCecPlan c WHERE c.fechaReg = :fechaReg")
    , @NamedQuery(name = "CepCecPlan.findByNumPeriodo", query = "SELECT c FROM CepCecPlan c WHERE c.numPeriodo = :numPeriodo")
    , @NamedQuery(name = "CepCecPlan.findByAnio", query = "SELECT c FROM CepCecPlan c WHERE c.anio = :anio")
    , @NamedQuery(name = "CepCecPlan.findByPlanActual", query = "SELECT c FROM CepCecPlan c WHERE c.planActual = :planActual")})
public class CepCecPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_plan")
    @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idPlan;
    @Size(max = 100)
    @Column(name = "detalles")
    private String detalles;
    @Column(name = "estado_plan")
    private Short estadoPlan;
    @Column(name = "fecha_reg")
    @Temporal(TemporalType.DATE)
    private Date fechaReg;
    @Column(name = "num_periodo")
    private Integer numPeriodo;
    @Column(name = "anio")
    private Integer anio;
    @Column(name = "plan_actual")
    private Boolean planActual;
    @JoinColumn(name = "id_curso_det", referencedColumnName = "id_curso_det")
    @ManyToOne
    private CepCecCursoDet cepCecCursoDet;
    @OneToMany( mappedBy = "cepCecPlan")
    private List<CepCecSesion> cepCecSesionList;

    public CepCecPlan() {
    }

    public CepCecPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public Integer getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Short getEstadoPlan() {
        return estadoPlan;
    }

    public void setEstadoPlan(Short estadoPlan) {
        this.estadoPlan = estadoPlan;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public Integer getNumPeriodo() {
        return numPeriodo;
    }

    public void setNumPeriodo(Integer numPeriodo) {
        this.numPeriodo = numPeriodo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Boolean getPlanActual() {
        return planActual;
    }

    public void setPlanActual(Boolean planActual) {
        this.planActual = planActual;
    }

    public CepCecCursoDet getCepCecCursoDet() {
        return cepCecCursoDet;
    }

    public void setCepCecCursoDet(CepCecCursoDet cepCecCursoDet) {
        this.cepCecCursoDet = cepCecCursoDet;
    }

    public List<CepCecSesion> getCepCecSesionList() {
        return cepCecSesionList;
    }

    public void setCepCecSesionList(List<CepCecSesion> cepCecSesionList) {
        this.cepCecSesionList = cepCecSesionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlan != null ? idPlan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepCecPlan)) {
            return false;
        }
        CepCecPlan other = (CepCecPlan) object;
        if ((this.idPlan == null && other.idPlan != null) || (this.idPlan != null && !this.idPlan.equals(other.idPlan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepCecPlan[ idPlan=" + idPlan + " ]";
    }
    
}
