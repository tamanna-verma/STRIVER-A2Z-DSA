import java.util.*;

class Pair {
    Character a;
    int frequency;

    Pair(Character a, int frequency) {
        this.a = a;
        this.frequency = frequency;
    }
}

class Solution{
    public String reorganizeString(String s) {

        // adding all elements in hashmap
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> y.frequency - x.frequency);
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            Character c = s.charAt(i);
            int freq = map.getOrDefault(c, 0);
            map.put(c, freq + 1);
        }
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            Pair p = new Pair(e.getKey(), e.getValue());
            pq.add(p);
        }

        StringBuilder ans = new StringBuilder("");
        if (pq.peek().frequency > (s.length() + 1) / 2)
            return "";

        // it will work till pq.size()>1
        while (pq.size() > 1) {
            Pair highest = pq.poll();
            Pair secondhighest = pq.poll();

            ans.append(highest.a);
            ans.append(secondhighest.a);
            if (highest.frequency > 1)
                pq.offer(new Pair(highest.a, highest.frequency - 1));
            if (secondhighest.frequency > 1)
                pq.offer(new Pair(secondhighest.a, secondhighest.frequency - 1));

        }

        // i need to handle last element alone
        if (pq.size() == 1) {
            ans.append(pq.poll().a);
        }

        return ans.toString();

    }
}