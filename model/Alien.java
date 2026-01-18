
/**
 * Abstakte Basisklasse, die ein Alien im Spiel repräsentiert.
 * Von dieser Klasse werden unterschiedliche Aliens mit unterschiedlichen Eigenschaften abgeleitet.
 * @author Aya Abu-Latifeh
 * @author Hanna Lübken
 */
public abstract class Alien {

    // Bitte serialVersionUID beibehalten, damit die Klasse bei der
    // Speicherung als Datei (Serialisierung) und beim Laden (Deserialisierung)
    // konsistent bleibt und Versionierungsprobleme vermieden werden.
    private static final long serialVersionUID = 1729389822767173584L;
    
    private String name;
    private int lifePoints;
    private boolean friendly;
    private String greeting;

    public Alien(String name, int lifePoints, boolean friendly, String greeting) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.friendly = friendly;
        this.greeting = greeting;
    }
    /**
     * Reduziert die Lebenspunkte des Aliens um angegebenen Wert.
     * Wenn die Lebenspunkte danach weniger als 0 betragen, werden sie auf 0 gesetzt.
     * @param amount Schadenswert, um den die Lebenspunkte reduziert werden
     */
    public void takeDamage(int amount) {
        this.lifePoints -= amount;

        if(this.lifePoints < 0) {
            this.lifePoints = 0;
        }

        System.out.println(this.name + " hat einen Schaden von " + amount + " erlitten!");
        System.out.println("Du hast noch: " + this.lifePoints + " Lebenspunkte über.");
    }
    /**
     * Gibt an, ob Alien noch handlungsfähig ist.
     * @return true, wenn Lebenspunkte 0 oder weniger betragen
     */
    public boolean isDefeated() {
        return this.lifePoints <= 0;
    }

    public String getName() {
        return this.name;
    }
    public int getLifePoints() {
        return this.lifePoints;
    }
    public boolean getFriendly() {
        return this.friendly;
    }
    public String getGreeting() {
        return this.greeting;
    }
 
}
