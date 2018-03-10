public class Solution {
    /**
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here
        //maintain a miniheap, get the n listnode from small value to larget value
        //and use a hashset, filter the duplicate listnode 
        //every data structure should be long, because if n is big enough like 1665
        //the results of multiplying will overflow on line 22. the result will not accurate
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        Set<Long> set = new HashSet<Long>();
        Long[] factors = new Long[3];
        factors[0] = Long.valueOf(2);
        factors[1] = Long.valueOf(3);
        factors[2] = Long.valueOf(5);
        set.add(Long.valueOf(1));
        pq.add(Long.valueOf(1));
        Long number = Long.valueOf(0);
        for(int i = 0; i < n; i ++) {
            number = pq.poll();
            for(int j = 0; j < 3; j ++) {
                if(!set.contains(number * factors[j])) {
                    pq.add(number * factors[j]);
                    set.add(number * factors[j]);
                }
            }
        }
       return number.intValue();
    }
}
