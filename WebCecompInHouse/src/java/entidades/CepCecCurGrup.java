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

/**
 *
 * @author Melvin
 */
@Entity
@Table(name = "cep_cec_cur_grup")
@NamedQueries({
    @NamedQuery(name = "CepCecCurGrup.findAll", query = "SELECT c FROM CepCecCurGrup c")
    , @NamedQuery(name = "CepCecCurGrup.findByIdCurGrup", query = "SELECT c FROM CepCecCurGrup c WHERE c.idCurGrup = :idCurGrup")
    , @NamedQuery(name = "CepCecCurGrup.findByEstadoGrupoCab", query = "SELECT c FROM CepCecCurGrup c WHERE c.estadoGrupoCab = :estadoGrupoCab")
    , @NamedQuery(name = "CepCecCurGrup.findByFechaInicio", query = "SELECT c FROM CepCecCurGrup c WHERE c.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "CepCecCurGrup.findByFechaFin", query = "SELECT c FROM CepCecCurGrup c WHERE c.fechaFin = :fechaFin")
    , @NamedQuery(name = "CepCecCurGrup.findByEstadoAcademico", query = "SELECT c FROM CepCecCurGrup c WHERE c.estadoAcademico = :estadoAcademico")
    , @NamedQuery(name = "CepCecCurGrup.findByIdPlan", query = "SELECT c FROM CepCecCurGrup c WHERE c.idPlan = :idPlan")
    , @NamedQuery(name = "CepCecCurGrup.findByRegFechafinacademico", query = "SELECT c FROM CepCecCurGrup c WHERE c.regFechafinacademico = :regFechafinacademico")})
public class CepCecCurGrup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cur_grup")
    @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idCurGrup;
    @Column(name = "estado_grupo_cab")
    private Short estadoGrupoCab;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "estado_academico")
    private Boolean estadoAcademico;
    @Column(name = "id_plan")
    private Integer idPlan;
    @Column(name = "reg_fechafinacademico")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regFechafinacademico;
    @OneToMany(mappedBy = "cepCecCurGrup")
    private List<CepCecCronogramaCab> cepCecCronogramaCabList;
    @OneToMany(mappedBy = "cepCecCurGrup")
    private List<CepCecMatriAlu> cepCecMatriAluList;
    @OneToMany(mappedBy = "cepCecCurGrup")
    private List<CepCecCurGrupDet> cepCecCurGrupDetList;
    @OneToMany( mappedBy = "cepCecCurGrup")
    private List<CepCecHorarios> cepCecHorariosList;
    @JoinColumn(name = "id_curso_subdet", referencedColumnName = "id_curso_subdet")
    @ManyToOne(optional = false)
    private CepCecCursoSubdet cepCecCursoSubdet;
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    @ManyToOne(optional = false)
    private CepCecGrupo cepCecGrupo;

    public CepCecCurGrup() {
    }

    public CepCecCurGrup(Integer idCurGrup) {
        this.idCurGrup = idCurGrup;
    }

    public Integer getIdCurGrup() {
        return idCurGrup;
    }

    public void setIdCurGrup(Integer idCurGrup) {
        this.idCurGrup = idCurGrup;
    }

    public Short getEstadoGrupoCab() {
        return estadoGrupoCab;
    }

    public void setEstadoGrupoCab(Short estadoGrupoCab) {
        this.estadoGrupoCab = estadoGrupoCab;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Boolean getEstadoAcademico() {
        return estadoAcademico;
    }

    public void setEstadoAcademico(Boolean estadoAcademico) {
        this.estadoAcademico = estadoAcademico;
    }

    public Integer getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public Date getRegFechafinacademico() {
        return regFechafinacademico;
    }

    public void setRegFechafinacademico(Date regFechafinacademico) {
        this.regFechafinacademico = regFechafinacademico;
    }

    public List<CepCecCronogramaCab> getCepCecCronogramaCabList() {
        return cepCecCronogramaCabList;
    }

    public void setCepCecCronogramaCabList(List<CepCecCronogramaCab> cepCecCronogramaCabList) {
        this.cepCecCronogramaCabList = cepCecCronogramaCabList;
    }

    public List<CepCecMatriAlu> getCepCecMatriAluList() {
        return cepCecMatriAluList;
    }

    public void setCepCecMatriAluList(List<CepCecMatriAlu> cepCecMatriAluList) {
        this.cepCecMatriAluList = cepCecMatriAluList;
    }

    public List<CepCecCurGrupDet> getCepCecCurGrupDetList() {
        return cepCecCurGrupDetList;
    }

    public void setCepCecCurGrupDetList(List<CepCecCurGrupDet> cepCecCurGrupDetList) {
        this.cepCecCurGrupDetList = cepCecCurGrupDetList;
    }

    public List<CepCecHorarios> getCepCecHorariosList() {
        return cepCecHorariosList;
    }

    public void setCepCecHorariosList(List<CepCecHorarios> cepCecHorariosList) {
        this.cepCecHorariosList = cepCecHorariosList;
    }

    public CepCecCursoSubdet getCepCecCursoSubdet() {
        return cepCecCursoSubdet;
    }

    public void setCepCecCursoSubdet(CepCecCursoSubdet cepCecCursoSubdet) {
        this.cepCecCursoSubdet = cepCecCursoSubdet;
    }

    public CepCecGrupo getCepCecGrupo() {
        return cepCecGrupo;
    }

    public void setCepCecGrupo(CepCecGrupo cepCecGrupo) {
        this.cepCecGrupo = cepCecGrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurGrup != null ? idCurGrup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepCecCurGrup)) {
            return false;
        }
        CepCecCurGrup other = (CepCecCurGrup) object;
        if ((this.idCurGrup == null && other.idCurGrup != null) || (this.idCurGrup != null && !this.idCurGrup.equals(other.idCurGrup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepCecCurGrup[ idCurGrup=" + idCurGrup + " ]";
    }
    
}
