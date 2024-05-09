import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Picnic {

    public static void main(String[] args) throws Exception {

        Map<String, Integer> inputMap = new TreeMap<String, Integer>();
        getMapFromFile(inputMap);
        getNumberOfWord(inputMap);
        System.out.println();
        getMaxLengthWord(inputMap);
        System.out.println();
        System.out.println();
        System.out.println("Частота слов из файла input.txt в виде TreeMap:");
        System.out.println(inputMap);
    }

    public static void getMapFromFile(Map<String, Integer> inputMap) {

        try (BufferedReader buffReader = new BufferedReader(new FileReader("Picnic/input.txt"))) {

            String line;
            String inputData = "";
            String word = "";
            int count = 1;

            while ((line = buffReader.readLine()) != null) {
                inputData += line;
            }

            for (int i = 0; i < inputData.length(); i++) {

                if (inputData.charAt(i) != ' ') {
                    word += inputData.charAt(i);
                } else {

                    if (!inputMap.containsKey(word)) {
                        inputMap.put(word, count);
                    } else {
                        inputMap.put(word, inputMap.get(word) + 1);
                    }
                    word = "";
                }
                inputMap.remove("");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getNumberOfWord(Map<String, Integer> inputMap) {

        int numberOfWord = 0;

        for (int countSingleWord : inputMap.values()) {
            numberOfWord += countSingleWord;
        }
        System.out.println("Количетсво слов в файле input.txt -> " + numberOfWord);

    }

    public static void getMaxLengthWord(Map<String, Integer> inputMap) {

        int maxLength = 0;

        for (String word : inputMap.keySet()) {
            maxLength = word.length() > maxLength ? word.length() : maxLength;
        }

        System.out.print("Самое длинное слово(а) в файле input.txt из " + maxLength + " букв -> | ");
        for (String word : inputMap.keySet()) {
            if (word.length() == maxLength) {
                System.out.print(word + " | ");
            }
        }

    }
}