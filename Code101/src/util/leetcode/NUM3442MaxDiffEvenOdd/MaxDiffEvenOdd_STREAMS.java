package util.leetcode.NUM3442MaxDiffEvenOdd;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxDiffEvenOdd_STREAMS {

    public int maxDifference_Streams(String s) {
        Map<Character, Long> map= s.chars().
                mapToObj(x-> (char)x).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        OptionalLong max= map.values().stream().filter(x-> x%2!=0).mapToLong(Long::longValue).max();
        OptionalLong min= map.values().stream().filter(x-> x%2==0).mapToLong(Long::longValue).min();
        if(max.isPresent() && min.isPresent()){
            return (int) max.getAsLong()- (int) min.getAsLong();
        }
        return 0;
    }
}
