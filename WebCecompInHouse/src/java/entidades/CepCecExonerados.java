/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "cep_cec_exonerados")
@NamedQueries({
    @NamedQuery(name = "CepCecExonerados.findAll", query = "SELECT c FROM CepCecExonerados c")})
public class CepCecExonerados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_exonerados")
    @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idExonerados;
    @Size(max = 20)
    @Column(name = "secuencia")
    private String secuencia;
    @Column(name = "cod_agencia")
    private Short codAgencia;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Column(name = "estado_exo")
    private Boolean estadoExo;
    @Column(name = "fecha_uso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUso;
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Size(max = 50)
    @Column(name = "num_resolucion")
    private String numResolucion;
    @Column(name = "pagototal")
    private Boolean pagototal;
    @Column(name = "fecha_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReg;
   // @OneToMany(mappedBy = "cepCecExonerados")
    //private List<CepCecMatriPago> cepCecMatriPagoList;
    @JoinColumn(name = "id_alu_des_exo", referencedColumnName = "id_alu_des_exo")
    @ManyToOne
    private CepCecDescExonerados cepCecDescExonerados;

    public CepCecExonerados() {
    }

    public CepCecExonerados(Integer idExonerados) {
        this.idExonerados = idExonerados;
    }

    public Integer getIdExonerados() {
        return idExonerados;
    }

    public void setIdExonerados(Integer idExonerados) {
        this.idExonerados = idExonerados;
    }

    public String getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    public Short getCodAgencia() {
        return codAgencia;
    }

    public void setCodAgencia(Short codAgencia) {
        this.codAgencia = codAgencia;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Boolean getEstadoExo() {
        return estadoExo;
    }

    public void setEstadoExo(Boolean estadoExo) {
        this.estadoExo = estadoExo;
    }

    public Date getFechaUso() {
        return fechaUso;
    }

    public void setFechaUso(Date fechaUso) {
        this.fechaUso = fechaUso;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getNumResolucion() {
        return numResolucion;
    }

    public void setNumResolucion(String numResolucion) {
        this.numResolucion = numResolucion;
    }

    public Boolean getPagototal() {
        return pagototal;
    }

    public void setPagototal(Boolean pagototal) {
        this.pagototal = pagototal;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

  /*  public List<CepCecMatriPago> getCepCecMatriPagoList() {
        return cepCecMatriPagoList;
    }

    public void setCepCecMatriPagoList(List<CepCecMatriPago> cepCecMatriPagoList) {
        this.cepCecMatriPagoList = cepCecMatriPagoList;
    }*/

    public CepCecDescExonerados getCepCecDescExonerados() {
        return cepCecDescExonerados;
    }

    public void setCepCecDescExonerados(CepCecDescExonerados cepCecDescExonerados) {
        this.cepCecDescExonerados = cepCecDescExonerados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExonerados != null ? idExonerados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepCecExonerados)) {
            return false;
        }
        CepCecExonerados other = (CepCecExonerados) object;
        if ((this.idExonerados == null && other.idExonerados != null) || (this.idExonerados != null && !this.idExonerados.equals(other.idExonerados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepCecExonerados[ idExonerados=" + idExonerados + " ]";
    }
    
}
