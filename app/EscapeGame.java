import java.util.Scanner;
import model.Hero;
import model.HTWRoom;

/**
 * Klasse EscapeGame repräsentiert das Spiel selbst. Sie verwaltet den Spieler,
 * die Räume und den Spielzustand.
 * Sie enthält die Methoden bzw. Logik zum Ausführen des Spiels.
 * 
 * @author Aya Abu-Latifeh
 * @author Hanna Lübken
 */
public class EscapeGame {
    private Hero hero;
    private HTWRoom[] rooms = new HTWRoom[7];
    private int currentRoom = 0;
    private int currentRound = 1;
    private boolean gameRunning = true;
    private boolean gameFinished = false;
    private boolean smallRestDone = false;

    /**
     * Konstruktor der Klasse EscapeGame
     * Initialisiert Array der Räume
     * Erstellung aller Übungsleiter und weist sie den Räumen zu
     * Einführung wird angezeigt und der Held erstellt.
     */
    public EscapeGame() {

        this.rooms = new HTWRoom[6];
        showIntroduction();
        String heroName = playerNameInput();
        this.hero = new Hero(heroName);

        Lecturer lec1 = new Lecturer(" Herr Poeser",
                "Er ist schlank, hat kurz geschnittene grau/blonde Haare und ist stehts motiviert seinen Studenten zu helfen.");
        Lecturer lec2 = new Lecturer("Frau safitri",
                "hat lange Schwarze Haare,ein dunkleren Teint und wird von ihren Studenten als sehr nett beschrieben.");
        Lecturer lec3 = new Lecturer("Herr Gnaoui", "Er hat eine kurze, dunkelbraune Frisue und ist sehr freundlich.");
        Lecturer lec4 = new Lecturer("Frau Gärtner",
                "Sie hat braune schulterlange wellige Haare und trägt eine brille. Sie ist sehr hilfsbereit und ist bei Fragen immer für ihre Studenten da.");
        Lecturer lec5 = new Lecturer("Frau Vaseva", " fehlt eine Beschreibung noch");

        rooms = new HTWRoom[6];
        rooms[0] = new HTWRoom("Haupteingang (Gebäude A)",
                " Dies ist der Haupteingang der HTW. Sobald man Eintritt und die ersten Stufen hochläuft siehst du die große Treppe, rechts von dir befindet sich der Studentenservice,doch dort scheint keiner zu sein.",
                null);
        rooms[1] = new HTWRoom("Cafeteria (Gebäude D)",
                " Du stehst vor der Cafeteria. Sobald du rein kommst erwarten dich weitere Etagen, du entscheidest dich in die Mensa zu gehen. Der rechte Eingang führt dich zu den vielen Sitzmöglichkeiten mit den großen Fensterfronten, links ist der Buffet Bereich und den Kaffeautomaten. Es ist sehr ruhig und düster.",
                lec1);
        rooms[2] = new HTWRoom("PC-Pool (A142)",
                "Der helle Raum ist normalerweise voller Studenten, die an ihren Computern arbeiten. Heute ist es jedoch still und verlassen. Am anfang des Raumes befindet sich direkt der Dozententisch hinter dem dann die weiteren Reihen mit jeweils 4 Pcs.",
                lec2);
        rooms[3] = new HTWRoom("Bibliothek (Gebäude A)",
                "Der Raum ist ruhig wie immer doch heute ist es irgendwie stiller als sonst.Es gibt unzählige Regale mit Büchern zu den verschiedensten Themen. In der Mitte der Bibliothek  befinden sich  weitere Sitzplätze und Tische für die Studenten zum lernen.",
                lec4);
        rooms[4] = new HTWRoom("Seminarraumb(A219)",
                " Der Seminarraum ist im gegensatz zu anderen Räumen größer, mit vielen Tischreihe  und einer Tafel vorne",
                lec5);
        rooms[5] = new HTWRoom("Sporthalle",
                "Ein Kalter Luftzug empfängt dich als du die Halle betritts. Es ist pure Stille. Das einzige was zu hören ist, sind  deine Schuhe auf dem Parkett Boden. U ",
                lec3);

    }

