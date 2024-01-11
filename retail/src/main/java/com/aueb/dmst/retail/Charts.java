package com.aueb.dmst.retail;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;

/**
 * Η κλάση Charts είναι μια εφαρμογή JavaFX που δημιουργεί και εμφανίζει
 * διάφορα είδη διαγραμμάτων βάσει δεδομένων χρήστη που ανακτώνται από την βάση δεδομένων.
 * Τα διαγράμματα περιλαμβάνουν Pie Chart, Area Chart, Bar Chart και Line Chart,
 * αναπαριστώντας διάφορες πτυχές πληροφοριών των προϊόντων.
 */


public class Charts extends Application {

    @Override
    public void start(Stage stage) {

        if (MethodsUser.category == 1) {
           Scene pieChartScene = new Scene(new Group());
           Stage pieChartStage = new Stage();
           pieChartStage.setTitle("ΠΡΟΙΟΝΤΑ");
           pieChartStage.setWidth(800);
           pieChartStage.setHeight(800);

           // Δημιουργεί τα δεδομένα του PieChart με τα κατάλληλα στοιχεία από την DataBase
           ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                   new PieChart.Data(UseDB.selectFromTableString(MethodsUser.username_local, "product_name1"), MethodsUser.total_revenues1),
                   new PieChart.Data(UseDB.selectFromTableString(MethodsUser.username_local, "product_name2"),MethodsUser.total_revenues2 ),
                   new PieChart.Data(UseDB.selectFromTableString(MethodsUser.username_local, "product_name3"), MethodsUser.total_revenues3 ),
                   new PieChart.Data(UseDB.selectFromTableString(MethodsUser.username_local, "product_name4"), MethodsUser.total_revenues4),
                   new PieChart.Data(UseDB.selectFromTableString(MethodsUser.username_local, "product_name5"), MethodsUser.total_revenues5));

            // Υπολογίζει το σύνολο για τον ποσοστιαίο υπολογισμό
            double total = pieChartData.stream().mapToDouble(PieChart.Data::getPieValue).sum();

            // Μορφοποίηση και ορισμός ετικετών ποσοστών
            pieChartData.forEach(data -> {
               double percentage = (data.getPieValue() / total) * 100;
               data.setName(String.format("%s (%.2f%%)", data.getName(), percentage));
            });

           final PieChart chart = new PieChart(pieChartData);
           chart.setTitle("ΠΡΟΙΟΝΤΑ");
           chart.setPrefSize(750,750);
           ((Group) pieChartScene.getRoot()).getChildren().add(chart);
           pieChartStage.setScene(pieChartScene);
           pieChartStage.show();
        }
        // Area Chart --------------------------------------
        
