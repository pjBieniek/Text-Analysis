import java.util.*;

public class StatisticalAnalysis {
    private Iterator<String> iterator;
    private Map<String, Integer> dataMap = new TreeMap<String, Integer>();

    public StatisticalAnalysis(Iterator<String> iterator){
        this.iterator = iterator;
        buildMap();
    }

    public int countOf(String... data) {
        int amount = 0;
        for (String key : dataMap.keySet()) {
            if (Arrays.asList(data).contains(key.toLowerCase())) {
                amount += dataMap.get(key);
            }
        }
        return amount;
    }

    public int dictionarySize() {
        return dataMap.size();
    }

    public int size() {
        int amount = 0;
        for (String key : dataMap.keySet()) {
            amount += dataMap.get(key);
        }
        return amount;
    }

    public Set<String> occurMoreThan(int n) {
        Set<String> elements = new TreeSet<String>();
        for (Map.Entry<String, Integer> current : dataMap.entrySet()) {
            if (current.getValue() > n) {
                elements.add(current.getKey().toLowerCase());
            }
        }
        return elements;
    }

    private void buildMap() {
        while (iterator.hasNext()) {
            String key = iterator.next().toLowerCase();
            if (dataMap.containsKey(key)){
                dataMap.put(key, dataMap.get(key)+1);
            } else {
                dataMap.put(key, 1);
            }
        }
    }


}
