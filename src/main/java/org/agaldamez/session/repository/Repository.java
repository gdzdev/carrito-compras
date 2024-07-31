package org.agaldamez.session.repository;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {

    List<T> listar() throws SQLException;

    T porId(Long id) throws SQLException;

    void guardar(T t) throws SQLException;

    void actualizar(T t) throws SQLException;

    void eliminar(Long id) throws SQLException;
}