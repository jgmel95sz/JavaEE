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
@Table(name = "cep_cec_desc_exonerados")
@NamedQueries({
    @NamedQuery(name = "CepCecDescExonerados.findAll", query = "SELECT c FROM CepCecDescExonerados c")
    , @NamedQuery(name = "CepCecDescExonerados.findByIdAluDesExo", query = "SELECT c FROM CepCecDescExonerados c WHERE c.idAluDesExo = :idAluDesExo")
    , @NamedQuery(name = "CepCecDescExonerados.findByCodAlumno", query = "SELECT c FROM CepCecDescExonerados c WHERE c.codAlumno = :codAlumno")
    , @NamedQuery(name = "CepCecDescExonerados.findByNumDocumento", query = "SELECT c FROM CepCecDescExonerados c WHERE c.numDocumento = :numDocumento")
    , @NamedQuery(name = "CepCecDescExonerados.findByDescripcionDes", query = "SELECT c FROM CepCecDescExonerados c WHERE c.descripcionDes = :descripcionDes")
    , @NamedQuery(name = "CepCecDescExonerados.findByEstadoDes", query = "SELECT c FROM CepCecDescExonerados c WHERE c.estadoDes = :estadoDes")
    , @NamedQuery(name = "CepCecDescExonerados.findByIdDir", query = "SELECT c FROM CepCecDescExonerados c WHERE c.idDir = :idDir")
    , @NamedQuery(name = "CepCecDescExonerados.findByFechaRegMb", query = "SELECT c FROM CepCecDescExonerados c WHERE c.fechaRegMb = :fechaRegMb")
    , @NamedQuery(name = "CepCecDescExonerados.findByFechaLimite", query = "SELECT c FROM CepCecDescExonerados c WHERE c.fechaLimite = :fechaLimite")
    , @NamedQuery(name = "CepCecDescExonerados.findByNomCompletosExo", query = "SELECT c FROM CepCecDescExonerados c WHERE c.nomCompletosExo = :nomCompletosExo")})
public class CepCecDescExonerados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_alu_des_exo")
    @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idAluDesExo;
    @Size(max = 15)
    @Column(name = "cod_alumno")
    private String codAlumno;
    @Size(max = 15)
    @Column(name = "num_documento")
    private String numDocumento;
    @Size(max = 300)
    @Column(name = "descripcion_des")
    private String descripcionDes;
    @Column(name = "estado_des")
    private Boolean estadoDes;
    @Column(name = "id_dir")
    private Integer idDir;
    @Column(name = "fecha_reg_mb")
    @Temporal(TemporalType.DATE)
    private Date fechaRegMb;
    @Column(name = "fecha_limite")
    @Temporal(TemporalType.DATE)
    private Date fechaLimite;
    @Size(max = 300)
    @Column(name = "nom_completos_exo")
    private String nomCompletosExo;
    @OneToMany(mappedBy = "cepCecDescExonerados")
    private List<CepCecExonerados> cepCecExoneradosList;
    @JoinColumn(name = "id_inversion", referencedColumnName = "id_inversion")
    @ManyToOne(optional = false)
    private CepCecInversionCurso cepCecInversionCurso;

    public CepCecDescExonerados() {
    }

    public CepCecDescExonerados(Integer idAluDesExo) {
        this.idAluDesExo = idAluDesExo;
    }

    public Integer getIdAluDesExo() {
        return idAluDesExo;
    }

    public void setIdAluDesExo(Integer idAluDesExo) {
        this.idAluDesExo = idAluDesExo;
    }

    public String getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(String codAlumno) {
        this.codAlumno = codAlumno;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getDescripcionDes() {
        return descripcionDes;
    }

    public void setDescripcionDes(String descripcionDes) {
        this.descripcionDes = descripcionDes;
    }

    public Boolean getEstadoDes() {
        return estadoDes;
    }

    public void setEstadoDes(Boolean estadoDes) {
        this.estadoDes = estadoDes;
    }

    public Integer getIdDir() {
        return idDir;
    }

    public void setIdDir(Integer idDir) {
        this.idDir = idDir;
    }

    public Date getFechaRegMb() {
        return fechaRegMb;
    }

    public void setFechaRegMb(Date fechaRegMb) {
        this.fechaRegMb = fechaRegMb;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getNomCompletosExo() {
        return nomCompletosExo;
    }

    public void setNomCompletosExo(String nomCompletosExo) {
        this.nomCompletosExo = nomCompletosExo;
    }

    public List<CepCecExonerados> getCepCecExoneradosList() {
        return cepCecExoneradosList;
    }

    public void setCepCecExoneradosList(List<CepCecExonerados> cepCecExoneradosList) {
        this.cepCecExoneradosList = cepCecExoneradosList;
    }

    public CepCecInversionCurso getCepCecInversionCurso() {
        return cepCecInversionCurso;
    }

    public void setCepCecInversionCurso(CepCecInversionCurso cepCecInversionCurso) {
        this.cepCecInversionCurso = cepCecInversionCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAluDesExo != null ? idAluDesExo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepCecDescExonerados)) {
            return false;
        }
        CepCecDescExonerados other = (CepCecDescExonerados) object;
        if ((this.idAluDesExo == null && other.idAluDesExo != null) || (this.idAluDesExo != null && !this.idAluDesExo.equals(other.idAluDesExo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepCecDescExonerados[ idAluDesExo=" + idAluDesExo + " ]";
    }
    
}
