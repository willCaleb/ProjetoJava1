package telas;

import classes.BDVeiculos;
import classes.Carga;
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

public class TelaCadCarga implements ActionListener{
    BDVeiculos bd;

    public TelaCadCarga(BDVeiculos bd) {
        this.bd = bd;
    }
    
    private JFrame tlCad = new JFrame();
    private JLabel lblTara= new JLabel();
    private JLabel lblCarga= new JLabel();
    private JLabel lblPlaca = new JLabel();
    private JLabel lblMarca = new JLabel();
    private JLabel lblModelo = new JLabel();
    private JLabel lblCor = new JLabel();
    private JLabel lblVelMax = new JLabel();
    private JLabel lblQntPist = new JLabel();
    private JLabel lblPoten = new JLabel();
    
    private JTextField txtTara = new JTextField(10);
    private JTextField txtCarga = new JTextField(10);
    private JTextField txtPlaca = new JTextField(15);
    private JTextField txtMarca = new JTextField(15);
    private JTextField txtModelo = new JTextField(15);
    private JTextField txtCor = new JTextField(15);
    private JTextField txtVelMax = new JTextField(8);
    private JTextField txtQntPist = new JTextField(12);
    private JTextField txtPoten = new JTextField(12);
    
    private JButton btnCad = new JButton();
    private JButton btnLimpar = new JButton();
    private JButton btnNovo = new JButton();
    private JButton btnSair = new JButton();
    
    public void mostrarCadastro(){
        int larg = 250, alt = 360;
        tlCad.setSize(larg, alt);
        lblTara.setText("Tara : ");
        lblCarga.setText("Carga max.: ");
        lblPlaca.setText("Placa: ");
        lblMarca.setText("Marca: ");                
        lblModelo.setText("Modelo");
        lblCor.setText("Cor: ");
        lblVelMax.setText("Velocidade max.: ");
        lblQntPist.setText("Qnt. Pistões");
        lblPoten.setText("Potência: ");
        
        btnCad.setText("Cadastrar");
        btnLimpar.setText("Limpar");
        btnNovo.setText("Novo");
        btnSair.setText("Sair");
        
        tlCad.add(lblTara);
        tlCad.add(txtTara);
        tlCad.add(lblCarga);
        tlCad.add(txtCarga);
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
        btnNovo.addActionListener(this);
        btnSair.addActionListener(this);
        
        tlCad.setLayout(new FlowLayout());
        tlCad.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource().equals(btnCad)){
            
            Carga c = new Carga();
            c.setTara(Integer.parseInt(txtTara.getText()));
            c.setCargaMax(Integer.parseInt(txtCarga.getText()));
            c.setPlaca(txtPlaca.getText());
            c.setMarca(txtMarca.getText());
            c.setModelo(txtModelo.getText());
            c.setCor(txtCor.getText());
            try {
                c.setVelocMax(Integer.parseInt(txtVelMax.getText()));
            } catch (VelocException ex) {
                Logger.getLogger(TelaCadCarga.class.getName()).log(Level.SEVERE, null, ex);
            }
            c.getMotor().setQntPist(Integer.parseInt(txtQntPist.getText()));
            c.getMotor().setPotencia(Integer.parseInt(txtPoten.getText()));
            if(bd.consultaCargaPlaca(c) != null){
                JOptionPane.showMessageDialog(tlCad, "Placa já cadastrada!", "ERRO", JOptionPane.WARNING_MESSAGE);
                limparCampos();
            }else{
                bd.cadasCarga(c);          
                limparCampos();
            }
        }
        if(evt.getSource().equals(btnLimpar)){
            limparCampos();
        }
        if(evt.getSource().equals(btnSair)){
            tlCad.dispose();
        }
    }
    private void limparCampos(){
        txtTara.setText("");
        txtCarga.setText("");
        txtPlaca.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtCor.setText("");
        txtVelMax.setText("");
        txtQntPist.setText("");
        txtPoten.setText("");
        txtTara.requestFocus();
    }
}
