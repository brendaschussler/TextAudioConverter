package textmusicconverter;

public class InputParser {

    private String userInput;

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public int getUserInputSize() {
        return userInput.length();
    }

    public void userInputParser() {

        for (int i = 0; i < getUserInputSize(); i++) {

            char c = getUserInput().charAt(i);
            boolean wasNote = false; 
            if (getUserInput().charAt(i-1)>'A' && getUserInput().charAt(i-1)<'G')
                wasNote = true; 
            
            switch(c){
                case 'A':
                    ParserMethods.appendNoteA();
                    break;
                case 'B':
                    ParserMethods.appendNoteB();
                    break;
                case 'C':
                    ParserMethods.appendNoteC();
                    break;
                case 'D':
                    ParserMethods.appendNoteD();
                    break;
                case 'E':
                    ParserMethods.appendNoteE();
                    break;
                case 'F':
                    ParserMethods.appendNoteF();
                    break;    
                case 'G':
                    ParserMethods.appendNoteG();
                    break; 
                case ' ':
                    ParserMethods.doubleCurrentVol(); //ajustar 
                    break;
                case '!':
                    ParserMethods.doubleCurrentVol(); //ajustar 
                    break;
                case '?':
                    ParserMethods.octavePlus(); 
                    break;
                case '.':
                    ParserMethods.octavePlus(); 
                    break;
                
                    
                    
            }

        }
    }

}
