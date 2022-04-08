public class FieldSearch {
    public static String FieldSearcher(String name) {
        String result;
        for (int i = 0; i < CreateGift.candy_arr.size(); i++) {
            if (name.equals(CreateGift.candy_arr.get(i).getName())) {
                result = CreateGift.candy_arr.get(i).toString();
                return result;
            }
        }
        return null;
    }

    public static String QuanSearch(String name) {
        String result;
        if (CreateGift.candy_arr.isEmpty()) {
            return "Quantity of that sweet \nin the present: 0";
        }
        else {
            for (int i = 0; i < CreateGift.candy_arr.size(); i++) {
                if (name.equals(CreateGift.candy_arr.get(i).getName())) {
                    if (CreateGift.candy_arr.get(i).getQuantity() != 0) {
                        result = "Quantity of that sweet \nin the present: " + CreateGift.candy_arr.get(i).getQuantity();
                        return result;
                    }
                }
            }
            result = "Quantity of that sweet \nin the present: 0";
            return result;
        }
    }
}
