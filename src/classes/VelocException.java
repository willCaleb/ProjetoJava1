package classes;


public class VelocException extends Exception{
    public VelocException (){
        //System.out.println("Velocidade acima dos limites nacionais!");
    }
    public Carga exceptioCarga(Carga c){
        if(c.getVelocMax() > 90){
            try {
                c.setVelocMax(90);
            } catch (VelocException ex) {
                ex.exceptioCarga(c);
            }            
        }
        return c;
    }
    public Passeio exceptionPasseio(Passeio p){
        if(p.getVelocMax() > 100){
            try{
                p.setVelocMax(100);
            }catch(VelocException e){
                e.exceptionPasseio(p);
            }
        }
       return p; 
    }
    
}
