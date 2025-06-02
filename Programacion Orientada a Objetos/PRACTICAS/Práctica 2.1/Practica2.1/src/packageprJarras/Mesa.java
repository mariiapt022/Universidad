package packageprJarras;
//Práctica 2.1 
//María Peinado Toledo 
public class Mesa {
	  private Jarra Jarra1;
	  private Jarra Jarra2;
	 
	  public Mesa(int c1, int c2) {
		  Jarra1 = new Jarra(c1);
		  Jarra2 = new Jarra(c2);
	  }
	  
	  public Mesa(Jarra j1, Jarra j2) {
		  if(j1==j2) {
			  throw new RuntimeException("Ambas jarras son la misma");
		  }
		  Jarra1 = j1;
		  Jarra2 = j2;
	  }
	 
	   public int contenido (int id) {
		   int c;
		   if (id==1) {
			   c = Jarra1.getContenido();
		   }else if (id==2) {
			   c = Jarra2.getContenido();
		   }else {
			   throw new RuntimeException("Identificador no válido");
		   }
		   return c;
	   }
	   
	   public int capacidad (int id) {
		   int c;
		   if (id==1) {
			   	c = Jarra1.getCapacidad();
		   }else if (id==2) {
			   c = Jarra2.getCapacidad();
		   }else {
			   throw new RuntimeException("Identificador no válido");
		   }
		   return c;
	   }
	   
	   public void llenar (int id) {
		   if (id==1) {
			   Jarra1.llenar();
		   }else if (id==2) {
			   Jarra2.llenar();
		   }else {
			   throw new RuntimeException("Identificador no válido");
		   }
	   }
	   
	   public void vaciar (int id) {
		   if (id==1) {
			   Jarra1.vaciar();
		   }else if (id==2) {
			   Jarra2.vaciar();
		   }else {
			   throw new RuntimeException("Identificador no válido");
		   }
	   }
	   
	   public void llenarDesde (int id) {
		   if (id==1) {
			   Jarra1.llenarDesde(Jarra2);
		   }else if (id==2) {
			   Jarra2.llenarDesde(Jarra1);
		   }else {
			   throw new RuntimeException("Identificador no válido");
		   }
	   }
	   
	   public String toString () {
		   return "M(J("+Jarra1.getCapacidad()+","+ Jarra1.getContenido()+"),J("+Jarra2.getCapacidad()+","+ Jarra2.getContenido()+"))";
	   }
	}
