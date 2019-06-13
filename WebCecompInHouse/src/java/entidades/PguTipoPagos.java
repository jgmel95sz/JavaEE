/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
//import java.math.Float;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Melvin
 */
@Entity
@Table(name = "pgu_tipo_pagos")
@NamedQueries({
    @NamedQuery(name = "PguTipoPagos.findAll", query = "SELECT p FROM PguTipoPagos p")
    , @NamedQuery(name = "PguTipoPagos.findByIdTipopag", query = "SELECT p FROM PguTipoPagos p WHERE p.idTipopag = :idTipopag")
    , @NamedQuery(name = "PguTipoPagos.findByIdAcper", query = "SELECT p FROM PguTipoPagos p WHERE p.idAcper = :idAcper")
    , @NamedQuery(name = "PguTipoPagos.findByIdCiclo", query = "SELECT p FROM PguTipoPagos p WHERE p.idCiclo = :idCiclo")
    , @NamedQuery(name = "PguTipoPagos.findByConcepto", query = "SELECT p FROM PguTipoPagos p WHERE p.concepto = :concepto")
    , @NamedQuery(name = "PguTipoPagos.findByPrecio", query = "SELECT p FROM PguTipoPagos p WHERE p.precio = :precio")
    , @NamedQuery(name = "PguTipoPagos.findByAnio", query = "SELECT p FROM PguTipoPagos p WHERE p.anio = :anio")
    , @NamedQuery(name = "PguTipoPagos.findByActivo", query = "SELECT p FROM PguTipoPagos p WHERE p.activo = :activo")
    , @NamedQuery(name = "PguTipoPagos.findByIdJerdep", query = "SELECT p FROM PguTipoPagos p WHERE p.idJerdep = :idJerdep")
    , @NamedQuery(name = "PguTipoPagos.findByIdEspecialidad", query = "SELECT p FROM PguTipoPagos p WHERE p.idEspecialidad = :idEspecialidad")
    , @NamedQuery(name = "PguTipoPagos.findByIdCurso", query = "SELECT p FROM PguTipoPagos p WHERE p.idCurso = :idCurso")
    , @NamedQuery(name = "PguTipoPagos.findByIdAmbito", query = "SELECT p FROM PguTipoPagos p WHERE p.idAmbito = :idAmbito")
    , @NamedQuery(name = "PguTipoPagos.findByIdFacultad", query = "SELECT p FROM PguTipoPagos p WHERE p.idFacultad = :idFacultad")
    , @NamedQuery(name = "PguTipoPagos.findByOrden", query = "SELECT p FROM PguTipoPagos p WHERE p.orden = :orden")})
public class PguTipoPagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipopag")
    @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idTipopag;
    @Column(name = "id_acper")
    private Integer idAcper;
    @Column(name = "id_ciclo")
    private Integer idCiclo;
    @Size(max = 250)
    @Column(name = "concepto")
    private String concepto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Float precio;
    @Column(name = "anio")
    private Short anio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @Column(name = "id_jerdep")
    private Integer idJerdep;
    @Column(name = "id_especialidad")
    private Integer idEspecialidad;
    @Column(name = "id_curso")
    private Integer idCurso;
    @Column(name = "id_ambito")
    private Integer idAmbito;
    @Column(name = "id_facultad")
    private Integer idFacultad;
    @Column(name = "orden")
    private Short orden;
    @OneToMany(mappedBy = "pguTipoPagos")
    private List<PguModalidadTipospagos> pguModalidadTipospagosList;
    @JoinColumn(name = "id_dep", referencedColumnName = "id_dep")
    @ManyToOne
    private OrgDependencia orgDependencia;
    @JoinColumn(name = "id_grupopag", referencedColumnName = "id_grupopag")
    @ManyToOne
    private PguGrupoTipospagos pguGrupoTipospagos;

    public PguTipoPagos() {
    }

    public PguTipoPagos(Integer idTipopag) {
        this.idTipopag = idTipopag;
    }

    public PguTipoPagos(Integer idTipopag, boolean activo) {
        this.idTipopag = idTipopag;
        this.activo = activo;
    }

    public Integer getIdTipopag() {
        return idTipopag;
    }

    public void setIdTipopag(Integer idTipopag) {
        this.idTipopag = idTipopag;
    }

    public Integer getIdAcper() {
        return idAcper;
    }

    public void setIdAcper(Integer idAcper) {
        this.idAcper = idAcper;
    }

    public Integer getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Short getAnio() {
        return anio;
    }

    public void setAnio(Short anio) {
        this.anio = anio;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Integer getIdJerdep() {
        return idJerdep;
    }

    public void setIdJerdep(Integer idJerdep) {
        this.idJerdep = idJerdep;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getIdAmbito() {
        return idAmbito;
    }

    public void setIdAmbito(Integer idAmbito) {
        this.idAmbito = idAmbito;
    }

    public Integer getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Integer idFacultad) {
        this.idFacultad = idFacultad;
    }

    public Short getOrden() {
        return orden;
    }

    public void setOrden(Short orden) {
        this.orden = orden;
    }

    public List<PguModalidadTipospagos> getPguModalidadTipospagosList() {
        return pguModalidadTipospagosList;
    }

    public void setPguModalidadTipospagosList(List<PguModalidadTipospagos> pguModalidadTipospagosList) {
        this.pguModalidadTipospagosList = pguModalidadTipospagosList;
    }

    public OrgDependencia getOrgDependencia() {
        return orgDependencia;
    }

    public void setOrgDependencia(OrgDependencia orgDependencia) {
        this.orgDependencia = orgDependencia;
    }

    public PguGrupoTipospagos getPguGrupoTipospagos() {
        return pguGrupoTipospagos;
    }

    public void setPguGrupoTipospagos(PguGrupoTipospagos pguGrupoTipospagos) {
        this.pguGrupoTipospagos = pguGrupoTipospagos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipopag != null ? idTipopag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PguTipoPagos)) {
            return false;
        }
        PguTipoPagos other = (PguTipoPagos) object;
        if ((this.idTipopag == null && other.idTipopag != null) || (this.idTipopag != null && !this.idTipopag.equals(other.idTipopag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PguTipoPagos[ idTipopag=" + idTipopag + " ]";
    }
    
}
