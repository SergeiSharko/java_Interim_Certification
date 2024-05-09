package AppToys.view;

import AppToys.data.StoreToys;
import AppToys.data.Toy;

public class StoreToysView {

    public void printStoreToysOnConsole(StoreToys storeToys) {
        System.out.println("Добро пожаловать в магазин игрушек -> " + storeToys.getNameStore() + " <-");
        System.out.println("Список игрушек в магазине:");
        for (Toy toy : storeToys.getListOfToys()) {
            System.out.println("Название -> \"" + toy.getNameToy() + "\" | " +
                    "Цена(у.е) -> " + toy.getPriceToy() + " | " +
                    "Количество -> " + toy.getAmountToys());
        }
        System.out.println("----------------------------------------------------------------------------");
    }
}
