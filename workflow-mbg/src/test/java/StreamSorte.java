import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by wl on 2020/10/26
 */
public class StreamSorte {
    public static void main(String[] args) {
        List<Long> a=new ArrayList<>();
        a.add(2l);
        a.add(1l);
        a.add(20l);
        a.add(19l);
        List<Long> collect = a.stream().sorted().collect(Collectors.toList());
        for (Long l :collect){
            System.out.println( l+"\r\n");
        }
        List<Person> l=new ArrayList<>();
        Person p1=new Person("za",11);
        Person p2=new Person("ls",20);
        Person p3=new Person("ww",6);
        Person p4=new Person("ss",16);
        l.add(p1);
        l.add(p2);
        l.add(p3);
        l.add(p4);
        List<Person> collect1 = l.stream().sorted((l1, l2) -> {
            return l1.getAge().compareTo(l2.getAge());
        }).collect(Collectors.toList());
        collect1.stream().forEach(p -> System.out.println(p.getAge()));
    }
}
