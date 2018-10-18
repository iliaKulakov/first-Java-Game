package io.github.maventest.model.board;

public class PlayersThread extends Thread implements Runnable {

    //I think i can delete this class, used for examples
    PlayersThread(String name) {
        super(name);
    }

    public void run() {
        Thread mainThread = Thread.currentThread();
        System.out.println("Текущий поток исполнения " + mainThread.getName());
        mainThread.setName("Поток игрока");
        System.out.println("Текущий поток исполнения " + mainThread.getName());

    }

    public static void main(String[] args) {

       // System.out.println("Main thread started...");
       // new PlayersThread("PlayersThread").start();
      //  System.out.println("Main thread finished...");
    }
}


