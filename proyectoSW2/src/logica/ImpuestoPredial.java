package logica;
// Generated 18/04/2015 08:11:28 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * ImpuestoPredial generated by hbm2java
 */
public class ImpuestoPredial  implements java.io.Serializable {


     private int NPredio;
     private Date fechaPagoPredial;
     private double valorPredio;
     private double impuestoPredio;

    public ImpuestoPredial() {
    }

    public ImpuestoPredial(int NPredio, Date fechaPagoPredial, double valorPredio, double impuestoPredio) {
       this.NPredio = NPredio;
       this.fechaPagoPredial = fechaPagoPredial;
       this.valorPredio = valorPredio;
       this.impuestoPredio = impuestoPredio;
    }
   
    public int getNPredio() {
        return this.NPredio;
    }
    
    public void setNPredio(int NPredio) {
        this.NPredio = NPredio;
    }
    public Date getFechaPagoPredial() {
        return this.fechaPagoPredial;
    }
    
    public void setFechaPagoPredial(Date fechaPagoPredial) {
        this.fechaPagoPredial = fechaPagoPredial;
    }
    public double getValorPredio() {
        return this.valorPredio;
    }
    
    public void setValorPredio(double valorPredio) {
        this.valorPredio = valorPredio;
    }
    public double getImpuestoPredio() {
        return this.impuestoPredio;
    }
    
    public void setImpuestoPredio(double impuestoPredio) {
        this.impuestoPredio = impuestoPredio;
    }




}


