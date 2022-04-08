public class SugarSorter implements Comparator<Candy>
{
    @Override
    public int compare(Candy o1, Candy o2) {
        int weight1 = o1.getSugar_perc();
        int weight2 = o2.getSugar_perc();
        return weight2 - weight1;
    }
}
