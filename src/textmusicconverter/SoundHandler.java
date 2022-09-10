package textmusicconverter;

import java.util.ArrayList;
import java.util.Random;

public class SoundHandler {

    //GENERAL CONSTANTS 
    private static final short maxBpmIndex = 13;
    private static short bpmIndexDefault = 9;
    private static short currentBpmIndex = bpmIndexDefault;
    private static final short maxOctave = 10;
    private static final short minOctave = 1;
    private static short octaveDefault = 5;
    private static short currentOctave = octaveDefault;
    private static final short defaultVolume = 40;
    private static final short maxVolume = 100;

    private static String currentInstrument = "PIANO";

    
    private static final ArrayList<String> audioScript = new ArrayList<>();
    //getter para audio script que sera usado em MusicaAssembler
    public static ArrayList<String> getAudioScript() {
        return audioScript;
    }
    
    private static final Random random = new Random();

    // variables
    private static short volume = defaultVolume;
    private static final char[] notes = {'A', 'B', 'C', 'D', 'F', 'G'};
    private static final String[] instruments = {
        "PIANO", "GUITAR", "TROMBONE", "TRUMPET", "CHURCH_ORGAN", "CLAVINET"
    };
    private static final String[] bpm = {
        "GRAVE", "LARGO", "LARGHETTO", "LENTO", "ADAGIO", "ADAGIETTO", "ANDANTE", "ANDANTINO",
        "MODERATO", "ALLEGRETTO", "ALLEGRO", "VIVACE", "PRESTO", "PRETISSIMO"
    };  // tempo constants (BPM)

    
    
    public static void initialize() {
        audioScript.add(String.format(":CON(7, %s)", String.valueOf(defaultVolume)));  // set default volume
        audioScript.add("T[ALLEGRO]");  // set default BPM
    }

    public static void doubleVolume() {
        volume *= 2;
        if (volume > 127) {
            volume = 127;
        }

        audioScript.add(String.format(":CON(7, %s)", String.valueOf(volume)));
    }

    public static void resetVolume() {
        volume = defaultVolume;
        audioScript.add(String.format(":CON(7, %s)", String.valueOf(volume)));
    }

    // as oitavas no Jfugue vão de 0 a 10 com a forma de um inteiro atrás da nota.
    public static void increaseOctave() {
        if (currentOctave < maxOctave) {
            currentOctave++;
        }else
            currentOctave = octaveDefault;
    }

    public static void decreaseOctave() {
        if (currentOctave > minOctave) {
            currentOctave--;
        }else
            currentOctave = octaveDefault;
    }

    public static void switchInstrumentRandomly() {
        String newInstrument;

        do {
            newInstrument = instruments[random.nextInt(instruments.length)];
        } while (newInstrument.equals(currentInstrument));

        currentInstrument = newInstrument;
        audioScript.add(String.format("I[%s]", newInstrument));
    }

    public static void increaseBPM() {
        if (currentBpmIndex < maxBpmIndex) {
            currentBpmIndex++;
        }

        audioScript.add(String.format("T[%s]", bpm[currentBpmIndex]));
    }

    public static void setRandomBPM() {
        int randomBpmIndex;

        do {
            randomBpmIndex = random.nextInt(bpm.length);
        } while (randomBpmIndex == currentBpmIndex);

        audioScript.add(String.format("T[%s]", bpm[randomBpmIndex]));
    }

    public static void phoneRinging() {
        audioScript.add("I[TELEPHONE_RING]");
        audioScript.add("Rq E E Rq");
        audioScript.add(String.format("I[%s]", currentInstrument));
    }

    public static void playPreviousNote() {
        String lastNote = audioScript.get(audioScript.size() - 1);
        audioScript.add(lastNote);
    }

    public static void playRandomNote() {
        char randomNote = notes[random.nextInt(notes.length)];
        appendNote(randomNote);
    }

    public static void appendNote(char note) {
        String newWord = String.valueOf(note) + currentOctave;
        audioScript.add(newWord);
    }
}
