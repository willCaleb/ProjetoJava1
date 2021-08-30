package classes;


public abstract class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private int velocMax;
    private Motor motor;

    public Veiculo() {
        placa = "";
        marca = "";
        modelo = "";
        cor = "";
        velocMax = 0;
        motor = new Motor();
    }

    public String getCor() {
        return cor;
    }

    public final void setCor(String cor) {
        this.cor = cor;
    }

    
    public String getPlaca() {
        return placa;
    }

    public final void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public final void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public final void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getVelocMax() {
        return velocMax;
    }

    public final void setVelocMax(int velocMax) throws VelocException{
        int max = 100;
        if(velocMax <= max){
            this.velocMax = velocMax;
        }else throw new VelocException();
    }

    public Motor getMotor() {
        return motor;
    }

    public final void setMotor(Motor motor) {
        this.motor = motor;
    }
    
    abstract int calcVel(int velocMax);
}
