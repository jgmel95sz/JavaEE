/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "fxa_estudiante")
@NamedQueries({
    @NamedQuery(name = "FxaEstudiante.findAll", query = "SELECT f FROM FxaEstudiante f")
    , @NamedQuery(name = "FxaEstudiante.findByIdAcexp", query = "SELECT f FROM FxaEstudiante f WHERE f.idAcexp = :idAcexp")
    , @NamedQuery(name = "FxaEstudiante.findByIdEspecialidad", query = "SELECT f FROM FxaEstudiante f WHERE f.idEspecialidad = :idEspecialidad")
    , @NamedQuery(name = "FxaEstudiante.findByIdPlancur", query = "SELECT f FROM FxaEstudiante f WHERE f.idPlancur = :idPlancur")
    , @NamedQuery(name = "FxaEstudiante.findByCodigoEstudiante", query = "SELECT f FROM FxaEstudiante f WHERE f.codigoEstudiante = :codigoEstudiante")
    , @NamedQuery(name = "FxaEstudiante.findByPromSeccion", query = "SELECT f FROM FxaEstudiante f WHERE f.promSeccion = :promSeccion")
    , @NamedQuery(name = "FxaEstudiante.findByCicloNumero", query = "SELECT f FROM FxaEstudiante f WHERE f.cicloNumero = :cicloNumero")
    , @NamedQuery(name = "FxaEstudiante.findByActivo", query = "SELECT f FROM FxaEstudiante f WHERE f.activo = :activo")
    , @NamedQuery(name = "FxaEstudiante.findByAnulado", query = "SELECT f FROM FxaEstudiante f WHERE f.anulado = :anulado")
    , @NamedQuery(name = "FxaEstudiante.findBySituacion", query = "SELECT f FROM FxaEstudiante f WHERE f.situacion = :situacion")
    , @NamedQuery(name = "FxaEstudiante.findByDateinsert", query = "SELECT f FROM FxaEstudiante f WHERE f.dateinsert = :dateinsert")
    , @NamedQuery(name = "FxaEstudiante.findByMigrado", query = "SELECT f FROM FxaEstudiante f WHERE f.migrado = :migrado")
    , @NamedQuery(name = "FxaEstudiante.findByCodNivAcad", query = "SELECT f FROM FxaEstudiante f WHERE f.codNivAcad = :codNivAcad")
    , @NamedQuery(name = "FxaEstudiante.findByCodSitAcad", query = "SELECT f FROM FxaEstudiante f WHERE f.codSitAcad = :codSitAcad")
    , @NamedQuery(name = "FxaEstudiante.findByPromocionId", query = "SELECT f FROM FxaEstudiante f WHERE f.promocionId = :promocionId")
    , @NamedQuery(name = "FxaEstudiante.findByPassEnc", query = "SELECT f FROM FxaEstudiante f WHERE f.passEnc = :passEnc")
    , @NamedQuery(name = "FxaEstudiante.findByPassVerifica", query = "SELECT f FROM FxaEstudiante f WHERE f.passVerifica = :passVerifica")
    , @NamedQuery(name = "FxaEstudiante.findByIdAmbito", query = "SELECT f FROM FxaEstudiante f WHERE f.idAmbito = :idAmbito")})
