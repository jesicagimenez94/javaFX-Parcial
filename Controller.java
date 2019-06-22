package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.*;

import javafx.scene.input.MouseEvent;
import java.time.LocalDate;

public class Controller {

    @FXML
    private TextField legajo;
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellido;
    @FXML
    private TextField parcial1;
    @FXML
    private TextField parcial2;
    @FXML
    private ComboBox materia;
    @FXML
    private ComboBox turno;
    @FXML
    private DatePicker fecha;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnSave;

    @FXML
    private void initialize(){

        fecha.setValue(LocalDate.now());
        materia.setItems(listaMaterias);
        turno.setItems(listaTurno);
        materia.setValue("matematica");
        turno.setValue("noche");


    }

    @FXML
    private void guardar(MouseEvent event){




//
        if(legajo.getText().equals("")||nombre.getText().equals("")||apellido.getText().equals("")||parcial1.getText().equals("")||parcial2.getText().equals("")){
            mensajeError1("ningun campo puede estar vacio ");
          return;
        }


        if(nombre.getText().length()<4||apellido.getText().length()<3){

            mensajeError2("el campo nombre debe ser mayor a 4 y apellido menor a 3");
            return;
        }


        if(fecha.getValue().compareTo(LocalDate.now())<0){
            mensajeError3("fecha no puede ser menor a la de hoy");
            return;
        }



            if((!isNumeric(legajo.getText())||!isNumeric(parcial1.getText())||!isNumeric(parcial2.getText()))){

            mensajeError4("debe ingresar un numero");
        }else {
            int parcia1 = Integer.parseInt(parcial1.getText());
            int parcia2 = Integer.parseInt(parcial2.getText());
            if (parcia1 < 4 || parcia2 < 4) {

                mensajeError5("la nota debe ser mayor a 3");
                return;
            }

                mensajeOk();

        }


    }



    public static  boolean isNumeric(String cadena){
        try {

            Integer.parseInt(cadena);
            return  true;

        }catch(NumberFormatException var){

            return false;


        }

    }







   @FXML
    ObservableList<String> listaMaterias= FXCollections.observableArrayList("matematica","programacion");
    @FXML
    ObservableList<String> listaTurno= FXCollections.observableArrayList("dia","noche");

    @FXML
    private void borrar(MouseEvent event){
     nombre.setText("");
     apellido.setText("");
     legajo.setText("");
     parcial2.setText("");
     parcial1.setText("");

    }


    @FXML
    private void mensajeError1(String mensaje ){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setContentText(mensaje);
        alert.setHeaderText(null);
        alert.showAndWait();

    }
    @FXML
    private void mensajeError2(String mensaje ){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setContentText(mensaje);
        alert.setHeaderText(null);
        alert.showAndWait();

    }

    @FXML
    private void mensajeError3(String mensaje ){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setContentText(mensaje);
        alert.setHeaderText(null);
        alert.showAndWait();

    }

    @FXML
    private void mensajeError4(String mensaje ){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setContentText(mensaje);
        alert.setHeaderText(null);
        alert.showAndWait();

    }

    @FXML
    private void mensajeError5(String mensaje ){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setContentText(mensaje);
        alert.setHeaderText(null);
        alert.showAndWait();

    }

    @FXML
    private void mensajeOk(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("OK");
        alert.setContentText("registro exitoso");
        alert.setHeaderText(null);
        alert.showAndWait();

    }

}
