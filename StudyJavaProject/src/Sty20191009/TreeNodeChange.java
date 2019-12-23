package Sty20191009;

import Test20190713.Main;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TreeNodeChange {
    private static List<simplePerson> getChild(Person person, List<Person> childList, List<simplePerson> simplePersonList){
        if(person.getChildren() != null && person.getChildren().size()>0){
            for (Person per : person.getChildren()){
                per.setParentName(person.getName());
                getChild(per,childList,simplePersonList);
                simplePerson sp = new simplePerson();
                sp.setName(per.getName());
                sp.setParentName(per.getParentName());
                sp.setLevel(per.getLevel());
                simplePersonList.add(sp);
                childList.add(per);
            }
        }
        return simplePersonList;
    }
    private static List<simplePerson> getSimplePerson(List<simplePerson> aChildList){
        for (simplePerson sp : aChildList) {
            List<simplePerson> childList = new ArrayList<>();
            for (simplePerson sp1 : aChildList){
                if (sp.getName().equals(sp1.getParentName())){
                    childList.add(sp1);
                }
            }
            sp.setChildren(childList);
        }
        return aChildList;
    }

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        List<simplePerson> simplePeopleList = new ArrayList<>();
        Person d = new Person("D","18","nan","3");
        Person c = new Person("C","18","nan","2");
        Person b = new Person("B","18","nan","2");
        Person a = new Person("A","18","nan","1");
        List<Person> childListB = new ArrayList<>();
        childListB.add(d);
        b.setChildren(childListB);
        personList.add(b);
        personList.add(c);
        a.setChildren(personList);
        List<simplePerson> aChildList = getChild(a,new ArrayList<Person>(),new ArrayList<simplePerson>());
        Collections.sort(aChildList, new Comparator<simplePerson>() {
            @Override
            public int compare(simplePerson o1, simplePerson o2) {
                return o1.getLevel().compareTo(o2.getLevel());
            }
        });
        getSimplePerson(aChildList);
        simplePerson finalSimplePerson = new simplePerson();
        finalSimplePerson.setLevel(a.getLevel());
        finalSimplePerson.setName(a.getName());
        finalSimplePerson.setChildren(aChildList);
        System.out.println(JSONObject.toJSON(finalSimplePerson).toString());
    }
}
