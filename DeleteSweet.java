public class DeleteSweet {
    public static int DeleteOne(String name) {
        for (int i = 0; i < CreateGift.candy_arr.size(); i++) {
            if (CreateGift.candy_arr.get(i).getName().equals(name)) {

                if (CreateGift.candy_arr.get(i).getQuantity() == 1) {
                    CreateGift.candy_arr.remove(i);
                    return 1;
                } else {
                    CreateGift.candy_arr.get(i).setQuantity(CreateGift.candy_arr.get(i).getQuantity() - 1);
                    return 0;
                }
            }
        }
        return 0;
    }
}
