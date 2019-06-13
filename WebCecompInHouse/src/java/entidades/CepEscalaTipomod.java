/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
@Table(name = "cep_escala_tipomod")
@NamedQueries({
    @NamedQuery(name = "CepEscalaTipomod.findAll", query = "SELECT c FROM CepEscalaTipomod c")
    , @NamedQuery(name = "CepEscalaTipomod.findByIdEscala", query = "SELECT c FROM CepEscalaTipomod c WHERE c.idEscala = :idEscala")
    , @NamedQuery(name = "CepEscalaTipomod.findByNombreEscala", query = "SELECT c FROM CepEscalaTipomod c WHERE c.nombreEscala = :nombreEscala")
    , @NamedQuery(name = "CepEscalaTipomod.findByNumEscala", query = "SELECT c FROM CepEscalaTipomod c WHERE c.numEscala = :numEscala")
    , @NamedQuery(name = "CepEscalaTipomod.findByEstadoEscala", query = "SELECT c FROM CepEscalaTipomod c WHERE c.estadoEscala = :estadoEscala")
    , @NamedQuery(name = "CepEscalaTipomod.findByNumCepEstpm", query = "SELECT c FROM CepEscalaTipomod c WHERE c.numCepEstpm = :numCepEstpm")})
public class CepEscalaTipomod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_escala")
    @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idEscala;
    @Size(max = 20)
    @Column(name = "nombre_escala")
    private String nombreEscala;
    @Column(name = "num_escala")
    private Integer numEscala;
    @Column(name = "estado_escala")
    private Short estadoEscala;
    @Column(name = "num_cep_estpm")
    private Integer numCepEstpm;
    @JoinColumn(name = "id_modalidad", referencedColumnName = "id_modalidad")
    @ManyToOne(optional = false)
    private CepTipoModalidad cepTipoModalidad;
    @OneToMany(mappedBy = "cepEscalaTipomod")
    private List<CepCecCursoSubdet> cepCecCursoSubdetList;

    public CepEscalaTipomod() {
    }

    public CepEscalaTipomod(Integer idEscala) {
        this.idEscala = idEscala;
    }

    public Integer getIdEscala() {
        return idEscala;
    }

    public void setIdEscala(Integer idEscala) {
        this.idEscala = idEscala;
    }

    public String getNombreEscala() {
        return nombreEscala;
    }

    public void setNombreEscala(String nombreEscala) {
        this.nombreEscala = nombreEscala;
    }

    public Integer getNumEscala() {
        return numEscala;
    }

    public void setNumEscala(Integer numEscala) {
        this.numEscala = numEscala;
    }

    public Short getEstadoEscala() {
        return estadoEscala;
    }

    public void setEstadoEscala(Short estadoEscala) {
        this.estadoEscala = estadoEscala;
    }

    public Integer getNumCepEstpm() {
        return numCepEstpm;
    }

    public void setNumCepEstpm(Integer numCepEstpm) {
        this.numCepEstpm = numCepEstpm;
    }

    public CepTipoModalidad getCepTipoModalidad() {
        return cepTipoModalidad;
    }

    public void setCepTipoModalidad(CepTipoModalidad cepTipoModalidad) {
        this.cepTipoModalidad = cepTipoModalidad;
    }

    public List<CepCecCursoSubdet> getCepCecCursoSubdetList() {
        return cepCecCursoSubdetList;
    }

    public void setCepCecCursoSubdetList(List<CepCecCursoSubdet> cepCecCursoSubdetList) {
        this.cepCecCursoSubdetList = cepCecCursoSubdetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEscala != null ? idEscala.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepEscalaTipomod)) {
            return false;
        }
        CepEscalaTipomod other = (CepEscalaTipomod) object;
        if ((this.idEscala == null && other.idEscala != null) || (this.idEscala != null && !this.idEscala.equals(other.idEscala))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepEscalaTipomod[ idEscala=" + idEscala + " ]";
    }
    
}
