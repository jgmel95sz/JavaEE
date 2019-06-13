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
@Table(name = "cep_cec_matri_alu")
@NamedQueries({
    @NamedQuery(name = "CepCecMatriAlu.findAll", query = "SELECT c FROM CepCecMatriAlu c")
    , @NamedQuery(name = "CepCecMatriAlu.findByIdMatriAlu", query = "SELECT c FROM CepCecMatriAlu c WHERE c.idMatriAlu = :idMatriAlu")
    , @NamedQuery(name = "CepCecMatriAlu.findByEstadoMatri", query = "SELECT c FROM CepCecMatriAlu c WHERE c.estadoMatri = :estadoMatri")
    , @NamedQuery(name = "CepCecMatriAlu.findByFechaRegMa", query = "SELECT c FROM CepCecMatriAlu c WHERE c.fechaRegMa = :fechaRegMa")
    , @NamedQuery(name = "CepCecMatriAlu.findByHoraRegMa", query = "SELECT c FROM CepCecMatriAlu c WHERE c.horaRegMa = :horaRegMa")
    , @NamedQuery(name = "CepCecMatriAlu.findByTipoAlumno", query = "SELECT c FROM CepCecMatriAlu c WHERE c.tipoAlumno = :tipoAlumno")
    , @NamedQuery(name = "CepCecMatriAlu.findByEstadoAcademico", query = "SELECT c FROM CepCecMatriAlu c WHERE c.estadoAcademico = :estadoAcademico")
    , @NamedQuery(name = "CepCecMatriAlu.findByCodMatricula", query = "SELECT c FROM CepCecMatriAlu c WHERE c.codMatricula = :codMatricula")})
public class CepCecMatriAlu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_matri_alu")
    @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idMatriAlu;
    @Column(name = "estado_matri")
    private Short estadoMatri;
    @Column(name = "fecha_reg_ma")
    @Temporal(TemporalType.DATE)
    private Date fechaRegMa;
    @Column(name = "hora_reg_ma")
    @Temporal(TemporalType.TIME)
    private Date horaRegMa;
    @Column(name = "tipo_alumno")
    private Integer tipoAlumno;
    @Column(name = "estado_academico")
    private Boolean estadoAcademico;
    @Size(max = 13)
    @Column(name = "cod_matricula")
    private String codMatricula;
    @OneToMany(mappedBy = "cepCecMatriAlu")
    private List<CepCecMatriPago> cepCecMatriPagoList;
    @JoinColumn(name = "id_cur_grup", referencedColumnName = "id_cur_grup")
    @ManyToOne
    private CepCecCurGrup cepCecCurGrup;
    @JoinColumn(name = "id_dir", referencedColumnName = "id_dir")
    @ManyToOne(optional = false)
    private DrtPersonanatural drtPersonanatural;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cepCecMatriAlu")
    private List<CepCecNotas> cepCecNotasList;
    @OneToMany(mappedBy = "cepCecMatriAlu")
    private List<CepCecCertificado> cepCecCertificadoList;

    public CepCecMatriAlu() {
    }

    public CepCecMatriAlu(Integer idMatriAlu) {
        this.idMatriAlu = idMatriAlu;
    }

    public Integer getIdMatriAlu() {
        return idMatriAlu;
    }

    public void setIdMatriAlu(Integer idMatriAlu) {
        this.idMatriAlu = idMatriAlu;
    }

    public Short getEstadoMatri() {
        return estadoMatri;
    }

    public void setEstadoMatri(Short estadoMatri) {
        this.estadoMatri = estadoMatri;
    }

    public Date getFechaRegMa() {
        return fechaRegMa;
    }

    public void setFechaRegMa(Date fechaRegMa) {
        this.fechaRegMa = fechaRegMa;
    }

    public Date getHoraRegMa() {
        return horaRegMa;
    }

    public void setHoraRegMa(Date horaRegMa) {
        this.horaRegMa = horaRegMa;
    }

    public Integer getTipoAlumno() {
        return tipoAlumno;
    }

    public void setTipoAlumno(Integer tipoAlumno) {
        this.tipoAlumno = tipoAlumno;
    }

    public Boolean getEstadoAcademico() {
        return estadoAcademico;
    }

    public void setEstadoAcademico(Boolean estadoAcademico) {
        this.estadoAcademico = estadoAcademico;
    }

    public String getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(String codMatricula) {
        this.codMatricula = codMatricula;
    }

    public List<CepCecMatriPago> getCepCecMatriPagoList() {
        return cepCecMatriPagoList;
    }

    public void setCepCecMatriPagoList(List<CepCecMatriPago> cepCecMatriPagoList) {
        this.cepCecMatriPagoList = cepCecMatriPagoList;
    }

    public CepCecCurGrup getCepCecCurGrup() {
        return cepCecCurGrup;
    }

    public void setCepCecCurGrup(CepCecCurGrup cepCecCurGrup) {
        this.cepCecCurGrup = cepCecCurGrup;
    }

    public DrtPersonanatural getDrtPersonanatural() {
        return drtPersonanatural;
    }

    public void setDrtPersonanatural(DrtPersonanatural drtPersonanatural) {
        this.drtPersonanatural = drtPersonanatural;
    }

    public List<CepCecNotas> getCepCecNotasList() {
        return cepCecNotasList;
    }

    public void setCepCecNotasList(List<CepCecNotas> cepCecNotasList) {
        this.cepCecNotasList = cepCecNotasList;
    }

    public List<CepCecCertificado> getCepCecCertificadoList() {
        return cepCecCertificadoList;
    }

    public void setCepCecCertificadoList(List<CepCecCertificado> cepCecCertificadoList) {
        this.cepCecCertificadoList = cepCecCertificadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatriAlu != null ? idMatriAlu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepCecMatriAlu)) {
            return false;
        }
        CepCecMatriAlu other = (CepCecMatriAlu) object;
        if ((this.idMatriAlu == null && other.idMatriAlu != null) || (this.idMatriAlu != null && !this.idMatriAlu.equals(other.idMatriAlu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepCecMatriAlu[ idMatriAlu=" + idMatriAlu + " ]";
    }
    
}
