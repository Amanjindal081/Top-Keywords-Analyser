package tech.codingclub;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadManager {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager(100);
        for(int i=0;i<1000;i++){
            taskManager.waittillqueueisfreeandadd(new RunableExample("A"+i,0,500+i));
        }


    }
}
