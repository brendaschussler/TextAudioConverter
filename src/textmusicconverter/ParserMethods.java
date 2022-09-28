package textmusicconverter;

public class ParserMethods {
    
    private static final int HARPISCHORD = 6;
    private static final int TUBULAR_BELLS = 14;
    private static final int CHURCH_ORGAN = 19;
    private static final int PAN_FLUTE = 75;
    private static final int AGOGO = 113;

    public static void C() {
        SoundHandler.appendNote('C');
    }

    public static void D() {
        SoundHandler.appendNote('D');
    }

    public static void E() {
        SoundHandler.appendNote('E');
    }

    public static void F() {
        SoundHandler.appendNote('F');
    }

    public static void G() {
        SoundHandler.appendNote('G');
    }

    public static void A() {
        SoundHandler.appendNote('A');
    }

    public static void B() {
        SoundHandler.appendNote('B');
    }

    public static void space() {
        SoundHandler.doubleVolume();
    }
    
    public static void exclamationMark() {
        SoundHandler.switchToInstrument(AGOGO);
    }

    public static void questionMarkOrDot() {
        SoundHandler.increaseOctave();
    }

    public static void semicolon() {
        SoundHandler.switchToInstrument(PAN_FLUTE);
    }

    public static void comma() {
        SoundHandler.switchToInstrument(CHURCH_ORGAN);
    }

    public static void newLine() {
        SoundHandler.switchToInstrument(TUBULAR_BELLS);
    }

    public static void digit(char c) {
        final int currentInstrument = SoundHandler.getInstrument();
        SoundHandler.switchToInstrument(currentInstrument + (int) c);
    }

    public static void nonNoteVowel() {
        SoundHandler.switchToInstrument(HARPISCHORD);
    }

    public static void other(int charIndex) {
        if (wasLastCharANote(charIndex)) {
            SoundHandler.repeatNote();
        }
        else {
            SoundHandler.appendPause();
        }
    }

    private static boolean wasLastCharANote(int charIndex) {
        if (charIndex <= 0) {
            return false;
        }

        final char lastChar = InputParser.getUserInput().charAt(charIndex - 1);
        final char[] notes = {'A', 'B', 'C', 'D', 'F', 'G'};

        for (char note : notes) {
            if (lastChar == note) {
                return true;
            }
        }

        return false;
    }
}
