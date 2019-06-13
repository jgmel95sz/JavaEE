/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Melvin
 */
@Entity
@Table(name = "psp_userapp")
@NamedQueries({
    @NamedQuery(name = "PspUserapp.findAll", query = "SELECT p FROM PspUserapp p")
    , @NamedQuery(name = "PspUserapp.findByUid", query = "SELECT p FROM PspUserapp p WHERE p.pspUserappPK.uid = :uid")
    , @NamedQuery(name = "PspUserapp.findByGid", query = "SELECT p FROM PspUserapp p WHERE p.pspUserappPK.gid = :gid")
    , @NamedQuery(name = "PspUserapp.findByApp", query = "SELECT p FROM PspUserapp p WHERE p.pspUserappPK.app = :app")
    , @NamedQuery(name = "PspUserapp.findByAcceso", query = "SELECT p FROM PspUserapp p WHERE p.acceso = :acceso")})
public class PspUserapp implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PspUserappPK pspUserappPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acceso")
    private short acceso;
    @JoinColumn(name = "app", referencedColumnName = "psp_app", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PspAplicacion pspAplicacion;
    @JoinColumns({
        @JoinColumn(name = "uid", referencedColumnName = "uid", insertable = false, updatable = false)
        , @JoinColumn(name = "gid", referencedColumnName = "gid", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PspGroupuser pspGroupuser;

    public PspUserapp() {
    }

    public PspUserapp(PspUserappPK pspUserappPK) {
        this.pspUserappPK = pspUserappPK;
    }

    public PspUserapp(PspUserappPK pspUserappPK, short acceso) {
        this.pspUserappPK = pspUserappPK;
        this.acceso = acceso;
    }

    public PspUserapp(int uid, int gid, short app) {
        this.pspUserappPK = new PspUserappPK(uid, gid, app);
    }

    public PspUserappPK getPspUserappPK() {
        return pspUserappPK;
    }

    public void setPspUserappPK(PspUserappPK pspUserappPK) {
        this.pspUserappPK = pspUserappPK;
    }

    public short getAcceso() {
        return acceso;
    }

    public void setAcceso(short acceso) {
        this.acceso = acceso;
    }

    public PspAplicacion getPspAplicacion() {
        return pspAplicacion;
    }

    public void setPspAplicacion(PspAplicacion pspAplicacion) {
        this.pspAplicacion = pspAplicacion;
    }

    public PspGroupuser getPspGroupuser() {
        return pspGroupuser;
    }

    public void setPspGroupuser(PspGroupuser pspGroupuser) {
        this.pspGroupuser = pspGroupuser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pspUserappPK != null ? pspUserappPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PspUserapp)) {
            return false;
        }
        PspUserapp other = (PspUserapp) object;
        if ((this.pspUserappPK == null && other.pspUserappPK != null) || (this.pspUserappPK != null && !this.pspUserappPK.equals(other.pspUserappPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PspUserapp[ pspUserappPK=" + pspUserappPK + " ]";
    }
    
}
