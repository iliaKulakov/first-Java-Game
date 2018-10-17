package io.github.maventest.menu;

import java.util.Scanner;

public class MainMenu extends AbstractMenu {

        public MainMenu() {
            super();
            initMenuItems();
        }

        private void initMenuItems() {
            this.items.add("Игра с компьютерным противником (ботом): ");
            this.items.add("Игра ботов между собой: ");
        }

        @Override
        public void interactWithMenu() {
            boolean exit = false;
            do {
                printMenu(); //вызываю печать меню от menu.AbstractMenu
                Scanner sc = new Scanner(System.in);
                int command;
                do {
                    System.out.println("Введите номер: ");
                    while (!sc.hasNextInt()) {
                        System.out.println("Введен не номер режима игры. Попробуйте еще раз");
                        sc.next();
                    }
                    command = sc.nextInt();
                } while (command <= 0);
                switch (command) {
                    case 1:
                        System.out.println("Вы ввели число 1 - Игра с компьютерным противником (ботом) ");
                        exit = false;
                        break;
                    case 2:
                        System.out.println("Вы ввели число 2 - Игра ботов между собой ");
                        exit = false;
                        break;
                    default:
                        System.out.println("Ошибка! Попробуйте еще раз:  ");
                        exit = false;
                        break;

                } // end switch

            } while (exit != true);

        }
    }


