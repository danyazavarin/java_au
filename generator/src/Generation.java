public class Generation {
    public static String getNewContent(String userSolutionContent, String oldFileContent, String oldFileName){
        int n = oldFileName.split("\\\\").length;
        String[] parts = oldFileName.split("\\\\")[n-1].split("\\.");
        SolutionFile old = SolutionFile.parseFile(oldFileContent, FileType.MARKDOWN, parts[0]);
        if (old == null){
            return null;
        }
        old.add(MarkdownEntity.parseEntity(userSolutionContent));
        return old.toString();
    }
}