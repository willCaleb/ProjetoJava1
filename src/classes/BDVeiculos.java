package classes;


import java.util.ArrayList;
import java.util.List;


public class BDVeiculos {
    private List<Passeio> bdPas = new ArrayList<Passeio>();
    private List<Carga> bdCarga = new ArrayList<Carga>();

    public List<Passeio> getBdPas() {
        return bdPas;
    }

    public void setBdPas(List<Passeio> bdPas) {
        this.bdPas = bdPas;
    }

    public List<Carga> getBdCarga() {
        return bdCarga;
    }

    public void setBdCarga(List<Carga> bdCarga) {
        this.bdCarga = bdCarga;
    }
    

    public void cadasPasseio(Passeio p){
        if(consultaPasseioPlaca(p) == null){
            bdPas.add(p);
        }
    }    
    public void cadasCarga(Carga c){
        if(consultaCargaPlaca(c) == null){
            bdCarga.add(c);
        }
    }   
    public void impAllPasseios(){
        for(int i = 0; i < bdPas.size(); i++){
            impPasseio(bdPas.get(i));
        }
    }
    public void impAllCargas(){
       for(int i = 0; i < bdCarga.size(); i++ ){
           impCarga(bdCarga.get(i));
       }
    }
    public Passeio consultaPasseioPlaca(Passeio p){
        for(int i = 0; i < bdPas.size(); i++){
            if( p.getPlaca().equalsIgnoreCase(bdPas.get(i).getPlaca()) ){
                return bdPas.get(i);
            }
        }
        return null;
    }
    public Carga consultaCargaPlaca(Carga c){
        for(int i = 0; i < bdCarga.size(); i++){
            if(c.getPlaca().equalsIgnoreCase(bdCarga.get(i).getPlaca())){
                return bdCarga.get(i);
            }
        }
        return null;
    }
    public void excluirPasseio(Passeio p){
        for(int i = 0; i < bdPas.size(); i++){
            if(p.getPlaca().equalsIgnoreCase(bdPas.get(i).getPlaca())){
                bdPas.remove(i);
            }
        }
    }
    public void excluirCarga(Carga c){
        for(int i = 0; i < bdCarga.size(); i++){
            if(c.getPlaca().equalsIgnoreCase(bdCarga.get(i).getPlaca())){
                bdCarga.remove(i);
            }
        }
    }
    public void impCarga(Carga c){
        System.out.println("Marca: " + c.getMarca()+ "\n"
                + "Modelo: " + c.getModelo()+ "\n"
                + "Placa: " + c.getPlaca()+ "\n"
                + "Cor: " + c.getCor() + "\n"
                + "Carga máx: " + c.getCargaMax() + "\n"
                + "Tara: " + c.getTara() + "\n"
                + "Velocidade máx: " + c.calcVel(c.getVelocMax())+ "\n"
                + "Pistões: " + c.getMotor().getQntPist() + "\n"
                + "Potência: " + c.getMotor().getPotencia() + "\n"
                + "Valor dos atributos tipo int: " + c.calcular());
    }
    public void impPasseio(Passeio p){
        System.out.println("Marca: " + p.getMarca() + "\n"
            + "Modelo: " + p.getModelo() + "\n"
            + "Placa: " + p.getPlaca() + "\n"
            + "Cor: " + p.getCor() + "\n" 
            + "Qntd de pistões: " + p.getMotor().getQntPist() + "\n"
            + "Qntd de passageiros: " + p.getQntdPassageiros() + "\n"
            + "Potência: " + p.getMotor().getPotencia() + "\n"
            + "Velocidade máx: " + p.calcVel(p.getVelocMax()) + "\n"
            + "Valor do total de caracteres nos atributos: " + p.calcular());
    }       
}
    

