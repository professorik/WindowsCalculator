package Controllers;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static javafx.scene.input.KeyCode.D;
import static javafx.scene.input.KeyCode.F;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textView;

    @FXML
    private Button MC_Button;

    @FXML
    private Button MR_Button;

    @FXML
    private Button MS_Button;

    @FXML
    private Button MPlus_Button;

    @FXML
    private Button MMinus_Button;

    @FXML
    private Button LeftArrow_Button;

    @FXML
    private Button CE_Button;

    @FXML
    private Button C_Button;

    @FXML
    private Button PlusMinus_Button;

    @FXML
    private Button SQRT_Button;

    @FXML
    private Button Seven_Button;

    @FXML
    private Button Eight_Button;

    @FXML
    private Button Nine_Button;

    @FXML
    private Button Div_Button;

    @FXML
    private Button Proc_Button;

    @FXML
    private Button Four_Button;

    @FXML
    private Button Five_Button;

    @FXML
    private Button Six_Button;

    @FXML
    private Button Mult_Button;

    @FXML
    private Button Inverse_Button;

    @FXML
    private Button One_Button;

    @FXML
    private Button Two_Button;

    @FXML
    private Button Three_Button;

    @FXML
    private Button Minus_Button;

    @FXML
    private Button Equal_Button;

    @FXML
    private Button Zero_Button;

    @FXML
    private Button Comma_Button;

    @FXML
    private Button Plus_Button;

    private String FirstNumber;
    private String LastOperand;

    private boolean fl = false;
    private boolean plus = false;
    private boolean minus = false;
    private boolean mult = false;


    @FXML
    void initialize() {
        textView.setMaxWidth(16);
        FirstNumber = textView.getText();
        Zero_Button.setOnAction(event -> {
            if (!textView.getText().equals("0")){
                if (fl){clear();}
                textView.setText(textView.getText() + "0");
            }
        });
        One_Button.setOnAction(event -> {clear();   textView.setText(textView.getText() + "1");});
        Two_Button.setOnAction(event -> {clear();   textView.setText(textView.getText() + "2");});
        Three_Button.setOnAction(event -> {clear();   textView.setText(textView.getText() + "3");});
        Four_Button.setOnAction(event -> {clear();   textView.setText(textView.getText() + "4");});
        Five_Button.setOnAction(event -> {clear();   textView.setText(textView.getText() + "5");});
        Six_Button.setOnAction(event -> {clear();   textView.setText(textView.getText() + "6");});
        Seven_Button.setOnAction(event -> {clear();  textView.setText(textView.getText() + "7");});
        Eight_Button.setOnAction(event -> {clear();  textView.setText(textView.getText() + "8");});
        Nine_Button.setOnAction(event -> {clear();  textView.setText(textView.getText() + "9");});
        Comma_Button.setOnAction(event -> {if (fl){clear(); textView.setText("0");} if (textView.getText().indexOf(',') == -1) textView.setText(textView.getText() + ",");});
        LeftArrow_Button.setOnAction(event -> {textView.setText(textView.getText().substring(0 , textView.getText().length() - 1)); clear(); if (textView.getText().isEmpty()) textView.setText("0");});
        CE_Button.setOnAction(event -> {textView.setText("0"); FirstNumber = "";});
        C_Button.setOnAction(event -> {textView.setText("0"); FirstNumber = ""; LastOperand = ""; plus = false; minus = false; mult = false; fl = false;});
        Plus_Button.setOnAction(event -> {
            FirstNumber = textView.getText();
            fl = true;
            plus = true;
        });
        Minus_Button.setOnAction(event -> {
            FirstNumber = textView.getText();
            fl = true;
            minus = true;
        });
        Mult_Button.setOnAction(event -> {
            FirstNumber = textView.getText();
            fl = true;
            mult = true;
        });
        Div_Button.setOnAction(event -> {
            FirstNumber = textView.getText();
            fl = true;
        });
        Equal_Button.setOnAction(event -> {
            if (plus) {
                LastOperand = "+" + textView.getText();
                textView.setText(String.valueOf(convertToNumber(FirstNumber) + convertToNumber(textView.getText())));
                clear();
            }else if (minus){
                LastOperand = "-" + textView.getText();
                textView.setText(String.valueOf(convertToNumber(FirstNumber) - convertToNumber(textView.getText())));
                clear();
            }else if (mult){
                LastOperand = "*" + textView.getText();
                textView.setText(String.valueOf(convertToNumber(FirstNumber) * convertToNumber(textView.getText())));
                clear();
            }else{
                if (convertToNumber(textView.getText()) != 0) {
                    System.out.println(String.valueOf(convertToNumber(FirstNumber) / convertToNumber(textView.getText())));
                    LastOperand = "/" + textView.getText();
                    textView.setText("2.333");
                   // textView.setText(String.valueOf(convertToNumber(FirstNumber) / convertToNumber(textView.getText())));
                    clear();
                }else{
                    textView.setText("Невозможно");
                }
            }
            fl = false;
        });
    }

    private void clear() {
        if (textView.getText().length() > 12){
            textView.setStyle("-fx-font-size: 15");
            if (textView.getText().length() > 16){
                textView.setText(textView.getText().substring(0 , 16));
            }
        }
        if (fl){textView.setText(""); fl = false; return;}
        if (textView.getText().isEmpty()){
            textView.setText("0");
        }else if (textView.getText().indexOf(',') == -1 && convertToNumber(textView.getText()) == 0){
            textView.setText("");
        }
    }

    private Double convertToNumber(String s){
        try {
            if (s.charAt(s.length() - 1) == ','){
                s += "0";
            }
            return Double.valueOf(s.replaceAll(",","."));
        }catch (Exception e){
            textView.setText("Error");
        }
        return 0.0;
    }
}
