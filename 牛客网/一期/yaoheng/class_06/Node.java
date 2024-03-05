package 牛客网.一期.yaoheng.class_06;

import java.util.List;


public class Node {
    private Integer num;
    private List<Node> nest;

    public Node(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public List<Node> getNest() {
        return nest;
    }

    public void setNest(List<Node> nest) {
        this.nest = nest;
    }
}
