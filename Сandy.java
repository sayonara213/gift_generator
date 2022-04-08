public class Candy{
    protected String name;
    protected int sugar_perc;
    protected int weight;
    protected int quantity;

    public Candy(){}

    public Candy(String name,int sugar_perc, int weight, int quantity)
    {
        this.name = name;
        this.sugar_perc = sugar_perc;
        this.weight = weight;
        this.quantity = quantity;
    }

    public int getSugar_perc() {
        return sugar_perc;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getQuantity() {return quantity;}

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {this.quantity = quantity;}

    public void setSugar_perc(int sugar_perc) {
        this.sugar_perc = sugar_perc;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return  "Type: Candy\n" +
                "Quantity: "+ quantity + " pieces\n"+
                "Sugar percentage: " + sugar_perc + "%\n" +
                "Weight: " + weight + " g";
    }
}
