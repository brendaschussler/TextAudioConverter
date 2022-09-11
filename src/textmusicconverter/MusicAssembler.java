package textmusicconverter;
import org.jfugue.player.Player;

public class MusicAssembler {

    private static final Player player = new Player();
    
    public static void playAudio() {
        //System.out.println(generateAudioString());
        player.play(generateAudioString());
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
