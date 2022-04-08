public class MenuController {
    Stage stage;
    Scene scene;
    static String currentquan;

    @FXML
    private TextField LableHigh;
    @FXML
    private TextField LableLow;
    @FXML
    private Label CreateChoiceText;
    @FXML
    private Label Label_GiftInfo;
    @FXML
    private TextField quanText;
    @FXML
    private Label quanLable;
    @FXML
    private ListView<String> CandyListView = new ListView<>() ;
    @FXML
    private ListView<String> allCandyListView = new ListView<>() ;
    @FXML
    private RangeSlider sugarSlider;

    @FXML
    protected void toCreateChoice(ActionEvent event) throws IOException {
        Transition(event, "CreateChoise.fxml");
    }

    @FXML
    protected void toMenu(ActionEvent event) throws IOException {
        Transition(event, "Menu.fxml");
    }

    @FXML
    protected void toPrint(ActionEvent event) throws IOException {
        Transition(event, "Print.fxml");
    }


    @FXML
    protected void toSelfAdd(ActionEvent event) throws IOException {
        Transition(event, "AddSelf.fxml");
    }

    @FXML
    protected void onCreateQuantity(ActionEvent event) throws IOException{
        Transition(event, "CreateQuantity.fxml");
    }

    @FXML
    protected void onSortButtonClick(ActionEvent event) throws IOException{
        Transition(event, "Sorting.fxml");
    }

    @FXML
    protected void Transition(ActionEvent event, String name) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(name)));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onGenerateButtonClick() throws SQLException {
        CreateGift.SelfCreate();
        allCandyListView.getItems().removeAll(CreateGift.all_name_arr);
        allCandyListView.getItems().addAll(CreateGift.all_name_arr);
        allCandyListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                currentquan = allCandyListView.getSelectionModel().getSelectedItem();
                quanLable.setText(FieldSearch.QuanSearch(currentquan));
            }
        });
    }

    @FXML
    protected void SomeButtonClick() {
        int low = 0, high = 100;
        if(CreateGift.candy_arr.isEmpty())
        {
            Label_GiftInfo.setText("You should add \nsome candies first");
            return;
        }
        CandyListView.getItems().removeAll(CreateGift.name_arr);

        sugarSlider.highValueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(
                    ObservableValue<? extends Number> observableValue,
                    Number oldValue,
                    Number newValue) {
                LableHigh.textProperty().setValue(String.valueOf((int)((newValue.doubleValue())*100)));
            }
        });

        sugarSlider.lowValueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(
                    ObservableValue<? extends Number> observableValue,
                    Number oldValue,
                    Number newValue) {
                LableLow.textProperty().setValue(String.valueOf((int)((newValue.doubleValue())*100)));
            }
        });

        low = (int)(sugarSlider.getLowValue()*100);
        high = (int)(sugarSlider.getHighValue()*100);
        CreateGift.DiapasonArrCreate(low, high);
        CandyListView.getItems().addAll(CreateGift.name_arr);
        CandyListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                currentquan = CandyListView.getSelectionModel().getSelectedItem();
                if(currentquan != null)
                  Label_GiftInfo.setText(FieldSearch.FieldSearcher(currentquan));
            }
        });
    }

    @FXML
    protected void onDeleteButtonClick()
    {
        if(currentquan != null) {
            int i = DeleteSweet.DeleteOne(currentquan);
            Label_GiftInfo.setText(FieldSearch.FieldSearcher(currentquan));
            if (i == 1)
                CandyListView.getItems().remove(currentquan);
        }
    }

    @FXML
    protected  void onRandomCreateButtonClick() throws SQLException {
        int quan = 0;
        try {
            quan = Integer.parseInt(quanText.getText());
            CreateChoiceText.setText("Submitted successfully!");
        }
        catch (NumberFormatException e){
            CreateChoiceText.setText("Input a number, please!");
        }
        CreateGift.create_gift(quan);
        CreateGift.NameArrCreate();
    }

    @FXML
    protected void onaddQuanButtonClick() {
        for (int i = 0; i < CreateGift.all_candy_arr.size(); i++) {
            if (currentquan.equals(CreateGift.all_candy_arr.get(i).getName())) {
                CreateGift.candy_arr.add(CreateGift.all_candy_arr.get(i));
                break;
            }
        }
        CreateGift.Quantity();
        CreateGift.NameArrCreate();
        quanLable.setText(FieldSearch.QuanSearch(currentquan));
    }

}
