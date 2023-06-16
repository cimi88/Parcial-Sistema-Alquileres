package datos;

public class Casa extends Propiedad {
	private boolean tienePatio;

	public Casa() {
	}

	public Casa(double precioBase, String direccion, boolean tienePatio) {
		super(precioBase, direccion);
		this.tienePatio = tienePatio;
	}

	/*------------------------------------------------------------------------------*/
	
	public boolean isTienePatio() {
		return tienePatio;
	}

	public void setTienePatio(boolean tienePatio) {
		this.tienePatio = tienePatio;
	}

	/*------------------------------------------------------------------------------*/
	
	@Override
	public double precioPorNoche() {
		double precio = precioBase;
		if(isTienePatio()) {
			precio = precioBase + (precioBase * 0.1);
		}
		return precio;
	}

	/*------------------------------------------------------------------------------*/
	
	@Override
	public String toString() {
		return "Casa [tienePatio=" + tienePatio + "]";
	}

}
