import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
// import PatientManagementLogic class!

public class PatientManagementGUI extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GridPane gp = new GridPane();
        StackPane sp1 = new StackPane();
        Patient pt = new Patient();

        Text i1 = new Text("Enter Patient Name : ");
        Text i2 = new Text("Enter Patient Disease : ");
        Text i3 = new Text("Enter Disease Priority : ");
        Text r1 = new Text("Added Successfully...");
        Text r2 = new Text("Removed Successfully...");
        Text e1 = new Text("All fields are Mandatory to fill...!");

        i1.setFont(Font.font("Lucida Sans Unicode",FontWeight.BOLD , FontPosture.REGULAR ,20));
        i2.setFont(Font.font("Lucida Sans Unicode",FontWeight.BOLD , FontPosture.REGULAR ,20));
        i3.setFont(Font.font("Lucida Sans Unicode",FontWeight.BOLD , FontPosture.REGULAR ,20));
        r1.setFont(Font.font("Lucida Sans Unicode",FontWeight.BOLD , FontPosture.REGULAR ,20));
        r2.setFont(Font.font("Lucida Sans Unicode",FontWeight.BOLD , FontPosture.REGULAR ,20));

        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        tf3.setText("Mandatory (Only Digits)");

        tf1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                sp1.getChildren().remove(r1);
            }
        });

        tf3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                tf3.clear();
            }
        });

        Button add = new Button("Add Patient");

        add.setStyle("-fx-background-color:Pink");
        add.setPrefSize(120,15);
        add.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                add.setPrefSize(120,30);
                add.setStyle("-fx-background-color:Yellow");
            }
        });
        add.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                add.setPrefSize(120,15);
                add.setStyle("-fx-background-color:Pink");
            }
        });
        add.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                String s1 = tf1.getText();
                String s2 = tf2.getText();
                String s3 = tf3.getText();

                add.setStyle("-fx-background-color:#00FFFF");

                int pr = Integer.parseInt(s3);
                pt.addPatient(s1, s2, pr);
                sp1.getChildren().add(r1);
                tf1.clear();
                tf2.clear();
                tf3.clear();

            }
        });

        Button remove = new Button("Remove Patient");

        remove.setStyle("-fx-background-color:Pink");
        remove.setPrefSize(120,15);
        remove.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                remove.setPrefSize(120,30);
                remove.setStyle("-fx-background-color:Yellow");
            }
        });
        remove.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                remove.setPrefSize(120,15);
                remove.setStyle("-fx-background-color:Pink");
            }
        });
        remove.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                sp1.getChildren().remove(r1);
                remove.setStyle("-fx-background-color:#00FFFF");
                String s1 = tf1.getText();
                pt.removePatient(s1);
                tf1.clear();
                tf2.clear();
                tf3.clear();
            }
        });

        Button search = new Button("Search Patient");

        search.setStyle("-fx-background-color:Pink");
        search.setPrefSize(120,15);
        search.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                search.setPrefSize(120,30);
                search.setStyle("-fx-background-color:Yellow");
            }
        });
        search.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                search.setPrefSize(120,15);
                search.setStyle("-fx-background-color:Pink");
            }
        });
        search.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                sp1.getChildren().remove(r1);
                search.setStyle("-fx-background-color:#00FFFF");
                String s1 = tf1.getText();
                pt.searchPatient(s1);
                tf1.clear();
                tf2.clear();
                tf3.clear();
            }
        });

        Button view = new Button("View All Patients");

        view.setStyle("-fx-background-color:Pink");
        view.setPrefSize(120,15);
        view.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.setPrefSize(120,30);
                view.setStyle("-fx-background-color:Yellow");
            }
        });
        view.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.setPrefSize(120,15);
                view.setStyle("-fx-background-color:Pink");
            }
        });
        view.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                view.setStyle("-fx-background-color:#00FFFF");
                pt.viewPatients();
                sp1.getChildren().remove(r1);
                tf1.clear();
                tf2.clear();
                tf3.clear();
            }
        });

        gp.setHgap(10);
        gp.setVgap(10);
        gp.setAlignment(Pos.TOP_CENTER);
        gp.setPadding(new Insets(30));

        gp.add(i1 , 1,2);
        gp.add(i2 , 1,3);
        gp.add(i3 , 1,4);
        gp.add(tf1 , 2,2);
        gp.add(tf2 , 2,3);
        gp.add(tf3 , 2,4);
        gp.add(add,4,15);
        gp.add(view,4,16);
        gp.add(remove,4,17);
        gp.add(search,4,18);

        gp.add(sp1 , 2,5);
        gp.setStyle("-fx-background-color: CYAN;");

        Scene scene = new Scene(gp,800,600);

        stage.setScene(scene);
        stage.setTitle("Patient Management App By RB");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}