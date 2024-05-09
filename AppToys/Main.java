package AppToys;

import AppToys.controller.Controller;

public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller();
        controller.addToyToList("Кукла", 15, 5);
        controller.addToyToList("Вертолет", 12, 15);
        controller.addToyToList("Медведь", 10, 10);
        controller.addToyToList("Машинка на ДУ", 3, 40);
        controller.addToyToList("Мега Лего!", 3, 50);
        controller.addToyToList("Волк ловит яйца", 2, 75);

        controller.createStoreToys("Детский мир", controller.getListOfToys());        
        controller.printStoreToysOnConsole();

        controller.createRaffle();
        controller.printRaffleOnConsole();

        controller.printStoreToysOnConsole();        
        controller.startRaffle();
    }
}