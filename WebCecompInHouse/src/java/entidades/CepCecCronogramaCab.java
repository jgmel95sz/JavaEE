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

/**
 *
 * @author Melvin
 */
@Entity
@Table(name = "cep_cec_cronograma_cab")
@NamedQueries({
    @NamedQuery(name = "CepCecCronogramaCab.findAll", query = "SELECT c FROM CepCecCronogramaCab c")
    , @NamedQuery(name = "CepCecCronogramaCab.findByIdCronogramaCab", query = "SELECT c FROM CepCecCronogramaCab c WHERE c.idCronogramaCab = :idCronogramaCab")
    , @NamedQuery(name = "CepCecCronogramaCab.findByNumPago", query = "SELECT c FROM CepCecCronogramaCab c WHERE c.numPago = :numPago")
    , @NamedQuery(name = "CepCecCronogramaCab.findByEstadoCroCab", query = "SELECT c FROM CepCecCronogramaCab c WHERE c.estadoCroCab = :estadoCroCab")})
public class CepCecCronogramaCab implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cronograma_cab")
    @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idCronogramaCab;
    @Column(name = "num_pago")
    private Integer numPago;
    @Column(name = "estado_cro_cab")
    private Short estadoCroCab;
    @JoinColumn(name = "id_cur_grup", referencedColumnName = "id_cur_grup")
    @ManyToOne
    private CepCecCurGrup cepCecCurGrup;
    @OneToMany(mappedBy = "cepCecCronogramaCab")
    private List<CepCecCronogramaDet> cepCecCronogramaDetList;

    public CepCecCronogramaCab() {
    }

    public CepCecCronogramaCab(Integer idCronogramaCab) {
        this.idCronogramaCab = idCronogramaCab;
    }

    public Integer getIdCronogramaCab() {
        return idCronogramaCab;
    }

    public void setIdCronogramaCab(Integer idCronogramaCab) {
        this.idCronogramaCab = idCronogramaCab;
    }

    public Integer getNumPago() {
        return numPago;
    }

    public void setNumPago(Integer numPago) {
        this.numPago = numPago;
    }

    public Short getEstadoCroCab() {
        return estadoCroCab;
    }

    public void setEstadoCroCab(Short estadoCroCab) {
        this.estadoCroCab = estadoCroCab;
    }

    public CepCecCurGrup getCepCecCurGrup() {
        return cepCecCurGrup;
    }

    public void setCepCecCurGrup(CepCecCurGrup cepCecCurGrup) {
        this.cepCecCurGrup = cepCecCurGrup;
    }

    public List<CepCecCronogramaDet> getCepCecCronogramaDetList() {
        return cepCecCronogramaDetList;
    }

    public void setCepCecCronogramaDetList(List<CepCecCronogramaDet> cepCecCronogramaDetList) {
        this.cepCecCronogramaDetList = cepCecCronogramaDetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCronogramaCab != null ? idCronogramaCab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepCecCronogramaCab)) {
            return false;
        }
        CepCecCronogramaCab other = (CepCecCronogramaCab) object;
        if ((this.idCronogramaCab == null && other.idCronogramaCab != null) || (this.idCronogramaCab != null && !this.idCronogramaCab.equals(other.idCronogramaCab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepCecCronogramaCab[ idCronogramaCab=" + idCronogramaCab + " ]";
    }
    
}
