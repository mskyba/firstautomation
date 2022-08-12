package sets;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Integer> iSet1 = new HashSet<>();
        Collections.addAll(iSet1, 1, 13, 25, 43, 7, 31);
        Sets.printSet("Set1", iSet1);

        Set<Integer> iSet2 = new TreeSet<>();
        Collections.addAll(iSet2, 19, 26, 2, 3, 33, 15);
        Sets.printSet("Set2", iSet2);

        Set<Integer> iSet3 = new LinkedHashSet<>();
        Collections.addAll(iSet1, 8, 10, 12, 14, 16, 18);
        Sets.printSet("Set3", iSet3);

        Set<Integer> iSet4 = Sets.intersect(iSet1, iSet2);

        Sets.printSet("Set1 intersect Set2", iSet4);
        Sets.printSet("Set1 intersect Set2 union Set3", Sets.union(iSet4, iSet3));
    }
}