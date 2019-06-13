/*
 * Sirve para poder traer dos parametros para validar en Vista exonerados
 * 
 */
package clases;

import entidades.DrtPersonanatural;

/**
 *
 * @author Melvin
 */
public class trazaMsg {
   
   private DrtPersonanatural drtPersonanatural;
   private Integer tipoAlumno ;

    public trazaMsg(DrtPersonanatural drtPersonanatural, Integer tipoAlumno) {
        this.drtPersonanatural = drtPersonanatural;
        this.tipoAlumno = tipoAlumno;
    }

    public DrtPersonanatural getDrtPersonanatural() {
        return drtPersonanatural;
    }

    public void setDrtPersonanatural(DrtPersonanatural drtPersonanatural) {
        this.drtPersonanatural = drtPersonanatural;
    }

    public Integer getTipoAlumno() {
        return tipoAlumno;
    }

    public void setTipoAlumno(Integer tipoAlumno) {
        this.tipoAlumno = tipoAlumno;
    }
   
   
   
   
}
