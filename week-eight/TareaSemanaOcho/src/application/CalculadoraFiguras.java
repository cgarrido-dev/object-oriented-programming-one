package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class CalculadoraFiguras extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculadora de Volumen y Superficie");

        TabPane tabPane = new TabPane();

        Tab tabCaja = new Tab("Caja", crearVistaCaja());
        Tab tabCilindro = new Tab("Cilindro", crearVistaCilindro());
        Tab tabEsfera = new Tab("Esfera", crearVistaEsfera());

        tabPane.getTabs().addAll(tabCaja, tabCilindro, tabEsfera);

        Scene scene = new Scene(tabPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox crearVistaCaja() {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        
        TextField tfLongitud = new TextField();
        TextField tfAnchura = new TextField();
        TextField tfAltura = new TextField();
        Button btnCalcular = new Button("Calcular");

        Label resultado = new Label();

        btnCalcular.setOnAction(e -> {
            if (validarEntrada(tfLongitud, tfAnchura, tfAltura)) {
                double longitud = Double.parseDouble(tfLongitud.getText());
                double anchura = Double.parseDouble(tfAnchura.getText());
                double altura = Double.parseDouble(tfAltura.getText());

                Caja caja = new Caja(longitud, anchura, altura);
                resultado.setText("Volumen: " + caja.calcularVolumen() + 
                                  "\nSuperficie: " + caja.calcularSuperficie());
            } else {
                resultado.setText("Por favor, ingrese valores válidos.");
            }
        });

        tfAltura.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                btnCalcular.fire();
            }
        });

        vbox.getChildren().addAll(new Label("Longitud (cm)"), tfLongitud,
                                  new Label("Anchura (cm)"), tfAnchura,
                                  new Label("Altura (cm)"), tfAltura,
                                  btnCalcular, resultado);

        return vbox;
    }

    private VBox crearVistaCilindro() {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        
        TextField tfRadio = new TextField();
        TextField tfAltura = new TextField();
        Button btnCalcular = new Button("Calcular");

        Label resultado = new Label();

        btnCalcular.setOnAction(e -> {
            if (validarEntrada(tfRadio, tfAltura)) {
                double radio = Double.parseDouble(tfRadio.getText());
                double altura = Double.parseDouble(tfAltura.getText());

                Cilindro cilindro = new Cilindro(radio, altura);
                resultado.setText("Volumen: " + cilindro.calcularVolumen() + 
                                  "\nSuperficie: " + cilindro.calcularSuperficie());
            } else {
                resultado.setText("Por favor, ingrese valores válidos.");
            }
        });

        tfAltura.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                btnCalcular.fire();
            }
        });

        vbox.getChildren().addAll(new Label("Radio (cm)"), tfRadio,
                                  new Label("Altura (cm)"), tfAltura,
                                  btnCalcular, resultado);

        return vbox;
    }

    private VBox crearVistaEsfera() {
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        
        TextField tfRadio = new TextField();
        Button btnCalcular = new Button("Calcular");

        Label resultado = new Label();

        btnCalcular.setOnAction(e -> {
            if (validarEntrada(tfRadio)) {
                double radio = Double.parseDouble(tfRadio.getText());

                Esfera esfera = new Esfera(radio);
                resultado.setText("Volumen: " + esfera.calcularVolumen() + 
                                  "\nSuperficie: " + esfera.calcularSuperficie());
            } else {
                resultado.setText("Por favor, ingrese valores válidos.");
            }
        });

        tfRadio.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                btnCalcular.fire();
            }
        });

        vbox.getChildren().addAll(new Label("Radio (cm)"), tfRadio, btnCalcular, resultado);

        return vbox;
    }

    private boolean validarEntrada(TextField... campos) {
        for (TextField campo : campos) {
            try {
                Double.parseDouble(campo.getText());
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Caja extends Figura {
    private double longitud, anchura, altura;

    public Caja(double longitud, double anchura, double altura) {
        this.longitud = longitud;
        this.anchura = anchura;
        this.altura = altura;
    }

    @Override
    public double calcularVolumen() {
        return longitud * anchura * altura;
    }

    @Override
    public double calcularSuperficie() {
        return 2 * (longitud * anchura + longitud * altura + anchura * altura);
    }
}

class Cilindro extends Figura {
    private double radio, altura;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
    }

    @Override
    public double calcularVolumen() {
        return Math.PI * Math.pow(radio, 2) * altura;
    }

    @Override
    public double calcularSuperficie() {
        return 2 * Math.PI * radio * (radio + altura);
    }
}

class Esfera extends Figura {
    private double radio;

    public Esfera(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularVolumen() {
        return (4.0/3.0) * Math.PI * Math.pow(radio, 3);
    }

    @Override
    public double calcularSuperficie() {
        return 4 * Math.PI * Math.pow(radio, 2);
    }
}

abstract class Figura {
    public abstract double calcularVolumen();
    public abstract double calcularSuperficie();
}
