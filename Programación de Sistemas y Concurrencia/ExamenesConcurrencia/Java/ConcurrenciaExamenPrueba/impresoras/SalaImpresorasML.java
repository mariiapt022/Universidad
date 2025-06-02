package impresoras;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SalaImpresorasML implements SalaImpresoras {

    // private int N;
    // private int nImpRes;
    // private int idImp = 0;
    // private ReentrantLock l = new ReentrantLock();
    // private Condition okTurno = l.newCondition();
    // private Condition okImpresora = l.newCondition();
    // private List<Integer> impresoras = new ArrayList<>();
    // private List<Integer> clientes = new LinkedList<>();
    // private boolean esperando = false;

    // public SalaImpresorasML(int nImp){
    //     this.N = nImp;
    //     nImpRes = nImp;
    //     for (int i = 0; i < N; i++) {
    //         impresoras.add(1);
    //     }
    // }
    
    // public int quieroImpresora(int id) throws InterruptedException{

    //     l.lock();

    //     try{

    //         clientes.add(id);
    //         System.out.println("Cliente " + id + " quiere impresora.");
            
    //         while(clientes.get(0) != id){
    //             okTurno.await();
    //         }

    //         while(!impresoras.contains(1)){
    //             esperando = true;
    //             okImpresora.await();
    //         }

    //         esperando = false;

    //         idImp = impresoras.indexOf(1);
    //         impresoras.set(idImp, 0);
    //         nImpRes --;
    //         clientes.remove(0);

    //         System.out.println("Cliente " + id + " coge impresora " + idImp + " quedan libres " + nImpRes + ".");

    //         if (clientes.size() > 0) {
    //             okTurno.signalAll();
    //         }

    //     }finally{
    //         l.unlock();
    //     }

    //     return idImp;
    // }

    // public void devuelvoImpresora(int id, int n) throws InterruptedException{
        
    //     l.lock();

    //     try{

    //         impresoras.set(n, 1);
    //         nImpRes ++;
    //         System.out.println("Cliente " + id + " devuelve la impresora " + n + " quedan libres " + nImpRes + ".");
    //         if (esperando) {
    //             okImpresora.signal();
    //         }else if(clientes.size() > 0){
    //             okTurno.signalAll();
    //         }

    //     }finally{
    //         l.unlock();
    //     }

    // }

    private int N;
    private int nImpRes;
    private int idImp = 0;
    private ReentrantLock l = new ReentrantLock();
    private Condition okTurno = l.newCondition();
    private Condition okImpresora = l.newCondition();
    private List<Integer> impresoras = new LinkedList<>();
    private List<Integer> clientes = new LinkedList<>();
    private boolean esperando = false;

    public SalaImpresorasML(int nImp){
        this.N = nImp;
        nImpRes = nImp;
        for (int i = 0; i < N; i++) {
            impresoras.add(i);
        }
    }
    
    public int quieroImpresora(int id) throws InterruptedException{

        l.lock();

        try{

            clientes.add(id);
            System.out.println("Cliente " + id + " quiere impresora.");
            
            while(clientes.get(0) != id){
                okTurno.await();
            }

            while(impresoras.size() == 0){
                esperando = true;
                okImpresora.await();
            }

            esperando = false;

            idImp = impresoras.get(0);
            impresoras.remove(0);
            nImpRes --;
            clientes.remove(0);

            System.out.println("Cliente " + id + " coge impresora " + idImp + " quedan libres " + nImpRes + ".");

            if (clientes.size() > 0) {
                okTurno.signalAll();
            }

        }finally{
            l.unlock();
        }

        return idImp;
    }

    public void devuelvoImpresora(int id, int n) throws InterruptedException{
        
        l.lock();

        try{

            impresoras.add(n);
            nImpRes ++;
            System.out.println("Cliente " + id + " devuelve la impresora " + n + " quedan libres " + nImpRes + ".");
            if (esperando) {
                okImpresora.signal();
            }else if(clientes.size() > 0){
                okTurno.signalAll();
            }

        }finally{
            l.unlock();
        }

    }

}
