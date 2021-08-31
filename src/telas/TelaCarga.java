
package telas;

import classes.BDVeiculos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaCarga implements ActionListener {
    private JFrame tlCarga = new JFrame();
    private JButton btnCad = new JButton();
    private JButton btnCons = new JButton();
    private JButton btnImp = new JButton();
    private JButton btnSair = new JButton();
    private JLabel lblCad = new JLabel();
    private JLabel lblCons = new JLabel();
    private JLabel lblImp = new JLabel();
    private JLabel lblSair = new JLabel();
    private BorderLayout layout;
    BDVeiculos bd;

    public TelaCarga(BDVeiculos bd) {
        this.bd = bd;
    }
    
    public void mostraCarga(){

        tlCarga.setSize(350, 200);
        tlCarga.setTitle("Veículos de Carga");
        btnCad.setText("+");
        lblCad.setText("Cadastrar");
        btnCons.setText("?");
        lblCons.setText("Consultar/Excluir pela placa");
        lblImp.setText("Imprimir/Excluir todos");
        btnImp.setText("X");
        lblSair.setText("Sair");
        btnSair.setText("S");
        
        btnCad.setBackground(new Color(30, 144, 255));
        btnCons.setBackground(new Color(30, 144, 255));
        btnImp.setBackground(new Color(30, 144, 255));
        btnSair.setBackground(new Color(255, 0, 0));
        
        tlCarga.add(btnCad);
        tlCarga.add(lblCad);
        tlCarga.add(btnCons);
        tlCarga.add(lblCons);
        tlCarga.add(btnImp);
        tlCarga.add(lblImp);        
        tlCarga.add(btnSair);
        tlCarga.add(lblSair);
        btnCad.addActionListener(this);
        btnCons.addActionListener(this);
        btnImp.addActionListener(this);
        btnSair.addActionListener(this);
        
        tlCarga.setLayout(new GridLayout(4,2, 10, 10));
        tlCarga.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource().equals(btnCad)){
            TelaCadCarga tc = new TelaCadCarga(bd);
            tc.mostrarCadastro();
        }
        if(evt.getSource().equals(btnCons)){
            if(evt.getSource().equals(btnCons)){
                TelaConsPlacaCarga tcp = new TelaConsPlacaCarga(bd);
                tcp.mostrarTelaCons();
            }
        }
        if(evt.getSource().equals(btnImp)){
            TelaImpCarga tip = new TelaImpCarga(bd);
            tip.mostrarTela();
        }
        if(evt.getSource().equals(btnSair)){
            tlCarga.dispose();
        }
    }
}
