package packageprJarras;
//Práctica 2.1 
//María Peinado Toledo 
public class EjemploUsoMesa1 {

	public static void main(String[] args) {
		Mesa Mesa1= new Mesa(7,5);

		Mesa1.llenar(2);
		System.out.println(Mesa1.toString());
		Mesa1.llenarDesde(1);
		System.out.println(Mesa1.toString());
		Mesa1.llenar(2);
		System.out.println(Mesa1.toString());
		Mesa1.llenarDesde(1);
		System.out.println(Mesa1.toString());
		Mesa1.vaciar(1);
		System.out.println(Mesa1.toString());
		Mesa1.llenarDesde(1);
		System.out.println(Mesa1.toString());
		Mesa1.llenar(2);
		System.out.println(Mesa1.toString());
		Mesa1.llenarDesde(1);
		System.out.println(Mesa1.toString());

	}

}
