package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import model.*;

import java.util.LinkedList;
import java.util.List;


public class Controller {
    @FXML
    public TextField l_wr;
    @FXML
    public TextField w_wr;
    @FXML
    private ComboBox combo_type;
    @FXML
    private ComboBox combo_color;
    @FXML
    private ListView sstok;
    @FXML
    private List<ClothesForWindows> list_s;

    @FXML
    public void initialize() {
        combo_type.getItems().addAll("рулонные", "тканевые", "кассетные");
        combo_type.getSelectionModel().select(0);


        combo_color.getItems().addAll("красный", "черный", "желтый", "белый", "синий");
        combo_color.getSelectionModel().select(0);
        list_s = new LinkedList<ClothesForWindows>();
    }



    public void addList() {
        if (l_wr.getText().equals("") || w_wr.getText().equals("")) {//проверка на пустоту текстовых полей
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Предупреждение: ");
            alert.setHeaderText(null);
            alert.setContentText("Не введёны размеры жалюзи!");
            alert.showAndWait();
            return;
        }
        ClothesForWindows ob1 = null;

        switch (
                combo_type.getSelectionModel().getSelectedItem().toString()
        ) {
            case "рулонные":
                ob1 = new RollerShutters(Double.parseDouble(l_wr.getText()), Double.parseDouble(w_wr.getText()), "Рулонные ", combo_color.getSelectionModel().getSelectedItem().toString());
                break;
            case "тканевые":
                ob1 = new FabricBlinds(Double.parseDouble(l_wr.getText()), Double.parseDouble(w_wr.getText()), "Тканевые ", combo_color.getSelectionModel().getSelectedItem().toString());
                break;
            case "кассетные":
                ob1 = new CassetteBlinds(Double.parseDouble(l_wr.getText()), Double.parseDouble(w_wr.getText()), "Кассетные ", combo_color.getSelectionModel().getSelectedItem().toString());
                break;
            default:
                break;
        }
        list_s.add(ob1);
        sstok.getItems().add(ob1.info());
        l_wr.setText("");
        w_wr.setText("");
        combo_type.getSelectionModel().select(0);
        combo_color.getSelectionModel().select(0);

    }
}
