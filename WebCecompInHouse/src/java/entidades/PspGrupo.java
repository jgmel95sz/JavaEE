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
@Table(name = "psp_grupo")
@NamedQueries({
    @NamedQuery(name = "PspGrupo.findAll", query = "SELECT p FROM PspGrupo p")
    , @NamedQuery(name = "PspGrupo.findByGid", query = "SELECT p FROM PspGrupo p WHERE p.gid = :gid")
    , @NamedQuery(name = "PspGrupo.findByIdGroup", query = "SELECT p FROM PspGrupo p WHERE p.idGroup = :idGroup")
    , @NamedQuery(name = "PspGrupo.findByNombre", query = "SELECT p FROM PspGrupo p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "PspGrupo.findByPspCxt", query = "SELECT p FROM PspGrupo p WHERE p.pspCxt = :pspCxt")
    , @NamedQuery(name = "PspGrupo.findByPspNivel", query = "SELECT p FROM PspGrupo p WHERE p.pspNivel = :pspNivel")
    , @NamedQuery(name = "PspGrupo.findByStdGrp", query = "SELECT p FROM PspGrupo p WHERE p.stdGrp = :stdGrp")})
public class PspGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "gid")
    private Integer gid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_group")
    private String idGroup;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "psp_cxt")
    private short pspCxt;
    @Column(name = "psp_nivel")
    private Short pspNivel;
    @Column(name = "std_grp")
    private Short stdGrp;
    @OneToMany( mappedBy = "pspGrupo")
    private List<PspGroupuser> pspGroupuserList;

    public PspGrupo() {
    }

    public PspGrupo(Integer gid) {
        this.gid = gid;
    }

    public PspGrupo(Integer gid, String idGroup, String nombre, short pspCxt) {
        this.gid = gid;
        this.idGroup = idGroup;
        this.nombre = nombre;
        this.pspCxt = pspCxt;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getPspCxt() {
        return pspCxt;
    }

    public void setPspCxt(short pspCxt) {
        this.pspCxt = pspCxt;
    }

    public Short getPspNivel() {
        return pspNivel;
    }

    public void setPspNivel(Short pspNivel) {
        this.pspNivel = pspNivel;
    }

    public Short getStdGrp() {
        return stdGrp;
    }

    public void setStdGrp(Short stdGrp) {
        this.stdGrp = stdGrp;
    }

    public List<PspGroupuser> getPspGroupuserList() {
        return pspGroupuserList;
    }

    public void setPspGroupuserList(List<PspGroupuser> pspGroupuserList) {
        this.pspGroupuserList = pspGroupuserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gid != null ? gid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PspGrupo)) {
            return false;
        }
        PspGrupo other = (PspGrupo) object;
        if ((this.gid == null && other.gid != null) || (this.gid != null && !this.gid.equals(other.gid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PspGrupo[ gid=" + gid + " ]";
    }
    
}
