package rutas;

public class RutasDesdeETSIIng extends Ruta{
	public RutasDesdeETSIIng(String n) {
		super(n);
	}
	
	public void agregar(Lugar lugar) {
		super.agregar(lugar);
		recorrido.sort(new OrdenETSIInfUma());
	}
}
