package logica;
// Generated 18/04/2015 08:11:28 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Soat generated by hbm2java
 */
public class Soat  implements java.io.Serializable {


     private String NPlaca;
     private double valorVehiculo;
     private Date fechaPagoSoat;
     private double pagoSoat;

    public Soat() {
    }

    public Soat(String NPlaca, double valorVehiculo, Date fechaPagoSoat, double pagoSoat) {
       this.NPlaca = NPlaca;
       this.valorVehiculo = valorVehiculo;
       this.fechaPagoSoat = fechaPagoSoat;
       this.pagoSoat = pagoSoat;
    }
   
    public String getNPlaca() {
        return this.NPlaca;
    }
    
    public void setNPlaca(String NPlaca) {
        this.NPlaca = NPlaca;
    }
    public double getValorVehiculo() {
        return this.valorVehiculo;
    }
    
    public void setValorVehiculo(double valorVehiculo) {
        this.valorVehiculo = valorVehiculo;
    }
    public Date getFechaPagoSoat() {
        return this.fechaPagoSoat;
    }
    
    public void setFechaPagoSoat(Date fechaPagoSoat) {
        this.fechaPagoSoat = fechaPagoSoat;
    }
    public double getPagoSoat() {
        return this.pagoSoat;
    }
    
    public void setPagoSoat(double pagoSoat) {
        this.pagoSoat = pagoSoat;
    }




}

