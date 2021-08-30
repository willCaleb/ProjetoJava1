package classes;


public class VeicExistException extends Exception{

    public VeicExistException() {
        System.out.println("Já existe veículo com essa placa!");
    }
    
}
