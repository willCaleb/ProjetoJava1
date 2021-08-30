package classes;


public final class Passeio extends Veiculo implements Calc{
    private int qntdPassageiros;

    public int calcular(){
        int total = 0;
        total += getPlaca().length();
        total += getMarca().length();
        total += getModelo().length();
        total += getCor().length();
        
        return total;
    }
    public Passeio() {
    }
      
    public Passeio(int qntdPassageiros) {
        this.qntdPassageiros = qntdPassageiros;
    }

    public int getQntdPassageiros() {
        return qntdPassageiros;
    }

    public void setQntdPassageiros(int qntdPassageiros) {
        this.qntdPassageiros = qntdPassageiros;
    }
    public int calcVel(int velMax){
        return velMax * 1000;
    }
    
}
