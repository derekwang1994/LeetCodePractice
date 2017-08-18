// Given a collection of intervals, merge all overlapping intervals.
//
// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1){
            return intervals;
        }

        List<Interval> list = new ArrayList<Interval>();

        // Lambda way, slower
        // intervals.sort( (i1, i2) -> Integer.compare(i1.start, i2.start) );

        // tradition way, faster
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for(Interval interval : intervals){
            if(interval.start <= end){ // if it's within the current interval (start - end)

                if(interval.end > end){
                    end = interval.end;
                }

            }else{
                list.add(new Interval(start, end)); // save the current interval and create a new one
                start = interval.start;
                end = interval.end;
            }
        }

        list.add(new Interval(start, end));
        return list;
    }
}
