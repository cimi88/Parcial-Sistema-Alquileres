package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.PropiedadDao;
import datos.Departamento;
import datos.Propiedad;

public class PropiedadABM {
	private static PropiedadABM instancia = null;
	
	public static PropiedadABM getInstance() {
		if(instancia == null) {
			instancia = new PropiedadABM();
		}
		return instancia;
	}
	
	/*------------------------------------------------------------------------------*/
	
	public List<Propiedad> traerPropiedad(){
		return PropiedadDao.getInstance().traerPropiedad();
	}

	public List<Propiedad> traerPropiedad(boolean tieneAscensor) {
		List<Propiedad> lista = new ArrayList<Propiedad>();
		
		for(Propiedad p: PropiedadDao.getInstance().traerPropiedad()) {
			if(p instanceof Departamento && ((Departamento) p).isTieneAscensor() == tieneAscensor) {
				lista.add(p);
			}
		}
		
		return lista;
	}
	
}
