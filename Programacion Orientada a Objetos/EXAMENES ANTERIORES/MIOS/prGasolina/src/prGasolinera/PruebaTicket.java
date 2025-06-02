package prGasolinera;

import java.util.SortedSet;
import java.util.TreeSet;

public class PruebaTicket {

	public static void main(String[] args) {
		Ticket t1=new Ticket(1,"Teatinos","1111aaa",50,1.40);
		Ticket t2=new Ticket(1,"TEATINOS","1111AAA",45,2.40);
		Ticket t3=new Ticket(2,"Teatinos","2222BBB",50,1.40);
		Ticket t4=new Ticket(1,"Ampliacion","3333CCC",40,1.30);
		
		System.out.println(t1.toString());
		System.out.println(t2.toString());
		boolean comp=t1.equals(t2);
		String res= comp? "":"No ";
		System.out.println(res+"son iguales");
		
		SortedSet<Ticket> tickets =new TreeSet<>();
		tickets.add(t1);
		tickets.add(t2);
		tickets.add(t3);
		tickets.add(t4);
		System.out.println("Tickets ordenador por orden natural:");
		System.out.println(tickets.toString());
		
		tickets=new TreeSet<>(new TicketOrdenAlternativo());
		tickets.add(t1);
		tickets.add(t2);
		tickets.add(t3);
		tickets.add(t4);
		System.out.println("Tickets ordenador por orden alternativo:");
		System.out.println(tickets.toString());
		
		//Ticket t5=new Ticket(1,"Ampliacion","3333CCC",-10,1.30);

	}

}
