package textmusicconverter;

public class ParserMethods {

    public static void appendNoteC() {
        SoundHandler.appendNote('C');
    }

    public static void appendNoteD() {
        SoundHandler.appendNote('D');
    }

    public static void appendNoteE() {
        SoundHandler.appendNote('E');
    }

    public static void appendNoteF() {
        SoundHandler.appendNote('F');
    }

    public static void appendNoteG() {
        SoundHandler.appendNote('G');
    }

    public static void appendNoteA() {
        SoundHandler.appendNote('A');
    }

    public static void appendNoteB() {
        SoundHandler.appendNote('B');
    }
    
    public static void appendSilence() {
        SoundHandler.appendNote('R');
    }

    public static void doubleCurrentVol() {
        SoundHandler.doubleVolume();
    }

    public static void returnStartVol() {
        SoundHandler.resetVolume();
    }

    //public static void nonNoteVowel() {
    // checar se o último caractere era uma nota e, se for, repeti-la (Audio.playPreviousNote())
    // se não, emitir um bip (Audio.ring())
    // as funções do áudio já foram implementadas, resta linkar com as do parse.
    //}
    
    public static void octavePlus() {
        SoundHandler.increaseOctave();
    }

    public static void octaveMinus() {
        SoundHandler.decreaseOctave();
    }

    public static void questionMark() {
        SoundHandler.playRandomNote();
    }

    public static void newLine() {
        SoundHandler.switchInstrumentRandomly();
    }

    public static void bpmPlus() {
        SoundHandler.increaseBPM();
    }

    public static void semicolon() {
        SoundHandler.setRandomBPM();
    }
}
