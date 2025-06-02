package packageprJarras;
//Práctica 2.1 
//María Peinado Toledo 
public class EjemploUsoJarras1 {

	public static void main(String[] args) {
		Jarra jarraA= new Jarra(7);
		Jarra jarraB= new Jarra(4);
		
		jarraA.llenar();
		System.out.println(jarraA.toString()+" , "+jarraB.toString());
		
		jarraB.llenarDesde(jarraA);
		System.out.println(jarraA.toString()+" , "+jarraB.toString());
		
		jarraB.vaciar();
		System.out.println(jarraA.toString()+" , "+jarraB.toString());
		
		jarraB.llenarDesde(jarraA);
		System.out.println(jarraA.toString()+" , "+jarraB.toString());

	}

}
