package ru.sapteh.controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.model.Doctor;
import ru.sapteh.model.Pacient;
import ru.sapteh.model.Reference;
import ru.sapteh.service.DoctorService;
import ru.sapteh.service.PacientService;
import ru.sapteh.service.ReferenceService;

import java.util.Date;

public class MainController {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    private ObservableList<Doctor> doctors = FXCollections.observableArrayList();
    private ObservableList<Pacient> pacients = FXCollections.observableArrayList();
    private ObservableList<Reference> references = FXCollections.observableArrayList();


    @FXML
    private BorderPane borderPane;

    @FXML
    private TableView<Doctor> tableViewDoctors;

    @FXML
    private TableColumn<Doctor, Integer> idDoctors;

    @FXML
    private TableColumn<Doctor, String> fioDoctors;

    @FXML
    private TableColumn<Doctor, String> profDoctors;

    @FXML
    private TableColumn<Doctor, String> catDoctors;

    @FXML
    private TableColumn<Doctor, String> imageDoctors;

    @FXML
    private TableView<Pacient> tableViewPacients;

    @FXML
    private TableColumn<Pacient, Integer> idPacients;

    @FXML
    private TableColumn<Pacient, String> fioPacients;

    @FXML
    private TableColumn<Pacient, Date> datePacients;

    @FXML
    private TableColumn<Pacient, String> imagePacients;

    @FXML
    private TableView<Reference> tableViewReferences;

    @FXML
    private TableColumn<Reference, Integer> idReferences;

    @FXML
    private TableColumn<Reference, Date> dateReferences;

    @FXML
    private TableColumn<Reference, String> diagReferences;

    @FXML
    private TableColumn<Reference, Integer> costReferences;

    @FXML
    private TableColumn<Reference, Integer> pacientIdReferences;

    @FXML
    private ImageView imageViewDoctor;


    public void initialize(){
        DAO<Doctor, Integer> doctorIntegerDAO =new DoctorService(factory);
        DAO<Pacient, Integer> pacientIntegerDAO =new PacientService(factory);
        DAO<Reference, Integer> referenceIntegerDAO =new ReferenceService(factory);
        doctors.addAll(doctorIntegerDAO.readByAll());
        pacients.addAll(pacientIntegerDAO.readByAll());
        references.addAll(referenceIntegerDAO.readByAll());

        tableViewDoctors.setItems(doctors);

        idDoctors.setCellValueFactory(doctorIntegerCellDataFeatures ->
                new SimpleObjectProperty<>(doctorIntegerCellDataFeatures.getValue().getId()));
        fioDoctors.setCellValueFactory(doctorStringCellDataFeatures ->
                new SimpleObjectProperty<>(doctorStringCellDataFeatures.getValue().getFio()));
        tableViewDoctors.getSelectionModel().selectedItemProperty().addListener((observableValue, doctor, t1) -> {
            if (t1!=null){
                imageViewDoctor.setImage(new Image("\\"+t1.getMainImagePath()));

            }
        });









    }


}
