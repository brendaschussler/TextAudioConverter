package textmusicconverter;
import java.util.ArrayList;
import java.util.Random;

public class MusicAssembler {

    private static final short maxOctave = 10;
    private static final short octaveDefault = 5;
    private static short currentOctave = octaveDefault;

    private static final int defaultVolume = 30;
    private static final int maxVolume = 127;
    private static int currentVolume = defaultVolume;

    private static final int maxInstrument = 120;
    private static final int minInstrument = 0;
    private static int currentInstrument = 0;

    private static final String[] bpm = {
            "GRAVE", "LARGO", "LARGHETTO", "LENTO", "ADAGIO", "ADAGIETTO", "ANDANTE", "ANDANTINO",
            "MODERATO", "ALLEGRETTO", "ALLEGRO", "VIVACE", "PRESTO", "PRETISSIMO"
    };  // tempo constants (BPM)
    
    private static final ArrayList<String> audioScript = new ArrayList<>();
    public static ArrayList<String> getAudioScript() {
        return audioScript;
    }

    public static void initialize(int initialInstrument, int initialBPM) {
        audioScript.clear();
        switchToInstrument(initialInstrument);
        audioScript.add(String.format("T[%s]", bpm[initialBPM]));
        audioScript.add(String.format(":CON(7, %d)", defaultVolume));
    }

    public static int getInstrument() {
        return currentInstrument;
    }

    public static void doubleVolume() {
        currentVolume *= 2;

        if (currentVolume > maxVolume) {
            currentVolume = defaultVolume;
        }

        audioScript.add(String.format(":CON(7, %d)", currentVolume));
    }

    // as oitavas no Jfugue vão de 0 a 10 com a forma de um inteiro atrás da nota.
    public static void increaseOctave() {
        if (currentOctave < maxOctave) {
            currentOctave++;
        }
        else {
            currentOctave = octaveDefault;
        }
    }

    public static void switchToInstrument(int instrument) {
        if (instrument > maxInstrument || instrument < minInstrument) {
            System.out.println(instrument + " is not a valid MIDI instrument code.");
            System.out.println("Selecting now an random instrument.");
            instrument = random.nextInt(maxInstrument);
        }

        currentInstrument = instrument;
        audioScript.add(String.format("I%d", instrument));
    }

    public static void appendNote(char note) {
        String newWord = String.valueOf(note) + currentOctave;
        audioScript.add(newWord);
    }

    public static void appendPause() {
        audioScript.add("R");
    }

    public static void repeatNote() {
        audioScript.add(audioScript.get(audioScript.size() - 1));
    }

    public static String generateAudioString() {
        StringBuilder builder = new StringBuilder();

        for (String word : MusicAssembler.getAudioScript()) {
            builder.append(word);
            builder.append(" ");
        }

        return builder.toString();
    }

    private static final Random random = new Random();
}


