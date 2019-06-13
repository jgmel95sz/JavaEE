/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
//import java.math.Float;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Melvin
 */
@Entity
@Table(name = "rcd_voucher")
@NamedQueries({
    @NamedQuery(name = "RcdVoucher.findAll", query = "SELECT r FROM RcdVoucher r")
    , @NamedQuery(name = "RcdVoucher.findByIdVoucher", query = "SELECT r FROM RcdVoucher r WHERE r.idVoucher = :idVoucher")
    , @NamedQuery(name = "RcdVoucher.findByCodUnidadRecaudadora", query = "SELECT r FROM RcdVoucher r WHERE r.codUnidadRecaudadora = :codUnidadRecaudadora")
    , @NamedQuery(name = "RcdVoucher.findByCodAlumno", query = "SELECT r FROM RcdVoucher r WHERE r.codAlumno = :codAlumno")
    , @NamedQuery(name = "RcdVoucher.findBySecuencia", query = "SELECT r FROM RcdVoucher r WHERE r.secuencia = :secuencia")
    , @NamedQuery(name = "RcdVoucher.findByTipoDocumento", query = "SELECT r FROM RcdVoucher r WHERE r.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "RcdVoucher.findBySituacion", query = "SELECT r FROM RcdVoucher r WHERE r.situacion = :situacion")
    , @NamedQuery(name = "RcdVoucher.findByTipoPersona", query = "SELECT r FROM RcdVoucher r WHERE r.tipoPersona = :tipoPersona")
    , @NamedQuery(name = "RcdVoucher.findBySede", query = "SELECT r FROM RcdVoucher r WHERE r.sede = :sede")
    , @NamedQuery(name = "RcdVoucher.findByNumDocumento", query = "SELECT r FROM RcdVoucher r WHERE r.numDocumento = :numDocumento")
    , @NamedQuery(name = "RcdVoucher.findByImportePagado", query = "SELECT r FROM RcdVoucher r WHERE r.importePagado = :importePagado")
    , @NamedQuery(name = "RcdVoucher.findByTipoPago", query = "SELECT r FROM RcdVoucher r WHERE r.tipoPago = :tipoPago")
    , @NamedQuery(name = "RcdVoucher.findByFormaPago", query = "SELECT r FROM RcdVoucher r WHERE r.formaPago = :formaPago")
    , @NamedQuery(name = "RcdVoucher.findByFechaPago", query = "SELECT r FROM RcdVoucher r WHERE r.fechaPago = :fechaPago")
    , @NamedQuery(name = "RcdVoucher.findByHoraPago", query = "SELECT r FROM RcdVoucher r WHERE r.horaPago = :horaPago")
    , @NamedQuery(name = "RcdVoucher.findByCodCajero", query = "SELECT r FROM RcdVoucher r WHERE r.codCajero = :codCajero")
    , @NamedQuery(name = "RcdVoucher.findByCodAgencia", query = "SELECT r FROM RcdVoucher r WHERE r.codAgencia = :codAgencia")
    , @NamedQuery(name = "RcdVoucher.findByNumCheque", query = "SELECT r FROM RcdVoucher r WHERE r.numCheque = :numCheque")
    , @NamedQuery(name = "RcdVoucher.findByCodBanco", query = "SELECT r FROM RcdVoucher r WHERE r.codBanco = :codBanco")
    , @NamedQuery(name = "RcdVoucher.findByCondicion", query = "SELECT r FROM RcdVoucher r WHERE r.condicion = :condicion")
    , @NamedQuery(name = "RcdVoucher.findByFechaEnvio", query = "SELECT r FROM RcdVoucher r WHERE r.fechaEnvio = :fechaEnvio")
    , @NamedQuery(name = "RcdVoucher.findByNombre", query = "SELECT r FROM RcdVoucher r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "RcdVoucher.findByCuenta", query = "SELECT r FROM RcdVoucher r WHERE r.cuenta = :cuenta")
    , @NamedQuery(name = "RcdVoucher.findByEstado", query = "SELECT r FROM RcdVoucher r WHERE r.estado = :estado")
    , @NamedQuery(name = "RcdVoucher.findByFechaUso", query = "SELECT r FROM RcdVoucher r WHERE r.fechaUso = :fechaUso")
    , @NamedQuery(name = "RcdVoucher.findByIdAcper", query = "SELECT r FROM RcdVoucher r WHERE r.idAcper = :idAcper")})
public class RcdVoucher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_voucher")
    private Integer idVoucher;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_unidad_recaudadora")
    private short codUnidadRecaudadora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "cod_alumno")
    private String codAlumno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "secuencia")
    private int secuencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_documento")
    private short tipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "situacion")
    private int situacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_persona")
    private short tipoPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sede")
    private short sede;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "num_documento")
    private String numDocumento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe_pagado")
    private Float importePagado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_pago")
    private short tipoPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "forma_pago")
    private short formaPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_pago")
    @Temporal(TemporalType.TIME)
    private Date horaPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cajero")
    private short codCajero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_agencia")
    private short codAgencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_cheque")
    private int numCheque;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_banco")
    private short codBanco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "condicion")
    private short condicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_envio")
    @Temporal(TemporalType.DATE)
    private Date fechaEnvio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cuenta")
    private String cuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "fecha_uso")
    @Temporal(TemporalType.DATE)
    private Date fechaUso;
    @Column(name = "id_acper")
    private Integer idAcper;
    @JoinColumn(name = "concepto", referencedColumnName = "id_concepto")
    @ManyToOne(optional = false)
    private RcdConcepto rcdConcepto;

    public RcdVoucher() {
    }

    public RcdVoucher(Integer idVoucher) {
        this.idVoucher = idVoucher;
    }

    public RcdVoucher(Integer idVoucher, short codUnidadRecaudadora, String codAlumno, int secuencia, short tipoDocumento, int situacion, short tipoPersona, short sede, String numDocumento, Float importePagado, short tipoPago, short formaPago, Date fechaPago, Date horaPago, short codCajero, short codAgencia, int numCheque, short codBanco, short condicion, Date fechaEnvio, String nombre, String cuenta, boolean estado) {
        this.idVoucher = idVoucher;
        this.codUnidadRecaudadora = codUnidadRecaudadora;
        this.codAlumno = codAlumno;
        this.secuencia = secuencia;
        this.tipoDocumento = tipoDocumento;
        this.situacion = situacion;
        this.tipoPersona = tipoPersona;
        this.sede = sede;
        this.numDocumento = numDocumento;
        this.importePagado = importePagado;
        this.tipoPago = tipoPago;
        this.formaPago = formaPago;
        this.fechaPago = fechaPago;
        this.horaPago = horaPago;
        this.codCajero = codCajero;
        this.codAgencia = codAgencia;
        this.numCheque = numCheque;
        this.codBanco = codBanco;
        this.condicion = condicion;
        this.fechaEnvio = fechaEnvio;
        this.nombre = nombre;
        this.cuenta = cuenta;
        this.estado = estado;
    }

    public Integer getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(Integer idVoucher) {
        this.idVoucher = idVoucher;
    }

    public short getCodUnidadRecaudadora() {
        return codUnidadRecaudadora;
    }

    public void setCodUnidadRecaudadora(short codUnidadRecaudadora) {
        this.codUnidadRecaudadora = codUnidadRecaudadora;
    }

    public String getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(String codAlumno) {
        this.codAlumno = codAlumno;
    }

    public int getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    public short getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(short tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getSituacion() {
        return situacion;
    }

    public void setSituacion(int situacion) {
        this.situacion = situacion;
    }

    public short getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(short tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public short getSede() {
        return sede;
    }

    public void setSede(short sede) {
        this.sede = sede;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public Float getImportePagado() {
        return importePagado;
    }

    public void setImportePagado(Float importePagado) {
        this.importePagado = importePagado;
    }

    public short getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(short tipoPago) {
        this.tipoPago = tipoPago;
    }

    public short getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(short formaPago) {
        this.formaPago = formaPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Date getHoraPago() {
        return horaPago;
    }

    public void setHoraPago(Date horaPago) {
        this.horaPago = horaPago;
    }

    public short getCodCajero() {
        return codCajero;
    }

    public void setCodCajero(short codCajero) {
        this.codCajero = codCajero;
    }

    public short getCodAgencia() {
        return codAgencia;
    }

    public void setCodAgencia(short codAgencia) {
        this.codAgencia = codAgencia;
    }

    public int getNumCheque() {
        return numCheque;
    }

    public void setNumCheque(int numCheque) {
        this.numCheque = numCheque;
    }

    public short getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(short codBanco) {
        this.codBanco = codBanco;
    }

    public short getCondicion() {
        return condicion;
    }

    public void setCondicion(short condicion) {
        this.condicion = condicion;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFechaUso() {
        return fechaUso;
    }

    public void setFechaUso(Date fechaUso) {
        this.fechaUso = fechaUso;
    }

    public Integer getIdAcper() {
        return idAcper;
    }

    public void setIdAcper(Integer idAcper) {
        this.idAcper = idAcper;
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
        hash += (idVoucher != null ? idVoucher.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RcdVoucher)) {
            return false;
        }
        RcdVoucher other = (RcdVoucher) object;
        if ((this.idVoucher == null && other.idVoucher != null) || (this.idVoucher != null && !this.idVoucher.equals(other.idVoucher))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.RcdVoucher[ idVoucher=" + idVoucher + " ]";
    }
    
}
