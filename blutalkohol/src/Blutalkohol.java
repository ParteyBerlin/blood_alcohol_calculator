/**
Ein Programm, welches den Blutalkoholwert C ermittelt.

C = A /(m *r)
A = V * e * p
C = Alkoholkonzentration im Blut
A = aufgenommene Masse des Alkohols in g
r = Verteilungsfaktor (Mann 0.7, Frau 0.6)
m = Masse der Person in kg
V =Volumen des Getränks in ml
e = Alkoholvolumenanteil in % (z. B. Bier: 0.05)
p = Dichte von Alkohol = 0.8 g / ml
Ausgeben werden soll C. 

TO-DO: Try Catch implementieren um ungültige Eingaben abzufangen
*/

import java.text.DecimalFormat;
import java.util.*;

public class Blutalkohol 
{
static Scanner scn = new Scanner(System.in);
static DecimalFormat df = new DecimalFormat ("##0.00");

public static void main(String[] args) 
{
	
	System.out.println("########################");
	System.out.println("## Blutalkoholrechner ##");
	System.out.println("########################");
	System.out.println("Nur Zahlen eingeben");
	
	double a = 0; // DEFAULT
	double gewicht = gewicht(a);
	double volumen = volumen(a);
	double alkGehalt = alkGehalt(a);
	
	String b = ""; //DEFAULT
	String geschlecht = geschlecht(b);
	
	double alkMenge = alkMenge(volumen,alkGehalt);
	System.out.println("Sie haben: " + alkMenge + " Gramm reinen Alkohol zu sich genommen.\n");
	
	double alkKonz = alkKonz(alkMenge, gewicht, geschlecht);
	if(alkKonz <= 0.5)
	{
		System.out.println("Alkoholkonzentration im Blut: " + df.format(alkKonz) + " Promille");
		System.out.println("Du darfst noch fahren. Aber vorsichtig!");
	}
	else if(alkKonz > 0.5 && alkKonz <= 0.8)
	{
		System.out.println("Alkoholkonzentration im Blut: " + df.format(alkKonz) + " Promille");
		System.out.println("Du darfst noch fahren! Aber NUR mit dem Fahrrad! Hände weg vom Auto!");
	}
	else if(alkKonz > 0.8 && alkKonz <= 1.5)
	{
		System.out.println("Alkoholkonzentration im Blut: " + df.format(alkKonz) + " Promille");
		System.out.println("Bus, Bahn, Taxi! Steig ein und lass Dich fahren!");
	}
	else if(alkKonz > 1.5 && alkKonz <=2.2)
	{
		System.out.println("Alkoholkonzentration im Blut: " + df.format(alkKonz) + " Promille");
		System.out.println("Ich staune, dass Du das hier noch lesen kannst! Geh schnell ins Bett!");
	}
	else if(alkKonz > 2.2)
	{
		System.out.println("Alkoholkonzentration im Blut: " + df.format(alkKonz) + " Promille");
		System.out.println("OK! Nicht mehr witzig! Jemand sollte einen Arzt rufen");
	}
	
}

public static double gewicht(double a)
{
	double gewicht = 0;
	while(gewicht == 0)
	{
	System.out.println("\nBitte Gewicht in Kilogramm eingeben");
	gewicht = scn.nextDouble();
	}
	return gewicht;
}
public static double volumen(double a)
{	
	double volumen = 0;
	while(volumen == 0)
	{
	System.out.println("\nWieviel haben Sie getrunken (in ml)");
	volumen = scn.nextDouble();
	}
	return volumen;
}
public static double alkGehalt(double a)
{	
	System.out.println("\nWie hoch war der Alkoholgehalt des Getränks");
	double alkGehalt = scn.nextDouble();
	return alkGehalt/100;
}
public static String geschlecht(String a)
{
	String geschlecht ="";
	while(!(geschlecht.equalsIgnoreCase("w")) && !(geschlecht.equalsIgnoreCase("m")))
	{
	System.out.println("\nWie ist ihr biologisches Geschlecht (M)ännlich / (W)eiblich");
	geschlecht = scn.next();
	}
	return geschlecht.toLowerCase();
}
public static double alkMenge(double volumen, double alkgehalt)
{
	double masse = volumen*alkgehalt*0.8;
	return masse;
}

public static double alkKonz(double alkMenge, double gewicht, String geschlecht)
{
		
	double alkKonz = 0;
	if(geschlecht.equals("w"))
	{
		alkKonz = alkMenge/(gewicht*0.6);
		return alkKonz;
	}
	else if(geschlecht.equals("m"))
	{
		alkKonz = alkMenge/(gewicht*0.7);
		return alkKonz;
	}
	return alkKonz;
}
}