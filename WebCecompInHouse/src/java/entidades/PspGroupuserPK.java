/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Melvin
 */
@Embeddable
public class PspGroupuserPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "uid")
    private int uid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gid")
    private int gid;

    public PspGroupuserPK() {
    }

    public PspGroupuserPK(int uid, int gid) {
        this.uid = uid;
        this.gid = gid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) uid;
        hash += (int) gid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PspGroupuserPK)) {
            return false;
        }
        PspGroupuserPK other = (PspGroupuserPK) object;
        if (this.uid != other.uid) {
            return false;
        }
        if (this.gid != other.gid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PspGroupuserPK[ uid=" + uid + ", gid=" + gid + " ]";
    }
    
}
