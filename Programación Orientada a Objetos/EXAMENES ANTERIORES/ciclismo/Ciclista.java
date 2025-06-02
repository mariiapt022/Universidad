
public class Ciclista {
	private String nombre;
	private String equipo;
	private int dorsal;
	public Ciclista(String nombre, String equipo, int dorsal) {
		super();
		this.nombre = nombre;
		this.equipo = equipo;
		this.dorsal = dorsal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	@Override
	public String toString() {
		return "Ciclista [nombre=" + nombre + ", equipo=" + equipo
				+ ", dorsal=" + dorsal + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dorsal;
		result = prime * result + ((equipo == null) ? 0 : equipo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ciclista other = (Ciclista) obj;
		if (dorsal != other.dorsal)
			return false;
		if (equipo == null) {
			if (other.equipo != null)
				return false;
		} else if (!equipo.equals(other.equipo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}
