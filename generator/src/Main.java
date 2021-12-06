import java.util.List;

public class Main {
    public static String generator(List<String> userSolutionContent, List<String> oldFileContent, String source){
        String[] parts = source.split("//");
        String fileName = parts[parts.length-1];
        SolutionFile old = SolutionFile.parseFile(oldFileContent, FileType.MARKDOWN, fileName);
        old.add(MarkdownEntity.parseEntity(userSolutionContent));
        String d = old.toString();
        return old.toString();
    }
    public static void main(String[] args) {
        String userSource = "C:\\Users\\Даниил\\IdeaProjects\\java_au\\generator\\src\\solution.txt";
        String source = "C://Users//Даниил//IdeaProjects//java_au//generator//src//array.md";
        List<String> userSolutionContent = IOUtils.readData(userSource);
        List<String> oldFileContent = IOUtils.readData(source);
        IOUtils.writeData(source, generator(  userSolutionContent,  oldFileContent, source));
    }
}