
package telas;

import classes.BDVeiculos;
import classes.Passeio;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class TelaConsPlacaPasseio implements ActionListener {
    private JFrame tlCons = new JFrame();
    private JLabel lblQntPas = new JLabel();
    private JLabel lblPlaca = new JLabel();
    private JLabel lblMarca = new JLabel();
    private JLabel lblModelo = new JLabel();
    private JLabel lblCor = new JLabel();
    private JLabel lblVelMax = new JLabel();
    private JLabel lblQntPist = new JLabel();
    private JLabel lblPoten = new JLabel();
    
    private JTextField txtQntPas = new JTextField(10);
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
    private BDVeiculos bd ;

    public TelaConsPlacaPasseio(BDVeiculos bd) {
        this.bd = bd;
    }
    
    
    public void mostrarTelaCons(){
        int larg = 250, alt = 340;
        tlCons.setSize(larg, alt);
        lblPlaca.setForeground(Color.red);
        lblPlaca.setText("Informe a placa: ");
        lblQntPas.setText("Qtd. Passageiros: ");        
        lblMarca.setText("Marca: ");                
        lblModelo.setText("Modelo");
        lblCor.setText("Cor: ");
        lblVelMax.setText("Velocidade max.: ");
        lblQntPist.setText("Qnt. Pistões");
        lblPoten.setText("Potência: ");
        
        btnCons.setText("Consultar");
        btnCons.setMnemonic('I');
        btnExcluir.setText("Excluir");
        btnSair.setText("Sair");
        btnCons.setForeground(Color.red);
        btnExcluir.setForeground(Color.red);
        btnCons.setBackground(Color.yellow);
        btnExcluir.setBackground(Color.yellow);
        
        tlCons.add(lblPlaca);
        tlCons.add(txtPlaca);
        tlCons.add(lblQntPas);
        tlCons.add(txtQntPas);
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
        
        btnCons.addActionListener(this);
        btnExcluir.addActionListener(this);
        btnSair.addActionListener(this);
        
        tlCons.setLayout(new FlowLayout());
        tlCons.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent evt){

        if(evt.getSource().equals(btnCons)){
            Passeio p = new Passeio();
            p.setPlaca(txtPlaca.getText());
            p = bd.consultaPasseioPlaca(p);
            if(p != null){
                txtQntPas.setText(Integer.toString(p.getQntdPassageiros()));
                txtMarca.setText(p.getMarca());
                txtModelo.setText(p.getModelo());
                txtCor.setText(p.getCor());
                txtVelMax.setText(Integer.toString(p.getVelocMax()));
                txtQntPist.setText(Integer.toString(p.getMotor().getQntPist()));
                txtPoten.setText(Integer.toString(p.getMotor().getPotencia()));
                txtQntPas.setEditable(false);
                txtMarca.setEditable(false);
                txtModelo.setEditable(false);
                txtCor.setEditable(false);
                txtVelMax.setEditable(false);
                txtQntPist.setEditable(false);
                txtPoten.setEditable(false);
            }else{
                JOptionPane.showMessageDialog(tlCons, "Placa já cadastrada","Atenção", JOptionPane.WARNING_MESSAGE);

            }
        }
        if(evt.getSource().equals(btnExcluir)){
            Passeio p = new Passeio();
            p.setPlaca(txtPlaca.getText());
            p = bd.consultaPasseioPlaca(p);
            for(int i = 0; i < bd.getBdPas().size(); i++){
                if(bd.getBdPas().get(i).getPlaca().equalsIgnoreCase(p.getPlaca())){
                    bd.getBdPas().remove(i);
                    //System.out.println(placa);
                    JOptionPane.showMessageDialog(tlCons, "Carro de passeio com a placa " + p.getPlaca() + " Excluido", "Atenção", JOptionPane.WARNING_MESSAGE);
                    txtQntPas.setText("");
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
