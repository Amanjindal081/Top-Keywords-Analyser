package tech.codingclub;

public class ThreadExample extends Thread{
    private String threadName;
    public int counter=0;
    private int wait=0;
    public ThreadExample(String threadName,int counter,int wait){
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
        ThreadExample thread1 = new ThreadExample("A",0,500);
        ThreadExample thread2 = new ThreadExample("B",0,1000);
        ThreadExample thread3 = new ThreadExample("C",0,2000);
        thread1.start();
        thread2.start();
        thread3.start();



    }

}
