package edu.ieu.proyecto3erParcialGanaderia.servicios;

import java.util.List;

import edu.ieu.proyecto3erParcialGanaderia.entities.Ganadero;

public interface GanaderoService {

	Ganadero findById(Integer id);
    Ganadero findByTipo_de_animal(String tipo_de_animal);
    List<Ganadero> findAll(); 
    boolean isGanadoExist(Ganadero Ganado);
    //create 
    void saveGanado(Ganadero Ganado);
     //update
    void updateGanado(Ganadero Ganado);
    //delete
    void deleteGanadoById(Integer id);
}