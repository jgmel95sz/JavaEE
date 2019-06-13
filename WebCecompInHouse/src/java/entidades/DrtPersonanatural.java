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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "drt_personanatural")
@NamedQueries({
    @NamedQuery(name = "DrtPersonanatural.findAll", query = "SELECT d FROM DrtPersonanatural d")
    , @NamedQuery(name = "DrtPersonanatural.findByIdDir", query = "SELECT d FROM DrtPersonanatural d WHERE d.idDir = :idDir")
    , @NamedQuery(name = "DrtPersonanatural.findByApMaterno", query = "SELECT d FROM DrtPersonanatural d WHERE d.apMaterno = :apMaterno")
    , @NamedQuery(name = "DrtPersonanatural.findByApPaterno", query = "SELECT d FROM DrtPersonanatural d WHERE d.apPaterno = :apPaterno")
    , @NamedQuery(name = "DrtPersonanatural.findByNombre", query = "SELECT d FROM DrtPersonanatural d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "DrtPersonanatural.findBySexo", query = "SELECT d FROM DrtPersonanatural d WHERE d.sexo = :sexo")
    , @NamedQuery(name = "DrtPersonanatural.findByFechaNac", query = "SELECT d FROM DrtPersonanatural d WHERE d.fechaNac = :fechaNac")
    , @NamedQuery(name = "DrtPersonanatural.findByEstadoPernat", query = "SELECT d FROM DrtPersonanatural d WHERE d.estadoPernat = :estadoPernat")
    , @NamedQuery(name = "DrtPersonanatural.findByFechaIng", query = "SELECT d FROM DrtPersonanatural d WHERE d.fechaIng = :fechaIng")
    , @NamedQuery(name = "DrtPersonanatural.findByDireccion", query = "SELECT d FROM DrtPersonanatural d WHERE d.direccion = :direccion")
    , @NamedQuery(name = "DrtPersonanatural.findByObservacion", query = "SELECT d FROM DrtPersonanatural d WHERE d.observacion = :observacion")
    , @NamedQuery(name = "DrtPersonanatural.findByIdPdid", query = "SELECT d FROM DrtPersonanatural d WHERE d.idPdid = :idPdid")
    , @NamedQuery(name = "DrtPersonanatural.findByNumeroPndid", query = "SELECT d FROM DrtPersonanatural d WHERE d.numeroPndid = :numeroPndid")
    , @NamedQuery(name = "DrtPersonanatural.findByIdPnec", query = "SELECT d FROM DrtPersonanatural d WHERE d.idPnec = :idPnec")
    , @NamedQuery(name = "DrtPersonanatural.findByIdGrpsng", query = "SELECT d FROM DrtPersonanatural d WHERE d.idGrpsng = :idGrpsng")
    , @NamedQuery(name = "DrtPersonanatural.findByNombreCompleto", query = "SELECT d FROM DrtPersonanatural d WHERE d.nombreCompleto = :nombreCompleto")
    , @NamedQuery(name = "DrtPersonanatural.findByIdColegio", query = "SELECT d FROM DrtPersonanatural d WHERE d.idColegio = :idColegio")
    , @NamedQuery(name = "DrtPersonanatural.findByAnioEgresoCole", query = "SELECT d FROM DrtPersonanatural d WHERE d.anioEgresoCole = :anioEgresoCole")
    , @NamedQuery(name = "DrtPersonanatural.findByUpdateFlow", query = "SELECT d FROM DrtPersonanatural d WHERE d.updateFlow = :updateFlow")
    , @NamedQuery(name = "DrtPersonanatural.findByEmailPrin", query = "SELECT d FROM DrtPersonanatural d WHERE d.emailPrin = :emailPrin")
    , @NamedQuery(name = "DrtPersonanatural.findByTelefonoPrin", query = "SELECT d FROM DrtPersonanatural d WHERE d.telefonoPrin = :telefonoPrin")
    , @NamedQuery(name = "DrtPersonanatural.findByCelularPrin", query = "SELECT d FROM DrtPersonanatural d WHERE d.celularPrin = :celularPrin")
    , @NamedQuery(name = "DrtPersonanatural.findByUpdateSelf", query = "SELECT d FROM DrtPersonanatural d WHERE d.updateSelf = :updateSelf")
    , @NamedQuery(name = "DrtPersonanatural.findByOtroColegio", query = "SELECT d FROM DrtPersonanatural d WHERE d.otroColegio = :otroColegio")
    , @NamedQuery(name = "DrtPersonanatural.findByPswa", query = "SELECT d FROM DrtPersonanatural d WHERE d.pswa = :pswa")
    , @NamedQuery(name = "DrtPersonanatural.findByPswv", query = "SELECT d FROM DrtPersonanatural d WHERE d.pswv = :pswv")})
public class DrtPersonanatural implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dir")
    private Integer idDir;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ap_materno")
    private String apMaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ap_paterno")
    private String apPaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexo")
    private Character sexo;
    @Column(name = "fecha_nac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_pernat")
    private Character estadoPernat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ing")
    @Temporal(TemporalType.DATE)
    private Date fechaIng;
    @Size(max = 200)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 250)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "id_pdid")
    private Integer idPdid;
    @Size(max = 250)
    @Column(name = "numero_pndid")
    private String numeroPndid;
    @Column(name = "id_pnec")
    private Integer idPnec;
    @Column(name = "id_grpsng")
    private Integer idGrpsng;
    @Size(max = 180)
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_colegio")
    private int idColegio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio_egreso_cole")
    private int anioEgresoCole;
    @Column(name = "update_flow")
    private Integer updateFlow;
    @Size(max = 250)
    @Column(name = "email_prin")
    private String emailPrin;
    @Size(max = 50)
    @Column(name = "telefono_prin")
    private String telefonoPrin;
    @Size(max = 50)
    @Column(name = "celular_prin")
    private String celularPrin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "update_self")
    private int updateSelf;
    @Size(max = 200)
    @Column(name = "otro_colegio")
    private String otroColegio;
    @Size(max = 50)
    @Column(name = "pswa")
    private String pswa;
    @Size(max = 50)
    @Column(name = "pswv")
    private String pswv;
    @OneToMany(mappedBy = "drtPersonanatural")
    private List<CepCecMatriAlu> cepCecMatriAluList;
    @OneToOne(mappedBy = "drtPersonanatural")
    private DrtPernatUns drtPernatUns;
    @OneToMany(mappedBy = "drtPersonanatural")
    private List<FxaEstudiante> fxaEstudianteList;
    @JoinColumn(name = "id_dir", referencedColumnName = "id_dir", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private DrtDirectorio drtDirectorio;
    @JoinColumn(name = "id_ubg_nac", referencedColumnName = "id_ubg")
    @ManyToOne(optional = false)
    private DrtDistrito drtDistrito;
    @JoinColumn(name = "id_ubg_pro", referencedColumnName = "id_ubg")
    @ManyToOne(optional = false)
    private DrtDistrito drtDistrito1;

    public DrtPersonanatural() {
    }

    public DrtPersonanatural(Integer idDir) {
        this.idDir = idDir;
    }

    public DrtPersonanatural(Integer idDir, String apMaterno, String apPaterno, String nombre, Character sexo, Character estadoPernat, Date fechaIng, int idColegio, int anioEgresoCole, int updateSelf) {
        this.idDir = idDir;
        this.apMaterno = apMaterno;
        this.apPaterno = apPaterno;
        this.nombre = nombre;
        this.sexo = sexo;
        this.estadoPernat = estadoPernat;
        this.fechaIng = fechaIng;
        this.idColegio = idColegio;
        this.anioEgresoCole = anioEgresoCole;
        this.updateSelf = updateSelf;
    }

    public Integer getIdDir() {
        return idDir;
    }

    public void setIdDir(Integer idDir) {
        this.idDir = idDir;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Character getEstadoPernat() {
        return estadoPernat;
    }

    public void setEstadoPernat(Character estadoPernat) {
        this.estadoPernat = estadoPernat;
    }

    public Date getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(Date fechaIng) {
        this.fechaIng = fechaIng;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getIdPdid() {
        return idPdid;
    }

    public void setIdPdid(Integer idPdid) {
        this.idPdid = idPdid;
    }

    public String getNumeroPndid() {
        return numeroPndid;
    }

    public void setNumeroPndid(String numeroPndid) {
        this.numeroPndid = numeroPndid;
    }

    public Integer getIdPnec() {
        return idPnec;
    }

    public void setIdPnec(Integer idPnec) {
        this.idPnec = idPnec;
    }

    public Integer getIdGrpsng() {
        return idGrpsng;
    }

    public void setIdGrpsng(Integer idGrpsng) {
        this.idGrpsng = idGrpsng;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getIdColegio() {
        return idColegio;
    }

    public void setIdColegio(int idColegio) {
        this.idColegio = idColegio;
    }

    public int getAnioEgresoCole() {
        return anioEgresoCole;
    }

    public void setAnioEgresoCole(int anioEgresoCole) {
        this.anioEgresoCole = anioEgresoCole;
    }

    public Integer getUpdateFlow() {
        return updateFlow;
    }

    public void setUpdateFlow(Integer updateFlow) {
        this.updateFlow = updateFlow;
    }

    public String getEmailPrin() {
        return emailPrin;
    }

    public void setEmailPrin(String emailPrin) {
        this.emailPrin = emailPrin;
    }

    public String getTelefonoPrin() {
        return telefonoPrin;
    }

    public void setTelefonoPrin(String telefonoPrin) {
        this.telefonoPrin = telefonoPrin;
    }

    public String getCelularPrin() {
        return celularPrin;
    }

    public void setCelularPrin(String celularPrin) {
        this.celularPrin = celularPrin;
    }

    public int getUpdateSelf() {
        return updateSelf;
    }

    public void setUpdateSelf(int updateSelf) {
        this.updateSelf = updateSelf;
    }

    public String getOtroColegio() {
        return otroColegio;
    }

    public void setOtroColegio(String otroColegio) {
        this.otroColegio = otroColegio;
    }

    public String getPswa() {
        return pswa;
    }

    public void setPswa(String pswa) {
        this.pswa = pswa;
    }

    public String getPswv() {
        return pswv;
    }

    public void setPswv(String pswv) {
        this.pswv = pswv;
    }

    public List<CepCecMatriAlu> getCepCecMatriAluList() {
        return cepCecMatriAluList;
    }

    public void setCepCecMatriAluList(List<CepCecMatriAlu> cepCecMatriAluList) {
        this.cepCecMatriAluList = cepCecMatriAluList;
    }

    public DrtPernatUns getDrtPernatUns() {
        return drtPernatUns;
    }

    public void setDrtPernatUns(DrtPernatUns drtPernatUns) {
        this.drtPernatUns = drtPernatUns;
    }

    public List<FxaEstudiante> getFxaEstudianteList() {
        return fxaEstudianteList;
    }

    public void setFxaEstudianteList(List<FxaEstudiante> fxaEstudianteList) {
        this.fxaEstudianteList = fxaEstudianteList;
    }

    public DrtDirectorio getDrtDirectorio() {
        return drtDirectorio;
    }

    public void setDrtDirectorio(DrtDirectorio drtDirectorio) {
        this.drtDirectorio = drtDirectorio;
    }

    public DrtDistrito getDrtDistrito() {
        return drtDistrito;
    }

    public void setDrtDistrito(DrtDistrito drtDistrito) {
        this.drtDistrito = drtDistrito;
    }

    public DrtDistrito getDrtDistrito1() {
        return drtDistrito1;
    }

    public void setDrtDistrito1(DrtDistrito drtDistrito1) {
        this.drtDistrito1 = drtDistrito1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDir != null ? idDir.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DrtPersonanatural)) {
            return false;
        }
        DrtPersonanatural other = (DrtPersonanatural) object;
        if ((this.idDir == null && other.idDir != null) || (this.idDir != null && !this.idDir.equals(other.idDir))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DrtPersonanatural[ idDir=" + idDir + " ]";
    }
    
}
