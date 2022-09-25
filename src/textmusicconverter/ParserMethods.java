package textmusicconverter;

public class ParserMethods {

    private static final int HARPISCHORD = 6;
    private static final int TUBULAR_BELLS = 14;
    private static final int CHURCH_ORGAN = 19;
    private static final int PAN_FLUTE = 75;
    private static final int AGOGO = 113;

    public static void C() {
        MusicAssembler.appendNote('C');
    }

    public static void D() {
        MusicAssembler.appendNote('D');
    }

    public static void E() {
        MusicAssembler.appendNote('E');
    }

    public static void F() {
        MusicAssembler.appendNote('F');
    }

    public static void G() {
        MusicAssembler.appendNote('G');
    }

    public static void A() {
        MusicAssembler.appendNote('A');
    }

    public static void B() {
        MusicAssembler.appendNote('B');
    }

    public static void space() {
        MusicAssembler.doubleVolume();
    }
    
    public static void exclamationMark() {
        MusicAssembler.switchToInstrument(AGOGO);
    }

    public static void questionMarkOrDot() {
        MusicAssembler.increaseOctave();
    }

    public static void semicolon() {
        MusicAssembler.switchToInstrument(PAN_FLUTE);
    }

    public static void comma() {
        MusicAssembler.switchToInstrument(CHURCH_ORGAN);
    }

    public static void newLine() {
        MusicAssembler.switchToInstrument(TUBULAR_BELLS);
    }

    public static void digit(char c) {
        final int currentInstrument = MusicAssembler.getInstrument();
        MusicAssembler.switchToInstrument(currentInstrument + (int) c);
    }

    public static void nonNoteVowel() {
        MusicAssembler.switchToInstrument(HARPISCHORD);
    }

    public static void other(int charIndex) {
        if (wasLastCharANote(charIndex)) {
            MusicAssembler.repeatNote();
        }

        else {
            MusicAssembler.appendPause();
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