public class WeightSorter implements Comparator<Candy>
{
    @Override
    public int compare(Candy o1, Candy o2) {
       int weight1 = o1.getWeight();
       int weight2 = o2.getWeight();
       return weight2 - weight1;
    }
}
