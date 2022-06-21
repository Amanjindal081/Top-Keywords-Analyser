package tech.codingclub;

public class RunableExample implements Runnable{
    private String threadName;
    public int counter=0;
    private int wait=0;
    public RunableExample(String threadName, int counter, int wait){
        this.counter = counter;
        this.threadName = threadName;
        this.wait =wait;
    }
    public void run(){
        while (counter<1000){
            counter++;
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread"+threadName+":"+counter);
        }
    }

    public static void main(String[] args) {
        RunableExample runableExample1 = new RunableExample("A",0,500);
        RunableExample runableExample2 = new RunableExample("B",0,1000);
        RunableExample runableExample3 = new RunableExample("C",0,2000);
        Thread thread1 =new Thread(runableExample1);
        Thread thread2 = new Thread(runableExample2);
        Thread thread3 = new Thread(runableExample3);


        thread1.start();
        thread2.start();
        thread3.start();



    }

}
