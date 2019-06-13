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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Melvin
 */
@Embeddable
public class PguPagospersDetPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_numpago")
    private int idNumpago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_modltipo")
    private int idModltipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_cuota")
    private short nroCuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_parte")
    private short nroParte;
    //@Basic(optional = false)
  //  @NotNull
  //  @Column(name = "estado")
   // private boolean estado;

    public PguPagospersDetPK() {
    }

    public PguPagospersDetPK(int idNumpago, int idModltipo, Date fechaPago, short nroCuota, short nroParte/*, boolean estado*/) {
        this.idNumpago = idNumpago;
        this.idModltipo = idModltipo;
        this.fechaPago = fechaPago;
        this.nroCuota = nroCuota;
        this.nroParte = nroParte;
        //this.estado = estado;
    }

    public int getIdNumpago() {
        return idNumpago;
    }

    public void setIdNumpago(int idNumpago) {
        this.idNumpago = idNumpago;
    }

    public int getIdModltipo() {
        return idModltipo;
    }

    public void setIdModltipo(int idModltipo) {
        this.idModltipo = idModltipo;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public short getNroCuota() {
        return nroCuota;
    }

    public void setNroCuota(short nroCuota) {
        this.nroCuota = nroCuota;
    }

    public short getNroParte() {
        return nroParte;
    }

    public void setNroParte(short nroParte) {
        this.nroParte = nroParte;
    }

  /*  public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idNumpago;
        hash += (int) idModltipo;
        hash += (fechaPago != null ? fechaPago.hashCode() : 0);
        hash += (int) nroCuota;
        hash += (int) nroParte;
        //hash += (estado ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PguPagospersDetPK)) {
            return false;
        }
        PguPagospersDetPK other = (PguPagospersDetPK) object;
        if (this.idNumpago != other.idNumpago) {
            return false;
        }
        if (this.idModltipo != other.idModltipo) {
            return false;
        }
        if ((this.fechaPago == null && other.fechaPago != null) || (this.fechaPago != null && !this.fechaPago.equals(other.fechaPago))) {
            return false;
        }
        if (this.nroCuota != other.nroCuota) {
            return false;
        }
        if (this.nroParte != other.nroParte) {
            return false;
        }
       /* if (this.estado != other.estado) {
            return false;
        }*/
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PguPagospersDetPK[ idNumpago=" + idNumpago + ", idModltipo=" + idModltipo + ", fechaPago=" + fechaPago + ", nroCuota=" + nroCuota + ", nroParte=" + nroParte /*+ ", estado=" + estado*/ + " ]";
    }
    
}
