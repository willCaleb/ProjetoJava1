package classes;


import telas.TelaCadCarga;
import telas.TelaCadasPasseio;
import telas.TelaCarga;
import telas.TelaConsPlacaCarga;
import telas.TelaConsPlacaPasseio;
import telas.TelaImpPasseio;
import telas.TelaPasseio;
import telas.TelaInicial;


public class Teste {
    private static Carga carga;
    private static Passeio passeio;
    private static Leitura leitura = new Leitura();
    //private static BDVeiculos bd = new BDVeiculos();
    private static TelaInicial tlPrinc = new TelaInicial();
   // public static TelaPasseio tp = new TelaPasseio();
    //static TelaCadCarga tlCad = new TelaCadCarga();
    //static TelaCadasPasseio cadPas = new TelaCadasPasseio();
    //static TelaConsPlacaCarga tcp = new TelaConsPlacaCarga();
    //static TelaCarga tc = new TelaCarga();
    //static TelaImpPasseio tip = new TelaImpPasseio();
    public static void main(String[] args) {
        //tlCad.mostrarCadastro();
        //tp.mostraPasseio();
        //tip.mostrarJanela();
        //cadPas.mostrarCadastro();
        //tcp.mostrarTelaCons();
        //tlCad.mostrarCadastro();
        tlPrinc.mostraPrincipal();
        /*int opcao = 0;
        boolean continua = true;                    
        while(continua){
            System.out.println("|===============================================|");
            System.out.println("|                                               |");
            System.out.println("| Sistema de Gestão de Veículos - Menu Inicial  |");
            System.out.println("|                                               |");
            System.out.println("| 1 - Cadastrar veículo de Passeio              |");
            System.out.println("| 2 - Cadastrar veículo de Carga                |");
            System.out.println("| 3 - Imprimir todos os veículos de Passeio     |");
            System.out.println("| 4 - Imprimir todos os veículos de Carga       |");
            System.out.println("| 5 - Imprimir veículo de Passeio pela placa    |");
            System.out.println("| 6 - Imprimir veículo de Carga pela placa      |");
            System.out.println("| 7 - Excluir veículo de Passeio pela placa     |");
            System.out.println("| 7 - Excluir veículo de Carga pela placa       |");
            System.out.println("| 9 - Sair do Sistema                           |");
            System.out.println("|                                               |");
            System.out.println("|===============================================|");
            
            try{
                opcao = Integer.parseInt(leitura.entDados("Escolha uma opção: "));
            }catch(NumberFormatException e){
                System.out.println("Entre um valor inteiro - press<ENTER>" + e);
                leitura.entDados("");                
                continue;
            }
            
            switch(opcao){
            case 1:
                passeio = new Passeio();                                      
                System.out.println("=========CADASTRO DE VEÍCULO DE PASSEIO==========");       
                passeio.setPlaca(leitura.entDados("Placa: "));
                if(bd.consultaPasseioPlaca(passeio) != null){
                    System.out.println("Placa já cadastrada!");
                    break;
                }
                passeio.setMarca(leitura.entDados("Marca: "));
                passeio.setModelo(leitura.entDados("Modelo: "));
                passeio.setCor(leitura.entDados("Cor: "));
                try{
                    passeio.setVelocMax(Integer.parseInt(leitura.entDados("Velocidade máx: ")));
                }catch(VelocException ve){
                    passeio = ve.exceptionPasseio(passeio);
                }
                passeio.getMotor().setQntPist(Integer.parseInt(leitura.entDados("Quantidade de pistões: ")));
                passeio.getMotor().setPotencia(Integer.parseInt(leitura.entDados("Potência: ")));
                passeio.setQntdPassageiros(Integer.parseInt(leitura.entDados("Quantidade de passageiros: ")));
            
                bd.cadasPasseio(passeio);
                break;                
            case 2:
                carga = new Carga();
                System.out.println("=====CADASTRAR VEÍCULO DE CARGA=====");
                carga.setPlaca(leitura.entDados("Placa: "));
                if(bd.consultaCargaPlaca(carga) != null){
                    System.out.println("Placa já cadastrada!");
                    break;
                }
                carga.setMarca(leitura.entDados("Marca: "));
                carga.setModelo(leitura.entDados("Modelo: "));                                               
                carga.setCor(leitura.entDados("Cor: "));
                carga.getMotor().setPotencia(Integer.parseInt(leitura.entDados("Potência: ")));     
                carga.getMotor().setQntPist(Integer.parseInt(leitura.entDados("Qntd de pistões: ")));
                carga.setCargaMax(Integer.parseInt(leitura.entDados("Carga máxima: ")));                        
                carga.setTara(Integer.parseInt(leitura.entDados("Tara: ")));
                try {
                    carga.setVelocMax(Integer.parseInt(leitura.entDados("Velocidade máx: ")));
                } catch (VelocException ex) {                    
                    carga = ex.exceptioCarga(carga);                
                }                
                bd.cadasCarga(carga);              
                break;
            case 3: 
                bd.impAllPasseios();
                break;
            case 4:
                bd.impAllCargas();                
                break;
            case 5:
                passeio = new Passeio();
                passeio.setPlaca(leitura.entDados("Digite a placa do veículo de Passeio: "));
                passeio = bd.consultaPasseioPlaca(passeio);
                if(passeio != null){
                    //bd.consultaPasseioPlaca(passeio);
                    bd.impPasseio(passeio);
                }
                break;
            case 6:
                carga = new Carga();
                carga.setPlaca(leitura.entDados("Digite a placa a ser pesquisada: "));
                carga = bd.consultaCargaPlaca(carga);   
                if(carga != null){
                    bd.impCarga(carga);
                }
                break;
            case 7:
                passeio = new Passeio();
                passeio.setPlaca(leitura.entDados("Digita a placa a ser excluida: "));
                bd.excluirPasseio(passeio);
                break;
            case 8:
                carga = new Carga();
                carga.setPlaca(leitura.entDados("Digite a placa a ser excluida: "));
                bd.excluirCarga(carga);
                break;
            case 9:
                String confirma = leitura.entDados("Deseja sair do programa? <s/n>");
                if(confirma.equalsIgnoreCase("s")){
                    continua = false;
                }
                break;
            default:
                leitura.entDados("Digite um valor válido >=1 <=7");
                break;
            }            
        }*/                       
    }
}

