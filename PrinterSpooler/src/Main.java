/*PrinterSpooler
Transforma la clase PrinterSpooler en un Singleton Synchronized:

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrinterSpooler {
    int jobCount;

    PrinterSpooler() {
        jobCount = 0;
    }

    void printJob(String job) {
        System.out.println("Printing job " + (++jobCount) + ": " + job);
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PrinterSpooler printerSpooler = new PrinterSpooler();

        List<Callable<Void>> printOrders = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            final int docId = i;
            printOrders.add(() -> {
                printerSpooler.printJob("Document" + docId);
                return null;
            });
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.invokeAll(printOrders);
        executorService.shutdown();

        System.out.println("FINISHED. Jobs printed: " + printerSpooler.jobCount);
    }
}
*/

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrinterSpooler {
    int jobCount;
    public static PrinterSpooler INSTANCIA;
    PrinterSpooler() {
        jobCount = 0;
    }

    static synchronized PrinterSpooler getInstance(){
        if(INSTANCIA==null){
            INSTANCIA=new PrinterSpooler();
        }
        return INSTANCIA;
    }
    synchronized void printJob(String job) {
        System.out.println("Printing job " + (++jobCount) + ": " + job);
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {
        PrinterSpooler printerSpooler = PrinterSpooler.getInstance();

        List<Callable<Void>> printOrders = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            final int docid = i;
            printOrders.add(() -> {
                printerSpooler.printJob("Document" + docid);
                return null;
            });
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.invokeAll(printOrders);
        executorService.shutdown();

        System.out.println("FINISHED. Jobs printed: " + printerSpooler.jobCount);
    }
}