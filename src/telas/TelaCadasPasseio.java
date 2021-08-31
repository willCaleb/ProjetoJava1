
package telas;

import classes.BDVeiculos;
import classes.Passeio;
import classes.VelocException;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class TelaCadasPasseio implements ActionListener{
    private BDVeiculos bd;

    public TelaCadasPasseio(BDVeiculos bd) {
        this.bd = bd;
    }
    private JFrame tlCad = new JFrame();
    private JLabel lblQntPas = new JLabel();
    private JLabel lblPlaca = new JLabel();
    private JLabel lblMarca = new JLabel();
    private JLabel lblModelo = new JLabel();
    private JLabel lblCor = new JLabel();
    private JLabel lblQntRodas = new JLabel();
    private JLabel lblVelMax = new JLabel();
    private JLabel lblQntPist = new JLabel();
    private JLabel lblPoten = new JLabel();
    
    private JTextField txtQntPas = new JTextField(10);
    private JTextField txtPlaca = new JTextField(15);
    private JTextField txtMarca = new JTextField(15);
    private JTextField txtModelo = new JTextField(15);
    private JTextField txtCor = new JTextField(15);
    private JTextField txtQntRodas = new JTextField(10);
    private JTextField txtVelMax = new JTextField(8);
    private JTextField txtQntPist = new JTextField(12);
    private JTextField txtPoten = new JTextField(12);
    
    private JButton btnCad = new JButton();
    private JButton btnLimpar = new JButton();
    private JButton btnSair = new JButton();
    
    public void mostrarCadastro(){
        int larg = 250, alt = 340;
        tlCad.setSize(larg, alt);
        
        lblQntPas.setText("Qtd. Passageiros: ");
        lblPlaca.setText("Placa: ");
        lblMarca.setText("Marca: ");                
        lblModelo.setText("Modelo");
        lblCor.setText("Cor: ");
        lblQntRodas.setText("Qnt. Rodas: ");
        lblVelMax.setText("Velocidade max.: ");
        lblQntPist.setText("Qnt. Pistões");
        lblPoten.setText("Potência: ");
        
        btnCad.setText("Cadastrar");
        btnLimpar.setText("Limpar");
        btnSair.setText("Sair");
        
        tlCad.add(lblQntPas);
        tlCad.add(txtQntPas);
        tlCad.add(lblPlaca);
        tlCad.add(txtPlaca);
        tlCad.add(lblMarca);
        tlCad.add(txtMarca);
        tlCad.add(lblModelo);
        tlCad.add(txtModelo);
        tlCad.add(lblCor);
        tlCad.add(txtCor);
        tlCad.add(lblVelMax);
        tlCad.add(txtVelMax);
        tlCad.add(lblQntPist);
        tlCad.add(txtQntPist);
        tlCad.add(lblPoten);
        tlCad.add(txtPoten);
        tlCad.add(btnCad);
        tlCad.add(btnLimpar);
        tlCad.add(btnSair);
        
        btnCad.addActionListener(this);
        btnLimpar.addActionListener(this);
        btnSair.addActionListener(this);
        
        tlCad.setLayout(new FlowLayout());
        tlCad.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource().equals(btnCad)){
            
            Passeio p = new Passeio();
            p.setQntdPassageiros(Integer.parseInt(txtQntPas.getText()));
            p.setPlaca(txtPlaca.getText());
           
            p.setMarca(txtMarca.getText());
            p.setModelo(txtModelo.getText());
            p.setCor(txtCor.getText());
            try {
                p.setVelocMax(Integer.parseInt(txtVelMax.getText()));
            } catch (VelocException ex) {
                ex.exceptionPasseio(p);
            }
            p.getMotor().setQntPist(Integer.parseInt(txtQntPist.getText()));
            p.getMotor().setPotencia(Integer.parseInt(txtPoten.getText()));
            if(bd.consultaPasseioPlaca(p) == null){
                bd.cadasPasseio(p);
            }else{
               JOptionPane.showMessageDialog(tlCad, "Placa já cadastrada!", "ERRO", JOptionPane.WARNING_MESSAGE);
            }        
            
            //bd.impAllPasseios();
            limparCampos();            
        }
        if(evt.getSource().equals(btnLimpar)){
            limparCampos();
        }
        if(evt.getSource().equals(btnSair)){
            tlCad.dispose();
        }
    }
    private void limparCampos(){
        txtQntPas.setText("");
        txtPlaca.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtCor.setText("");
        txtVelMax.setText("");
        txtQntPist.setText("");
        txtPoten.setText("");
        txtQntPas.requestFocus();
    }
}
