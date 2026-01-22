
import java.io.Serializable;

/**
 * Repräsentiert den Spielcharakter/Halden im Spiel.
 * Klasse verwaltet Eigenschaften des Helden.
 * 
 * @author Aya Abu-Latifeh
 * @author Hanna Lübken
 */
public class Hero implements Serializable {

    // Bitte serialVersionUID beibehalten, damit die Klasse bei der
    // Speicherung als Datei (Serialisierung) und beim Laden (Deserialisierung)
    // konsistent bleibt und Versionierungsprobleme vermieden werden.
    private static final long serialVersionUID = 3578735620108186013L;

    private String name;
    private int healthPoints;
    private int experiencePoints;
    private Lecturer[] signedExerciseLeaders;

    public Hero(String name) {
        this.name = name;
        this.healthPoints = 50;
        this.experiencePoints = 0;
        this.signedExerciseLeaders = new Lecturer[5];
    }

    /**
     * Reduziert die Lebenspunkte um angegebenen Wert.
     * Die Lebenspunkte dürfen nicht unter 0 fallen.
     * 
     * @param amount Schaden, der dem Spieler/Helden zugefügt wurde
     */
    public void takeDamage(int amount) {
        this.healthPoints = this.healthPoints - amount;
        if (this.healthPoints < 0)
            this.healthPoints = 0;
        System.out.println(
                this.name + " hat " + amount + " Schaden erlitten! Lebenspunkte betragen jetzt: " + this.healthPoints);
    }

    /**
     * Verschnaufpause ermöglicht eine erhöhung der Lebenspunkte.
     * Eine große erhöht die HP um 10 und eine kleine um 3.
     * Lebenspunkte dürfen den maximalen Wert von 50 nicht überschreiten.
     * 
     * @param longRest true wenn große Pause eingelegt werden soll und false bei
     *                 kleiner
     */
    public void regenerate(boolean longRest) {
        int recoveryAmount;

        if (longRest) {
            recoveryAmount = 10;
            System.out.println(this.name + "macht eine große Verschnaufpause eine Runde lang.");
        } else {
            recoveryAmount = 3;
            System.out.println(this.name + "macht eine kleine Verschnaufpause.");
        }
        this.healthPoints = this.healthPoints + recoveryAmount;
        if (this.healthPoints > 50) {
            this.healthPoints = 50;
        }
        System.out.println("Aktuelle Lebenspunkte betragen: " + this.healthPoints + " von 50 HP.");
    }

    /**
     * Spieler versucht vorm feindlichen Alien zu fliehen.
     * Flucht gelingt mit einer 42 Prozentigen Wahrscheinlichkeit.
     * 
     * @return true beim gelingen, ansonsten false
     */
    public boolean flee() {
        if (Math.random() < 0.42) {
            System.out.println("Flucht ist gelungen!");
            return true;
        } else {
            System.out.println("Flucht ist NICHT gelungen! Du musst mit dem feindlichen Alien kämpfen!");
            return false;
        }
    }

    /**
     * Spieler greift feindliches Alien an.
     * Der Schaden berechnet sich aus den XP * 2,3 +1.
     * Fehlschläge mit keinem Schaden passieren zu 13% und starke Treffer mit einer
     * Wahrscheinlichkeit von 12%.
     * 
     * @return berechnete Schaden als int
     */
    public int attack() {
        double chance = Math.random();

        if (chance < 0.13) {
            System.out.println("Der Angriff ist fehlgeschlagen! Kein Schaden erlitten.");
            return 0;
        }

        double calculateDamage = this.experiencePoints * 2.3 + 1;

        if (chance >= 0.13 && chance < 0.25) {
            calculateDamage = calculateDamage * 2;
            System.out.println("Besonders guter Treffer! Schaden wird verdoppelt.");
        }

        return (int) calculateDamage;
    }

    /**
     * Trägt den Übungsleiter in den nächsten freien Platz des Laufzettels ein.
     * Übungsleiter dürfen nur einmal unterschreiben.
     * 
     * @param lecturer Übungsleiter der Laufzettel unterschreibt
     */
    public void signExerciseLeader(Lecturer lecturer) {
        for (int i = 0; i < this.signedExerciseLeaders.length; i++) {
            if (this.signedExerciseLeaders[i] != null && this.signedExerciseLeaders[i].equals(lecturer)) {
                System.out.println(lecturer.getName() + " hat schon unterschrieben!");
                return;
            }
        }

        for (int i = 0; i < this.signedExerciseLeaders.length; i++) {
            if (this.signedExerciseLeaders[i] == null) {
                this.signedExerciseLeaders[i] = lecturer;
                System.out.println("Sie haben eine Unterschrift von " + lecturer.getName() + " erhalten!");
                return;
            }
        }
    }

    /**
     * Gibt an, ob Spieler noch handlungsfähing ist.
     * 
     * @return true wenn Lebenspunkte mehr als 0 sind, ansonsten false
     */
    public boolean isOperational() {
        return this.healthPoints > 0;
    }

    /**
     * Erhöht Erfahrungspunkte um angebenen Wert.
     * 
     * @param experiencePoints Wert um den sich die Erfahrungspunkte erhöhen
     */
    public void addExperiencePoints(int experiencePoints) {
        this.experiencePoints = this.experiencePoints + experiencePoints;
        System.out.println(this.name + " hat aktuell " + this.experiencePoints + " Erfahrungspunkte!");
    }

    /**
     * Zählt die bereits gesammelten Unterschriften
     * 
     * @return Anzahl der beelgten Plätze im Array
     */
    public int getSignatureCount() {
        int count = 0;
        for (int i = 0; i < this.signedExerciseLeaders.length; i++) {
            if (this.signedExerciseLeaders[i] != null) {
                count++;
            }
        }
        return count++;
    }

    /**
     * Gibt die aktuellen Wert der Erfahrungspunkte zurück.
     * 
     * @return Wert der XP
     */
    public int getExperiencePoints() {
        return experiencePoints;
    }

    /**
     * Gibt den Namen des Spielers/Heldenzurück.
     * 
     * @return Name des Spielers
     */
    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;

    }
}
