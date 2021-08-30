
package telas;

import classes.BDVeiculos;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class TelaInicial implements ActionListener{
    private JFrame tlPrinc = new JFrame();
    private JButton btnPasseio = new JButton();
    private JButton btnCarga = new JButton();
    private BDVeiculos bd = new BDVeiculos();
    public void mostraPrincipal(){
        tlPrinc.setSize(185, 120);
        btnPasseio.setText("Passeio");
        btnCarga.setText("Carga");
        tlPrinc.add(btnPasseio);
        tlPrinc.add(btnCarga);
        btnPasseio.addActionListener(this);
        btnCarga.addActionListener(this);
        tlPrinc.setDefaultCloseOperation(EXIT_ON_CLOSE);
        tlPrinc.setLayout(new GridLayout(2,1));
        tlPrinc.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource().equals(btnPasseio)){
            TelaPasseio tp = new TelaPasseio(bd);
            tp.mostraPasseio();
        }
        if(evt.getSource().equals(btnCarga)){
            TelaCarga tc = new TelaCarga(bd);
            tc.mostraCarga();
        }
    }
}
