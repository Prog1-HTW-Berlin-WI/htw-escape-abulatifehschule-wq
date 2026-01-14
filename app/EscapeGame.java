import java.util.Scanner;
/**import model.Hero;
import model.HTWRoom;
/**
 * Klasse EscapeGame repräsentiert das Spiel selbst. Sie verwaltet den Spieler, die Räume und den Spielzustand.
 * Sie enthält die Methoden bzw. Logik zum Ausführen des Spiels.
 * @author Aya Abu-Latifeh
 * @author Hanna Lübken
 */
public class EscapeGame {
    private  Hero hero;
    private  HTWRoom[] rooms = new HTWRoom[7];
    private int currentRoom = 0;
    private boolean gameRunning = true;
    private boolean gameFinished = false;

    public EscapeGame() {
       /** Einführungstext anzeigen */
      showIntroduction();
      String heroName = playerNameInput();
      this.hero = new Hero(heroName);

      Lecturer lec1= new Lecturer (" Herr Poeser", "Er ist schlank, hat kurz geschnittene grau/blonde Haare und ist stehts motiviert seinen Studenten zu helfen.");
      Lecturer lec2= new Lecturer ("Frau safitri", "hat lange Schwarze Haare,ein dunkleren Teint und wird von ihren Studenten als sehr nett beschrieben.");
      Lecturer lec3= new Lecturer ("Herr Gnaoui",  "Er hat eine kurze, dunkelbraune Frisue und ist sehr freundlich.");
      Lecturer lec4= new Lecturer ("Frau Gärtner", "Sie hat braune schulterlange wellige Haare und trägt eine brille. Sie ist sehr hilfsbereit und ist bei Fragen immer für ihre Studenten da."); 
      Lecturer lec5= new Lecturer ("Frau Vaseva",  " fehlt eine Beschreibung noch");
      Lecturer lec6= new Lecturer ("Frau Majunkte","Sie hat braune auch bis zur Schulterlange Haare, trägt ebenfalls eine Brille und hat ein strahelnd weißes Lächeln. ");
      



      rooms = new HTWRoom [7];
      rooms [0]  = new HTWRoom ( "Haupteingang (Gebäude A)", " Dies ist der Haupteingang der HTW. Sobald man Eintritt und die ersten Stufen hochläuft siehst du die große Treppe, rechts von dir befindet sich der Studentenservice,doch dort scheint keiner zu sein.",  null);
      rooms [1] = new HTWRoom ("Cafeteria (Gebäude D)" , " Du stehst vor der Cafeteria. Sobald du rein kommst erwarten dich weitere Etagen, du entscheidest dich in die Mensa zu gehen. Der rechte Eingang führt dich zu den vielen Sitzmöglichkeiten mit den großen Fensterfronten, links ist der Buffet Bereich und den Kaffeautomaten. Es ist sehr ruhig und düster.",  lec1);
      rooms [2] = new HTWRoom ("PC-Pool (A142)", "Der helle Raum ist normalerweise voller Studenten, die an ihren Computern arbeiten. Heute ist es jedoch still und verlassen. Am anfang des Raumes befindet sich direkt der Dozententisch hinter dem dann die weiteren Reihen mit jeweils 4 Pcs.", lec2);
      rooms [3] = new HTWRoom ("Bibliothek (Gebäude A)", "Der Raum ist ruhig wie immer doch heute ist es irgendwie stiller als sonst.Es gibt unzählige Regale mit Büchern zu den verschiedensten Themen. In der Mitte der Bibliothek  befinden sich  weitere Sitzplätze und Tische für die Studenten zum lernen.", lec4);
      rooms [4] = new HTWRoom ("Seminarraumb(A219)", " Der Seminarraum ist im gegensatz zu anderen Räumen größer, mit vielen Tischreihe  und einer Tafel vorne", lec5);
      rooms [5] = new HTWRoom ("Sporthalle", "Ein Kalter Luftzug empfängt dich als du die Halle betritts. Es ist pure Stille. Das einzige was zu hören ist, sind  deine Schuhe auf dem Parkett Boden. U ", lec3);
      rooms [6] = new HTWRoom ( "Audimax (A238)", "Der letzte Raum. Ein riesiger Hörsaal. Es wirkt so als würden dich tausend Blicke von den aufsteigenden braunfarbigen Reihen anschauen. Vorne am LehrerPult ist eine riesige Tafel", lec6);
      
      

        
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
