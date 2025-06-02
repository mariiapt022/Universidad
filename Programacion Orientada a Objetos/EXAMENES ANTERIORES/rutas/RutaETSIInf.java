package rutas;

public class RutaETSIInf extends Ruta {
	public RutaETSIInf(String n) {
		super(n);
	}

	public void agregar(Lugar lugar) {
		super.agregar(lugar);
		recorrido.sort(new OrdenETSIInfUMA());
	}
}
