package org.example.demo.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.demo.database.VueloDAO;
import org.example.demo.model.Vuelo;

import java.sql.SQLException;
import java.time.LocalDate;

public class VueloController {

    @FXML private TableView<Vuelo> tablaVuelos;
    @FXML private TableColumn<Vuelo, String> colNumero;
    @FXML private TableColumn<Vuelo, String> colDestino;
    @FXML private TableColumn<Vuelo, LocalDate> colFecha;
    @FXML private TableColumn<Vuelo, Integer> colDuracion;

    @FXML private TextField txtNumero;
    @FXML private TextField txtDestino;
    @FXML private DatePicker dpFecha;
    @FXML private TextField txtDuracion;
    @FXML private ComboBox<String> comboFiltros;

    private VueloDAO vueloDAO = new VueloDAO();
    private ObservableList<Vuelo> listaObservable;

    @FXML
    public void initialize() {
        colNumero.setCellValueFactory(new PropertyValueFactory<>("numFlight"));
        colDestino.setCellValueFactory(new PropertyValueFactory<>("destination"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("departure"));
        colDuracion.setCellValueFactory(new PropertyValueFactory<>("duration"));

        comboFiltros.getItems().addAll("Todos", "+3 Horas", "Destino: London", "Destino: Bilbao");

        cargarVuelos();
    }

    private void cargarVuelos() {
        listaObservable = FXCollections.observableArrayList(vueloDAO.obtenerTodos());
        tablaVuelos.setItems(listaObservable);
    }

    @FXML
    public void refreshAction() {
        cargarVuelos();
        comboFiltros.getSelectionModel().clearSelection();
    }

    @FXML
    public void addFlightAction() {
        try {
            String num = txtNumero.getText();
            String dest = txtDestino.getText();
            LocalDate fecha = dpFecha.getValue();
            int duracion = Integer.parseInt(txtDuracion.getText());

            Vuelo nuevoVuelo = new Vuelo(num, dest, fecha, duracion);

            if (vueloDAO.insertar(nuevoVuelo)) {
                cargarVuelos();
                txtNumero.clear(); txtDestino.clear(); dpFecha.setValue(null); txtDuracion.clear();
            }
        } catch (SQLException e) {
            mostrarAlerta("Error de Base de Datos", "Ese número de vuelo ya existe o hay un problema de conexión.");
        } catch (NumberFormatException e) {
            mostrarAlerta("Error de Formato", "La duración debe ser un número entero.");
        } catch (Exception e) {
            mostrarAlerta("Error", "Revisa que todos los campos estén rellenos correctamente.");
        }
    }

    @FXML
    public void deleteFlightAction() {
        Vuelo seleccionado = tablaVuelos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION, "¿Seguro que quieres borrar el vuelo " + seleccionado.getNumFlight() + "?");
            confirmacion.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    if (vueloDAO.eliminar(seleccionado.getIdFlight())) {
                        cargarVuelos();
                    }
                }
            });
        } else {
            mostrarAlerta("Atención", "Debes seleccionar un vuelo de la tabla primero.");
        }
    }

    @FXML
    public void applyFilterAction() {
        String seleccion = comboFiltros.getValue();
        if (seleccion == null || seleccion.equals("Todos")) {
            cargarVuelos();
        } else if (seleccion.equals("+3 Horas")) {
            tablaVuelos.setItems(FXCollections.observableArrayList(vueloDAO.filtrarPorDuracion()));
        } else if (seleccion.equals("Destino: London")) {
            tablaVuelos.setItems(FXCollections.observableArrayList(vueloDAO.filtrarPorDestino("London")));
        } else if (seleccion.equals("Destino: Bilbao")) {
            tablaVuelos.setItems(FXCollections.observableArrayList(vueloDAO.filtrarPorDestino("Bilbao")));
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}