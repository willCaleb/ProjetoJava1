
package telas;

import classes.BDVeiculos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class TelaPasseio implements ActionListener{
    private JFrame tlPasseio = new JFrame();
    private JButton btnCad = new JButton();
    private JButton btnCons = new JButton();
    private JButton btnImp = new JButton();
    private JButton btnSair = new JButton();
    private JLabel lblCad = new JLabel();
    private JLabel lblCons = new JLabel();
    private JLabel lblImp = new JLabel();
    private JLabel lblSair = new JLabel();
    private BDVeiculos bd;

    public TelaPasseio(BDVeiculos bd) {
        this.bd = bd;
    }
    
    
    public void mostraPasseio(){
        //layout = new BorderLayout(5,5);
        tlPasseio.setSize(390, 200);
        //btnCad.setSize(20, 15);
        btnCad.setText("+");
        lblCad.setText("Cadastrar");
        btnCons.setText("?");
        lblCons.setText("Consultar/Excluir pela placa");
        lblImp.setText("Imprimir/Excluir todos");
        btnImp.setText("X");
        lblSair.setText("Sair");
        btnSair.setText("S");
        //btnCad.setPreferredSize(new Dimension(10,20));
        
        btnCad.setBackground(new Color(30, 144, 255));
        btnCons.setBackground(new Color(30, 144, 255));
        btnImp.setBackground(new Color(30, 144, 255));
        btnSair.setBackground(new Color(255, 0, 0));
        
        tlPasseio.add(btnCad);
        tlPasseio.add(lblCad);
        tlPasseio.add(btnCons);
        tlPasseio.add(lblCons);
        tlPasseio.add(btnImp);
        tlPasseio.add(lblImp);        
        tlPasseio.add(btnSair);
        tlPasseio.add(lblSair);
        btnCad.addActionListener(this);
        btnCons.addActionListener(this);
        btnImp.addActionListener(this);
        btnSair.addActionListener(this);
        
        tlPasseio.setLayout(new GridLayout(4, 2, 30, 10));
        tlPasseio.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource().equals(btnCad)){
            TelaCadasPasseio tlCad = new TelaCadasPasseio(bd);
            tlCad.mostrarCadastro();
        }
        if(evt.getSource().equals(btnCons)){
            TelaConsPlacaPasseio tcp = new TelaConsPlacaPasseio(bd);
            tcp.mostrarTelaCons();
        }
        if(evt.getSource().equals(btnImp)){
            TelaImpPasseio ti = new TelaImpPasseio(bd);
            ti.mostrarJanela();
        }
        if(evt.getSource().equals(btnSair)){
            tlPasseio.dispose();
        }
    }
}
