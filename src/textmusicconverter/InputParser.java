package textmusicconverter;

public class InputParser {
    
    private static String userInput;

    private static boolean isNonNoteVowel(char letter) {
        final char[] nonNoteVowels = {'I', 'i', 'O', 'o', 'U', 'u'};
        for (char nonNoteVowel : nonNoteVowels) {
            if (letter == nonNoteVowel) {
                return true;
            }
        }

        return false;
    }

    private static boolean isDigitChar(char c) {
        return (c >= '0' && c <= '9');
    }

    public final static char newLine = (char) 0x0A;

    public static String getUserInput() {
        return userInput;
    }

    public static void parseInput(String input) {
        userInput = input;

        for (int charIndex = 0; charIndex < userInput.length(); charIndex++) {
            char c = getUserInput().charAt(charIndex);

            switch (c) {
                case 'A' -> ParserMethods.A();
                case 'B' -> ParserMethods.B();
                case 'C' -> ParserMethods.C();
                case 'D' -> ParserMethods.D();
                case 'E' -> ParserMethods.E();
                case 'F' -> ParserMethods.F();
                case 'G' -> ParserMethods.G();
                case ' ' -> ParserMethods.space();
                case '!' -> ParserMethods.exclamationMark();
                case '?', '.' -> ParserMethods.questionMarkOrDot();
                case ';' -> ParserMethods.semicolon();
                case ',' -> ParserMethods.comma();
                case newLine -> ParserMethods.newLine();
                default -> {
                    if (isDigitChar(c)) {
                        ParserMethods.digit(c);
                    }

                    else if (isNonNoteVowel(c)) {
                        ParserMethods.nonNoteVowel();
                    }

                    else {
                        ParserMethods.other(charIndex);
                    }
                }
            }
        }
    }
}
