package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.AlquilerDao;
import datos.Alquiler;

public class AlquilerABM {
	private static AlquilerABM instancia = null;

	protected AlquilerABM() {
	}

	public static AlquilerABM getInstance() {
		if (instancia == null) {
			instancia = new AlquilerABM();
		}
		return instancia;
	}

	/*------------------------------------------------------------------------------*/

	public Alquiler traerAlquiler(int id) {
		return AlquilerDao.getInstance().traerAlquiler(id);
	}

	public double calcularPrecioFinal(Alquiler alquiler) {
		return alquiler.precioFinal();
	}

	public double calcularPrecioFinal(LocalDate desde, LocalDate hasta) {
		double precioFinal = 0;
		
		for(Alquiler a: traerAlquileres()) {
			if(estaEntre(a, desde, hasta)) {
				precioFinal += a.precioFinal();
			}
		}
		return precioFinal;
	}

	public List<Alquiler> traerAlquileres() {
		return AlquilerDao.getInstance().traerAlquileres();
	}
	
	private boolean estaEntre(Alquiler a, LocalDate desde, LocalDate hasta) {
		return a.getFechaDesde().isEqual(desde) || a.getFechaDesde().isAfter(desde) &&
				   a.getFechaHasta().isEqual(hasta) || a.getFechaHasta().isBefore(hasta);
	}
}
