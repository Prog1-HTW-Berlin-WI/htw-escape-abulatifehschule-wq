

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
/**
 * Klasse EscapeApp ist die Hauptklasse des Escape-Spiels.Sie verwaltet das Hauptmenü und  die Spielzustände.
 * Sie ermöglicht das starten eines Spiels, das laden, fortsetzen, speichern, löschen und beeenden.
 * @author Aya Abu-Latifeh
 * @author Hanna Lübken
 */
public class EscapeApp {

    public static final String SAVE_FILE_NAME = "save";
    private EscapeGame game;
    private boolean gameRunning = true;
    
/**
 * Startet das Spiel und initialisiert die Spielumgebung.
 * @param args Parameter für Kommandozeile
 */
    public static void main(String[] args) {
        System.out.println("Welcome to the HTW escape");
        System.out.println("========================================");

        EscapeApp app = new EscapeApp();

        while (true) {
            app.showMainMenu();
            String choice = app.readUserInput();
            app.handleUserInput(choice);
            System.out.println("====================");
        }
    }
/**
 * Methode zum anzeigen des Hauptmenüs auf der Konsole.
 * Die Methode gibt alle verfügbaren Optionen an, wobei bestimmte Optionen nur dann eingeblendet werden, wenn die entsprechenden Bedingungen erfüllt sind.
 */
    private void showMainMenu() {
        System.out.println("Du bist im Hauptmenü.");
        System.out.println("Was möchtest du als nächstes tun?");
        
        System.out.println("(1) Neues Spiel starten");
        
        if (isGameRunning() && !isGameFinished()){
            System.out.println("(2) Spiel fortsetzen");
        }
        if (hasSavedGame()){
         System.out.println("(3) Spiel laden");
        }
         if (isGameRunning()){
        System.out.println("(4) Spiel speichern");
         }
         if (hasSavedGame()){
        System.out.println("(5) Spiel löschen");
         }
        System.out.println("(6) Spiel Beenden");
        System.out.println("=====================");
        if (isGameRunning() || hasSavedGame()){
            System.out.println("Bitte gib eine Zahl zwischen 1-6 ein: ");
        
         } else{
            System.out.println("Bitte wähle (1) um ein Spiel zu starten oder (6) um das Spiel zu beenden.");
         }
        
        

    }

    /** Liest die Benutzereingabe ein und gibt sie zurück.
     * @param input
     * @return UserInput als String.
     */

    private String readUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        
        // TBD 
        return userInput;
    
    }


   /** Verarbeitet die Benutzereingabe und führt ausgewählte Aktion aus  
    * Methode prüft die Eingabe und  ruft entsprechende Methoden aus.
    * @param input Benutzereingabe als String
    */


    private void handleUserInput(String input) {
        switch (input) {
            case "1":
                this.startGame();
                break;
            case "2":
               if(isGameRunning() ) {
                    this.resumeGame();
                } else{
                    System.out.println("Es läuft leider noch kein Spiel. Bitte starte ein neues Spiel."); 
               
                }
                break;
            case "3":
                if (hasSavedGame()) {
                    System.out.println("Lade gespeichertes Spiel...");
                    this.loadGame();
                } else{
                    System.out.println("Es existiert noch kein gespeichertes Spiel. Bitte speichere zuerst ein Spiel.");
                   
                }
                break;

                case "4":
                    if (isGameRunning() && !isGameFinished()) {
                        this.saveGame();
                    }else{
                        System.out.println("Es läuft kein Spiel oder das Spiel ist bereits beendet. Bitte starte ein neues Spiel.");
                        
                    }
                    break;
                case "5":
                        if(hasSavedGame()) {
                            this.deleteGame();
                        }else{
                            System.out.println("Es existiert kein gespeichertes Spiel zum Löschen.");
                            
                        }
                        break;
                case "6":
                      System.out.println("Spiel wird beendet. Bis zum nächsten Mal!!");
                        System.exit(0);
                      break;
            default:
                System.out.println("Ungültige Eingabe. Bitte wähle eine zahl zwischen 1-6.");
                
            
        }
    }
     /** Startet ein neues Spiel indem klasse EscapeGame aufgerufen wird.
      * Anschließend wird mit resumeGame() das Spiel gestartet.
      */
    private void startGame() {
        this.game = new EscapeGame();
        resumeGame();

    }
    /** Setzt das Spiel fort
     * Ruft dann die run()-Methode der EscapeGame klasse auf um Spiel fortzuführen.
     */
    private void resumeGame() {
        System.out.println("Spiel wird fortgesetzt....");
        this.game.setGameRunning(true);
        this.game.run();
    }

    /** Löscht das gespeicherte Spiel vom System
     * Gibt Bestätigungsmeldung aus.
     */
    private void deleteGame() {
        if (new File(SAVE_FILE_NAME).delete()) {
            System.out.println("Spiel gelöscht!");
        }
    }
    /** Speichert aktuellen Spielstand
     * falls ein Fehler auftritt wird eine Meldung ausgegeben.
     */
    private void saveGame() {
        try (FileOutputStream fos = new FileOutputStream(SAVE_FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(game);
            oos.flush();
        } catch (Exception ex) {
            System.err.println("Es ist ein Fehler beim Speichern des Spiels aufgetreten " + ex.getMessage());
            return;
        }
        System.out.println("Spiel gespeichert!");
    }
     /** Gepeichertes Spiel wird geladen
      * Tritt ein fehler auf wird eine Fehlermeldung angezeigt.
      */
    private void loadGame() {
        try (FileInputStream fis = new FileInputStream(SAVE_FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            this.game = (EscapeGame) ois.readObject();
            System.out.println("Spiel geladen!");
            resumeGame();
        } catch (Exception ex) {
            System.err.println("Es ist ein Fehler beim Laden des Spiels aufgetreten: " + ex.getMessage());
        }
    }
    /** prüft ob ein Spiel läuft
     * @return true wenn Spiel läuft ansonsten false.
     */
    private boolean isGameRunning() {
        return game != null;
    }

      /** prüft ob das Spiel beendet wurde.
       * @return true wenn Spiel beendet wurde ansonsten false.
       */
    private boolean isGameFinished() {
        return game != null && game.isGameFinished();
    }
    
    /** prüft ob ein Spiel gespeichert wurde bzw. ein gespeichertes Spiel existiert
     * @return true wenn es ein gespeichertes Spiel gibt ansonsten false.
     */
    private boolean hasSavedGame() {
        return new File(SAVE_FILE_NAME).exists();
    }

}
