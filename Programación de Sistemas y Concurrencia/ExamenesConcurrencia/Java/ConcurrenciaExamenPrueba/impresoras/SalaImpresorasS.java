package impresoras;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SalaImpresorasS implements SalaImpresoras {

    private int N;
    private int nImpRes;
    private int idImp = 0;
    private boolean esperando = false;
    private List<Integer> impresoras = new ArrayList<>();
    private Semaphore mutex = new Semaphore(1, true);
    private Semaphore turno = new Semaphore(1, true);
    private Semaphore cogeImp = new Semaphore(0, true);

    public SalaImpresorasS(int nImp){
        this.N = nImp;
        nImpRes = nImp;
        for (int i = 0; i < N; i++) {
            impresoras.add(1);
        }
    }
    
    public int quieroImpresora(int id) throws InterruptedException{

        System.out.println("Cliente " + id + " quiere impresora.");

        turno.acquire();
        mutex.acquire();

        if (impresoras.contains(1)) {
            cogeImp.release();
        }else{
            esperando = true;
        }

        mutex.release();

        cogeImp.acquire();
        mutex.acquire();

        esperando = false;
        idImp = impresoras.indexOf(1);
        nImpRes --;
        impresoras.set(idImp, 0);
        System.out.println("Cliente " + id + " coge impresora " + idImp + " quedan libres " + nImpRes + ".");

        mutex.release();
        turno.release();

        return idImp;
    }

    public void devuelvoImpresora(int id, int n) throws InterruptedException{

        mutex.acquire();

        nImpRes ++;
        System.out.println("Cliente " + id + " devuelve la impresora " + n + " quedan libres " + nImpRes + ".");
        impresoras.set(n, 1);
        if (esperando) {
            cogeImp.release();
        }

        mutex.release();
    }

}
