import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackTest {
    public static void main(String[] args) {
        BackTrack backTrack = new BackTrack();
//        backTrack.combine(4, 2).forEach(x -> System.out.println(x));
        BackTrackTest.generateGroupingSets();
    }


    public static void generateGroupingSets() {
        BackTrack backTrack = new BackTrack();
        String[] dimensions = {"content","sex","os"};
        String[] basicDimensions = {"dt","accid"};

        Integer total = 1;
        Integer counter = 1;
        String first = new Gson().toJson(basicDimensions).replaceAll("\\[", "(")
                .replaceAll("]", ")")
                .replaceAll("\"", "");
        System.out.println(first + ",");


        for (int i = 1; i <= dimensions.length; i++) {

            List<List<Integer>> rs = backTrack.combine(dimensions.length, i);
            total += rs.size();
//            System.out.println("total-------" + total);
        }


        for (int i = 1; i <= dimensions.length; i++) {

            List<List<Integer>> rs = backTrack.combine(dimensions.length, i);
            for (List<Integer> arr : rs
            ) {
                ArrayList<String> dimensionNameArr = new ArrayList<>();

                dimensionNameArr.addAll(Arrays.asList(basicDimensions));
                for (int idxPlus : arr
                ) {
                    dimensionNameArr.add(dimensions[idxPlus - 1]);
                }
                String dimensionName = new Gson().toJson(dimensionNameArr).replaceAll("\\[", "(")
                        .replaceAll("]", ")")
                        .replaceAll("\"", "");
                counter++;
//                System.out.println("counter-----" + counter);
                System.out.println(dimensionName + ",");

            }

        }
    }

}
