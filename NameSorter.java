public class NameSorter implements Comparator<Candy> {

    @Override
    public int compare(Candy o1, Candy o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());

    }
}
