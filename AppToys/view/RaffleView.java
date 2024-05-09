package AppToys.view;

import java.util.List;
import java.util.Map;

import AppToys.data.RaffleToys;
import AppToys.data.Toy;

public class RaffleView {

    public void printRaffleOnConsole(RaffleToys raffleToys) {
        System.out.println("Добро пожаловать в розыгрыш призов в магазине игрушек !!!");
        System.out.println("Список игрушек, участвующих в розыгрыше:");
        for (Map.Entry<Integer, List<Toy>> item : raffleToys.getMapOfRaffleToys().entrySet()) {
            for (Toy toy : item.getValue()) {
                System.out.println("Название -> \"" + toy.getNameToy() + "\" | " +
                        "Цена(у.е) -> " + toy.getPriceToy() + " | " +
                        "Количество -> " + toy.getAmountToys() + " | " +
                        "Шанс выпадения -> " + item.getKey() + "%");
            }
        }
        System.out.println("----------------------------------------------------------------------------");
    }
}
