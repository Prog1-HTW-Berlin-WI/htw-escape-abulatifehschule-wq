

import java.io.Serializable;
/** 
 * Die Klasse repräsentiert immer ein Übungsleiter und beschreibt dessen Eigenschaften
 * @author Aya Abu-Latifeh
 * @author Hanna Lübken
 */
public class Lecturer implements Serializable {
    private String name;
    private boolean hasSigned;
    
   

    public Lecturer(String name, String description){
        this.name = name;
        this.hasSigned =  false;
    }
       


    public boolean isReadyToSign(){
        return true;
    }
    
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
    // Bitte serialVersionUID beibehalten, damit die Klasse bei der
    // Speicherung als Datei (Serialisierung) und beim Laden (Deserialisierung)
    // konsistent bleibt und Versionierungsprobleme vermieden werden.
    private static final long serialVersionUID = 540082607047283589L;
}
