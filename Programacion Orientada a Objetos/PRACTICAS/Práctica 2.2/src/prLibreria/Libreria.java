package prLibreria;
import java.util.Arrays;
//Práctica 2.2 
//María Peinado Toledo 
public class Libreria {
	protected static final int CAP_INICIAL=8;
    private int numLibs=0;
    private Libro[]libs;
    
    public Libreria(){
  	  this(CAP_INICIAL);
    }
    
    public Libreria (int cap) {
  	  numLibs=0;
  	  libs = new Libro [cap];
    }
    
    public void addLibro (String a, String t, double p) {
        Libro libro;
        libro = new Libro(a,t,p);
        anyadirLibro(libro);
    }
    
    public void remLibro(String a, String t) {
    	int pos;
    	if(buscarLibro(a,t)!=-1) {
    		pos=buscarLibro(a,t);
    		eliminarLibro(pos);
    	}else {
    		System.out.println("No existe el libro");
    	}
    }
    
    public double getPrecioBase(String a, String t) {
    	 int pos;
    	 if (buscarLibro(a,t)!=-1) {
    		 pos = buscarLibro(a,t);
    		 return libs[pos].getPrecioBase();
   	  	} else {
   	  		return 0;
   	  	}
    }
    
    public double getPrecioFinal(String a, String t) {
    	int pos;
   	 	if (buscarLibro(a,t)!=-1) {
   	 		pos = buscarLibro(a,t);
   	 		return libs[pos].getPrecioFinal();
  	  	} else {
  	  		return 0;
  	  	}
    }
    
    @Override
    
    public String toString() {
  	  	String result = "";
  	  	for (int i=0;i<numLibs;i++) {
  	  		result += "," + libs[i];
  	  	}
  	  	return "[" + result + "]";
    }
    
    protected void anyadirLibro(Libro libro) {
    	int pos;
  	  	pos = buscarLibro(libro.getAutor(),libro.getTitulo());
  	  	if (pos>=0) {
  	  		libs[pos]=libro;
  	  	}else{
  	  		if (numLibs == libs.length) {
  	  			libs = Arrays.copyOf(libs, 2*libs.length);
  	  		}
  		  libs[numLibs] = libro;
  		  numLibs++;
  	  	}
    }
    
    private void eliminarLibro(int ind) {
    	if ((ind>=0)&&(ind<numLibs)) {
  		  libs[ind] = libs[numLibs-1];
  		  libs[numLibs-1]=null;
  		  numLibs--;
  	  	}
    }
    
    private int buscarLibro(String a, String t) {
    	int pos=-1;
  	  	int i=0;
  	  	boolean encontrado=false;
  	  	
  	  	if (numLibs > 0) {
  	  		while ((i<numLibs)&&(encontrado == false)) {
  	  			if ((libs[i].getAutor()==a)&&(libs[i].getTitulo()==t)) {
  				  encontrado = true;
  				  pos = i;
  			  }
  			 i++; 
  		  }
  	  	}
  	  	
  	  	return pos;
    }
    
}
