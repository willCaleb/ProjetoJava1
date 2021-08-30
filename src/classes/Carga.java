package classes;


public final class Carga extends Veiculo implements Calc{
    private int tara;
    private int cargaMax;

    public int calcular(){
        int total = 0;
        total += tara;
        total += cargaMax;
        total += getVelocMax();
        total += getMotor().getQntPist();
        total += getMotor().getPotencia();
        return total;
    }
    public Carga() {
        tara = 0;
        cargaMax = 0;
    }

    public int getTara() {
        return tara;
    }

    public void setTara(int tara) {
        this.tara = tara;
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }
    
    public int calcVel(int velMax){
        return velMax * 100000;
    }
    
}
