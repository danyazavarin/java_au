import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void generator() {
        var expected = "# array.md\n" + "\n" + "+ [design-twitter](#design-twitter)\n" + "\n" + "## design-twitter\n" + "\n" +
                "https://leetcode.com/problems/design-twitter/\n" + "\n" + "``` java\n" + "def __init__(self):\n" + "    self.users = {}\n" + "```";
        String source = "C://Users//liza_//IdeaProjects//java_au_2//generator//src//array.md";
        String d = Main.generator(getSourceSolution(), getSourceSolution(), source);
        assertEquals(expected, d);
    }

    @Test
    void main() {
    }

    private List<String> getSourceSolution(){
        return  List.of("design-twitter",
                "https://leetcode.com/problems/design-twitter/",
                "def __init__(self):" ,
                "    self.users = {}", "");
    }
}