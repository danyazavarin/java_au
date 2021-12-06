import java.util.*;

public class SolutionFile {
    List<ItemEntity> data;
    private FileType fileType;
    private String fileName;


    public SolutionFile(List<ItemEntity> data, FileType fileType, String fileName){
        this.data = data;
        this.fileType = fileType;
        this.fileName = fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolutionFile that = (SolutionFile) o;
        return Objects.equals(data, that.data) && fileType == that.fileType && Objects.equals(fileName, that.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, fileType, fileName);
    }

    private static List<ItemEntity> parseMDFile(List<String> content){
        List<ItemEntity> lst = new ArrayList<>();
        List<String> title = new ArrayList<>();
        List<String> urls = new ArrayList<>();
        int count = 0;
        int count1 = 0;
        while (count < content.size()) {
            String str = content.get(count);
            if (str.contains("+ [")) {
                String[] d = str.split("\\[");
                String[] d1 = d[1].split("\\]");
                title.add(d1[0]);
                count++;
            }else if (str.contains("http")) {
                urls.add(str);
                count++;
            } else if (str.contains("``` java")) {
                StringJoiner joiner = new StringJoiner("");
                while (!str.equals("```")) {
                    str = content.get(count);
                    joiner.add(str).add("\n");
                    count++;
                }
                lst.add(new MarkdownEntity(title.get(count1), urls.get(count1), joiner.toString()));
                count1++;
            } else{
                count++;
            }
        }
        return lst;
    }


    private static List<ItemEntity> parseLatexFile(List<String> content){
        List<ItemEntity> lst = new ArrayList<>();
        return lst;
    }
    private static List<ItemEntity> parseHTMLFile(List<String> content){
        List<ItemEntity> lst = new ArrayList<>();
        return lst;
    }


    public static SolutionFile parseFile(List<String> content, FileType fileType, String fileName) {
        List<ItemEntity> data;
        switch (fileType) {
            case MARKDOWN -> data = parseMDFile(content);
            case HTML -> data = parseHTMLFile(content);
            case LATEX -> data = parseLatexFile(content);
            default -> throw new IllegalStateException("Unexpected value: " + fileType);
        }
        return new SolutionFile(data, fileType, fileName);
    }

    public void add(ItemEntity new_item) {
        this.data.add(new_item);
    }


    private String mdToString(){
        StringJoiner joiner = new StringJoiner("");
        // String[] d = this.data.stream().map(ItemEntity::getTitle).toArray(String[]::new);
        String title = String.join("\n", this.data.stream().map(ItemEntity::getTitle).toArray(String[]::new));
        String solutions = String.join("\n\n", this.data.stream().map(ItemEntity::getFormatted).toArray(String[]::new));
        joiner.add("# ").add(this.fileName).add("\n\n").
                add(title).add("\n\n").
                add(solutions);
        return joiner.toString();
    }


    private String mdToLatex(){
        return "";
    }


    private String mdToHTML(){
        return "";
    }


    @Override
    public String toString(){
        String res;
        switch (fileType){
            case MARKDOWN -> res = mdToString();
            case LATEX -> res = mdToLatex();
            case HTML -> res = mdToHTML();
            default -> throw new IllegalStateException("Unexpected value: " + fileType);
        }
        return res;
    }

}