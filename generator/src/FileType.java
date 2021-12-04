public enum FileType {
    MARKDOWN("md"),
    HTML("html"),
    LATEX("tex");

    private String type;

    FileType(String fileType){
        this.type = fileType;
    }

    public  String getValue(){
        return type;
    }

}
