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
import javax.persistence.GeneratedValue;
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
@Table(name = "cep_cec_curso_cab")
@NamedQueries({
    @NamedQuery(name = "CepCecCursoCab.findAll", query = "SELECT c FROM CepCecCursoCab c")
    , @NamedQuery(name = "CepCecCursoCab.findByIdCursoCab", query = "SELECT c FROM CepCecCursoCab c WHERE c.idCursoCab = :idCursoCab")
    , @NamedQuery(name = "CepCecCursoCab.findByNomCurso", query = "SELECT c FROM CepCecCursoCab c WHERE c.nomCurso = :nomCurso")
    , @NamedQuery(name = "CepCecCursoCab.findByEstadoCabcur", query = "SELECT c FROM CepCecCursoCab c WHERE c.estadoCabcur = :estadoCabcur")})
public class CepCecCursoCab implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_curso_cab")
    @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idCursoCab;
    @Size(max = 100)
    @Column(name = "nom_curso")
    private String nomCurso;
    @Column(name = "estado_cabcur")
    private Short estadoCabcur;
    @OneToMany(mappedBy = "cepCecCursoCab")
    private List<CepCecCursoDet> cepCecCursoDetList;

    public CepCecCursoCab() {
    }

    public CepCecCursoCab(Integer idCursoCab) {
        this.idCursoCab = idCursoCab;
    }

    public Integer getIdCursoCab() {
        return idCursoCab;
    }

    public void setIdCursoCab(Integer idCursoCab) {
        this.idCursoCab = idCursoCab;
    }

    public String getNomCurso() {
        return nomCurso;
    }

    public void setNomCurso(String nomCurso) {
        this.nomCurso = nomCurso;
    }

    public Short getEstadoCabcur() {
        return estadoCabcur;
    }

    public void setEstadoCabcur(Short estadoCabcur) {
        this.estadoCabcur = estadoCabcur;
    }

    public List<CepCecCursoDet> getCepCecCursoDetList() {
        return cepCecCursoDetList;
    }

    public void setCepCecCursoDetList(List<CepCecCursoDet> cepCecCursoDetList) {
        this.cepCecCursoDetList = cepCecCursoDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCursoCab != null ? idCursoCab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepCecCursoCab)) {
            return false;
        }
        CepCecCursoCab other = (CepCecCursoCab) object;
        if ((this.idCursoCab == null && other.idCursoCab != null) || (this.idCursoCab != null && !this.idCursoCab.equals(other.idCursoCab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepCecCursoCab[ idCursoCab=" + idCursoCab + " ]";
    }
    
}
