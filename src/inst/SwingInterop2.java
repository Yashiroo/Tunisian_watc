/*
 * Copyright (c) 2008, 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle Corporation nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package inst;

import DAO.EtablissementDAO;
import Entities.Etablissement;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.embed.swing.JFXPanel;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.Chart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * SwingInterop2
 *
 * Note using the browser might require setting the properties
 *  - http.proxyHost
 *  - http.proxyPort
 *
 * e.g. -Dhttp.proxyHost=webcache.mydomain.com -Dhttp.proxyPort=8080
 * 
 */
public class SwingInterop2 extends JFrame {

    
    private static final int PANEL_WIDTH_INT = 1100;
    private static final int PANEL_HEIGHT_INT = 460;
    private static final int TABLE_PANEL_HEIGHT_INT = 100;
    public static JFXPanel chartFxPanel;
//    private static JFXPanel browserFxPanel;
//    private static JFXPanel comboBox;
    private static SampleTableModel2 tableModel;
    public  Chart chart;
    private JTable table;
    private JTable table2;
    private Pane browser;
    private GridPane cm;
    public static JPanel panel = new JPanel();
        final Button button = new Button ("Afficher");
        final Button resetButton = new Button ("Réinitialiser");
        final Label notification = new Label ();
        final ComboBox etabComboBox = new ComboBox();
        EtablissementDAO ed = new EtablissementDAO();
//       private static Etablissement etab = new Etablissement();
         public static String etabName;
         private NumberAxis yAxis;
               
      


    public static void main(String[] args) {

                
                
                JFrame frame = new SwingInterop2();
//                "Statistiques réclamations par Etablissement"
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
    }

    public SwingInterop2() throws HeadlessException {
        init();
    }

    

    public void createScene() {
          chart = createBarChart();
          cm = combo();
          Pane root = new Pane();
          Scene scene = new Scene(root);
          cm.setLayoutX(PANEL_WIDTH_INT-310);
          cm.setLayoutY(10);
          chart.setLegendVisible(true);
//          chart.setLegendSide(Side.BOTTOM);
          chart.setTitle("Statistiques");
          
          
          root.getChildren().add(0,chart);

          root.getChildren().add(1,cm);

          chart.setPrefWidth(PANEL_WIDTH_INT-300);
          chartFxPanel.setScene(scene);
//          chartFxPanel.setScene(new Scene(chart));

//        chartFxPanel.setScene(new Scene(cm));
        
        //browserFxPanel.setScene(new Scene(browser));
    }
    
    public BarChart createBarChart() {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(tableModel.getColumnNames()));
        xAxis.setLabel("Etablissement");
        
        double tickUnit = tableModel.getTickUnit();
        
         yAxis = new NumberAxis();
        yAxis.setTickUnit(tickUnit);
        yAxis.setLabel("Réclamations");

        final BarChart chart = new BarChart(xAxis, yAxis, tableModel.getBarChartData());
        tableModel.addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    final int row = e.getFirstRow();
                    final int column = e.getColumn();
                    final Object value = ((SampleTableModel2) e.getSource()).getValueAt(row, column);
                    
                    Platform.runLater(new Runnable() {
                        public void run() {
                            XYChart.Series<String, Number> s = (XYChart.Series<String, Number>) chart.getData().get(row);
                            BarChart.Data data = s.getData().get(column-1);
                            data.setYValue(value);
//                            tableModel = new SampleTableModel(etab);
//                            createScene();
//                            repaint();
                            
                        }
                    });
                }
            }
        });
        return chart;
    }



    private static class DecimalFormatRenderer extends DefaultTableCellRenderer {
        private static final DecimalFormat formatter = new DecimalFormat("#.0");

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if(!(value instanceof String))
            value = formatter.format((Number) value);
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
    

    
    
    
    
    
    
    
    
    
    
    public GridPane combo(){
        

//        this.setTitle("Selection d'un Etablissement");
//        Scene scene = new Scene(new Group());
        

        EtablissementDAO et = new EtablissementDAO();
        List<Etablissement> lt = new ArrayList<Etablissement>();
        lt=et.getAllEtab();
        for(Etablissement e:lt)
        {
        etabComboBox.getItems().addAll(e.getName());
        }
         
        etabComboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (etabComboBox.getValue() != null && 
                    !etabComboBox.getValue().toString().isEmpty()){
                        notification.setText("Statistiques rafraichies" );   
//                        etabComboBox.setValue(null);
//                            ini();
//                          tableModel = new SampleTableModel(etabComboBox.getValue().toString());
                          etabName=etabComboBox.getValue().toString();
                          tableModel = new SampleTableModel2();
                          table2 = new JTable(tableModel);
                          
                          int rows = table.getRowCount()-1;
                          int columns = table.getColumnCount()-1;
                          
                            for(int i=0;i<=rows;i++){
                                for(int j=1;j<=columns;j++){
//                                    System.out.println(table.getModel().getValueAt(i, j).getClass());
                            table.getModel().setValueAt(table2.getModel().getValueAt(i, j),i,j);
                            }
                            }
                            chart.setTitle("Statistiques "+etabName);
                            
                          repaint();

                }
                else {
                    notification.setText("Aucun établissement sélectionné"); 
                }
            }
        });
        
            resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                        notification.setText("Données Réinitialisées" );   
