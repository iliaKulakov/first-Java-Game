package io.github.maventest.menu;

    public class MainMenu extends AbstractMenu {

        public MainMenu() {
            super();
            initMenuItems();

        }

        private void initMenuItems() {

        }

        @Override
        public void interactWithMenu(){
            super.printMenu();
        }
    }


