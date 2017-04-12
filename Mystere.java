/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystere;
import java.util.Scanner;
/**
 *
 * @author Antoine
 */
public class Mystere {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int choix;
        int ret = 0;
         
      do{
         
       do{ 
           design();
        System.out.println("1 Deviner un chiffre\n2 Deviner un mot");
         end();
         choix = sc.nextInt();
         if(choix == 1){
             ret=chiffre();
         }
         else if(choix == 2){
            
         }
       }while(choix < 1 || choix > 2);
      }while(ret == 1);
        // TODO code application logic here
    }
    
    
    public static void design()
    {
        System.out.println("============MENU===========\n choix du mode:");
    }
    
    public static void end()
    {
    System.out.println("===========================");
    }
    
    public static int chiffre(){
        
        Scanner sc = new Scanner(System.in);
        int max = 100 ;
         int choix;
        int c;
  
         do{
             int coups = 0;
              int chiffre = (int) (Math.random()*( max - 1 + 1 )  + 1);
             int limite = limite(1);
         if(limite!=0){
            do{
                
                end();
                System.out.println("nombre de coups restant: "+ limite + "\nproposer un nombre(1-"+max+"):");
                choix = sc.nextInt();
                end();
                limite--;
                coups++;
                if(choix < chiffre){
         
                    System.out.println("\n\n\t c'est plus");
                }
                else if(choix > chiffre){
                    System.out.println("\n\n\t c'est moins");
                }
                else{
                    System.out.println("\n\n\t ☻GAGNEE☻");
                    break;
                }
                
                
            }while(limite != 0);
         }
            else{
                    do{
                      
                         end();
                         System.out.println("proposer un nombre (1-"+max+"):");
                         choix = sc.nextInt();
                         end();
                         coups++;
                         if(choix < chiffre){
                        System.out.println("\n\n\t c'est plus");
                        }
                        else if(choix > chiffre){
                        System.out.println("\n\n\t c'est moins");
                        }
                        else{
                        System.out.println("\n\n\t ☻GAGNÉ☻");
                        }
                        
                     }while(choix != chiffre);
                }
         
         if(choix != chiffre && limite==0){
             System.out.println("\n\n\t !!! Perdu !!!");
         }
         System.out.println("vous avez fait "+ coups +"coups \n le nombre magique: "+ chiffre );
          c = restart();
         }while( c == 2);
         if (c == 0){
             return 0;
         }
         return (1);
}
    
    public static int limite(int a){
        Scanner sc = new Scanner(System.in);
         int choix;
         do{
         design();
         System.out.println("1 Nombre de coups illimité\n2 Nombre de coups limité");
         end();
         choix = sc.nextInt();
         if (choix == 1){
             return(0);
         }
         else if(choix == 2 && a == 1){
             return(6);
         }
         else if(choix == 2 && a == 2 ){
             return(10);
         }
         
          }while(choix < 1 || choix > 2);
        return 0;
    }
    
    public static int restart(){
        Scanner sc = new Scanner(System.in);
        char reponse=' ';
         
        do{       
		        System.out.println("Souhaitez-vous faire une autre Partie ?(O/N)");
		        reponse = sc.next().charAt(0);
		       if(reponse == 'O'){
                           return restart2();
                       }
                       else{
                           System.out.println("Aurevoir");
                        return 0;
                       }
		      }while(reponse != 'O' && reponse != 'N');
      
    }
    
    public static int restart2(){
         Scanner sc = new Scanner(System.in);
       int reponse;
         
        do{       
                        design();
		        System.out.println("1 Revenir au menu ? \n2 ou autre partie");
                        end();
		        reponse = sc.nextInt();
		       
                           return reponse;
                       
                      
		      }while(reponse != 'O' && reponse != 'N');
    }
}