//                        etabComboBox.setValue(null);
//                            ini();
//                          tableModel = new SampleTableModel(etabComboBox.getValue().toString());
//                          etabName=etabComboBox.getValue().toString();
//                          tableModel = new SampleTableModel();
//                          table = new JTable(tableModel);
                            
                            resetTable();

                

            }
        });
        
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("Etablissement"), 0, 0);
        grid.add(etabComboBox, 1, 0);
        

//        grid.add(button, 3, 5,5,2);
        grid.add(resetButton, 2, 8,8,2);
        grid.add (notification, 1, 3, 3, 1);
        
//        Group root = (Group)scene.getRoot();
//        root.getChildren().add(grid);
//        stage.setScene(scene);
//        stage.show();
        return grid;
        
    }
    
    
    private void resetTable()
    {
            
                          
                          
                          int rows = table.getRowCount()-1;
                          int columns = table.getColumnCount()-1;
                          
                            for(int i=0;i<=rows;i++){
                                for(int j=1;j<=columns;j++){
                            table.getModel().setValueAt(new Double(0),i,j);
                            }
                            }

//                            System.out.println("working");
                            etabComboBox.setValue(null);
                            chart.setTitle("Statistiques ");
                          repaint();
                          
        
    }
    
    
    
    
    
    
    public void init() {
//    ini();
    
//    if(etabComboBox.getValue()!=null)
//        tableModel = new SampleTableModel(etabComboBox.getValue().toString());
//    if(etabComboBox.getValue()==null)
        
        
        
        tableModel = new SampleTableModel2();
//        tableModel.setName("STEG");
        
//        etab.setId(1);
    
//    }
//    else if(etab==null)
//        tableModel = new SampleTableModel(); 
        
        
        
    // create javafx panel for charts
    chartFxPanel = new JFXPanel();
    chartFxPanel.setPreferredSize(new Dimension(PANEL_WIDTH_INT, PANEL_HEIGHT_INT));
    
    
    panel.setLayout(new BorderLayout());

    //JTable
//    tableModel.updateTableContent("STEG");
     table = new JTable(tableModel);
     
     
    table.setAutoCreateRowSorter(true);
    table.setGridColor(Color.DARK_GRAY);
    SwingInterop2.DecimalFormatRenderer renderer = new SwingInterop2.DecimalFormatRenderer();
    renderer.setHorizontalAlignment(JLabel.LEFT);
    for (int i = 0; i < table.getColumnCount(); i++) {
        table.getColumnModel().getColumn(i).setCellRenderer(renderer);
    }
    
    JScrollPane tablePanel = new JScrollPane(table);
    tablePanel.setPreferredSize(new Dimension(PANEL_WIDTH_INT, TABLE_PANEL_HEIGHT_INT));

    JPanel chartTablePanel = new JPanel();
    chartTablePanel.setLayout(new BorderLayout());
    chartTablePanel.add(chartFxPanel, BorderLayout.CENTER);

    panel.add(chartTablePanel, BorderLayout.CENTER);
    panel.add(tablePanel, BorderLayout.SOUTH);
    table.getColumnModel().getColumn(0).setMinWidth(150); // reclamations
//    panel.add(comboBox, rootPane);
    add(panel, BorderLayout.CENTER);
    

    
    
    
    
    
    
    
    
    
    
    
    // create JavaFX scene
    Platform.runLater(new Runnable() {
        public void run() {
            createScene();
        }
    });

}
    
    }
