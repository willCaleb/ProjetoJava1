
package telas;

import classes.BDVeiculos;
import classes.Passeio;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaImpPasseio implements ActionListener{

    private JFrame janImp = new JFrame();
    private String[] col = {"Placa", "Marca", "Modelo", "Cor", "Veloc Max", "Qnt Pist", "Potência", "Qnt. Passag"};
    private DefaultTableModel model = new DefaultTableModel(col, 0);
    private JTable tab = new JTable(model);
    private JScrollPane barraRol = new JScrollPane(tab);
    private BDVeiculos bd;

    public TelaImpPasseio(BDVeiculos bd) {
        this.bd = bd;
    }        
    private JButton btnImp = new JButton();
    private JButton btnExc = new JButton();
    private JButton btnSair = new JButton();
    private JPanel painelBtn = new JPanel();
    private int larg = 600, alt = 500;
    
    public void mostrarJanela(){
        //janImp.setDefaultCloseOperation(EXIT_ON_CLOSE);
        janImp.setLayout(new GridLayout(4, 1, 10, 10));
        janImp.setSize(larg, alt);
        janImp.setTitle("Imprimir/Excluir todos");
        painelBtn.setSize(600, 200);
        btnImp.setText("Imprimir todos");
        btnImp.setMnemonic('I');
        btnImp.addActionListener(this);
        
        btnExc.setText("Excluir todos");
        btnExc.setMnemonic('E');
        btnExc.addActionListener(this);      
        
        btnSair.setText("Sair");
        btnSair.setMnemonic('S');
        btnSair.addActionListener(this);
        
        janImp.add(barraRol);
        painelBtn.add(btnImp);
        painelBtn.add(btnExc);
        painelBtn.add(btnSair);
        janImp.add(painelBtn);

        janImp.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource().equals(btnImp)){
            listarPasseio();
        }
        if(evt.getSource().equals(btnExc)){
            excluirTodos();
        }
        if(evt.getSource().equals(btnSair)){
            janImp.dispose();
        }
    }
    public void listarPasseio(){
        //List<Passeio> listPas = bd.getBdPas();
        model = new DefaultTableModel(col, 0);
        for(Passeio p : bd.getBdPas()){
            String[] dados = {p.getPlaca(), p.getMarca(), p.getModelo(), p.getCor(), 
                Integer.toString(p.calcVel(p.getVelocMax())), Integer.toString(p.getMotor().getQntPist()),
                Integer.toString(p.getMotor().getPotencia(), p.getQntdPassageiros())};
            model.addRow(dados);
        }
        tab.setModel(model);
    }
    public void excluirTodos(){
        for(int i = 0; i < bd.getBdPas().size(); i++){
            bd.getBdPas().remove(i);
        }
        model = new DefaultTableModel(col, 0);
        tab.setModel(model);
    }
}
