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
@Table(name = "rcd_concepto")
@NamedQueries({
    @NamedQuery(name = "RcdConcepto.findAll", query = "SELECT r FROM RcdConcepto r")
    , @NamedQuery(name = "RcdConcepto.findByIdConcepto", query = "SELECT r FROM RcdConcepto r WHERE r.idConcepto = :idConcepto")
    , @NamedQuery(name = "RcdConcepto.findByNombre", query = "SELECT r FROM RcdConcepto r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "RcdConcepto.findByTipo", query = "SELECT r FROM RcdConcepto r WHERE r.tipo = :tipo")
    , @NamedQuery(name = "RcdConcepto.findByIdPartida1", query = "SELECT r FROM RcdConcepto r WHERE r.idPartida1 = :idPartida1")
    , @NamedQuery(name = "RcdConcepto.findByIdPartida2", query = "SELECT r FROM RcdConcepto r WHERE r.idPartida2 = :idPartida2")
    , @NamedQuery(name = "RcdConcepto.findByCondicion", query = "SELECT r FROM RcdConcepto r WHERE r.condicion = :condicion")})
public class RcdConcepto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_concepto")
    private Integer idConcepto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 250)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "id_partida_1")
    private Integer idPartida1;
    @Column(name = "id_partida_2")
    private Integer idPartida2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "condicion")
    private short condicion;
    @OneToMany(mappedBy = "rcdConcepto")
    private List<RcdTarifario> rcdTarifarioList;
    @OneToMany(mappedBy = "rcdConcepto")
    private List<CepCecInversionCurso> cepCecInversionCursoList;
    @OneToMany(mappedBy = "rcdConcepto")
    private List<RcdVoucher> rcdVoucherList;

    public RcdConcepto() {
    }

    public RcdConcepto(Integer idConcepto) {
        this.idConcepto = idConcepto;
    }

    public RcdConcepto(Integer idConcepto, String nombre, short condicion) {
        this.idConcepto = idConcepto;
        this.nombre = nombre;
        this.condicion = condicion;
    }

    public Integer getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(Integer idConcepto) {
        this.idConcepto = idConcepto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getIdPartida1() {
        return idPartida1;
    }

    public void setIdPartida1(Integer idPartida1) {
        this.idPartida1 = idPartida1;
    }

    public Integer getIdPartida2() {
        return idPartida2;
    }

    public void setIdPartida2(Integer idPartida2) {
        this.idPartida2 = idPartida2;
    }

    public short getCondicion() {
        return condicion;
    }

    public void setCondicion(short condicion) {
        this.condicion = condicion;
    }

    public List<CepCecInversionCurso> getCepCecInversionCursoList() {
        return cepCecInversionCursoList;
    }

    public void setCepCecInversionCursoList(List<CepCecInversionCurso> cepCecInversionCursoList) {
        this.cepCecInversionCursoList = cepCecInversionCursoList;
    }

    public List<RcdVoucher> getRcdVoucherList() {
        return rcdVoucherList;
    }

    public void setRcdVoucherList(List<RcdVoucher> rcdVoucherList) {
        this.rcdVoucherList = rcdVoucherList;
    }

    public List<RcdTarifario> getRcdTarifarioList() {
        return rcdTarifarioList;
    }

    public void setRcdTarifarioList(List<RcdTarifario> rcdTarifarioList) {
        this.rcdTarifarioList = rcdTarifarioList;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConcepto != null ? idConcepto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RcdConcepto)) {
            return false;
        }
        RcdConcepto other = (RcdConcepto) object;
        if ((this.idConcepto == null && other.idConcepto != null) || (this.idConcepto != null && !this.idConcepto.equals(other.idConcepto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.RcdConcepto[ idConcepto=" + idConcepto + " ]";
    }
    
}
