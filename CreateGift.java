public class CreateGift {
    static int counter = 0;
    static int k = 1;
    public static String[] name_arr;
    public static String[] all_name_arr;
    public static ArrayList<Candy> candy_arr = new ArrayList<>();
    public static ArrayList<Candy> all_candy_arr = new ArrayList<>();
    static Random rand = new Random();
    static int randret;

    public static void create_gift(int input) throws SQLException {
        for(int i = 0; i < input; i++)
        {
            candy_arr.add(CandyList.candylist(RandID()));
        }
        Quantity();
    }

    public static String RandID() throws SQLException {
        Random rand = new Random();
        DatabaseHandler handler = new DatabaseHandler();
        randret = rand.nextInt(handler.getIDnum());
        return String.valueOf(randret);
    }

    public static void Quantity()
    {
        for(int i = 0; i<candy_arr.size(); i++)
        {
            for(int j = i+1; j < candy_arr.size(); j++ )
            {
                if(candy_arr.get(i).getName().equals(candy_arr.get(j).getName()))
                {
                    candy_arr.get(i).setQuantity(candy_arr.get(i).getQuantity() + 1);
                    candy_arr.remove(j);
                    --j;
                }
            }
        }
    }

    public static void DiapasonArrCreate(int Low, int High)
    {
        name_arr = new String[CountArr(Low, High)];
        for(int j = 0, i = 0; i<candy_arr.size(); i++) {
            if (candy_arr.get(i).getSugar_perc() <= High && candy_arr.get(i).getSugar_perc() >= Low) {
                name_arr[j] = candy_arr.get(i).getName();
                j++;
            }
            if(j >= CountArr(Low, High))
            {
                return;
            }
        }
    }
    public static int CountArr(int Low, int High)
    {
        int count = 0;
        for(int i = 0; i<candy_arr.size(); i++)
        {
            if (candy_arr.get(i).getSugar_perc() <= High && candy_arr.get(i).getSugar_perc() >= Low) {
            count++;
            }
        }
        return count;
    }

    public static void NameArrCreate()
    {
        name_arr = new String[candy_arr.size()];
        for(int i = 0, j = 0; i < candy_arr.size(); i++, j++) {
                name_arr[j] = candy_arr.get(i).getName();
        }
    }

    public static void SelfCreate() throws SQLException {
        DatabaseHandler handler = new DatabaseHandler();
        if(counter != 0)
            return;

        int i = 0;
        for(; i<handler.getIDnum(); i++) {
            all_candy_arr.add(CandyList.candylist(String.valueOf(i)));
        }
        counter++;
        allNameArrCreate();
    }

    public static void allNameArrCreate() {
        all_name_arr = new String[all_candy_arr.size()];
        for(int i = 0; i < all_candy_arr.size(); i++)
        {
            all_name_arr[i] = all_candy_arr.get(i).getName();
        }
    }
}
