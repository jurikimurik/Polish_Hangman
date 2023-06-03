package basic;

import java.util.HashSet;

public class HangmanGame {

    //---------------------------VARIABLES------------------------------
    private int score;
    private String descriptionOfWord;   // Additional description of the word
    private String hidedWord;   //This is answer.
    private String currentWord; //Current string word that CAN be shown!
    private HashSet<String> usedCharacters; // String needed for wide-coded characters.
    private int numberOfAttempts;
    //-----------------------------------------------------------------

    //-----------------------GETTERS AND SETTERS-----------------------
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDescriptionOfWord() {
        return descriptionOfWord;
    }

    public void setDescriptionOfWord(String descriptionOfWord) {
        this.descriptionOfWord = descriptionOfWord;
    }

    public String getHidedWord() {
        return hidedWord;
    }

    public void setHidedWord(String hidedWord) {
        this.hidedWord = hidedWord;
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
    }

    public HashSet<String> getUsedCharacters() {
        return usedCharacters;
    }

    public void setUsedCharacters(HashSet<String> usedCharacters) {
        this.usedCharacters = usedCharacters;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void setNumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }

    //-----------------------------------------------------------------
}
