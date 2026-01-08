

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**@author Aya Abu Latifeh 
 * @author Hanna Lübken
 * Klasse EscapeApp ist die Hauptklasse des Escape-Spiels.Sie verwaltet das Hauptmenü und  die Spielzustände.
 * Sie ermöglicht das starten eines Spiels, das laden, fortsetzen, speichern, löschen und beeenden.
 */

public class EscapeApp {

    public static final String SAVE_FILE_NAME = "save";
    private EscapeGame game;
    private boolean gameRunning = true;

    public static void main(String[] args) {
        System.out.println("Welcome to the HTW escape");
        System.out.println("========================================\n");

        EscapeApp app = new EscapeApp();

        while (true) {
            app.showMainMenu();
            String choice = app.readUserInput();
            app.handleUserInput(choice);
            System.out.println("====================");
        }
    }

    private void showMainMenu() {
        System.out.println("Du bist im Hauptmenü.");
        System.out.println("Was möchtest du als nächstes tun?");
        System.out.println("(1) Neues Spiel starten");
        System.out.println("(2) Spiel fortsetzen");
        System.out.println("(3) Spiel laden");
        System.out.println("(4) Spiel speichern");
        System.out.println("(5) Spiel löschen");
        System.out.println("(6) Spiel Beenden");
        System.out.println("=====================");
        System.out.println("Bitte gib eine Zahl zwischen 1-6 ein: ");
    }

    private String readUserInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        // TBD
        return userInput;
    }

    private void handleUserInput(String input) {
        switch (input) {
            case "1":
                this.startGame();
                break;
            case "2":
                if (isGameRunning()) {
                    this.resumeGame();
                } else{
                    System.err.println("Es läuft leider noch kein Spiel. Bitte starte ein neues Spiel."); 
                break;
                }
            case "3":
                if (hasSavedGame()) {
                    this.loadGame();
                } else{
                    System.out.println("Es existiert noch kein gespeichertes Spiel. Bitte speichere zuerst ein Spiel.");
                    break;
                }
                case "4":
                    if (isGameRunning() && !isGameFinished()) {
                        this.saveGame();
                    }else{
                        System.out.println("Es läuft kein Spiel oder das Spiel ist bereits beendet. Bitte starte ein neues Spiel.");
                        break;
                    }
                case "5":
                        if(hasSavedGame()) {
                            this.deleteGame();
                        }else{
                            System.out.println("Es existiert kein gespeichertes Spiel zum Löschen.");
                            break;
                        }
                case "6":
                
                    System.out.println("Spiel wird beendet. Bis zum nächsten Mal!!");
            default:
                System.out.println("Ungültige Eingabe. Bitte wähle eine zahl zwischen 1-6.");
                break;
        }
    }

    private void startGame() {
        this.game = new EscapeGame();
        resumeGame();
    }

    private void resumeGame() {
        this.game.setGameRunning(true);
        this.game.run();
    }

    private void deleteGame() {
        if (new File(SAVE_FILE_NAME).delete()) {
            System.out.println("Game deleted!");
        }
    }

    private void saveGame() {
        try (FileOutputStream fos = new FileOutputStream(SAVE_FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(game);
            oos.flush();
        } catch (Exception ex) {
            System.err.println("Something went wrong while saving the game: " + ex.getMessage());
            return;
        }
        System.out.println("Game saved!");
    }

    private void loadGame() {
        try (FileInputStream fis = new FileInputStream(SAVE_FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            this.game = (EscapeGame) ois.readObject();
            System.out.println("Game loaded!");
        } catch (Exception ex) {
            System.err.println("Something went wrong while loading the game: " + ex.getMessage());
        }
    }

    private boolean isGameRunning() {
        return game != null;
    }

    private boolean isGameFinished() {
        return game != null && game.isGameFinished();
    }

    private boolean hasSavedGame() {
        return new File(SAVE_FILE_NAME).exists();
    }

}
