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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Melvin
 */
@Entity
@Table(name = "cep_cec_notas")
@NamedQueries({
    @NamedQuery(name = "CepCecNotas.findAll", query = "SELECT c FROM CepCecNotas c")
    , @NamedQuery(name = "CepCecNotas.findByIdNotas", query = "SELECT c FROM CepCecNotas c WHERE c.idNotas = :idNotas")
    , @NamedQuery(name = "CepCecNotas.findByNota3", query = "SELECT c FROM CepCecNotas c WHERE c.nota3 = :nota3")
    , @NamedQuery(name = "CepCecNotas.findByNota4", query = "SELECT c FROM CepCecNotas c WHERE c.nota4 = :nota4")
    , @NamedQuery(name = "CepCecNotas.findByFechaRn", query = "SELECT c FROM CepCecNotas c WHERE c.fechaRn = :fechaRn")
    , @NamedQuery(name = "CepCecNotas.findByNotaSubsanacion", query = "SELECT c FROM CepCecNotas c WHERE c.notaSubsanacion = :notaSubsanacion")
    , @NamedQuery(name = "CepCecNotas.findByNotaFinal", query = "SELECT c FROM CepCecNotas c WHERE c.notaFinal = :notaFinal")
    , @NamedQuery(name = "CepCecNotas.findByEstadoNotas", query = "SELECT c FROM CepCecNotas c WHERE c.estadoNotas = :estadoNotas")
    , @NamedQuery(name = "CepCecNotas.findByNota1", query = "SELECT c FROM CepCecNotas c WHERE c.nota1 = :nota1")
    , @NamedQuery(name = "CepCecNotas.findByNota2", query = "SELECT c FROM CepCecNotas c WHERE c.nota2 = :nota2")
    , @NamedQuery(name = "CepCecNotas.findByFechaModNota", query = "SELECT c FROM CepCecNotas c WHERE c.fechaModNota = :fechaModNota")})
public class CepCecNotas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_notas")
    @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idNotas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota3")
    private Float nota3;
    @Column(name = "nota4")
    private Float nota4;
    @Column(name = "fecha_rn")
    @Temporal(TemporalType.DATE)
    private Date fechaRn;
    @Column(name = "nota_subsanacion")
    private Float notaSubsanacion;
    @Column(name = "nota_final")
    private Float notaFinal;
    @Column(name = "estado_notas")
    private Boolean estadoNotas;
    @Column(name = "nota1")
    private Float nota1;
    @Column(name = "nota2")
    private Float nota2;
    @Column(name = "fecha_mod_nota")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModNota;
    @JoinColumn(name = "id_matri_alu", referencedColumnName = "id_matri_alu")
    @ManyToOne(optional = false)
    private CepCecMatriAlu cepCecMatriAlu;

    public CepCecNotas() {
    }

    public CepCecNotas(Integer idNotas) {
        this.idNotas = idNotas;
    }

    public Integer getIdNotas() {
        return idNotas;
    }

    public void setIdNotas(Integer idNotas) {
        this.idNotas = idNotas;
    }

    public Float getNota3() {
        return nota3;
    }

    public void setNota3(Float nota3) {
        this.nota3 = nota3;
    }

    public Float getNota4() {
        return nota4;
    }

    public void setNota4(Float nota4) {
        this.nota4 = nota4;
    }

    public Date getFechaRn() {
        return fechaRn;
    }

    public void setFechaRn(Date fechaRn) {
        this.fechaRn = fechaRn;
    }

    public Float getNotaSubsanacion() {
        return notaSubsanacion;
    }

    public void setNotaSubsanacion(Float notaSubsanacion) {
        this.notaSubsanacion = notaSubsanacion;
    }

    public Float getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Float notaFinal) {
        this.notaFinal = notaFinal;
    }

    public Boolean getEstadoNotas() {
        return estadoNotas;
    }

    public void setEstadoNotas(Boolean estadoNotas) {
        this.estadoNotas = estadoNotas;
    }

    public Float getNota1() {
        return nota1;
    }

    public void setNota1(Float nota1) {
        this.nota1 = nota1;
    }

    public Float getNota2() {
        return nota2;
    }

    public void setNota2(Float nota2) {
        this.nota2 = nota2;
    }

    public Date getFechaModNota() {
        return fechaModNota;
    }

    public void setFechaModNota(Date fechaModNota) {
        this.fechaModNota = fechaModNota;
    }

    public CepCecMatriAlu getCepCecMatriAlu() {
        return cepCecMatriAlu;
    }

    public void setCepCecMatriAlu(CepCecMatriAlu cepCecMatriAlu) {
        this.cepCecMatriAlu = cepCecMatriAlu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotas != null ? idNotas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepCecNotas)) {
            return false;
        }
        CepCecNotas other = (CepCecNotas) object;
        if ((this.idNotas == null && other.idNotas != null) || (this.idNotas != null && !this.idNotas.equals(other.idNotas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepCecNotas[ idNotas=" + idNotas + " ]";
    }
    
}
