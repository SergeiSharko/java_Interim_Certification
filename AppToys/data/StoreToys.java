package AppToys.data;

import java.util.List;

public class StoreToys {

    private String nameStore;
    private List<Toy> listOfToys;
    
    public String getNameStore() {
        return nameStore;
    }

    public void setNameStore(String newNameStore) {
        this.nameStore = newNameStore;
    }

    public List<Toy> getListOfToys() {
        return listOfToys;
    }

    public void setListOfToys(List<Toy> listOfToys) {
        this.listOfToys = listOfToys;
    }

    @Override
    public String toString() {
        return "StoreToys=" + nameStore
                + " -> listOfToys=" + listOfToys;
    }
}
