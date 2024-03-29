
package telas;

import classes.BDVeiculos;
import classes.Carga;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaConsPlacaCarga implements ActionListener {
    BDVeiculos bd;

    public TelaConsPlacaCarga(BDVeiculos bd) {
        this.bd = bd;
    }
    private JFrame tlCons = new JFrame();
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
    private JTextField txtPlaca = new JTextField(8);
    private JTextField txtMarca = new JTextField(15);
    private JTextField txtModelo = new JTextField(15);
    private JTextField txtCor = new JTextField(15);
    private JTextField txtVelMax = new JTextField(8);
    private JTextField txtQntPist = new JTextField(12);
    private JTextField txtPoten = new JTextField(12);
    
    private JButton btnCons = new JButton();
    private JButton btnExcluir = new JButton();
    private JButton btnSair = new JButton();
    
    public void mostrarTelaCons(){
        int larg = 250, alt = 340;
        tlCons.setSize(larg, alt);
        lblPlaca.setForeground(Color.red);
        lblPlaca.setText("Informe a placa: ");
        lblTara.setText("Tara : ");  
        lblCarga.setText("Carga max.: ");
        lblMarca.setText("Marca: ");                
        lblModelo.setText("Modelo");
        lblCor.setText("Cor: ");
        lblVelMax.setText("Velocidade max.: ");
        lblQntPist.setText("Qnt. Pistões");
        lblPoten.setText("Potência: ");
        
        btnCons.setText("Consultar");
        btnExcluir.setText("Excluir");
        btnSair.setText("Sair");
        btnCons.setForeground(Color.red);
        btnExcluir.setForeground(Color.red);
        btnCons.setBackground(Color.yellow);
        btnExcluir.setBackground(Color.yellow);
        
        tlCons.add(lblPlaca);
        tlCons.add(txtPlaca);
        tlCons.add(lblTara);
        tlCons.add(txtTara);
        tlCons.add(lblCarga);
        tlCons.add(txtCarga);
        tlCons.add(lblMarca);
        tlCons.add(txtMarca);
        tlCons.add(lblModelo);
        tlCons.add(txtModelo);
        tlCons.add(lblCor);
        tlCons.add(txtCor);
        tlCons.add(lblVelMax);
        tlCons.add(txtVelMax);
        tlCons.add(lblQntPist);
        tlCons.add(txtQntPist);
        tlCons.add(lblPoten);
        tlCons.add(txtPoten);
        tlCons.add(btnCons);
        tlCons.add(btnExcluir);
        tlCons.add(btnSair);
        txtTara.setEditable(false);
        txtCarga.setEditable(false);
        txtMarca.setEditable(false);
        txtModelo.setEditable(false);
        txtCor.setEditable(false);
        txtVelMax.setEditable(false);
        txtQntPist.setEditable(false);
        txtPoten.setEditable(false);
        
        btnCons.addActionListener(this);
        btnExcluir.addActionListener(this);
        btnSair.addActionListener(this);
        
        tlCons.setLayout(new FlowLayout());
        tlCons.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource().equals(btnCons)){
            Carga c = new Carga();
            c.setPlaca(txtPlaca.getText());
            c = bd.consultaCargaPlaca(c);
            if(c != null){
                txtTara.setText(Integer.toString(c.getTara()));
                txtCarga.setText(Integer.toString(c.getCargaMax()));
                txtMarca.setText(c.getMarca());
                txtModelo.setText(c.getModelo());
                txtCor.setText(c.getCor());
                txtVelMax.setText(Integer.toString(c.calcVel(c.getVelocMax())));
                txtQntPist.setText(Integer.toString(c.getMotor().getQntPist()));
                txtPoten.setText(Integer.toString(c.getMotor().getPotencia()));            
            }else{
                JOptionPane.showMessageDialog(tlCons, "Placa não cadastrada", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        }
        if(evt.getSource().equals(btnExcluir)){
            Carga c = new Carga();
            c.setPlaca(txtPlaca.getText());
            for(int i = 0; i < bd.getBdCarga().size(); i++){
                if(bd.getBdCarga().get(i).getPlaca().equalsIgnoreCase(c.getPlaca())){
                    bd.getBdCarga().remove(i);
                    JOptionPane.showMessageDialog(tlCons, "Carro de Carga com a placa " + c.getPlaca() + 
                            " Excluido", "Atenção", JOptionPane.WARNING_MESSAGE);
                    txtPlaca.setText("");
                    txtTara.setText("");
                    txtCarga.setText("");
                    txtMarca.setText("");
                    txtModelo.setText("");
                    txtCor.setText("");
                    txtVelMax.setText("");
                    txtQntPist.setText("");
                    txtPoten.setText("");   
                }
            }
        }
        if(evt.getSource().equals(btnSair)){
            tlCons.dispose();
        }
    }
}