public class FxaEstudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_acexp")
    private Integer idAcexp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_especialidad")
    private int idEspecialidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_plancur")
    private int idPlancur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "codigo_estudiante")
    private String codigoEstudiante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prom_seccion")
    private Character promSeccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ciclo_numero")
    private short cicloNumero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anulado")
    private boolean anulado;
    @Size(max = 2)
    @Column(name = "situacion")
    private String situacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateinsert")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateinsert;
    @Column(name = "migrado")
    private Boolean migrado;
    @Size(max = 3)
    @Column(name = "cod_niv_acad")
    private String codNivAcad;
    @Size(max = 3)
    @Column(name = "cod_sit_acad")
    private String codSitAcad;
    @Column(name = "promocion_id")
    private Short promocionId;
    @Size(max = 150)
    @Column(name = "pass_enc")
    private String passEnc;
    @Size(max = 150)
    @Column(name = "pass_verifica")
    private String passVerifica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ambito")
    private short idAmbito;
    @JoinColumn(name = "id_direstudiante", referencedColumnName = "id_dir")
    @ManyToOne(optional = false)
    private DrtPersonanatural drtPersonanatural;

    public FxaEstudiante() {
    }

    public FxaEstudiante(Integer idAcexp) {
        this.idAcexp = idAcexp;
    }

    public FxaEstudiante(Integer idAcexp, int idEspecialidad, int idPlancur, String codigoEstudiante, Character promSeccion, short cicloNumero, boolean activo, boolean anulado, Date dateinsert, short idAmbito) {
        this.idAcexp = idAcexp;
        this.idEspecialidad = idEspecialidad;
        this.idPlancur = idPlancur;
        this.codigoEstudiante = codigoEstudiante;
        this.promSeccion = promSeccion;
        this.cicloNumero = cicloNumero;
        this.activo = activo;
        this.anulado = anulado;
        this.dateinsert = dateinsert;
        this.idAmbito = idAmbito;
    }

    public Integer getIdAcexp() {
        return idAcexp;
    }

    public void setIdAcexp(Integer idAcexp) {
        this.idAcexp = idAcexp;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public int getIdPlancur() {
        return idPlancur;
    }

    public void setIdPlancur(int idPlancur) {
        this.idPlancur = idPlancur;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public Character getPromSeccion() {
        return promSeccion;
    }

    public void setPromSeccion(Character promSeccion) {
        this.promSeccion = promSeccion;
    }

    public short getCicloNumero() {
        return cicloNumero;
    }

    public void setCicloNumero(short cicloNumero) {
        this.cicloNumero = cicloNumero;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(boolean anulado) {
        this.anulado = anulado;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public Date getDateinsert() {
        return dateinsert;
    }

    public void setDateinsert(Date dateinsert) {
        this.dateinsert = dateinsert;
    }

    public Boolean getMigrado() {
        return migrado;
    }

    public void setMigrado(Boolean migrado) {
        this.migrado = migrado;
    }

    public String getCodNivAcad() {
        return codNivAcad;
    }

    public void setCodNivAcad(String codNivAcad) {
        this.codNivAcad = codNivAcad;
    }

    public String getCodSitAcad() {
        return codSitAcad;
    }

    public void setCodSitAcad(String codSitAcad) {
        this.codSitAcad = codSitAcad;
    }

    public Short getPromocionId() {
        return promocionId;
    }

    public void setPromocionId(Short promocionId) {
        this.promocionId = promocionId;
    }

    public String getPassEnc() {
        return passEnc;
    }

    public void setPassEnc(String passEnc) {
        this.passEnc = passEnc;
    }

    public String getPassVerifica() {
        return passVerifica;
    }

    public void setPassVerifica(String passVerifica) {
        this.passVerifica = passVerifica;
    }

    public short getIdAmbito() {
        return idAmbito;
    }

    public void setIdAmbito(short idAmbito) {
        this.idAmbito = idAmbito;
    }

    public DrtPersonanatural getDrtPersonanatural() {
        return drtPersonanatural;
    }

    public void setDrtPersonanatural(DrtPersonanatural drtPersonanatural) {
        this.drtPersonanatural = drtPersonanatural;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcexp != null ? idAcexp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FxaEstudiante)) {
            return false;
        }
        FxaEstudiante other = (FxaEstudiante) object;
        if ((this.idAcexp == null && other.idAcexp != null) || (this.idAcexp != null && !this.idAcexp.equals(other.idAcexp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.FxaEstudiante[ idAcexp=" + idAcexp + " ]";
    }
    
}
