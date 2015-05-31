package logica;
// Generated 18/04/2015 08:11:28 PM by Hibernate Tools 4.3.1



/**
 * ELuzId generated by hbm2java
 */
public class ELuzId  implements java.io.Serializable {


     private int reciboLuz;
     private int clienteCedula;

    public ELuzId() {
    }

    public ELuzId(int reciboLuz, int clienteCedula) {
       this.reciboLuz = reciboLuz;
       this.clienteCedula = clienteCedula;
    }
   
    public int getReciboLuz() {
        return this.reciboLuz;
    }
    
    public void setReciboLuz(int reciboLuz) {
        this.reciboLuz = reciboLuz;
    }
    public int getClienteCedula() {
        return this.clienteCedula;
    }
    
    public void setClienteCedula(int clienteCedula) {
        this.clienteCedula = clienteCedula;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ELuzId) ) return false;
		 ELuzId castOther = ( ELuzId ) other; 
         
		 return (this.getReciboLuz()==castOther.getReciboLuz())
 && (this.getClienteCedula()==castOther.getClienteCedula());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getReciboLuz();
         result = 37 * result + this.getClienteCedula();
         return result;
   }   


}

