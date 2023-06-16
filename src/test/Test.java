package test;

import java.time.LocalDate;
import java.util.List;

import negocio.*;
import datos.*;

public class Test {

	public static void main(String[] args) {
		
		List<Propiedad> propiedad = PropiedadABM.getInstance().traerPropiedad();
		Alquiler alquiler = AlquilerABM.getInstance().traerAlquiler(1);
		LocalDate fechaDesde = LocalDate.of(2022, 03, 2);
		LocalDate fechaHasta = LocalDate.of(2022, 03, 9);

		System.out.println("1)");
		System.out.println(propiedad);

		System.out.println("\n2)");
		System.out.println(alquiler);
		
		System.out.println("\n3)");
		System.out.println(PropiedadABM.getInstance().traerPropiedad(true));
		
		System.out.println("\n4)");
		System.out.println(AlquilerABM.getInstance().calcularPrecioFinal(alquiler));
		
		System.out.println("\n5)");
		System.out.println(AlquilerABM.getInstance().calcularPrecioFinal(fechaDesde, fechaHasta));
		
	}
	
}