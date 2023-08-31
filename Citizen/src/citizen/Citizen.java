/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizen;

/**
 *
 * @author Dimas
 */
public class Citizen {
    public static void main(String[] args) {
        CitizenKelas a=new CitizenKelas();
        
       
        
        
        
    }
    
}

class CitizenKelas{
    
    
    private String nama;
    private String agama;
    private String statusPernikahan;
    private String Pekerjaan;
    
     
    
   public void setNama(String nama){
       this.nama=nama;
       
   }
   public void setAgama(String agama){
       this.agama=agama;
   }
   
   public void setstatusPernikahan(String status){
       this.statusPernikahan=status;
   }
   public void pekerjaan(String pekerjaan){
       this.Pekerjaan=pekerjaan;
   }
   
   
   
   public String getNama(){
       return nama;
       
   }
   public String getAgama(){
   return agama;
   }
   public String getStatus(){
       return statusPernikahan;
   }
   public String getPekerjaan(){
       return Pekerjaan;
   }
   
   
   
    
       
    
}