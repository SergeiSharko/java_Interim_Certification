package AppToys.data;

public class Toy {

    private int idToy;
    private String nameToy;
    private int amountToys;
    private int priceToy;

    public Toy(int idToy, String nameToy, int amountToy, int priceToy) {

        this.idToy = idToy;
        this.nameToy = nameToy;
        this.amountToys = amountToy;
        this.priceToy = priceToy;
    }

    public int getIdToy() {
        return idToy;
    }

    public void setIdToy(int idToy) {
        this.idToy = idToy;
    }

    public String getNameToy() {
        return nameToy;
    }

    public void setNameToy(String nameToy) {
        this.nameToy = nameToy;
    }

    public int getAmountToys() {
        return amountToys;
    }

    public void setAmountToys(int amountToy) {
        this.amountToys = amountToy;
    }

    public void decreaseAmount() {
        amountToys--;
    }

    public int getPriceToy() {
        return priceToy;
    }

    public void setPriceToy(int priceToy) {
        this.priceToy = priceToy;
    }

    @Override
    public String toString() {
        return "idToy=" + this.idToy
                + " | nameToy=" + this.nameToy
                + " | amountToy=" + this.amountToys
                + " | priceToy=" + this.priceToy + " y.e";
    }
}