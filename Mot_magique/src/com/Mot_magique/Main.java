package com.Mot_magique;
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

public class Main {
	
	public static int TotalLinesNumber()
	{
		int count = 0;
		try
		{
			File f = new File("C:/Users/Pierre/workspace/Mot_magique/src/com/Mot_magique/dictionnaire.txt");
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
			System.out.println("Le fichier n'as pas été trouvé");
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
			File f = new File("C:/Users/Pierre/workspace/Mot_magique/src/com/Mot_magique/dictionnaire.txt");
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
			System.out.println("Le fichier n'as pas été trouvé");
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
		char tab[] = new char[t.length + 10];
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
	
	
	

	
	public static void main(String[] args) {
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
		
	}

}
