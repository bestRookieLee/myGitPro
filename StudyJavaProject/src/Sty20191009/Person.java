package Sty20191009;

import java.util.List;

public class Person {
    private String name;
    private String age;
    private String sex;
    private String parentName;
    private String level;
    private List<Person> children;
    public Person(){
        super();
    }
    public Person(String name,  String age, String sex, String level){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }
}
