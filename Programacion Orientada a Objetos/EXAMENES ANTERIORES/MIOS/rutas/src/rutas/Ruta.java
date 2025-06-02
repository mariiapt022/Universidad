package rutas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ruta {
	private String nombre;
	protected List<Lugar> recorrido;
	
	public Ruta(String n) {
		nombre=n;
		recorrido=new ArrayList<>();
	}
	
	public void agregar(Lugar lugar) {
		if(lugar==null) {
			throw new RutasException("Lugar nulo para introducir");
		}else {
			recorrido.add(lugar);
		}
	}
	
	public void agregarLugares(String nomFich) throws FileNotFoundException {
		Scanner sc=new Scanner(new File(nomFich));
		agregarLugares(sc);
		sc.close();
	}
	
	public void agregarLugares(Scanner sc) {
		while(sc.hasNextLine()) {
			String linea=sc.nextLine();
			try(Scanner scl=new Scanner(linea)){
				scl.useDelimiter("[@:]+");
				String nombre=scl.next();
				double la=scl.nextDouble();
				double lo=scl.nextDouble();
				Lugar lugar=new Lugar(nombre,la,lo);
				agregar(lugar);
			}catch (InputMismatchException ime) {
				throw new RutasException("Se espera un dato num√©rico en la l√≠nea: " + linea);
			} catch (NoSuchElementException nsee) {
				throw new RutasException("Se esperaban m√°s datos en la l√≠nea: " + linea);
			} catch (RutasException re) {
				throw new RutasException("Los datos geoposicionales no est√°n en el rango en la l√≠nea: " + linea);
			}
		}
	}
	
	public String getNombreRuta() {
		return nombre;
	}
	
	public Lugar origen() {
		if(recorrido.isEmpty()) {
			throw new RutasException("ColecciÛn vacÌa");
		}else {
			return recorrido.get(0);
		}
	}
	
	public Lugar destino() {
		if(recorrido.isEmpty()) {
			throw new RutasException("ColecciÛn vacÌa");
		}else {
			return recorrido.get(recorrido.size()-1);
		}
	}
	
	public boolean estaEnRuta(Lugar lugar) {
		return recorrido.contains(lugar);
	}
	
	public double distanciaRuta() {
		if(recorrido.isEmpty()) {
			throw new RutasException("Distancia de la ruta vacia");
		}else {
			double suma=0;
			for(int i=0;i<recorrido.size()-1;i++) {
				suma=suma+recorrido.get(i+1).distancia(recorrido.get(i));
			}
			return suma;
		}
	}
	
	public void guardarRuta(String nomFich) throws FileNotFoundException {
		PrintWriter pw=new PrintWriter(nomFich);
		guardarRuta(pw);
	}
	
	public void guardarRuta(PrintWriter pw) {
		pw.println(nombre.toUpperCase()+"\n");
		for(Lugar l:recorrido) {
			pw.println(l.toString()+"\n");
		}
	}
	
	
	
}
