package edu.ieu.proyecto3erParcialGanaderia.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ieu.proyecto3erParcialGanaderia.entities.Ganadero;
import edu.ieu.proyecto3erParcialGanaderia.repositorios.GanaderoRepository;


@Service
public class GanaderoServiceImp implements GanaderoService {
	@Autowired
	private GanaderoRepository ganadoDao;

	//buscar por id
	@Override
	public Ganadero findById(Integer id) {
		return ganadoDao.findById( id)
				.orElse(null);
	
	}

	@Override
	public Ganadero findByTipo_de_animal(String tipo_de_animal) {
		return ganadoDao.findByTipo_de_animal(tipo_de_animal);
	
	}


	@Override
	public List<Ganadero> findAll() {
		List<Ganadero> lista = new ArrayList<>();
		ganadoDao.findAll()
			.forEach( lista::add );
		return lista;
	}

	@Override
	public boolean isGanadoExist(Ganadero ganado) {
		return ganadoDao.existsById(ganado.getId() );
	}

	//guardar
	@Override @Transactional
	public void saveGanado(Ganadero ganado) {
		ganadoDao.save(ganado);
		
	}

	//actualizar 
	@Override @Transactional
	public void updateGanado(Ganadero ganado) {
		Ganadero ganadoDb = ganadoDao.findById(ganado.getId() ).orElse(null);
		if(ganadoDb != null) {
			ganadoDb.setTipo_de_animal( ganado.getTipo_de_animal() );
			ganadoDb.setEstado_de_salud( ganado.getEstado_de_salud() );
			ganadoDb.setTipo_de_produccion_de_alimentos( ganado.getTipo_de_produccion_de_alimentos() );			
			ganadoDb.setCosto( ganado.getCosto() );
			ganadoDb.setTiempo_de_produccion( ganado.getTiempo_de_produccion() );
			
			
			ganadoDao.save(ganadoDb);
		}
	}

	

	@Override @Transactional
	public void deleteGanadoById(Integer id) {
		ganadoDao.deleteById( id);	
		
	}
}