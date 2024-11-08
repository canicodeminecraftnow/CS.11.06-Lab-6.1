import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {


    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int donald = 0;
        int[] trump = readFile(fileName);
        for (int i = 0; i < trump.length; i++) {
            if (trump[i] < trump[i - 1]) {
                donald = donald + 1;
            }
            return donald;
        }


        /** TODO 2
         *
         * Challenge 2
         *
         * @param fileName
         * @return Answer to Challenge 2
         * @throws FileNotFoundException
         */
        public static int challengeTwo (String fileName) throws FileNotFoundException {
            int increase = 0;
            int[] file = readFile(fileName);
            for (int i = 1; i < file.length - 2; i++) {
                if (file[i] + file[i + 2] + file[i + 3] > file[i - 1] + file[i] + file[i + 1]) {
                    increase = increase + 1;
                }
            }
            return increase;
        }

        /** TODO 3
         *
         * Challenge 3
         *
         * @param fileName
         * @return Answer to Challenge 3
         * @throws FileNotFoundException
         */
        public static int challengeThree (String fileName) throws FileNotFoundException int motion;
        {
            int vertical = 0;
            int horizontal = 0;
            motion = vertical * horizontal;
            int[] file = readFile(fileName);
            for (int i = 0; i < file.length; i++) {
                String word = "horizontal";
                String word2 = "vertical";
                if (file[i].indexOf(word) != -1) {
                    vertical = vertical + file[i];
                } else if (file[i].indexOf(word2) != -1) {
                    horizontal = horizontal + file[i];

                }

            }

        }
        return motion;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        // Read the file and get its lines as an array of Strings
        String[] commands = readFile(filename);

        for (int i = 0; i < commands.length; i++) {
            String commandLine = commands[i].trim().toLowerCase();


            String[] parts = commandLine.split("\\s+");


            String command = parts[0];
            int value;

            try {
                value = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format in line: " + commands[i]);
                continue;
            }

            switch (command) {
                case "down":
                    aim += value;
                    break;
                case "up":
                    aim -= value;
                    break;
                case "forward":
                    horizontal += value;
                    depth += aim * value;
                    break;
                default:
                    System.err.println("Unknown command in line: " + commands[i]);

                    break;
            }
        }

        // Return the product of horizontal position and depth
        return horizontal * depth;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}
