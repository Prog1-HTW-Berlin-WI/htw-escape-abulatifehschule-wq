import java.util.Scanner;
import model.Hero;
import model.HTWRoom;
/**
 * Klasse EscapeGame repräsentiert das Spiel selbst. Sie verwaltet den Spieler, die Räume und den Spielzustand.
 * Sie enthält die Methoden bzw. Logik zum Ausführen des Spiels.
 * @author Aya Abu-Latifeh
 * @author Hanna Lübken
 */
public class EscapeGame {
    private final Hero hero;
    private final HTWRoom[] rooms = new HTWRoom[7];
    private int currentRoom = 0;
    private boolean gameRunning = true;
    private boolean gameFinished = false;

    public EscapeGame() {
       /** Einführungstext anzeigen */
      showIntroduction();
      String heroName = playerNameInput();
      this.hero = new Hero(heroName);

      Lecturer lec1= new Lecturer (  " Herr Poeser",  
      "Er ist schlank, hat kurz geschnittene grau/blonde Haare und ist stehts motiviert seinen Studenten zu helfen.");
      Lecturer lec2= new Lecturer (" Frau fitri", 
      "");
      Lecturer lec3= new Lecturer ( "",  
      "");
      Lecturer lec4= new Lecturer  ("", 
       "");
      Lecturer lec5= new Lecturer ("",
      "");
      Lecturer lec6= new Lecturer ( "",  
      "");
      Lecturer lec7= new Lecturer (" Frau Majunkte",  
      "Sie ist eine sehr sympathische und hilfsbereite Übungsleiterin.");
      



      rooms = new HTWRoom [7];
      rooms [0]  = new HTWRoom ( "Haupteingang (Gebäude A)",
        " "
       ),;
      rooms [1] = new HTWRoom ("Cafeteria (Gebäude B)");
      rooms [2] = new HTWRoom ("PC-Pool (A142)", );
      rooms [3] = new HTWRoom ("Bibliothek (Gebäude A)");
      rooms [4] = new HTWRoom ("Seminarraumb(A219)");
      rooms [5] = new HTWRoom ("Sporthalle");
      rooms [6] = new HTWRoom ( "Audimax (A238)");

      this.hero = new Hero(heroName);

        
    }
    
    private void showIntroduction() {
        System.out.println("Willkommen zum HTW Escape Game! NO WAY OUT!");
        System.out.println("Folgendes Szenario erwartet dich :");
        System.out.println("=======================================================");
        System.out.println("Es ist ein ganz normaler Tag an der HTW Berlin, als plötzlich alle Türen verschlossen werden.");
        System.out.println("Es führt kein Weg mehr hinaus. Deine Aufgabe ist es, Hinweise zu finden und Rätsel zu lösen, um zu entkommen.");
        System.out.println("Der Schlüssel zum Ausgang  hat ausschließlich Frau Majunkte.");
        System.out.println("Um sie zu finden, musst du jedoch vorher alle Übungsleiter finden und ihre Unterschrift sammeln.");
        System.out.println("Aber Achtung! Die HTW ist befallen von gefährlichen Kreaturen, die dich aufhalten können.");
        System.out.println("Sei vorsichtig und nutze deine Fähigkeiten, um zu überleben und zu entkommen!");
        System.out.println("Viel Glück!");
        System.out.println("==================================================================");
    }
  
    private String playerNameInput() {
    System.out.println (" Bitte gebe deinem Helden einen Namen: ");
    Scanner scanner = new Scanner(System.in);
    String heroName = scanner.nextLine();
    System.out.println(" Dein Held heißt nun: " + heroName);
    System.out.println("Viel Erfolg, " + heroName + "!");
    return heroName;
   
    }



    public boolean isGameRunning() {
        return gameRunning;
    }

    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }

    public void run() {
        System.out.println("Das Spiel läuft jetzt....");
        
 }
     
    public Hero getHero() {
        return hero;
    }
}
