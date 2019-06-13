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
@Table(name = "drt_directorio_clase")
@NamedQueries({
    @NamedQuery(name = "DrtDirectorioClase.findAll", query = "SELECT d FROM DrtDirectorioClase d")
    , @NamedQuery(name = "DrtDirectorioClase.findByIdDclas", query = "SELECT d FROM DrtDirectorioClase d WHERE d.idDclas = :idDclas")
    , @NamedQuery(name = "DrtDirectorioClase.findByNombre", query = "SELECT d FROM DrtDirectorioClase d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "DrtDirectorioClase.findByDescripcion", query = "SELECT d FROM DrtDirectorioClase d WHERE d.descripcion = :descripcion")
    , @NamedQuery(name = "DrtDirectorioClase.findByAbrevia", query = "SELECT d FROM DrtDirectorioClase d WHERE d.abrevia = :abrevia")})
public class DrtDirectorioClase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dclas")
    private Short idDclas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "abrevia")
    private String abrevia;
    @OneToMany( mappedBy = "drtDirectorioClase")
    private List<DrtDirectorio> drtDirectorioList;

    public DrtDirectorioClase() {
    }

    public DrtDirectorioClase(Short idDclas) {
        this.idDclas = idDclas;
    }

    public DrtDirectorioClase(Short idDclas, String nombre, String descripcion, String abrevia) {
        this.idDclas = idDclas;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.abrevia = abrevia;
    }

    public Short getIdDclas() {
        return idDclas;
    }

    public void setIdDclas(Short idDclas) {
        this.idDclas = idDclas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAbrevia() {
        return abrevia;
    }

    public void setAbrevia(String abrevia) {
        this.abrevia = abrevia;
    }

    public List<DrtDirectorio> getDrtDirectorioList() {
        return drtDirectorioList;
    }

    public void setDrtDirectorioList(List<DrtDirectorio> drtDirectorioList) {
        this.drtDirectorioList = drtDirectorioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDclas != null ? idDclas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DrtDirectorioClase)) {
            return false;
        }
        DrtDirectorioClase other = (DrtDirectorioClase) object;
        if ((this.idDclas == null && other.idDclas != null) || (this.idDclas != null && !this.idDclas.equals(other.idDclas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DrtDirectorioClase[ idDclas=" + idDclas + " ]";
    }
    
}
