package edu.ieu.proyecto3erParcialGanaderia.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.ieu.proyecto3erParcialGanaderia.entities.Ganadero;

public interface GanaderoRepository extends CrudRepository<Ganadero, Integer> {
	@Query("SELECT ganado FROM Ganadero ganado WHERE ganado.tipo_de_animal = ?1  ")
	public  Ganadero findByTipo_de_animal(String tipo_de_animal);
}
