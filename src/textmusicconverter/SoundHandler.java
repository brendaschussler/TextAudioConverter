package textmusicconverter;

import java.util.ArrayList;
import java.util.Random;

public class SoundHandler {
    
    private static final int MAX_OCTAVE = 9;
    private static final int OCTAVE_DEFAULT = 5;
    private static short currentOctave = OCTAVE_DEFAULT;

    private static final int DEFAULT_VOLUME = 40;
    private static final int MAX_VOLUME = 127;
    private static int currentVolume = DEFAULT_VOLUME;

    private static final int MAX_INSTRUMENT = 120;
    private static final int MIN_INSTRUMENT = 0;
    private static int currentInstrument = 0;
    
    private static final Random RANDOM = new Random();

    private static final String[] bpm = {
            "GRAVE", "LARGO", "LARGHETTO", "LENTO", "ADAGIO", "ADAGIETTO", "ANDANTE", "ANDANTINO",
            "MODERATO", "ALLEGRETTO", "ALLEGRO", "VIVACE", "PRESTO", "PRETISSIMO"
    }; 
    
    private static final ArrayList<String> audioScript = new ArrayList<>();
    public static ArrayList<String> getAudioScript() {
        return audioScript;
    }

    public static void initialize(int initialInstrument, int initialBPM) {
        audioScript.clear();
        switchToInstrument(initialInstrument);
        currentOctave = OCTAVE_DEFAULT;
        currentVolume = DEFAULT_VOLUME; 
        audioScript.add(String.format("T[%s]", bpm[initialBPM]));
        audioScript.add(String.format(":CON(7, %d)", DEFAULT_VOLUME));
    }

    public static int getInstrument() {
        return currentInstrument;
    }

    public static void doubleVolume() {
        currentVolume *= 2;

        if (currentVolume > MAX_VOLUME) {
            currentVolume = DEFAULT_VOLUME;
        }

        audioScript.add(String.format(":CON(7, %d)", currentVolume));
    }

    public static void increaseOctave() {
        if (currentOctave < MAX_OCTAVE) {
            currentOctave++;
        }
        else {
            currentOctave = OCTAVE_DEFAULT;
        }
    }

    public static void switchToInstrument(int instrument) {
        if (instrument > MAX_INSTRUMENT || instrument < MIN_INSTRUMENT) {
            System.out.println(instrument + " is not a valid MIDI instrument code.");
            System.out.println("Selecting now an random instrument.");
            instrument = RANDOM.nextInt(MAX_INSTRUMENT);
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

        for (String word : SoundHandler.getAudioScript()) {
            builder.append(word);
            builder.append(" ");
        }

        return builder.toString();
    }
}    
