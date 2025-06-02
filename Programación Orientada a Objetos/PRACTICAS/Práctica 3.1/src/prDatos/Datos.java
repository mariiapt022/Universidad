package prDatos;

import java.util.Arrays;

public class Datos {
	private double[] datos=new double[0];
	private String[] errores=new String[0];
	private double min,max;
	
	public Datos(String[] dat,double i, double a) {
		convertirDatos(dat);
		min=i;
		max=a;
	}
	
	private void convertirDatos(String[] dat) {
		double num=0;
		int numDatos=0;
		int numErr=0;
		for(int i=0;i<dat.length;i++) {
			try {
				num=Double.parseDouble(dat[i]);
				datos=Arrays.copyOf(datos, numDatos+1);
				datos[numDatos]=num;
				numDatos++;
			}catch(NumberFormatException e){
				errores=Arrays.copyOf(errores, numErr+1);
				errores[numErr]=dat[i];
				numErr++;
			}
		}
	}
	
	public double calcMedia() throws DatosException{
		double suma=0;
		int cap=0;
		for(int i=0;i<datos.length;i++) {
			if(datos[i]>=min&&datos[i]<=max) {
				suma=suma+datos[i];
				cap++;
			}
		}
		if(cap==0) {
			throw new DatosException("No hay datos en el rango especificado");
		}
		return suma/cap;
	}
	
	public double calcDesvTipica() throws DatosException{
		double suma=0;
		double media=calcMedia();
		int cap=0;
		for(int i=0;i<datos.length;i++) {
			if(datos[i]>=min&&datos[i]<=max) {
				suma=suma+Math.pow(datos[i]-media,2);
				cap++;
			}
		}
		if(cap==0) {
			throw new DatosException("No hay datos en el rango especificado");
		}
		
		return Math.sqrt(suma/cap);
	}
	
	public void setRango(String r) throws DatosException{
		try {
    		int pos = r.indexOf(';');
    		min = Double.parseDouble(r.substring(0, pos));
    	    max = Double.parseDouble(r.substring(pos+1));
    	    if (min > max) throw new DatosException("El mínimo tiene que ser menor o igual que el máximo");
    	} catch (IndexOutOfBoundsException e) {
    		throw new DatosException("Error en los datos al establecer el rango");
    	} catch (NumberFormatException e) {
    		throw new DatosException("Error en los datos al establecer el rango");
    	}
	}
	
	public double[] getDatos() {
		return datos;
	}
	
	public String[] getErrores() {
		return errores;
	}
	
	@Override
	public String toString() {
		try {
			return "Min: "+min+", Max: "+max+Arrays.toString(datos)+", "+Arrays.toString(errores)+" Media: "+calcMedia()+", DesvTipica: "+calcDesvTipica();
		}catch(DatosException e) {
			return "Min: "+min+" Max: "+max+", "+Arrays.toString(datos)+", "+Arrays.toString(errores)+", Media: ERROR, DesvTipica: ERROR";
		}
	}
	
	
}
