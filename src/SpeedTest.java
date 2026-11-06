import java.util.ArrayList;
import java.util.HashMap;

public class SpeedTest {

    static final int LOOKUPS = 2000;
    static volatile Container lastResult;

    static class Container {
        String id;
        String position;

        Container(String id, String position) {
            this.id = id;
            this.position = position;
        }
    }

    static Container searchList(ArrayList<Container> containers, String id) {
        for (int i = 0; i < containers.size(); i++) {
            Container container = containers.get(i);
            if (container.id.equals(id)) {
                return container;
            }
        }
        return null;
    }

    static double timeList(ArrayList<Container> list, String[] searchIDs) {
        Container found = null;

        long start = System.nanoTime();

        for (int i = 0; i < LOOKUPS; i++) {
            int index = i % searchIDs.length;
            String id = searchIDs[index];
            found = searchList(list, id);
        }

        long elapsed = System.nanoTime() - start;
        lastResult = found;

        double averageTime = (double) elapsed / LOOKUPS;
        return averageTime;
    }

    static double timeMap(HashMap<String, Container> map, String[] searchIDs) {
        Container found = null;

        long start = System.nanoTime();

        for (int i = 0; i < LOOKUPS; i++) {
            int index = i % searchIDs.length;
            String id = searchIDs[index];
            found = map.get(id);
        }

        long elapsed = System.nanoTime() - start;
        lastResult = found;

        double averageTime = (double) elapsed / LOOKUPS;
        return averageTime;
    }

    static void test(int size) {

        ArrayList<Container> list = new ArrayList<>();
        HashMap<String, Container> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            String id = "RP-" + (100000 + i);
            Container container = new Container(id, "Yard A - Slot " + i);

            list.add(container);
            map.put(id, container);
        }

        String[] searchIDs = new String[100];

        for (int i = 0; i < searchIDs.length; i++) {
            searchIDs[i] = list.get(size - 100 + i).id;
        }

        for (int i = 0; i < 4; i++) {
            timeList(list, searchIDs);
            timeMap(map, searchIDs);
        }

        double listTime = timeList(list, searchIDs);
        double mapTime = timeMap(map, searchIDs);

        System.out.printf("%,d | %,.1f ns | %,.1f ns%n",
                size, listTime, mapTime);
    }

    public static void main(String[] args) {

        System.out.println("Containers | ArrayList lookup | HashMap lookup");

        test(1000);
        test(50000);

    }
}