        Stage areaChartStage = new Stage();
        areaChartStage.setTitle("Area Chart Sample");
        final NumberAxis xAxis = new NumberAxis(1, 3, 1);
        final NumberAxis yAxis = new NumberAxis();
        final AreaChart<Number,Number> ac = 
            new AreaChart<Number,Number>(xAxis,yAxis);
        ac.setTitle("ΔΙΑΚΥΜΑΝΣΗ ΠΟΣΟΤΗΤΑΣ ΑΠΟΘΕΜΑΤΩΝ ΣΕ ΔΙΑΣΤΗΜΑ ΤΡΙΩΝ ΗΜΕΡΩΝ");
         // Καταχωρούμε τις τιμές των προιόντων για τις τρεις ημέρες απο την βάση δεδομένων
        XYChart.Series<Number, Number> series1 =
                new XYChart.Series<Number, Number>();
        series1.setName(UseDB.selectFromTableString(MethodsUser.username_local, "product_name1"));
        series1.getData().add(new XYChart.Data(1, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_db_yesterday1") ));
        series1.getData().add(new XYChart.Data(2, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_yesterday1") ));
        series1.getData().add(new XYChart.Data(3, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_now1") ));
      
        
        XYChart.Series<Number, Number> series2 =
                new XYChart.Series<Number, Number>();
        series2.setName(UseDB.selectFromTableString(MethodsUser.username_local, "product_name2"));
        series2.getData().add(new XYChart.Data(1, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_db_yesterday2")));
        series2.getData().add(new XYChart.Data(2, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_yesterday2")));
        series2.getData().add(new XYChart.Data(3, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_now2")));
       
        
        XYChart.Series<Number, Number> series3 =
                new XYChart.Series<Number, Number>();
        series3.setName(UseDB.selectFromTableString(MethodsUser.username_local, "product_name3"));
        series3.getData().add(new XYChart.Data(1, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_db_yesterday3")));
        series3.getData().add(new XYChart.Data(2, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_yesterday3")));
        series3.getData().add(new XYChart.Data(3, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_now3")));
        
        XYChart.Series<Number, Number> series4 =
                new XYChart.Series<Number, Number>();
    series4.setName(UseDB.selectFromTableString(MethodsUser.username_local, "product_name4"));
    series4.getData().add(new XYChart.Data(1, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_db_yesterday4")));
    series4.getData().add(new XYChart.Data(2, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_yesterday4")));
    series4.getData().add(new XYChart.Data(3, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_now4") ));
        
    XYChart.Series<Number, Number> series5 =
            new XYChart.Series<Number, Number>();
    series5.setName(UseDB.selectFromTableString(MethodsUser.username_local, "product_name5"));
    series5.getData().add(new XYChart.Data(1,  UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_db_yesterday5")));
    series5.getData().add(new XYChart.Data(2,  UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_yesterday5")));
    series5.getData().add(new XYChart.Data(3, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_now5")));
        
        Scene areaChartScene  = new Scene(ac,800,600);
        ac.getData().addAll(series1, series2,series3, series4, series5);
        areaChartStage.setScene(areaChartScene);
        areaChartStage.show();
        
        // Bar Chart -------------------------------------------
        
        // Διαδικασία για εύρεση των ονομάτων των προϊόντων από την βάση δεδομένων
        String prod1 = UseDB.selectFromTableString(MethodsUser.username_local, "product_name1");
        String prod2 = UseDB.selectFromTableString(MethodsUser.username_local, "product_name2");
        String prod3 = UseDB.selectFromTableString(MethodsUser.username_local, "product_name3");
        String prod4 = UseDB.selectFromTableString(MethodsUser.username_local, "product_name4");
        String prod5 = UseDB.selectFromTableString(MethodsUser.username_local, "product_name5");
        
        Stage barChartStage = new Stage();
        barChartStage.setTitle("Bar Chart Sample");
        final CategoryAxis x2Axis = new CategoryAxis();
        final NumberAxis y2Axis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(x2Axis,y2Axis);
        bc.setTitle("ΠΟΣΟΤΗΤΑ ΠΡΟΙΟΝΤΩΝ");
        x2Axis.setLabel("ΠΡΟΙΟΝΤΑ");       
        y2Axis.setLabel("ΠΟΣΟΤΗΤΕΣ");
         // Καταχωρούμε για κάθε κατηγορία bar (προχθές, χθες, σήμερα) τις αντίστοιχες τιμές
        XYChart.Series seriesl1 = new XYChart.Series();
        seriesl1.setName("ΠΡΟΧΘΕΣ");       
        seriesl1.getData().add(new XYChart.Data(prod1, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_db_yesterday1")));
        seriesl1.getData().add(new XYChart.Data(prod2, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_db_yesterday2")));
        seriesl1.getData().add(new XYChart.Data(prod3, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_db_yesterday3")));
        seriesl1.getData().add(new XYChart.Data(prod4, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_db_yesterday4")));
        seriesl1.getData().add(new XYChart.Data(prod5, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_db_yesterday5")));      
        
        XYChart.Series seriesl2 = new XYChart.Series();
        seriesl2.setName("ΧΘΕΣ");
        seriesl2.getData().add(new XYChart.Data(prod1, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_yesterday1")));
        seriesl2.getData().add(new XYChart.Data(prod2, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_yesterday2")));
        seriesl2.getData().add(new XYChart.Data(prod3, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_yesterday3")));
        seriesl2.getData().add(new XYChart.Data(prod4, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_yesterday4")));
        seriesl2.getData().add(new XYChart.Data(prod5, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_yesterday5")));  
        
        XYChart.Series seriesl3 = new XYChart.Series();
        seriesl3.setName("ΣΗΜΕΡΑ");
        seriesl3.getData().add(new XYChart.Data(prod1, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_now1")));
        seriesl3.getData().add(new XYChart.Data(prod2, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_now2")));
        seriesl3.getData().add(new XYChart.Data(prod3, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_now3")));
        seriesl3.getData().add(new XYChart.Data(prod4, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_now4")));
        seriesl3.getData().add(new XYChart.Data(prod5, UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_now5")));  
        
        Scene barChartScene  = new Scene(bc,800,600);
        bc.getData().addAll(seriesl1, seriesl2, seriesl3);
        barChartStage.setScene(barChartScene);
        barChartStage.show();
        
        // Line Chart -------------------------------------
        
        Stage lineChartStage = new Stage();
        lineChartStage.setTitle("Line Chart Sample");
        final CategoryAxis x3Axis = new CategoryAxis();
        final NumberAxis y3Axis = new NumberAxis();
         x3Axis.setLabel("DAYS");
        final LineChart<String,Number> lineChart = 
                new LineChart<String,Number>(x3Axis,y3Axis);
       
        lineChart.setTitle("ΠΟΣΟΤΗΤΑ ΑΠΟΘΕΜΑΤΩΝ ΣΕ ΔΙΑΣΤΗΜΑ ΤΡΙΩΝ ΗΜΕΡΩΝ");
         // Καταχωρούμε για κάθε γραμμή (προχθές, χθες, σήμερα) τις αντίστοιχες τιμές                 
        XYChart.Series seriesb1 = new XYChart.Series();
        seriesb1.setName(UseDB.selectFromTableString(MethodsUser.username_local, "product_name1"));
        
        seriesb1.getData().add(new XYChart.Data("ΠΡΟΧΘΕΣ",UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_db_yesterday1")));
        seriesb1.getData().add(new XYChart.Data("ΧΘΕΣ", UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_yesterday1")));
        seriesb1.getData().add(new XYChart.Data("ΣΗΜΕΡΑ", UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_now1")));
        
        XYChart.Series seriesb2 = new XYChart.Series();
        seriesb2.setName(UseDB.selectFromTableString(MethodsUser.username_local, "product_name2"));
        
        seriesb2.getData().add(new XYChart.Data("ΠΡΟΧΘΕΣ",UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_db_yesterday2")));
        seriesb2.getData().add(new XYChart.Data("ΧΘΕΣ", UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_yesterday2")));
        seriesb2.getData().add(new XYChart.Data("ΣΗΜΕΡΑ", UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_now2")));
        
        XYChart.Series seriesb3 = new XYChart.Series();
        seriesb3.setName(UseDB.selectFromTableString(MethodsUser.username_local, "product_name3"));
        
        seriesb3.getData().add(new XYChart.Data("ΠΡΟΧΘΕΣ",UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_db_yesterday3")));
        seriesb3.getData().add(new XYChart.Data("ΧΘΕΣ", UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_yesterday3")));
        seriesb3.getData().add(new XYChart.Data("ΣΗΜΕΡΑ", UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_now3")));
        
        XYChart.Series seriesb4 = new XYChart.Series();
        seriesb4.setName(UseDB.selectFromTableString(MethodsUser.username_local, "product_name4"));
        
        seriesb4.getData().add(new XYChart.Data("ΠΡΟΧΘΕΣ",UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_db_yesterday4")));
        seriesb4.getData().add(new XYChart.Data("ΧΘΕΣ", UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_yesterday4")));
        seriesb4.getData().add(new XYChart.Data("ΣΗΜΕΡΑ", UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_now4")));
        
        XYChart.Series seriesb5 = new XYChart.Series();
        seriesb5.setName(UseDB.selectFromTableString(MethodsUser.username_local, "product_name5"));
        
        seriesb5.getData().add(new XYChart.Data("ΠΡΟΧΘΕΣ",UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_db_yesterday5")));
        seriesb5.getData().add(new XYChart.Data("ΧΘΕΣ", UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_yesterday5")));
        seriesb5.getData().add(new XYChart.Data("ΣΗΜΕΡΑ", UseDB.selectFromTableNumber(MethodsUser.username_local, "pr_now5")));
        
        Scene lineChartScene  = new Scene(lineChart,800,600);
        lineChart.getData().addAll(seriesb1, seriesb2, seriesb3, seriesb4, seriesb5);
       
        lineChartStage.setScene(lineChartScene);
        lineChartStage.show();
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}
