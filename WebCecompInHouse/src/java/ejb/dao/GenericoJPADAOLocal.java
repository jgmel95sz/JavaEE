package ejb.dao;

import javax.persistence.EntityManager;

abstract interface GenericoJPADAOLocal<T> {
    T crear(T entidad);
    T actualizar(T entidad);
    void eliminar(T entidad);
    T buscarPorId(Object id);
}
