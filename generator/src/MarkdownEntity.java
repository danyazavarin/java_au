import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class MarkdownEntity implements ItemEntity {
    private String taskTitle;
    private String taskUrl;
    private String taskSolution;
    public MarkdownEntity(String title, String url, String solution){
        this.taskTitle = title;
        this.taskUrl = url;
        this.taskSolution = solution;
    }
    @Override
    public String getTitle(){
        return String.format("+ [%s](#%s)", taskTitle, taskUrl.split("/")[4]);
    }
    @Override
    public String getFormatted(){
        return String.format("## %s\n\n%s\n\n%s", taskTitle, taskUrl, taskSolution);
    }
    public static MarkdownEntity parseEntity(String s) {
        String[] lines = s.split("[\\r\\n]+");
        String title = lines[0].split("\\. ")[1];
        String url = lines[1];
        String solution = IntStream.range(3, lines.length)
                .mapToObj(i -> lines[i].substring(4))
                .collect(Collectors.joining("\n"));
        return new MarkdownEntity(title, url, String.format("``` java\n%s\n```", solution));
    }
    @Override
    public boolean newEquals(Object o){
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MarkdownEntity that = (MarkdownEntity) o;
        return Objects.equals(taskTitle, that.taskTitle) && Objects.equals(taskUrl, that.taskUrl) && Objects.equals(taskSolution, that.taskSolution);
    }
} 