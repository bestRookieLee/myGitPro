package Sty20191009;

import java.util.List;

public class simplePerson {
    private String name;
    private String parentName;
    private String level;
    private List<simplePerson> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<simplePerson> getChildren() {
        return children;
    }

    public void setChildren(List<simplePerson> children) {
        this.children = children;
    }
}
