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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Melvin
 */
@Entity
@Table(name = "cep_cec_tip_alumno")
@NamedQueries({
    @NamedQuery(name = "CepCecTipAlumno.findAll", query = "SELECT c FROM CepCecTipAlumno c")
    , @NamedQuery(name = "CepCecTipAlumno.findByIdTipAlumno", query = "SELECT c FROM CepCecTipAlumno c WHERE c.idTipAlumno = :idTipAlumno")
    , @NamedQuery(name = "CepCecTipAlumno.findByNomTipAlumno", query = "SELECT c FROM CepCecTipAlumno c WHERE c.nomTipAlumno = :nomTipAlumno")
    , @NamedQuery(name = "CepCecTipAlumno.findByEstadoTipAlumno", query = "SELECT c FROM CepCecTipAlumno c WHERE c.estadoTipAlumno = :estadoTipAlumno")
    , @NamedQuery(name = "CepCecTipAlumno.findByNomAbrev", query = "SELECT c FROM CepCecTipAlumno c WHERE c.nomAbrev = :nomAbrev")})
public class CepCecTipAlumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tip_alumno")
    private Integer idTipAlumno;
    @Size(max = 30)
    @Column(name = "nom_tip_alumno")
    private String nomTipAlumno;
    @Column(name = "estado_tip_alumno")
    private Short estadoTipAlumno;
    @Size(max = 20)
    @Column(name = "nom_abrev")
    private String nomAbrev;
    @OneToMany( mappedBy = "cepCecTipAlumno")
    private List<CepCecInversionCurso> cepCecInversionCursoList;

    public CepCecTipAlumno() {
    }

    public CepCecTipAlumno(Integer idTipAlumno) {
        this.idTipAlumno = idTipAlumno;
    }

    public Integer getIdTipAlumno() {
        return idTipAlumno;
    }

    public void setIdTipAlumno(Integer idTipAlumno) {
        this.idTipAlumno = idTipAlumno;
    }

    public String getNomTipAlumno() {
        return nomTipAlumno;
    }

    public void setNomTipAlumno(String nomTipAlumno) {
        this.nomTipAlumno = nomTipAlumno;
    }

    public Short getEstadoTipAlumno() {
        return estadoTipAlumno;
    }

    public void setEstadoTipAlumno(Short estadoTipAlumno) {
        this.estadoTipAlumno = estadoTipAlumno;
    }

    public String getNomAbrev() {
        return nomAbrev;
    }

    public void setNomAbrev(String nomAbrev) {
        this.nomAbrev = nomAbrev;
    }

    public List<CepCecInversionCurso> getCepCecInversionCursoList() {
        return cepCecInversionCursoList;
    }

    public void setCepCecInversionCursoList(List<CepCecInversionCurso> cepCecInversionCursoList) {
        this.cepCecInversionCursoList = cepCecInversionCursoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipAlumno != null ? idTipAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepCecTipAlumno)) {
            return false;
        }
        CepCecTipAlumno other = (CepCecTipAlumno) object;
        if ((this.idTipAlumno == null && other.idTipAlumno != null) || (this.idTipAlumno != null && !this.idTipAlumno.equals(other.idTipAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepCecTipAlumno[ idTipAlumno=" + idTipAlumno + " ]";
    }
    
}
