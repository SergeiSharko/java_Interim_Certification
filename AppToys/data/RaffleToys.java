package AppToys.data;

import java.util.List;
import java.util.TreeMap;

public class RaffleToys {

    private TreeMap<Integer, List<Toy>> raffleToys;

    public TreeMap<Integer, List<Toy>> getMapOfRaffleToys() {
        return raffleToys;
    }

    public void setMapOfRaffleToys(TreeMap<Integer, List<Toy>> raffleToys) {
        this.raffleToys = raffleToys;
    }

    public int countAllToysInRaffle() {
        int countToysInRaffle = 0;
        for (var item : raffleToys.values()) {
            for (Toy toy : item) {
                countToysInRaffle += toy.getAmountToys();
            }
        }
        return countToysInRaffle;
    }
}