    /**
     * Die Hauptmethode des Spiels
     * beinhaltet die while-Schleife, die so lange läuft bis das Spiel beendet wird.
     * Hier werden Benutzereingaben verarbeitet, Runden gezählt und
     * Zufallsereignisse ausgelöst.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (this.gameRunning && !this.gameFinished) {

            if (currentRound > 24) {
                System.out.println("=========================================================");
                System.out.println("DEINE ZEIT IST ABGELAUFEN! DU HAST VERLOREN!");
                System.out.println(
                        "ES STELLT SICH HERAUS, FRAU MAJUNKTE IST IN WAHRHEIT EIN ALIEN UND FLIEGT MIT IHREM RAUMSCHIFF DAVON!");
                System.out.println("WAS MIT DER HTW PASSIERT WEISS NIEMAND.....");
                System.out.println("=========================================================");
                this.gameFinished = true;
            }

            System.out.println("======================================================================");
            System.out.println("DEIN AKTUELLER RAUM:" + rooms[currentRoom].getIdentifier());
            System.out.println("======================================================================");
            System.out.println("Was möchtest du tun?");
            System.out.println("[1]  HTW erkunden");
            System.out.println("[2] Hero Status anzeigen");
            System.out.println("[3] Laufzettel anzeigen");
            System.out.println("[4] Verschnaufpause machen");
            System.out.println("[5] Spiel beenden");
            System.out.println("======================================================================");

            System.out.println("Eingabe: ");
            String eingabe = scanner.nextLine();

            switch (eingabe) {
                case "1":
                    if (currentRoom < rooms.length - 1) {
                        currentRoom++;
                        currentRound++;
                        smallRestDone = false;
                        System.out.println(" Du betrittst nun den Raum: ");

                        int AlienZufall = (int) (Math.random() * 100 + 1);
                        if (AlienZufall <= 20) {
                            System.out.println("======================================================");
                            System.out.println(" ERKUNDUNG WAR EREIGNISLOS!");
                            System.out.println("=======================================================");

                        } else if (AlienZufall <= 72) {
                            System.out.println("==================================================================");
                            System.out.println(" ACHTUNG! ALIEN BEGEGNUNG!");
                            System.out.println("==================================================================");

                            boolean istFeindlich = Math.random() < 0.5;

                            if (istFeindlich) {
                                System.out.println(" ES HANDELT SICH UM EIN FEINDLICHES ALIEN!!!");
                                System.out.println(" Du hast die Wahl zu kämpfen oder zu fliehen.");

                            } else {
                                System.out.println("GLÜCK GEHABT! DAS ALIEN IST FREUNDLICH!!");
                                // ERGÄNZUNG KOMMT KREATIV
                            }

                        } else {
                            System.out.println("========================================================");
                            System.out.println("DU TRIFFST AUF EIN ÜBUNGSLEITER!");
                            System.out.println("==========================================================");
                            Lecturer l = rooms[currentRoom].getLecturer();
                            if (l != null) {
                                if (l.hasSigned()) {
                                    System.out.println(
                                            "Hey,dich kenn ich doch schon, du hast ja schon meine Unterschrift erhalten!");

                                } else {
                                    if (hero.getExperiencePoints() >= 5) {
                                        l.sign();
                                        System.out.println(
                                                l.getName() + "Super, du hast genug Erfahrung mit Aliens gesammelt");
                                        System.out.println(
                                                " Yayy! Du hast eine weitere Unterschrift auf deinem Laufzettel erhalten und bist dem Finale ein Schritt näher gekommen!");

                                    } else {
                                        System.out.println(
                                                " Es tut mir leid, du hast nicht genug Erfahrung mit Aliens gesammelt.");
                                        System.out.println(
                                                " Du musst noch mehr Erfahrungen im kämpfen mit feindlichen Aliens sammeln.");
                                        System.out.println(
                                                "Erkunde die HTW weiter um auf ein feindliches Alien zu treffen");
                                    }

                                }
                            } else {
                                System.out.println("In diesem Raum befindet sich leider kein Übungsleiter.");
                                System.out.println("Bitte erkunde die HTW weiter um auf ein Übungsleiter zu treffen!");

                            }

                        }

                    } else {
                        System.out.println("Du befindest dich bereits im letzten Raum!.");

                    }
                    break;

                case "2":
                    System.out.println("===== HERO STATUS =====");
                    System.out.println("Name: " + hero.getName());
                    System.out.println("HP: " + hero.getHealthPoints() + "/50");
                    System.out.println("XP: " + hero.getExperiencePoints());
                    System.out.println("Runde: " + this.currentRound + "/ 24");
                    System.out.println("=========================");

                    break;

                case "3":
                    System.out.println("====== LAUFZETTEL ======");
                    int signaturesCount = 0;

                    for (int i = 0; i < rooms.length; i++) {
                        Lecturer lecturer = rooms[i].getLecturer();
                        if (lecturer != null) {
                            if (lecturer.hasSigned()) {
                                System.out.println("[X]" + lecturer.getName());
                                signaturesCount++;
                            } else {
                                System.out.println("[ ]" + lecturer.getName());
                            }
                        }

                    }
                    System.out.println("Gesammelte Unterschriften: " + signaturesCount + "/5");
                    System.out.println("=============================");
                    break;

                case "4":
                    System.out.println("======= VERSCHNAUFPAUSE =======");
                    System.out.println("[1] Kleine Pause (3 HP, schneller Rundenfortschritt)");
                    System.out.println("[2] Lange Pause (10 HP, kostet 1 Runde)");
                    System.out.println("Bei anderer Eingabe entscheidest du dich gegen eine Pause");
                    System.out.println("=================================");
                    System.out.print("Eingabe: ");
                    String pauseInput = scanner.nextLine();

                    if (pauseInput.equals("1")) {
                        if (!smallRestDone) {
                            hero.regenerate(false);
                            smallRestDone = true;
                            System.out.println("Du setzt dich für eine kleine Pause auf die Bank im Flur.");
                        } else {
                            System.out.println("Du hast dich bereits ausgeruht! Erkunde die HTW erstmal weiter!");
                        }

                    } else if (pauseInput.equals("2")) {
                        hero.regenerate(true);
                        this.currentRound++;
                        smallRestDone = true;
                        System.out.println(" Eine lange Pause tut dir gut und du fühlst dich gestärkt.");
                    } else {
                        System.out.println("Du hast dich gegen eine Pause entschieden");
                    }
                    System.out.println("Aktuelle Lebenspunkte: " + hero.getHealthPoints() + "/50");
                    break;

                case "5":
                    System.out.println("Das Spiel wird beendet und du kehrst zum Hauptmenü zurück.");
                    this.gameRunning = false;
                    break;

                default:
                    System.out.println("Ungültige Eingabe. Bitte gib eine Zahl zwischen 1-5 ein.");
                    break;
            }
        }
    }

    /* Einführungstext */
    private void showIntroduction() {
        System.out.println("Willkommen zum HTW Escape Game! NO WAY OUT!");
        System.out.println("Folgendes Szenario erwartet dich :");
        System.out.println("=======================================================");
        System.out.println(
                "Es ist ein ganz normaler Tag an der HTW Berlin, als plötzlich alle Türen verschlossen werden.");
        System.out.println(
                "Es führt kein Weg mehr hinaus. Deine Aufgabe ist es, Hinweise zu finden und Rätsel zu lösen, um zu entkommen.");
        System.out.println("Der Schlüssel zum Ausgang  hat ausschließlich Frau Majunkte.");
        System.out.println(
                "Um sie zu finden, musst du jedoch vorher alle Übungsleiter finden und ihre Unterschrift sammeln.");
        System.out.println("Aber Achtung! Die HTW ist befallen von gefährlichen Kreaturen, die dich aufhalten können.");
        System.out.println("Sei vorsichtig und nutze deine Fähigkeiten, um zu überleben und zu entkommen!");
        System.out.println("Viel Glück!");
        System.out.println("==================================================================");
    }

