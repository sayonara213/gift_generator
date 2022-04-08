public class SortController {

    Parent root;
    Stage stage;
    Scene scene;

    @FXML
    private Label SortingText;

    @FXML
    protected void toMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Menu.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onSortNameButtonClick()
    {
        CreateGift.candy_arr.sort(new NameSorter());
        CreateGift.NameArrCreate();
        SortingText.setText("Sorted by name!");
    }

    @FXML
    protected void onSortWeightButtonClick()
    {
        CreateGift.candy_arr.sort(new WeightSorter());
        CreateGift.NameArrCreate();
        SortingText.setText("Sorted by weight!");
    }

    @FXML
    protected void onSortSugarButtonClick()
    {
        CreateGift.candy_arr.sort(new SugarSorter());
        CreateGift.NameArrCreate();
        SortingText.setText("Sorted by % of sugar!");
    }

}
