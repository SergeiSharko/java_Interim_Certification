package AppToys.controller;

import java.util.List;

import AppToys.data.RaffleToys;
import AppToys.data.StoreToys;
import AppToys.data.Toy;
import AppToys.service.DataService;
import AppToys.view.RaffleView;
import AppToys.view.StoreToysView;

public class Controller {

    private DataService dataService = new DataService();
    private StoreToysView storeView = new StoreToysView();
    private RaffleView raffleView = new RaffleView();

    public void addToyToList(String nameToy, int amountToy, int priceToy) {
        dataService.addToyToList(nameToy, amountToy, priceToy);
    } 
    
    public void createStoreToys(String name, List<Toy> listOfToy) {        
        dataService.createStoreToys(name, listOfToy);
    }

    public StoreToys getStoreToys() {
        return dataService.getStoreToys();
    }

    public List<Toy> getListOfToys() {
        return dataService.getListOfToys();
    }

    public void createRaffle() {
        dataService.createRaffle();
    }

    public RaffleToys getRaffle() {
        return dataService.getRaffleOfToys();
    }

    public int countAllToysInRaffle() {
        return dataService.countAllToysInRaffle();
    }

    public void startRaffle() {
        dataService.startRaffle();
    }

    public void printStoreToysOnConsole() {        
        storeView.printStoreToysOnConsole(getStoreToys());
    }

    public void printRaffleOnConsole() {
        raffleView.printRaffleOnConsole(getRaffle());
    }    
}