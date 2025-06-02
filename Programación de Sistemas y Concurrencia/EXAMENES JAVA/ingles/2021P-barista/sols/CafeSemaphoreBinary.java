package solution.june2021.psc.uma.es;

import java.util.concurrent.Semaphore;
import june2021.psc.uma.es.Cafe;

public class CafeSemaphoreBinary extends Cafe
{
    Semaphore mutex;
    Semaphore mayComeIn;
    Semaphore thereAreClients;
    Semaphore waitCoffe;
    Semaphore waitPayment;
    
    public CafeSemaphoreBinary() {
        this.currentClientsNum = 0;
        this.mutex = new Semaphore(1, true);
        this.mayComeIn = new Semaphore(1, true);
        this.waitCoffe = new Semaphore(0, true);
        this.waitPayment = new Semaphore(0, true);
        this.thereAreClients = new Semaphore(0, true);
    }
    
    public void enterCafe(final int id) throws InterruptedException {
        this.mayComeIn.acquire();
        this.mutex.acquire();
        ++this.currentClientsNum;
        if (this.currentClientsNum < 5) {
            this.mayComeIn.release();
        }
        if (this.currentClientsNum == 1) {
            this.thereAreClients.release();
        }
        System.out.println("Client " + id + " enters. Num. clients " + this.currentClientsNum);
        this.mutex.release();
    }
    
    public void waitCoffee(final int id) throws InterruptedException {
        this.waitCoffe.acquire();
        System.out.println("Client " + id + " drinks a coffee");
    }
    
    public void payAndExitCafe(final int id) throws InterruptedException {
        this.mutex.acquire();
        this.waitPayment.release();
        --this.currentClientsNum;
        if (this.currentClientsNum == 4) {
            this.mayComeIn.release();
        }
        System.out.println("Client " + id + " pays and exits. Num. clients " + this.currentClientsNum);
        this.mutex.release();
    }
    
    public void prepareCoffee() throws InterruptedException {
        this.thereAreClients.acquire();
        this.waitCoffe.release();
        System.out.println("Coffee ready - waiting the money");
        this.waitPayment.acquire();
        this.mutex.acquire();
        if (this.currentClientsNum > 0) {
            this.thereAreClients.release();
        }
        this.mutex.release();
    }
}