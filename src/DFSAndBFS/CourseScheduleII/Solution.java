package DFSAndBFS.CourseScheduleII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result  = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();
        List<Integer> cycle = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++){
            for(int j = 0; j < 2; j++){
                map.computeIfAbsent(prerequisites[i][0], k -> new ArrayList<>())
                        .add(prerequisites[i][1]);
            }
        }
        for(int c = 0; c < numCourses; c++){
            if(dfs(c, map, visited, cycle, result) == false){
                return new int[0];
            }
        }
        int[] returnResult = result.stream().mapToInt(Integer::intValue).toArray();
        return returnResult;
    }

    public boolean dfs(int courseNum, Map<Integer, List<Integer>> map, List<Integer> visited, List<Integer> cycle, List<Integer> result){
        if(cycle.contains(courseNum)){
            return false;
        }
        if(visited.contains(courseNum)){
            return true;
        }
        cycle.add(courseNum);
        List<Integer> pres = map.get(courseNum);
        if(pres != null){
            for(int k = 0; k < pres.size(); k++) {
                int pre = pres.get(k);
                if(dfs(pre, map, visited, cycle, result) == false){
                    return false;
                }
            }

        }
        cycle.remove(Integer.valueOf(courseNum));
        visited.add(courseNum);
        result.add(courseNum);
        return true;
    }
}