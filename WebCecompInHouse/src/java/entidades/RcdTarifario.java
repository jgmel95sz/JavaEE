/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
//import java.math.Float;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "rcd_tarifario")
@NamedQueries({
    @NamedQuery(name = "RcdTarifario.findAll", query = "SELECT r FROM RcdTarifario r")
    , @NamedQuery(name = "RcdTarifario.findByIdTarifario", query = "SELECT r FROM RcdTarifario r WHERE r.idTarifario = :idTarifario")
    , @NamedQuery(name = "RcdTarifario.findByIdUndeje", query = "SELECT r FROM RcdTarifario r WHERE r.idUndeje = :idUndeje")
   /* , @NamedQuery(name = "RcdTarifario.findByIdConcepto", query = "SELECT r FROM RcdTarifario r WHERE r.idConcepto = :idConcepto")*/
    , @NamedQuery(name = "RcdTarifario.findByTipoPersona", query = "SELECT r FROM RcdTarifario r WHERE r.tipoPersona = :tipoPersona")
    , @NamedQuery(name = "RcdTarifario.findByIdSituacest", query = "SELECT r FROM RcdTarifario r WHERE r.idSituacest = :idSituacest")
    , @NamedQuery(name = "RcdTarifario.findByImporte", query = "SELECT r FROM RcdTarifario r WHERE r.importe = :importe")
    , @NamedQuery(name = "RcdTarifario.findByCondicion", query = "SELECT r FROM RcdTarifario r WHERE r.condicion = :condicion")
    , @NamedQuery(name = "RcdTarifario.findByPagoParcial", query = "SELECT r FROM RcdTarifario r WHERE r.pagoParcial = :pagoParcial")})
public class RcdTarifario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tarifario")
    private Integer idTarifario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_undeje")
    private int idUndeje;
  //  @Basic(optional = false)
  //  @NotNull
 //   @Column(name = "id_concepto")
 //   private int idConcepto;
    @Column(name = "tipo_persona")
    private Short tipoPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_situacest")
    private int idSituacest;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "importe")
    private Float importe;
    @Column(name = "condicion")
    private Short condicion;
    @Column(name = "pago_parcial")
    private Short pagoParcial;
    //añadi
    @JoinColumn(name = "id_concepto", referencedColumnName = "id_concepto")
    @ManyToOne(optional = false)
    private RcdConcepto rcdConcepto;
    public RcdTarifario() {
    }

    public RcdTarifario(Integer idTarifario) {
        this.idTarifario = idTarifario;
    }

    public RcdTarifario(Integer idTarifario, int idUndeje/*, int idConcepto*/, int idSituacest) {
        this.idTarifario = idTarifario;
        this.idUndeje = idUndeje;
        //this.idConcepto = idConcepto;
        this.idSituacest = idSituacest;
    }

    public Integer getIdTarifario() {
        return idTarifario;
    }

    public void setIdTarifario(Integer idTarifario) {
        this.idTarifario = idTarifario;
    }

    public int getIdUndeje() {
        return idUndeje;
    }

    public void setIdUndeje(int idUndeje) {
        this.idUndeje = idUndeje;
    }

   /* public int getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(int idConcepto) {
        this.idConcepto = idConcepto;
    }
*/
    public Short getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(Short tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public int getIdSituacest() {
        return idSituacest;
    }

    public void setIdSituacest(int idSituacest) {
        this.idSituacest = idSituacest;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public Short getCondicion() {
        return condicion;
    }

    public void setCondicion(Short condicion) {
        this.condicion = condicion;
    }

    public Short getPagoParcial() {
        return pagoParcial;
    }

    public void setPagoParcial(Short pagoParcial) {
        this.pagoParcial = pagoParcial;
    }

    public RcdConcepto getRcdConcepto() {
        return rcdConcepto;
    }

    public void setRcdConcepto(RcdConcepto rcdConcepto) {
        this.rcdConcepto = rcdConcepto;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarifario != null ? idTarifario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RcdTarifario)) {
            return false;
        }
        RcdTarifario other = (RcdTarifario) object;
        if ((this.idTarifario == null && other.idTarifario != null) || (this.idTarifario != null && !this.idTarifario.equals(other.idTarifario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.RcdTarifario[ idTarifario=" + idTarifario + " ]";
    }
    
}
