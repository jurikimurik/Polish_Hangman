package basic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HangmanGame {
    //---------------------------CONSTRUCTORS---------------------------
    public HangmanGame() {
        startNewGame();
    }

    public HangmanGame(String path, int numberOfAttempts) {
        startNewGame(path, numberOfAttempts);
    }
    //-----------------------------------------------------------------

    //-----------------------------METHODS-----------------------------
    public void startNewGame() {
        startNewGame("words.hm", 12);
    }

    public void startNewGame(String path, int numberOfAttempts) {
        reset();



        //CHOOSING OF THE WORD (PROCESS)
        // - Every word in data is in this format: [:|:]WORD{DESC}DESCRIPTION[:|:]
        String wordDataSplitter = "\\[:\\|:]\\s*(\\[:\\|:])*";
        String inWordDataSplitter = "\\{DESC}";

        String word;
        String description = "";

        StringBuilder readedData = new StringBuilder();
        try {
            File wordDatabase = new File(path);
            Scanner reader = new Scanner(wordDatabase);
            while(reader.hasNextLine()) {
                readedData.append(reader.nextLine()).append("\n");
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Can't open file!");
            e.printStackTrace();
            return;
        }

        //Removing empty strings
        ArrayList<String> splittedData = new ArrayList<>(Arrays.asList(readedData.toString().split(wordDataSplitter)));
        splittedData.removeIf(Objects::isNull);
        splittedData.removeIf(String::isEmpty);

        String choosedWord = splittedData.get(random.nextInt(splittedData.size()));

        String[] splittedWord = choosedWord.split(inWordDataSplitter);
        word = splittedWord[0];
        if(splittedWord.length > 1)
            description = splittedWord[1];

        //Set basic parameters
        setHidedWord(word);
        setCurrentWord(word.replaceAll(".","*"));
        setDescriptionOfWord(description);

        //Another settings
        setNumberOfAttempts(numberOfAttempts);
    }

    public void reset() {
        setScore(0);
        setHidedWord("");
        setDescriptionOfWord("");
        setCurrentWord("");
        setUsedCharacters(new HashSet<>());
        setNumberOfAttempts(0);
    }

    //------BASIC METHODS------

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder("Score:" + getScore() + "\n" +
                "Hided word: " + getHidedWord() + "\n" +
                "Description: " + getDescriptionOfWord() + "\n" +
                "Current word: " + getCurrentWord() + "\n" +
                "Number of attempts: " + getNumberOfAttempts() + "\n");

        data.append("Used characters: ");
        ArrayList<String> usedCharacters = new ArrayList<>(getUsedCharacters());
        for(int i = 0; i < usedCharacters.size(); i++) {
            data.append(usedCharacters.get(i));
            if(i + 1 != usedCharacters.size())
                data.append(",");
        }

        return data.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    //-----------------------------------------------------------------


    //---------------------------VARIABLES------------------------------
    private int score;
    private String hidedWord;   //This is answer.
    private String descriptionOfWord;   // Additional description of the word
    private String currentWord; //Current string word that CAN be shown!
    private HashSet<String> usedCharacters; // String needed for wide-coded characters.
    private int numberOfAttempts;

    private final Random random = new Random();
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