    /**
     * Hier muss der Spieler seinem Helden einem Namen geben
     * 
     * @return Der Name des Spielers als String
     */
    private String playerNameInput() {
        System.out.println(" Bitte gebe deinem Helden einen Namen: ");
        Scanner scanner = new Scanner(System.in);
        String heroName = scanner.nextLine();
        System.out.println(" Dein Held heißt nun: " + heroName);
        System.out.println("Viel Erfolg, " + heroName + "!");
        return heroName;

    }

    /**
     * prüft ob das aktuelle Spiel läuft.
     * 
     * @return true wenn das Spiel läuft ansonsten false.
     */
    public boolean isGameRunning() {
        return gameRunning;
    }

    /**
     * Status, ob Spiel läuft
     * 
     * @param gameRunning true um zu starte und false zum stoppen.
     */
    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

    /**
     * Prüft ob Spiel verloren oder gewonnen wurde.
     * 
     * @return true wenn das Spiel beendet ist
     */
    public boolean isGameFinished() {
        return gameFinished;
    }

    /**
     * Status, ob Spiel beendet ist.
     * 
     * @param gameFinished true, wenn das Spiel vorbei ist.
     */
    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }

    /**
     * Gibt Helden Objekt zurück.
     * 
     * @return Held des Spiels.
     */
    public Hero getHero() {
        return hero;
    }

}
