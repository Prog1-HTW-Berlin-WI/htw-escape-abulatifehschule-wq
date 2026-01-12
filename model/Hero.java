

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
}
private String name;

public Hero(String name){
    this.name = name;


}

public String getName(){
    return name;

}

