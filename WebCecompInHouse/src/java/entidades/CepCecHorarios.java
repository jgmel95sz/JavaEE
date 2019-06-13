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
@Table(name = "cep_cec_horarios")
@NamedQueries({
    @NamedQuery(name = "CepCecHorarios.findAll", query = "SELECT c FROM CepCecHorarios c")
    , @NamedQuery(name = "CepCecHorarios.findByIdHorario", query = "SELECT c FROM CepCecHorarios c WHERE c.idHorario = :idHorario")
    , @NamedQuery(name = "CepCecHorarios.findByEstadoHorario", query = "SELECT c FROM CepCecHorarios c WHERE c.estadoHorario = :estadoHorario")
    , @NamedQuery(name = "CepCecHorarios.findByHoraIni", query = "SELECT c FROM CepCecHorarios c WHERE c.horaIni = :horaIni")
    , @NamedQuery(name = "CepCecHorarios.findByHoraFin", query = "SELECT c FROM CepCecHorarios c WHERE c.horaFin = :horaFin")})
public class CepCecHorarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_horario")
    @GeneratedValue( generator = "generador_siigaa" )
    @org.hibernate.annotations.GenericGenerator(name = "generador_siigaa",strategy = "increment")
    private Integer idHorario;
    @Column(name = "estado_horario")
    private Short estadoHorario;
    @Column(name = "hora_ini")
    @Temporal(TemporalType.TIME)
    private Date horaIni;
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @JoinColumn(name = "id_cur_grup", referencedColumnName = "id_cur_grup")
    @ManyToOne(optional = false)
    private CepCecCurGrup cepCecCurGrup;
    @JoinColumn(name = "id_horario_dias", referencedColumnName = "id_horario_dias")
    @ManyToOne(optional = false)
    private CepHorarioDias cepHorarioDias;

    public CepCecHorarios() {
    }

    public CepCecHorarios(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Short getEstadoHorario() {
        return estadoHorario;
    }

    public void setEstadoHorario(Short estadoHorario) {
        this.estadoHorario = estadoHorario;
    }

    public Date getHoraIni() {
        return horaIni;
    }

    public void setHoraIni(Date horaIni) {
        this.horaIni = horaIni;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public CepCecCurGrup getCepCecCurGrup() {
        return cepCecCurGrup;
    }

    public void setCepCecCurGrup(CepCecCurGrup cepCecCurGrup) {
        this.cepCecCurGrup = cepCecCurGrup;
    }

    public CepHorarioDias getCepHorarioDias() {
        return cepHorarioDias;
    }

    public void setCepHorarioDias(CepHorarioDias cepHorarioDias) {
        this.cepHorarioDias = cepHorarioDias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHorario != null ? idHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CepCecHorarios)) {
            return false;
        }
        CepCecHorarios other = (CepCecHorarios) object;
        if ((this.idHorario == null && other.idHorario != null) || (this.idHorario != null && !this.idHorario.equals(other.idHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CepCecHorarios[ idHorario=" + idHorario + " ]";
    }
    
}
