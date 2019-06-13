package ejb.dao;

import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

abstract class  GenericoJPADAO<T> implements GenericoJPADAOLocal<T> {
    @PersistenceContext(unitName = "WebCecompInHousePU")
    EntityManager em;
    
    @Override
    public T crear(T entidad) {
       em.persist(entidad); // Crea una nueva tupla en la BD con los datos de "entidad"
                            // -> ademas genera su ID
       return entidad;
    }
    @Override
    public T actualizar(T entidad) {
        entidad=em.merge(entidad);   // Actualiza los datos de "entidad" en su correspondiente tupla BD
       return entidad;
    }
    @Override
    public void eliminar(T entidad) {
        em.remove(em.merge(entidad));  // Actualiza y elimina
    }
    @Override
    public T buscarPorId(Object id) {
        Class<T> claseEntidad = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
                             // Identifica la clase real de las entidades gestionada por este objeto (T.class)
        return em.find(claseEntidad, id);
    }
}
