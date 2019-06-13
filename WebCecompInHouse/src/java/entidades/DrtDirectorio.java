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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Melvin
 */
@Entity
@Table(name = "drt_directorio")
@NamedQueries({
    @NamedQuery(name = "DrtDirectorio.findAll", query = "SELECT d FROM DrtDirectorio d")
    , @NamedQuery(name = "DrtDirectorio.findByIdDir", query = "SELECT d FROM DrtDirectorio d WHERE d.idDir = :idDir")
    , @NamedQuery(name = "DrtDirectorio.findByPspCxt", query = "SELECT d FROM DrtDirectorio d WHERE d.pspCxt = :pspCxt")
    , @NamedQuery(name = "DrtDirectorio.findByPspApp", query = "SELECT d FROM DrtDirectorio d WHERE d.pspApp = :pspApp")
    , @NamedQuery(name = "DrtDirectorio.findByPspUid", query = "SELECT d FROM DrtDirectorio d WHERE d.pspUid = :pspUid")
    , @NamedQuery(name = "DrtDirectorio.findByDateinsert", query = "SELECT d FROM DrtDirectorio d WHERE d.dateinsert = :dateinsert")})
public class DrtDirectorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dir")
    @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idDir;
    @Basic(optional = false)
    @NotNull
    @Column(name = "psp_cxt")
    private short pspCxt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "psp_app")
    private int pspApp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "psp_uid")
    private int pspUid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateinsert")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateinsert;
    @OneToMany(mappedBy = "drtDirectorio")
    private List<PspUsuario> pspUsuarioList;
    @JoinColumn(name = "id_dclas", referencedColumnName = "id_dclas")
    @ManyToOne(optional = false)
    private DrtDirectorioClase drtDirectorioClase;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "drtDirectorio")
    private DrtPersonanatural drtPersonanatural;

    public DrtDirectorio() {
    }

    public DrtDirectorio(Integer idDir) {
        this.idDir = idDir;
    }

    public DrtDirectorio(Integer idDir, short pspCxt, int pspApp, int pspUid, Date dateinsert) {
        this.idDir = idDir;
        this.pspCxt = pspCxt;
        this.pspApp = pspApp;
        this.pspUid = pspUid;
        this.dateinsert = dateinsert;
    }

    public Integer getIdDir() {
        return idDir;
    }

    public void setIdDir(Integer idDir) {
        this.idDir = idDir;
    }

    public short getPspCxt() {
        return pspCxt;
    }

    public void setPspCxt(short pspCxt) {
        this.pspCxt = pspCxt;
    }

    public int getPspApp() {
        return pspApp;
    }

    public void setPspApp(int pspApp) {
        this.pspApp = pspApp;
    }

    public int getPspUid() {
        return pspUid;
    }

    public void setPspUid(int pspUid) {
        this.pspUid = pspUid;
    }

    public Date getDateinsert() {
        return dateinsert;
    }

    public void setDateinsert(Date dateinsert) {
        this.dateinsert = dateinsert;
    }

    public List<PspUsuario> getPspUsuarioList() {
        return pspUsuarioList;
    }

    public void setPspUsuarioList(List<PspUsuario> pspUsuarioList) {
        this.pspUsuarioList = pspUsuarioList;
    }

    public DrtDirectorioClase getDrtDirectorioClase() {
        return drtDirectorioClase;
    }

    public void setDrtDirectorioClase(DrtDirectorioClase drtDirectorioClase) {
        this.drtDirectorioClase = drtDirectorioClase;
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
        hash += (idDir != null ? idDir.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DrtDirectorio)) {
            return false;
        }
        DrtDirectorio other = (DrtDirectorio) object;
        if ((this.idDir == null && other.idDir != null) || (this.idDir != null && !this.idDir.equals(other.idDir))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DrtDirectorio[ idDir=" + idDir + " ]";
    }
    
}
