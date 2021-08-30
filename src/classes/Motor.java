package classes;


public class Motor {
    private int qntPist;
    private int potencia;

    public Motor() {
    }

    public Motor(int qntPist, int potencia) {
        this.qntPist = qntPist;
        this.potencia = potencia;
    }

    /**
     *
     * @return
     */
    public int getQntPist() {
        return qntPist;
    }

    public final void setQntPist(int qntPist) {
        this.qntPist = qntPist;
    }

    public int getPotencia() {
        return potencia;
    }

    public final void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    
    
}
