package com.comfeco.demo.service;

import java.util.List;

public interface ICRUD<T, V> {

    T registrar(T obj);
    T modificar(T obj);
    List<T> listar();
    T listarPorId(V v);
    void eliminar(V v);
}
