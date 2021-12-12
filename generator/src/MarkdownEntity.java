import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;


public class MarkdownEntity implements ItemEntity {
    private String taskTitle;
    private String taskUrl;
    private String taskSolution;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarkdownEntity that = (MarkdownEntity) o;
        return Objects.equals(taskTitle, that.taskTitle) && Objects.equals(taskUrl, that.taskUrl) && Objects.equals(taskSolution, that.taskSolution);
    }

    MarkdownEntity(String taskTitle, String taskUrl, String taskSolution){
        this.taskTitle = taskTitle;
        this.taskUrl = taskUrl;
        this.taskSolution = taskSolution;
    }


    static   MarkdownEntity parseEntity(List<String> s){
        StringJoiner joiner = new StringJoiner("\n");
        if (s.size() < 4) {
            return new MarkdownEntity(null, null, null);
        }
        for (int i = 2; i<s.size();i++){
            joiner.add(s.get(i));
        }
        String solution = "``` java" + "\n" + joiner + "```";
        return new MarkdownEntity(s.get(0), s.get(1), solution);
    }


    @Override
    public String getTitle() {
        return "+ [" + this.taskTitle + "]" + "(#" + this.taskUrl.split("/")[4] + ")";
    }


    @Override
    public String getFormatted() {
        return "## " + this.taskTitle + "\n\n" + this.taskUrl + "\n\n"  + this.taskSolution;
    }

    @Override
    public boolean newEquals(Object o) {
        return false;
    }
}