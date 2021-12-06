import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MarkdownEntityTest {

    @org.junit.jupiter.api.Test
    void parseEntity() {
        var expected = new MarkdownEntity("design-twitter","https://leetcode.com/problems/design-twitter/","``` java\n"+"def __init__(self):\n\n" +
                "    self.users = {}" + "```");
        List<String> d = getSourceSolution();
        MarkdownEntity v = MarkdownEntity.parseEntity(d);
        assertEquals(expected, v);
    }

    @org.junit.jupiter.api.Test
    void getTitle() {
    }

    @org.junit.jupiter.api.Test
    void getFormatted() {
    }
    private List<String> getSourceSolution(){
        return  List.of(
                "design-twitter",
                "https://leetcode.com/problems/design-twitter/",
                "def __init__(self):\n" ,
                "    self.users = {}");
    }
}