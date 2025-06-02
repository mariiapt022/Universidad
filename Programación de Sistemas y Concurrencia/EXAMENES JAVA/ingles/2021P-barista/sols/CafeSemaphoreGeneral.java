package solution.june2021.psc.uma.es;

import java.util.concurrent.Semaphore;
import june2021.psc.uma.es.Cafe;

public class CafeSemaphoreGeneral extends Cafe
{
    Semaphore mayComeIn;
    Semaphore thereAreClients;
    Semaphore waitCoffee;
    Semaphore waitPayment;
    
    public CafeSemaphoreGeneral() {
        this.mayComeIn = new Semaphore(5, true);
        this.waitCoffee = new Semaphore(0, true);
        this.waitPayment = new Semaphore(0, true);
        this.thereAreClients = new Semaphore(0, true);
    }
    
    public void enterCafe(final int id) throws InterruptedException {
        this.mayComeIn.acquire();
        ++this.currentClientsNum;
        this.thereAreClients.release();
        System.out.println("Client " + id + " enters. Num. clients " + this.currentClientsNum);
    }
    
    public void waitCoffee(final int id) throws InterruptedException {
        this.waitCoffee.acquire();
        System.out.println("Client " + id + " drinks a coffee");
    }
    
    public void payAndExitCafe(final int id) throws InterruptedException {
        --this.currentClientsNum;
        System.out.println("Client " + id + " pays and exits. Num. clients " + this.currentClientsNum);
        this.waitPayment.release();
        this.mayComeIn.release();
    }
    
    public void prepareCoffee() throws InterruptedException {
        this.thereAreClients.acquire();
        System.out.println("Coffee ready - waiting the money");
        this.waitCoffee.release();
        this.waitPayment.acquire();
    }
}