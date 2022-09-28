package textmusicconverter;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.player.Player;
import org.jfugue.pattern.Pattern;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class ExecutionManager{
    private static final Player PLAYER = new Player();
    
    public static void playAudio() {
        PLAYER.play(SoundHandler.generateAudioString());
    }
    
    public static boolean saveAsFile(Path path) {
        File outputFile = new File(path.toUri());
        Pattern pattern = new Pattern();
        pattern.add(SoundHandler.generateAudioString());

        try {
            MidiFileManager.savePatternToMidi(pattern, outputFile);
            return true;
        } catch (IOException error) {
            System.out.println("Erro ao salvar o arquivo. Detalhes abaixo");
            error.printStackTrace();
            return false;
        }
    }
}