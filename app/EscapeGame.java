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
    private HTWRoom[] rooms = new HTWRoom[6];
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
        Lecturer lec5 = new Lecturer("Frau Vaseva", "Sie ist klein,schlank und hat mittel lange Haare");

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
                "Ein Kalter Luftzug empfängt dich als du die Halle betritts. Es ist pure Stille. Das einzige was zu hören ist, sind  deine Schuhe auf dem Parkett Boden.",
                lec3);

    }

    /**
     * Die Hauptmethode des Spiels
     * beinhaltet die while-Schleife, die so lange läuft bis das Spiel beendet wird.
     * Hier werden Benutzereingaben verarbeitet, Runden gezählt und
     * Zufallsereignisse ausgelöst.
     * Anzeige des aktuellen Raums und die Aktionsmenüs.
     * Alien Begegnung Auswahl Kampf oder Flucht.
     * Anzeige aktueller Lebens - und Erfahrungspunkte.
     * Regeneration von Lebenspunkten.
     * Beenden des Spiels 
    
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
                    if(hero.getSignatureCount()==5){
                        startFinalMajunkte(scanner);

                    }else if(currentRoom < rooms.length - 1) {
                        currentRoom++;
                        currentRound++;
                        smallRestDone = false;

                        HTWRoom actualHtwRoom = rooms[currentRoom];
                        System.out.println("Du betrittst nun den Raum: " + actualHtwRoom.getIdentifier());
                        System.out.println(actualHtwRoom.getDescription());

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
                                System.out.println("============================================");
                                System.out.println("ES HANDELT SICH UM EIN FEINDLICHES ALIEN!!!");
                                System.out.println("Du hast die Wahl zu kämpfen oder zu fliehen:");
                                System.out.println("[1] Kämpfen");
                                System.out.println("[2] Fliehen");
                                System.out.println("Bitte gib eine 1 oder 2 ein");
                                System.out.println("============================================");
                                System.out.println("Eingabe: ");

                                String wahl = scanner.nextLine();

                                if (wahl.equals("1")) {
                                    while (hero.isOperational() && !alien.isDefeated()) {
                                        System.out.println("====================================");
                                        System.out.println("Drücke ENTER wenn du bereit bist anzugreifen!!");
                                        scanner.nextLine();

                                        int damage = hero.attack();
                                        alien.takeDamage(damage);
                                        System.out.println("YAYYY! Du hast das Alien mit " + damage + " Schaden erfolgreich getroffen.");

                                        if(!alien.isDefeated()) {
                                            System.out.println("Das Alien gibt auf!");
                                            hero.takeDamage(5);
                                            System.out.println("Deine restlichen HP: " hero.getHealthPoints());
                                        }
                                    }
                                    if(alien.isDefeated()) {
                                        System.out.println("Du hast gewonnen! Du gewinnst 5 HP dazu.");
                                        hero.addExperiencePoints(5);
                                    }else{
                                        System.out.println("Du hast verloren... ABER erhälst trotzdem 1 XP für den Einsatz");
                                        hero.addExperiencePoints(1);
                                    }
                                }

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
     * Startet Finale des Spiels
     * Begegnung mit Frau Majunkte
     * Initialisierung des finalen Raumes und Frau Majunkte als Objekt.
     * Zufällige Auswahl an Multiple-Choice-Fragen
     * Überprüfung der Antwort
     * 
     * @param scanner zum Einlesen der Antwort des Spielers.
     */
    private void startFinalMajunkte(Scanner scanner) {
        Lecturer lec6 = new Lecturer("Prof.Dr. Majunkte",
                "Sie hat kurze braune Haare, trägt ebenfalls eine Brille und hat strahlend weiße Zähne, welche sie ihren Studenten, durch ein Lächeln zeigt.");
        HTWRoom finalRoom = new HTWRoom("Audimax (A238)",
                "Der letzte Raum. Ein riesiger Hörsaal. Es wirkt so als würden dich tausend Blicke von den aufsteigenden braunfarbigen Reihen anschauen. Vorne am LehrerPult ist eine riesige Tafel",
                lec6);
        System.out.println("=============================================================================");
        System.out.println("YAYY GLÜCKWUNSCH !! DU HAST ES GESCHAFFT ALLE 5 UNTERSCHRIFTEN ZU SAMMELN");
        System.out.println("Du betritts den Audimax und triffst auf Prof.Dr.Majunkte");
        System.out.println(lec6.getDescription());
        System.out.println("Hallo," + hero.getName() + ",du hast es fast geschafft der HTW zu entkommen");
        System.out.println("Allerdings,musst du eine letzte Prüfung bei mir bestehen.");
        System.out.println("Ich hoffe du hast fleißig in meinem Kurs, Grundlagen der Programmierung mitgemacht.");
        System.out.println(
                "Du musst die folgende Frage richtig beantworten, scheiterst du, hast du im zweiten Prüfungszeitraum noch eine letzte Chance");

        String[] questions = {
                "Welchen Datentyp verwenden Sie bei einer Reellen Zahl?",
                "Wie deklariert man eine Variable mit dem Variablennamen zaehler vom Datentyp int?",
                "Welche Schleife läuft garantiert mindestens einmal durch?"
        };

        String[][] answers = {
                { "[A] String", "[B] int", "[C] double", "[D] boolean" },
                { "[A] int zaehler;", "[B] double zaehler;", "[C] int count;", "[D] String zaheler;" },
                { "[A] for-Schleife", "[B] while-Schleife", "[C] do-while-Schleife", "[D] if-Schleife" }

        };

        String[] solutions = { B, A, C };
        int randomNumber = (int) (Math.random() * questions.length);

        boolean passed = askQuestion(scanner, questions[randomNumber], answers[randomNumber], solutions[randomNumber]);

        if (!passed) {
            System.out.println("UPS, das war wohl nix!");
            System.out.println("Du hast jetzt noch eine zweite Chance, im zweitem Prüfungszeitraum");
            int randomNumber = (int) (Math.random() * questions.length);
            passed = askQuestion(scanner, questions[randomNumber], answers[randomNumber], solutions[randomNumber]);

        }
        if (passed) {
            System.out.println("======================================");
            System.out.println(
                    lec6.getName() + " freut sich für dich und sagt: 'Das war richtig! Du hast es geschafft.'");
            System.out.println(lec6.getName() + " übergibt dir deine Urkunde und drückt auf einen Knopf!");
            System.out.println("Alle Türe des HTW Gebäudes öffnen sich und Licht kommt herein");
            System.out.println("Du hast das Spiel gewonnen!! Herzlichen Glückwunsch!");
            System.out.println("======================================");
            this.gameFinished = true;
        } else {
            System.out.println("=====================================");
            System.out.println("'Leider schon wieder falsche Antwort! Sie sind durchgefallen.'");
            System.out.println(lec6.getName() + " zieht ihre Verkleidung aus und enttarnt sich als Alien!");
            System.out
                    .println("Sie steigt in ihr Raumschiff und ruft: 'Noch viel Glück mit meinen Freunden in der HTW!");
            System.out.println("Du bleibst allein zurück in der HTW gefangen...");
            System.out.println("GAME OVER");
            System.out.println("======================================");
            this.isGameFinished = true;
        }
    }

    /**
     * Hilfsmethode, für Fragestellung sowie das prüfen der richtigen Antwort.
     * Zeigt Frage und Antwortmöglichkeiten auf der Konsole.
     * Vergleicht die Benutzereingabe mit der vorgegebenen richtigen Lösung.
     * 
     * @param scanner
     * @param question
     * @param answers
     * @param solutions
     * @return
     */
    private boolean askQuestion(Scanner scanner, String question, String[] answers, String solutions) {
        System.out.println("Frage: " + question);
        for (int i = 0; i < answers.length; i++) {
            System.out.println(answers[i]);
        }
        System.out.println("Einagabe: ");
        String input = scanner.nextLine();

        return input.equals(solutions);
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
