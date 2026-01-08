

import model.Hero;
import model.HTWRoom;

/**@author Aya Abu Latifeh 
 * @author Hanna Lübken
 * Klasse EscapeGame repräsentiert das Spiel selbst. Sie verwaltet den Spieler, die Räume und den Spielzustand.
 * Sie enthält die Methoden bzw. Logik zum Ausführen des Spiels.
 */

public class EscapeGame {
    private final Hero hero;
    private final HTWRoom[] rooms = new HTWRoom[3];
    private boolean gameRunning = true;
    private boolean gameFinished = false;

    public EscapeGame() {
        this.hero = new Hero();
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
        System.out.println("The game has started. Or not?");
    }

    public Hero getHero() {
        return hero;
    }
}
