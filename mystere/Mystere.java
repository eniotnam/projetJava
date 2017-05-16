/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystere;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


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
            ret=mot();
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
         
                    System.out.println("\n\n\t ▲c'est plus▲");
                }
                else if(choix > chiffre){
                    System.out.println("\n\n\t ▼c'est moins▼");
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
                        System.out.println("\n\n\t ▲c'est plus▲");
                        }
                        else if(choix > chiffre){
                        System.out.println("\n\n\t ▼c'est moins▼");
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
    
   
        
        public static int mot() {
		// TODO Auto-generated method stub
		
		String essai;
		String word = Load();
		char tword[] = Word(word);
		char wordHelp[] = WordHelp(tword);
		int count = 0;
		
		System.out.println("Votre but est de devenez le mot magique");
		System.out.println("========================================");
		
		String listString = "";

		for (char c : wordHelp)
		{
		    listString += c + "\t";
		}
		
		do
		{
		Scanner sc =new Scanner(System.in);
		System.out.println("Entrez une tentative");
		essai=sc.nextLine();
		essai = ""+essai;
		
		if (!(essai.equals(word))) { System.out.println("Ce n'est pas le mot magique"); count++; }
		
		if(essai.equals(word)) { System.out.println("Bravo vous avez trouvé le mot"); count = 0; }
		
		if (count >= 3) 
		{
			System.out.println("Voici quelques lettres pour vous aider");
			System.out.println("========================================");
			System.out.println(listString);
		}
		} while(!(essai.equals(word)));
                return 0;	
	}
         public static int TotalLinesNumber()
	{
		int count = 0;
		try
		{
			File f = new File("C:/Users/Antoine/Desktop/INGESUP/cours/JAVA/mystere/src/mystere/dictionnaire.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			LineNumberReader l = new LineNumberReader(br);
			
			try
			{
				String line = "";
				
				while((line=l.readLine()) != null) {}
				
				count = l.getLineNumber();
				
				br.close();
				fr.close();
			}
			
			catch (IOException exception)
			{
				System.out.println("Erreur lors de la lecture: " +exception.getMessage());
			}
		}
		catch(FileNotFoundException exception)
		{
			System.out.println("Le fichier n'as pas été trouvé totalline");
		}
		
		return count;
	}
	
	public static String Load()
	{
		int count = TotalLinesNumber();
		Random rand = new Random();
		int lineNumber = rand.nextInt(count);
		int i = 0;
		String word = "";
		try
		{
			File f = new File("C:/Users/Antoine/Desktop/INGESUP/cours/JAVA/mystere/src/mystere/dictionnaire.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			try
			{
				String line = br.readLine();
				
				while(i != lineNumber)
				{
					line = br.readLine();
					i++;
				}
				word = line;
				br.close();
				fr.close();
			}
			
			catch (IOException exception)
			{
				System.out.println("Erreur lors de la lecture: " +exception.getMessage());
			}
		}
		catch(FileNotFoundException exception)
		{
			System.out.println("Le fichier n'as pas été trouvé ");
		}
		return word;
	}
	
	public static char[] Word(String s)
	{
		char tab[] = new char[s.length()];
		for (int i = 0; i <s.length(); i++)
		{
			tab[i] = s.charAt(i);
		}
		
		return tab;
	}
	
	public static char[] WordHelp(char[] t) {
		char tab[] = new char[t.length ];
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		for(int i = 0; i <t.length; i++)
		{
			tab[i] = t[i];
		}
		
		for(int i = t.length; i<tab.length; i++)
		{
			Random rand = new Random();
			int index = rand.nextInt(26);
			tab[i] = alphabet.charAt(index);
		}
		
		for(int i = 0; i <tab.length; i++)
		{
			Random r1 = new Random();
			int idx1 = r1.nextInt(tab.length);
			
			char tmp = tab[i];
			tab[i] = tab[idx1];
			tab[idx1] = tmp;
			
		}
		
		return tab;
	}
}

