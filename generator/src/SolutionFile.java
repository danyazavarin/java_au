import java.util.*;
public class SolutionFile {
    final List<ItemEntity> data;
    private final String fileName;
    public SolutionFile(List<ItemEntity> lst, String title) {
        this.data = lst;
        this.fileName = title;
    }
    private static boolean checkMarkdownFile(ArrayList<String> title, ArrayList<String> code){
        if (title.size() - 1 != code.size()){
            System.out.println("Error(size): Incorrect md file!\n");
            return false;
        }
        for (int i = 0; i < code.size(); i++) {
            String title_1 = title.get(i+1).split("]")[0].substring(3);
            String code_1 = code.get(i).split("\n")[0].substring(3);
            if (!title_1.equals(code_1)){
                System.out.println("Error(title): Incorrect md file!\n");
                return false;
            }
        }
        return true;
    }
    private static List<ItemEntity> parseMD(String s){
        String[] parts = s.split("\n<!---Comment--");
        ArrayList<String> title = new ArrayList<String>(Arrays.asList(parts[0].split("\\R+")));
        ArrayList<String> codeLines = new ArrayList<String>(Arrays.asList(parts[1].split("[\\r\\n]+")));
        codeLines.removeAll(Arrays.asList("", null, "\n"));
        ArrayList<String> code = new ArrayList<String>();
        String tmp = "";
        for (String line : codeLines) {
            if (line.equals("```")) {
                tmp += line;
                code.add(tmp);
                tmp = "";
            } else {
                tmp += line;
                tmp += "\n";
            }
        }
        if (!checkMarkdownFile(title, code))
            return null;
        ArrayList<ItemEntity> lst = new ArrayList<>();
        String taskTitle;
        String taskUrl;
        String taskSolution;
        String[] parse_lst;
        for (String problem : code) {
            parse_lst = problem.split("\n");
            taskTitle = parse_lst[0].substring(3);
            taskUrl = parse_lst[1];
            taskSolution = "";
            for (int i = 2; i < parse_lst.length; i++){
                taskSolution += parse_lst[i];
                taskSolution += "\n";
            }
            ItemEntity task = new MarkdownEntity(taskTitle, taskUrl, taskSolution.substring(0, taskSolution.length() - 1));
            lst.add(task);
        }
        return lst;
    }
    public static SolutionFile parseFile(String str, FileType t, String fileName){
        List<ItemEntity> lst = new ArrayList<>();
        String title = "";
        if (t == FileType.MARKDOWN) {
            if (str.length() != 0) {
                lst = parseMD(str);
            }
            title = "# " + fileName.substring(0, 1).toUpperCase() + fileName.substring(1) + "\n";
        }
        if (lst != null)
            return new SolutionFile(lst, title);
        else
            return null;
    }
    public void add(MarkdownEntity o){
        data.add(o);
    }
    public void add(ItemEntity thing){
        data.add(thing);
    }
    @Override
    public String toString(){
        String resultString = fileName + "\n";
        for (ItemEntity task : data){
            resultString += task.getTitle();
            resultString += "\n";
        }
        resultString += "\n<!---Comment-->\n\n";
        for (ItemEntity task : data){
            resultString += task.getFormatted();
            resultString += "\n\n";
        }
        return resultString;
    }
    @Override
    public boolean equals(Object ob){
        if (this == ob) return true;
        if (ob == null || getClass() != ob.getClass()) return false;
        SolutionFile that = (SolutionFile) ob;
        return Objects.equals(data, that.data) && Objects.equals(fileName, that.fileName);

    }
} 