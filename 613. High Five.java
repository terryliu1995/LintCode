/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        //create a minheap to mantain 5 largest scores for each student
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(Record result : results) {
            if(!map.containsKey(result.id)) {
                map.put(result.id, new PriorityQueue<Integer>());
            }
            PriorityQueue<Integer> scores = map.get(result.id);
            if(scores.size() < 5) {
                scores.add(result.score);
            } else {
                if(scores.peek() < result.score) {
                    scores.poll();
                    scores.add(result.score);
                }
            }
        }
        
        Map<Integer, Double> answer = new HashMap<>();
        //change map into entryset, and caculate each student's average score
        for(Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Integer> s = entry.getValue();
            double average = 0;
            for(int i = 0; i < 5; i ++) {
                average += s.poll();
            }
            average /= 5.0;
            answer.put(id, average);
        }
        return answer;
        
    }
}
