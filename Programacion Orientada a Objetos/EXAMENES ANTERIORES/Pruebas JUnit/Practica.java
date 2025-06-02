
package practicas;

public class Practica implements Comparable<Practica> {
    private final String nombre;
    private final String descripcion;
    private int cntRealizadas;
    private int cntExito;
	
    public Practica(String n, String d) {
		this(n, d, 0, 0);
	}
    public Practica(String n, String d, int t, int e) {
		if (n == null || n.length() == 0 || d == null || d.length() == 0 || t < 0 || e < 0) {
			throw new AppException("Argumentos erroneos");
		}
		nombre = n;
		descripcion = d;
		cntRealizadas = t;
		cntExito = e;
    }
    public String getNombre() {
		return nombre;
    }
    public String getDescripcion() {
		return descripcion;
    }
    public int getCntRealizadas() {
		return cntRealizadas;
    }
    public int getCntExito() {
		return cntExito;
    }
    public void setCntRealizadas(int v) {
		if (v < 0) {
			throw new AppException("Cuenta negativa");
		}
		cntRealizadas = v;
    }
    public void setCntExito(int v) {
		if (v < 0) {
			throw new AppException("Cuenta negativa");
		}
		cntExito = v;
    }
    public int getPorcExito() {
		int p = 0;
		if (getCntRealizadas() > 0) {
			p = 100 * getCntExito() / getCntRealizadas(); 
		}
		return p;
    }
	@Override
    public String toString() {
		return "(" + getNombre()
			+ ", " + getDescripcion()
			+ ", " + getCntRealizadas()
			+ ", " + getCntExito()
			+ ", " + getPorcExito()
			+ "%)";
    }
	@Override
    public boolean equals(Object o) {
		boolean ok = false;
		if (o instanceof Practica) {
			Practica other = (Practica)o;
			ok = this.getNombre().equalsIgnoreCase(other.getNombre())
				&& this.getDescripcion().equalsIgnoreCase(other.getDescripcion());
		}
		return ok;
    }
	@Override
    public int hashCode() {
		return getNombre().toLowerCase().hashCode()
			+ getDescripcion().toLowerCase().hashCode();
    }
	@Override
    public int compareTo(Practica m) {
		int c = this.getNombre().compareToIgnoreCase(m.getNombre());
		if (c == 0) {
			c = this.getDescripcion().compareToIgnoreCase(m.getDescripcion());
		}
		return c;
    }
}
