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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "psp_usuario")
@NamedQueries({
    @NamedQuery(name = "PspUsuario.findAll", query = "SELECT p FROM PspUsuario p")
    , @NamedQuery(name = "PspUsuario.findByUid", query = "SELECT p FROM PspUsuario p WHERE p.uid = :uid")
    , @NamedQuery(name = "PspUsuario.findByIdUser", query = "SELECT p FROM PspUsuario p WHERE p.idUser = :idUser")
    , @NamedQuery(name = "PspUsuario.findByConfig", query = "SELECT p FROM PspUsuario p WHERE p.config = :config")
    , @NamedQuery(name = "PspUsuario.findByStdUid", query = "SELECT p FROM PspUsuario p WHERE p.stdUid = :stdUid")
    , @NamedQuery(name = "PspUsuario.findByIdTarjeta", query = "SELECT p FROM PspUsuario p WHERE p.idTarjeta = :idTarjeta")
    , @NamedQuery(name = "PspUsuario.findByTempData", query = "SELECT p FROM PspUsuario p WHERE p.tempData = :tempData")})
public class PspUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "uid")
    private Integer uid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "id_user")
    private String idUser;
    @Lob
    @Column(name = "pwd")
    private byte[] pwd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "config")
    private String config;
    @Basic(optional = false)
    @NotNull
    @Column(name = "std_uid")
    private short stdUid;
    @Size(max = 12)
    @Column(name = "id_tarjeta")
    private String idTarjeta;
    @Size(max = 20)
    @Column(name = "temp_data")
    private String tempData;
    @JoinColumn(name = "id_dir", referencedColumnName = "id_dir")
    @ManyToOne
    private DrtDirectorio drtDirectorio;
    @OneToMany( mappedBy = "pspUsuario")
    private List<PspGroupuser> pspGroupuserList;
    @OneToMany(mappedBy = "pspUsuario")
    private List<PguPagospersCab> pguPagospersCabList;

    public PspUsuario() {
    }

    public PspUsuario(Integer uid) {
        this.uid = uid;
    }

    public PspUsuario(Integer uid, String idUser, String config, short stdUid) {
        this.uid = uid;
        this.idUser = idUser;
        this.config = config;
        this.stdUid = stdUid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public byte[] getPwd() {
        return pwd;
    }

    public void setPwd(byte[] pwd) {
        this.pwd = pwd;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public short getStdUid() {
        return stdUid;
    }

    public void setStdUid(short stdUid) {
        this.stdUid = stdUid;
    }

    public String getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(String idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getTempData() {
        return tempData;
    }

    public void setTempData(String tempData) {
        this.tempData = tempData;
    }

    public DrtDirectorio getDrtDirectorio() {
        return drtDirectorio;
    }

    public void setDrtDirectorio(DrtDirectorio drtDirectorio) {
        this.drtDirectorio = drtDirectorio;
    }

    public List<PspGroupuser> getPspGroupuserList() {
        return pspGroupuserList;
    }

    public void setPspGroupuserList(List<PspGroupuser> pspGroupuserList) {
        this.pspGroupuserList = pspGroupuserList;
    }

    public List<PguPagospersCab> getPguPagospersCabList() {
        return pguPagospersCabList;
    }

    public void setPguPagospersCabList(List<PguPagospersCab> pguPagospersCabList) {
        this.pguPagospersCabList = pguPagospersCabList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uid != null ? uid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PspUsuario)) {
            return false;
        }
        PspUsuario other = (PspUsuario) object;
        if ((this.uid == null && other.uid != null) || (this.uid != null && !this.uid.equals(other.uid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PspUsuario[ uid=" + uid + " ]";
    }
    
}
