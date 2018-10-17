package io.github.maventest.Thread;

public class PlayersThread implements Runnable {

    Thread thread;


    PlayersThread () {
        // Создаём новый второй поток
        thread = new Thread(this, "Поток");

        thread.start(); // Запускаем поток
    }


    public void run() {


    }
}

}
