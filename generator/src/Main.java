import java.io.IOException;
public class Main {
    public static void main (String[] args) throws IOException{
        String userSource = "C:\\Users\\Даниил\\IdeaProjects\\java_au\\generator\\src\\source_leetcode_data.txt";
        String source = "C:\\Users\\Даниил\\IdeaProjects\\java-au\\Generator\\src\\array.md";
        String userSolutionContent = IOUtils.readFile(userSource);
        String odlFileContent = IOUtils.readFile(source);
        String newFileContent = Generation.getNewContent(userSolutionContent, odlFileContent, source);
        if (newFileContent != null){
            IOUtils.writeToFile(source, newFileContent);
        }
    }
}