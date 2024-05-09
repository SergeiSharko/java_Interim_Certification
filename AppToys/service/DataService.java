package AppToys.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import AppToys.data.RaffleToys;
import AppToys.data.StoreToys;
import AppToys.data.Toy;

public class DataService {

    private List<Toy> listOfToys = new ArrayList<Toy>();
    private TreeMap<Integer, List<Toy>> mapRaffle = new TreeMap<Integer, List<Toy>>();
    private StoreToys storeToys = new StoreToys();
    private RaffleToys raffleToys = new RaffleToys();

    public void addToyToList(String nameToy, int amountToy, int priceToy) {
        int idToy = 1;
        for (Toy item : listOfToys) {
            item.setIdToy(idToy);
            if (item.getIdToy() == idToy) {
                idToy += 1;
            }
        }
        listOfToys.add(new Toy(idToy, nameToy, amountToy, priceToy));
    }

    public List<Toy> getListOfToys() {
        return listOfToys;
    }

    public void createStoreToys(String name, List<Toy> listOfToy) {
        storeToys.setNameStore(name);
        storeToys.setListOfToys(listOfToy);
    }

    public StoreToys getStoreToys() {
        return storeToys;
    }

    public float getPriceAllToys() {
        float sumPriceAllToys = 0;
        for (Toy toy : listOfToys) {
            sumPriceAllToys += toy.getPriceToy() * toy.getAmountToys();
        }
        return sumPriceAllToys;
    }

    public void createRaffle() {
        Random rand = new Random();
        float sumPriceAllToys = getPriceAllToys();
        for (Toy toy : listOfToys) {
            Toy currToy = new Toy(toy.getIdToy(), toy.getNameToy(), toy.getAmountToys(), toy.getPriceToy());
            List<Toy> listOfRaffleToys = new ArrayList<Toy>();
            int dropChance = Math.round(((toy.getPriceToy() * toy.getAmountToys()) / sumPriceAllToys) * 100);
            currToy.setAmountToys(rand.nextInt(1, toy.getAmountToys()));
            toy.setAmountToys(toy.getAmountToys() - currToy.getAmountToys());
            if (mapRaffle.containsKey(dropChance)) {
                listOfRaffleToys = mapRaffle.get(dropChance);
                listOfRaffleToys.add(currToy);
                mapRaffle.put(dropChance, listOfRaffleToys);
            } else {
                listOfRaffleToys.add(currToy);
                mapRaffle.put(dropChance, listOfRaffleToys);
            }
        }
        raffleToys.setMapOfRaffleToys(mapRaffle);
    }

    public RaffleToys getRaffleOfToys() {
        return raffleToys;
    }

    public int countAllToysInRaffle() {
        return raffleToys.countAllToysInRaffle();
    }

    public void startRaffle() {
        int countAllToysInRaffle = countAllToysInRaffle();
        Random rand = new Random();
        TreeMap<Integer, List<Toy>> mapRaffleWithNumberBounds = new TreeMap<Integer, List<Toy>>();
        int numberBound = 0;

        for (Map.Entry<Integer, List<Toy>> item : raffleToys.getMapOfRaffleToys().entrySet()) {
            if (item.getValue().size() < 1) {
                numberBound += item.getKey();
                mapRaffleWithNumberBounds.put(numberBound, item.getValue());
            } else {
                Iterator<Toy> iter = item.getValue().iterator();
                while (iter.hasNext()) {
                    numberBound += item.getKey();
                    List<Toy> currList = new ArrayList<Toy>();
                    currList.add(iter.next());
                    iter.remove();
                    mapRaffleWithNumberBounds.put(numberBound, currList);
                }
            }
        }        

        try (FileWriter fileWriter = new FileWriter("AppToys/prizes.txt", false)) {
            System.out.println("Розыгрыш игрушек начинается!!!");
            System.out.println("Количество всех игрушек в розыгрыше -> " + countAllToysInRaffle);
            System.out.println("----------------------------------------------------------------------------");
            fileWriter.write("Количество всех игрушек в розыгрыше -> " + countAllToysInRaffle + "\n");
            for (int i = 1; i <= countAllToysInRaffle; i++) {
                int winNumber = rand.nextInt(1, mapRaffleWithNumberBounds.lastKey() + 1);
                System.out.println("Участнику под номером - " + i + " | " + "Выпало число -> " + winNumber);
                fileWriter.write("Участнику под номером - " + i + " | " + "Выпало число -> " + winNumber + "\n");
                Map.Entry<Integer, List<Toy>> prize = mapRaffleWithNumberBounds.ceilingEntry(winNumber);
                Toy winToy = prize.getValue().getFirst();
                System.out.println("Этому числу соответсвует приз -> " + winToy);
                fileWriter.write("Этому числу соответсвует приз -> " + winToy + "\n");
                winToy.decreaseAmount();
                if (winToy.getAmountToys() == 0) {
                    System.out.println("Игрушка - " + "\"" + winToy.getNameToy() + "\"" + " -> розыграны полностью!");
                    fileWriter.write("Игрушка - " + "\"" + winToy.getNameToy() + "\"" + " -> розыграны полностью!\n");
                    mapRaffleWithNumberBounds.remove(prize.getKey());
                }
            }
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("Все игрушки розыграны!!!");
            fileWriter.write("Все игрушки розыграны!!!\n");
            fileWriter.flush();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}