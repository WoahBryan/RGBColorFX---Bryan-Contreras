// CONTRERAS MARTINEZ BRYAN DANIEL
package com.mycompany.rgbcolorfx;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory;


public class PrimaryController {
@FXML private TextField txtRgbR, txtRgbG, txtRgbB;
@FXML private Pane paneRgbText;

@FXML private Spinner<Integer> spnRgbR, spnRgbG, spnRgbB;
@FXML private Pane paneRgbSpinner;

@FXML private Slider sldRgbR, sldRgbG, sldRgbB;
@FXML private Pane paneRgbSlider;

@FXML private CheckBox chkRgbR, chkRgbG, chkRgbB;
@FXML private Pane paneRgbCheck;

@FXML private RadioButton radRgbR, radRgbG, radRgbB;
@FXML private Pane paneRgbRadio;

@FXML private ToggleButton tglRgbHex;
@FXML private Label lblToggleInfo;
@FXML private Pane paneToggle;

@FXML private ColorPicker cpRgbFull;
@FXML private Pane paneColorPicker;

@FXML private TextField txtHex;
@FXML private Pane paneHex;

@FXML private TextArea txtInfo;

private void pintar(Pane pane, int r, int g, int b){
    r = Math.max(0, Math.min(255, r));
    g = Math.max(0, Math.min(255, g));
    b = Math.max(0, Math.min(255, b));
    System.out.println("Pintando " + pane.getId() + " con RGB: " + r + "," + g + "," + b);
    pane.setStyle("-fx-background-color: rgb(" + r + " , " + g + "," + b + ");");
}

@FXML 
public void initialize(){
    txtRgbR.textProperty().addListener((obs, oldV, newV) -> actualizarPaneTextField());
    txtRgbG.textProperty().addListener((obs, oldV, newV) -> actualizarPaneTextField());
    txtRgbB.textProperty().addListener((obs, oldV, newV) -> actualizarPaneTextField());
    
    spnRgbR.setValueFactory(new IntegerSpinnerValueFactory(0, 255, 0));
     spnRgbG.setValueFactory(new IntegerSpinnerValueFactory(0, 255, 0));
      spnRgbB.setValueFactory(new IntegerSpinnerValueFactory(0, 255, 0));
      
      spnRgbR.valueProperty().addListener((obs, oldV, newV) -> actualizarPaneSpinner());
       spnRgbG.valueProperty().addListener((obs, oldV, newV) -> actualizarPaneSpinner());
        spnRgbB.valueProperty().addListener((obs, oldV, newV) -> actualizarPaneSpinner());
        
        sldRgbR.valueProperty().addListener((obs, oldV, newV) -> actualizarPaneSlider());
       sldRgbG.valueProperty().addListener((obs, oldV, newV) -> actualizarPaneSlider());
        sldRgbB.valueProperty().addListener((obs, oldV, newV) -> actualizarPaneSlider());
        
         chkRgbR.selectedProperty().addListener((obs, oldV, newV) -> actualizarPaneCheck());
       chkRgbG.selectedProperty().addListener((obs, oldV, newV) -> actualizarPaneCheck());
        chkRgbB.selectedProperty().addListener((obs, oldV, newV) -> actualizarPaneCheck());
        
         radRgbR.selectedProperty().addListener((obs, oldV, newV) -> actualizarPaneRadio());
       radRgbG.selectedProperty().addListener((obs, oldV, newV) -> actualizarPaneRadio());
        radRgbB.selectedProperty().addListener((obs, oldV, newV) -> actualizarPaneRadio());
        
         tglRgbHex.selectedProperty().addListener((obs, oldV, newV) -> actualizarToggle());
       cpRgbFull.valueProperty().addListener((obs, oldV, newV) -> actualizarToggle());
       actualizarToggle();
       
      cpRgbFull.valueProperty().addListener((obs, oldV, newV) -> actualizarPaneColorPicker());
      actualizarPaneColorPicker();
      
      txtHex.textProperty().addListener((obs, oldV, newV) -> actualizarPaneHex());
        
        
}
private void actualizarPaneTextField(){
    try{
        int r = Integer.parseInt(txtRgbR.getText().trim());
        int g = Integer.parseInt(txtRgbG.getText().trim());
        int b = Integer.parseInt(txtRgbB.getText().trim());
        pintar(paneRgbText, r, g, b);
    } catch(NumberFormatException e) {
}
    
}
private void actualizarPaneSpinner(){
    int r = spnRgbR.getValue();
    int g = spnRgbG.getValue();
    int b = spnRgbB.getValue();
    pintar(paneRgbSpinner, r, g, b);
}

private void actualizarPaneSlider(){
    int r = (int) sldRgbR.getValue();
    int g = (int) sldRgbG.getValue();
    int b = (int) sldRgbB.getValue();
    pintar(paneRgbSlider, r, g, b);
    
}

public void actualizarPaneCheck(){
    int r = chkRgbR.isSelected() ? 255:0;
     int g = chkRgbG.isSelected() ? 255:0;
      int b = chkRgbB.isSelected() ? 255:0;
      pintar(paneRgbCheck, r, g, b);


}
private void actualizarPaneRadio(){
    int r = 0, g = 0, b = 0;
    if(radRgbR.isSelected()){
        r = 255;
    }else if (radRgbG.isSelected()){
        g = 255;
    } else if (radRgbB.isSelected()){
        b = 255;
    }
    pintar(paneRgbRadio, r, g, b);
}

private void actualizarToggle(){
    Color c = cpRgbFull.getValue();
    int r = (int) Math.round(c.getRed() * 255);
    int g = (int) Math.round(c.getGreen() * 255);
    int b = (int) Math.round(c.getBlue() * 255);
    
    if(tglRgbHex.isSelected()){
        tglRgbHex.setText("HEX");
        lblToggleInfo.setText(String.format("#%02X%02X%02X", r, g, b));
    } else {
        tglRgbHex.setText("RGB");
        lblToggleInfo.setText("RGB(" + r + "," + g + "," + b + ")");
        
    }
    pintar(paneToggle, r, g, b);
}

private void actualizarPaneColorPicker(){
    Color c = cpRgbFull.getValue();
    int r = (int) Math.round(c.getRed() * 255);
    int g = (int) Math.round(c.getGreen() * 255);
    int b = (int) Math.round(c.getBlue() * 255);
   pintar(paneColorPicker, r, g, b);
}

private void actualizarPaneHex(){
    String texto = txtHex.getText().trim();
    if(texto.matches("^#[0-9A-Fa-f]{6}$")){
     Color c = Color.web(texto);
     int r = (int) Math.round(c.getRed() * 255);
     int g = (int) Math.round(c.getGreen() * 255);
     int b = (int) Math.round(c.getBlue() * 255);
     pintar(paneHex, r, g, b);
    }
}
}
