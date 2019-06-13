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
@Table(name = "drt_pernat_uns")
@NamedQueries({
    @NamedQuery(name = "DrtPernatUns.findAll", query = "SELECT d FROM DrtPernatUns d")
    , @NamedQuery(name = "DrtPernatUns.findByIdDir", query = "SELECT d FROM DrtPernatUns d WHERE d.idDir = :idDir")
    , @NamedQuery(name = "DrtPernatUns.findByUbigeoPro", query = "SELECT d FROM DrtPernatUns d WHERE d.ubigeoPro = :ubigeoPro")
    , @NamedQuery(name = "DrtPernatUns.findByFechaIng", query = "SELECT d FROM DrtPernatUns d WHERE d.fechaIng = :fechaIng")})
public class DrtPernatUns implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dir")
    private Integer idDir;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ubigeo_pro")
    private int ubigeoPro;
    @Column(name = "fecha_ing")
    @Temporal(TemporalType.DATE)
    private Date fechaIng;
    @JoinColumn(name = "id_dir", referencedColumnName = "id_dir", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private DrtPersonanatural drtPersonanatural;
    @JoinColumn(name = "tipo_peruns", referencedColumnName = "id_tipo_peruns")
    @ManyToOne
    private DrtTipoPeruns drtTipoPeruns;

    public DrtPernatUns() {
    }

    public DrtPernatUns(Integer idDir) {
        this.idDir = idDir;
    }

    public DrtPernatUns(Integer idDir, int ubigeoPro) {
        this.idDir = idDir;
        this.ubigeoPro = ubigeoPro;
    }

    public Integer getIdDir() {
        return idDir;
    }

    public void setIdDir(Integer idDir) {
        this.idDir = idDir;
    }

    public int getUbigeoPro() {
        return ubigeoPro;
    }

    public void setUbigeoPro(int ubigeoPro) {
        this.ubigeoPro = ubigeoPro;
    }

    public Date getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(Date fechaIng) {
        this.fechaIng = fechaIng;
    }

    public DrtPersonanatural getDrtPersonanatural() {
        return drtPersonanatural;
    }

    public void setDrtPersonanatural(DrtPersonanatural drtPersonanatural) {
        this.drtPersonanatural = drtPersonanatural;
    }

    public DrtTipoPeruns getDrtTipoPeruns() {
        return drtTipoPeruns;
    }

    public void setDrtTipoPeruns(DrtTipoPeruns drtTipoPeruns) {
        this.drtTipoPeruns = drtTipoPeruns;
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
        if (!(object instanceof DrtPernatUns)) {
            return false;
        }
        DrtPernatUns other = (DrtPernatUns) object;
        if ((this.idDir == null && other.idDir != null) || (this.idDir != null && !this.idDir.equals(other.idDir))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DrtPernatUns[ idDir=" + idDir + " ]";
    }
    
}
