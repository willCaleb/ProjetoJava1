
package telas;

import classes.BDVeiculos;
import classes.Carga;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


class TelaImpCarga implements ActionListener{
    BDVeiculos bd;

    public TelaImpCarga(BDVeiculos bd) {
        this.bd = bd;
    }
    private JFrame janImp = new JFrame();
    private String[] col = {"Placa", "Marca", "Modelo", "Cor", "Veloc. Máx", "Qntd Pist", "Potência", "Tara", "Carga máx"};
    private DefaultTableModel model = new DefaultTableModel(col, 0);
    private JTable tab = new JTable(model);
    private JScrollPane rol = new JScrollPane(tab);
    
    private JButton btnImp = new JButton();
    private JButton btnExc = new JButton();
    private JButton btnSair = new JButton();
    private JPanel painelBtn = new JPanel();
    private int larg = 1000, alt = 500;
    
    public void mostrarTela(){
        janImp.setLayout(new GridLayout(4,1,10,10));
        //painelBtn.setMaximumSize(new Dimension(larg, 200));
        //painelBtn.setPreferredSize(new Dimension(5,5));
        janImp.setSize(larg, alt);
        janImp.setTitle("Imprimir/Excluir todos");  
        btnImp.setText("Imprimir todos");
        btnImp.addActionListener(this);
        btnExc.setText("Excluir todos");
        btnExc.addActionListener(this);
        btnSair.setText("Sair");
        btnSair.addActionListener(this);
        //painelBtn.setBounds(0, 0, larg, alt);
        //btnImp.setPreferredSize(new Dimension(20,10));
        painelBtn.add(btnImp);
        painelBtn.add(btnExc);
        painelBtn.add(btnSair);
        //rol.setSize(larg, 300);
        janImp.add(rol);
        janImp.add(painelBtn);
        janImp.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource().equals(btnImp)){
            listarCarga();
        }
        if(evt.getSource().equals(btnExc)){
            bd.setBdCarga(new ArrayList<>());
            model = new DefaultTableModel();
            tab.setModel(model);
        }
        if(evt.getSource().equals(btnSair)){
            janImp.dispose();
        }
    }
    private void listarCarga(){
        model = new DefaultTableModel(col, 0);
        for(Carga c : bd.getBdCarga()){
            String[] dados = {c.getPlaca(),c.getMarca(), c.getModelo(), c.getCor(),
                Integer.toString(c.calcVel(c.getVelocMax())), Integer.toString(c.getMotor().getQntPist()),
                Integer.toString(c.getMotor().getQntPist()), Integer.toString(c.getTara()), 
                Integer.toString(c.getCargaMax())};
            model.addRow(dados);
        }
        tab.setModel(model);
    }

}
