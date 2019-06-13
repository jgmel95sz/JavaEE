/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Melvin
 */
@Entity
@Table(name = "psp_groupuser")
@NamedQueries({
    @NamedQuery(name = "PspGroupuser.findAll", query = "SELECT p FROM PspGroupuser p")
    , @NamedQuery(name = "PspGroupuser.findByUid", query = "SELECT p FROM PspGroupuser p WHERE p.pspGroupuserPK.uid = :uid")
    , @NamedQuery(name = "PspGroupuser.findByGid", query = "SELECT p FROM PspGroupuser p WHERE p.pspGroupuserPK.gid = :gid")})
public class PspGroupuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PspGroupuserPK pspGroupuserPK;
    @JoinColumn(name = "gid", referencedColumnName = "gid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PspGrupo pspGrupo;
    @JoinColumn(name = "uid", referencedColumnName = "uid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PspUsuario pspUsuario;
    @OneToMany(mappedBy = "pspGroupuser")
    private List<PspUserapp> pspUserappList;

    public PspGroupuser() {
    }

    public PspGroupuser(PspGroupuserPK pspGroupuserPK) {
        this.pspGroupuserPK = pspGroupuserPK;
    }

    public PspGroupuser(int uid, int gid) {
        this.pspGroupuserPK = new PspGroupuserPK(uid, gid);
    }

    public PspGroupuserPK getPspGroupuserPK() {
        return pspGroupuserPK;
    }

    public void setPspGroupuserPK(PspGroupuserPK pspGroupuserPK) {
        this.pspGroupuserPK = pspGroupuserPK;
    }

    public PspGrupo getPspGrupo() {
        return pspGrupo;
    }

    public void setPspGrupo(PspGrupo pspGrupo) {
        this.pspGrupo = pspGrupo;
    }

    public PspUsuario getPspUsuario() {
        return pspUsuario;
    }

    public void setPspUsuario(PspUsuario pspUsuario) {
        this.pspUsuario = pspUsuario;
    }

    public List<PspUserapp> getPspUserappList() {
        return pspUserappList;
    }

    public void setPspUserappList(List<PspUserapp> pspUserappList) {
        this.pspUserappList = pspUserappList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pspGroupuserPK != null ? pspGroupuserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PspGroupuser)) {
            return false;
        }
        PspGroupuser other = (PspGroupuser) object;
        if ((this.pspGroupuserPK == null && other.pspGroupuserPK != null) || (this.pspGroupuserPK != null && !this.pspGroupuserPK.equals(other.pspGroupuserPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PspGroupuser[ pspGroupuserPK=" + pspGroupuserPK + " ]";
    }
    
}
