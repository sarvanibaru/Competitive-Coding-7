// Time Complexity : O(nlogn)
// Space Complexity : O(n), n = heap size
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to maintain a min heap.But, before that, we need to first sort the given intervals for us to understand
the start and end times and easier processing.Initially we add the first end time to the heap.So, at any time, if
the new interval's start time is greater than initially started(minimum) end time, then we can poll the heap
meaning we can leverage that same room as by the time new meeting gets started old meeting is getting finished,
if not, we push to the heap. This way, heap's size gives us the number of conference rooms as we are only storing
required ones.
 */
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        pq.offer(intervals[0][1]);

        for(int i = 1 ; i < intervals.length ; i++) {
            if(intervals[i][0] >= pq.peek())
                pq.poll();
            pq.offer(intervals[i][1]);
        }
        return pq.size();
    }
}