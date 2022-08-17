package com.portfolio.backend.service;

import java.util.List;

import com.portfolio.backend.entity.Proyecto;

public interface IProyectoService {

    public void saveProyecto(Proyecto proyecto);

    public void deleteProyecto(int id);

    public List<Proyecto> traerProyectos();

    public Proyecto traerProyectoPorId(int id);

}