

import java.io.Serializable;
/** 
 * Die Klasse repräsentiert immer ein Übungsleiter und beschreibt dessen Eigenschaften
 * @author Aya Abu-Latifeh
 * @author Hanna Lübken
 */

public class Lecturer implements Serializable {
    private String name;
    private String description;
    private boolean hasSigned;
    
   
 /** 
  * Konstruktur
  * @param name Name des Übungsleiters
  * @param description Beschreibung des übungsleiters
  * @param hasSigned Gibt an, ob der Übungsleiter schon unterschrieben hat.
  */
    public Lecturer(String name, String description){
        this.name = name;
        this.description = description;
        this.hasSigned =  false;
    }
       

    /**
     * Hier wird überprüft, ob der Held bereit ist, die Unterschrift zu kriege.
     * @return true wird angegeben, wenn Held bereit ist, Unterschrift zu erhalten.
     */
    public boolean isReadyToSign(){
        return true;
    }
    /** 
     * Methode für Unterschreiben
     */
    public void sign(){
        this.hasSigned = true;
        System.out.println("Du hast die übung bei " +  this.name + " bestanden und bekommst eine Unterschrift!");
    }
    
    public boolean hasSigned(){
        return hasSigned;
    }
    
    public String getName(){
        return name;

    }
    public String getDescription(){

    return description;
}
    // Bitte serialVersionUID beibehalten, damit die Klasse bei der
    // Speicherung als Datei (Serialisierung) und beim Laden (Deserialisierung)
    // konsistent bleibt und Versionierungsprobleme vermieden werden.
    private static final long serialVersionUID = 540082607047283589L;
}
