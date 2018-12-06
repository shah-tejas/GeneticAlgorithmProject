/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticAlgorithm.userInterface;

import geneticAlgorithm.Arrangement;
import geneticAlgorithm.ArrangementManager;
import geneticAlgorithm.GeneticAlgorithm;
import geneticAlgorithm.Person;
import geneticAlgorithm.Population;
import geneticAlgorithm.Seat;
import geneticAlgorithm.Table;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author prajakta
 */
public class ViewDetailsJPanel extends javax.swing.JPanel {

    Arrangement arrangement;

    /**
     * Creates new form ViewDetailsJPanel
     */
    public ViewDetailsJPanel(int tablesno, int guestsno) {
        initComponents();
        calculateFitness(tablesno, guestsno);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TablesComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDetail = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtInitalFitness = new javax.swing.JLabel();
        txtFinalFitness = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("Table :");

        TablesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TablesComboBoxActionPerformed(evt);
            }
        });

        tableDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Person Id", "Views", "Relation", "Eating Preference"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableDetail);

        jLabel2.setText("Initial Fitness: ");

        txtInitalFitness.setText(" ");

        txtFinalFitness.setText(" ");

        jLabel3.setText("Final Fitness: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(TablesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtInitalFitness, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFinalFitness, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TablesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtInitalFitness)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtFinalFitness)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TablesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TablesComboBoxActionPerformed
         Table table= (Table) TablesComboBox.getSelectedItem();

         int tableId=table.getTableId();
        if (this.arrangement != null) {
            DefaultTableModel model = (DefaultTableModel) tableDetail.getModel();

            model.setRowCount(0);
            for (Table t : this.arrangement.getArrangement()) {
                if (t.getTableId() == tableId) {
                    for (Seat s : t.getSeats()) {
                        Person p = s.getPerson();
                        Object[] row = new Object[4];
                        row[0] = p.getPersonId();
                        row[1] = p.getViews();
                        row[2] = p.getRelation();
                        row[3] = p.getEatingPreferences();
                        model.addRow(row);
                    }
                }
            }

        }

    }//GEN-LAST:event_TablesComboBoxActionPerformed

    private void calculateFitness(int tablesno, int guestsno) {

        int GuestsPerTable = (int) guestsno / tablesno;
        ArrangementManager.setGuestsPerTable(GuestsPerTable);

        //Set number of tables and number of persons
        for (int i = 0; i < tablesno; i++) {
            Table t = new Table();
            for (int j = 0; j < GuestsPerTable; j++) {
                t.getSeats().add(new Seat());
            }
            ArrangementManager.addTable(t);
        }

        //Create initial population and print the fitness
        Population population = new Population(50, true);
        Arrangement fittest = population.getFittest();

        double initialFitness = population.getFittest().getFitness();

        txtInitalFitness.setText(String.valueOf(initialFitness));

        fittest.displayArrangement();

        //evolve the population
        for (int i = 0; i < 100000; i++) {
            population = GeneticAlgorithm.evolvePopulation(population);
        }

        //Print the fitness and the solution
        fittest = population.getFittest();
        double finalFitness = fittest.getFitness();
        txtFinalFitness.setText(String.valueOf(finalFitness));
        fittest.displayArrangement();

        this.arrangement = fittest;

        for (Table t : fittest.getArrangement()) {
            TablesComboBox.addItem(t);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> TablesComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDetail;
    private javax.swing.JLabel txtFinalFitness;
    private javax.swing.JLabel txtInitalFitness;
    // End of variables declaration//GEN-END:variables
}