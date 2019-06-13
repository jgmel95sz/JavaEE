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
@Table(name = "psp_aplicacion")
@NamedQueries({
    @NamedQuery(name = "PspAplicacion.findAll", query = "SELECT p FROM PspAplicacion p")
    , @NamedQuery(name = "PspAplicacion.findByPspApp", query = "SELECT p FROM PspAplicacion p WHERE p.pspApp = :pspApp")
    , @NamedQuery(name = "PspAplicacion.findByNombre", query = "SELECT p FROM PspAplicacion p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "PspAplicacion.findByEtiqueta", query = "SELECT p FROM PspAplicacion p WHERE p.etiqueta = :etiqueta")
    , @NamedQuery(name = "PspAplicacion.findByStdApp", query = "SELECT p FROM PspAplicacion p WHERE p.stdApp = :stdApp")
    , @NamedQuery(name = "PspAplicacion.findByPwd", query = "SELECT p FROM PspAplicacion p WHERE p.pwd = :pwd")
    , @NamedQuery(name = "PspAplicacion.findByRequerirDep", query = "SELECT p FROM PspAplicacion p WHERE p.requerirDep = :requerirDep")})
public class PspAplicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "psp_app")
    private Short pspApp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "etiqueta")
    private String etiqueta;
    @Column(name = "std_app")
    private Short stdApp;
    @Size(max = 50)
    @Column(name = "pwd")
    private String pwd;
    @Column(name = "requerir_dep")
    private Short requerirDep;
    @OneToMany(mappedBy = "pspAplicacion")
    private List<PspUserapp> pspUserappList;

    public PspAplicacion() {
    }

    public PspAplicacion(Short pspApp) {
        this.pspApp = pspApp;
    }

    public PspAplicacion(Short pspApp, String nombre, String etiqueta) {
        this.pspApp = pspApp;
        this.nombre = nombre;
        this.etiqueta = etiqueta;
    }

    public Short getPspApp() {
        return pspApp;
    }

    public void setPspApp(Short pspApp) {
        this.pspApp = pspApp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Short getStdApp() {
        return stdApp;
    }

    public void setStdApp(Short stdApp) {
        this.stdApp = stdApp;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Short getRequerirDep() {
        return requerirDep;
    }

    public void setRequerirDep(Short requerirDep) {
        this.requerirDep = requerirDep;
    }

    public List<PspUserapp> getPspUserappList() {
        return pspUserappList;
    }

    public void setPspUserappList(List<PspUserapp> pspUserappList) {
        this.pspUserappList = pspUserappList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pspApp != null ? pspApp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PspAplicacion)) {
            return false;
        }
        PspAplicacion other = (PspAplicacion) object;
        if ((this.pspApp == null && other.pspApp != null) || (this.pspApp != null && !this.pspApp.equals(other.pspApp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PspAplicacion[ pspApp=" + pspApp + " ]";
    }
    
}
