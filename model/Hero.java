

import java.io.Serializable;
/**
 * Repräsentiert den Spielcharakter/Halden im Spiel.
 * Klasse verwaltet Eigenschaften des Helden.
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

public Hero(String name){
    this.name = name;
    this.healthPoints = 50;
    this.experiencePoints = 0;
    this.signedExerciseLeaders = new Lecturer[5];
}
/**
 * Reduziert die Lebenspunkte um angegebenen Wert.
 * Die Lebenspunkte dürfen nicht unter 0 fallen.
 * @param amount Schaden, der dem Spieler/Helden zugefügt wurde
 */
public void takeDamage(int amount){
    this.healthPoints = this.healthPoints - amount;
    if (this.healthPoints < 0)
        this.healthPoints = 0;
    System.out.println(this.name + " hat " + amount + " Schaden erlitten! Lebenspunkte betragen jetzt: " + this.healthPoints);
}

public void regenerate(boolean longRest){
    int recoveryAmount;

    if (longRest){
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



public String getName(){
    return name;

}

}

