package datos;

import java.time.LocalDate;

public class Alquiler {
	private int idAlquiler;
	private Propiedad propiedad;
	private LocalDate fechaDesde;
	private LocalDate fechaHasta;
	private int cantidadNoches;

	public Alquiler() {
	}

	public Alquiler(Propiedad propiedad, LocalDate fechaDesde, LocalDate fechaHasta, int cantidadNoches) {
		super();
		this.propiedad = propiedad;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.cantidadNoches = cantidadNoches;
	}

	/*------------------------------------------------------------------------------*/
	
	public int getIdAlquiler() {
		return idAlquiler;
	}

	protected void setIdAlquiler(int idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	public LocalDate getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(LocalDate fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public LocalDate getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(LocalDate fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public int getCantidadNoches() {
		return cantidadNoches;
	}

	public void setCantidadNoches(int cantidadNoches) {
		this.cantidadNoches = cantidadNoches;
	}
	
	/*------------------------------------------------------------------------------*/

	@Override
	public String toString() {
		return "Alquiler [idAlquiler=" + idAlquiler + ", propiedad=" + propiedad + ", cantidadNoches=" + cantidadNoches + "]";
	}

	/*------------------------------------------------------------------------------*/
	
	public double precioFinal() {
		return propiedad.precioPorNoche() * cantidadNoches;
	}
}
