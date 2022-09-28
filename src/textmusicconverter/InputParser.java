package textmusicconverter;

public class InputParser {

    private static String userInput;

    private final static char NEW_LINE = (char) 0x0A;
    private final static int SIZE_LIMIT_USER_INPUT = 1000;

    private static boolean isNonNoteVowel(char letter) {
        final char[] nonNoteVowels = {'I', 'i', 'O', 'o', 'U', 'u'};
        for (char nonNoteVowel : nonNoteVowels) {
            if (letter == nonNoteVowel) {
                return true;
            }
        }

        return false;
    }

    private static boolean isDigit(char c) {
        return (c >= '0' && c <= '9');
    }

    public static String getUserInput() {
        return userInput;
    }

    public static void setUserInput(String userInput) {
        InputParser.userInput = userInput;
    }

    public static int getUserInputSize() {
        if (userInput.length() > SIZE_LIMIT_USER_INPUT) {
            return SIZE_LIMIT_USER_INPUT;
        } else {
            return userInput.length();
        }
    }

    public static void parseInput(String input) {
        userInput = input;

        for (int charIndex = 0; charIndex < getUserInputSize(); charIndex++) {
            char c = getUserInput().charAt(charIndex);

            switch (c) {
                case 'A' ->
                    ParserMethods.A();
                case 'B' ->
                    ParserMethods.B();
                case 'C' ->
                    ParserMethods.C();
                case 'D' ->
                    ParserMethods.D();
                case 'E' ->
                    ParserMethods.E();
                case 'F' ->
                    ParserMethods.F();
                case 'G' ->
                    ParserMethods.G();
                case ' ' ->
                    ParserMethods.space();
                case '!' ->
                    ParserMethods.exclamationMark();
                case '?' ->
                    ParserMethods.questionMarkOrDot();
                case '.' ->
                    ParserMethods.questionMarkOrDot();
                case ';' ->
                    ParserMethods.semicolon();
                case ',' ->
                    ParserMethods.comma();
                case NEW_LINE ->
                    ParserMethods.newLine();
                default -> {
                    if (isDigit(c)) {
                        ParserMethods.digit(c);
                    } else if (isNonNoteVowel(c)) {
                        ParserMethods.nonNoteVowel();
                    } else {
                        ParserMethods.other(charIndex);
                    }
                }
            }
        }
    }

}
