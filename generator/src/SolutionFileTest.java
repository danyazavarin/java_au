import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionFileTest {

    @org.junit.jupiter.api.Test
    void parseFile() {
        List<ItemEntity> s = new ArrayList<>();
        s.add(new MarkdownEntity("design-twitter","https://leetcode.com/problems/design-twitter/","``` java\n"+"def __init__(self):\n" +
                "    self.users = {}" + "\n```\n"));
        var expected = new SolutionFile(s, FileType.MARKDOWN, "solution.txt");
        List<String> d = getSourceSolution();

        SolutionFile v = SolutionFile.parseFile(d, FileType.MARKDOWN, "solution.txt");
        assertEquals(expected, v);
    }

    private List<String> getSourceSolution(){
        return  List.of("# array.md",
                "+ [design-twitter](#design-twitter)",
                "## design-twitter",
                "https://leetcode.com/problems/design-twitter/",
                "``` java",
                "def __init__(self):",
                "    self.users = {}",
                "```");
    }

    @org.junit.jupiter.api.Test
    void add() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}