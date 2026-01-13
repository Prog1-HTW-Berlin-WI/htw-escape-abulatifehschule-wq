
import java.io.Serial;
import java.io.Serializable;
/** 
 * Die Klasse HtWRoom beschreibt einen Raum in der Htw Umgebung.
 * @author aya Abu-Latifeh
 * @author Hanna Lübken
 */
public class HTWRoom implements  Serializable{

    // Bitte serialVersionUID beibehalten, damit die Klasse bei der
    // Speicherung als Datei (Serialisierung) und beim Laden (Deserialisierung)
    // konsistent bleibt und Versionierungsprobleme vermieden werden.
    private static final long serialVersionUID = 9065680017147292999L;
}
private String identifier;
private String description;
private Lecturer lecturer;

public HTWRoom(String identifier, String description, Lecturer lecturer){
    this.identifier = identifier;
    this.description = description;
    this.lecturer = lecturer;
}

    public void showRoom(){
        System.out.println("==================================================");
        System.out.println("Du befindest dich grade im Raum: " + this.identifier);
        System.out.println(this.description);

        if ( this.lecturer !=null){
            if (!this.lecturer.hasSigned()){
                System.out.println("Übungsleiter im Raum: " + this.lecturer.getName());
                System.out.println ("Beschreibung : " + this.lecturer.getDescription());
             
            }else{
                System.out.println(" Du hast bereits die Unterschrift des Übungsleiters " + this.lecturer.getName() + " erhalten.");
            }  
            System.out.println ("==========================================================");

        }
    

}
public String getIdentifier(){
     return identifier;
}
public String getDescription(){
    return description;

}
public Lecturer getLecturer(){
    return this.lecturer;
}


