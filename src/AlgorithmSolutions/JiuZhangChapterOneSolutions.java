package AlgorithmSolutions;

import java.util.ArrayList;
import java.util.Collections;

public class JiuZhangChapterOneSolutions {

    /**
     * Returns a index to the first occurrence of target in source, or -1 if target is not part of
     * source.
     * 
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        int i = -1;
        int j;
        if (source != null && target != null) {
            if (source.equals(target)) {
                return 0;
            }
            for (i = 0; i < source.length(); i++) {
                if ((i + target.length()) <= source.length()) {
                    for (j = 0; j < target.length(); j++) {
                        if (source.charAt(i + j) == target.charAt(j)) {
                            continue;
                        } else {
                            break;
                        }
                    }
                    if (j == target.length()) {
                        return i;
                    }
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }

    /**
     * @param S: A set of distinct integers.
     * @return: A list of lists. All valid subsets.
     * Solution: use recursion
     */
    public ArrayList<ArrayList<Integer>> subSets(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (S != null) {
            Collections.sort(S);
            subsetsHelper(result, list, S, 0);
            // subsetsHelper2(result, S);
            return result;
        } else {
            return null;
        }
    }

    /**
     * Recursion solution 1:
     *  take [0, 1, 4] for example
     *                    []
     *         --------------------------
     *         |             |          |
     *        [0]           [1]        [4]
     *     ---------         |
     *     |       |         |
     *   [0, 1]  [0, 4]    [1, 4]   
     *     |   
     * [0, 1, 4]   
     *        
     *  put element into the list one by one
     */
    private void subsetsHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list,
            ArrayList<Integer> S, int pos) {
        result.add(new ArrayList<Integer>(list));
        System.out.println("--START-- pos = " + pos + ", result = " + result);
        for (int i = pos; i < S.size(); i++) {
            list.add(S.get(i));
            System.out.println("i = " + i + ", list = " + list);
            subsetsHelper(result, list, S, i + 1);
            list.remove(list.size() - 1);
            System.out.println("i = " + i + ", pos = " + pos + ", list.remove = " + list);
        }
        System.out.println("--END-- pos = " + pos);
    }

    /**
     * Recursion solution 2:
     * take [0, 1, 4] for example
     * minimum the problem by see what is the result of [], it is [[]]
     * Then add one element [0], the result is []'s result plus [0], it is [[], [0]]
     * Then add one more element [0, 1], the result is [0]'s result plus [1] to each element, []+[1] and [0]+[1], it is [[], [0], [1], [0, 1]]
     * So we can get the conclusion is that suppose we have n element ArrayList, the result is 
     * (n-1)'s result + {add n to each element of (n-1)'s result}
     */
    private void subsetsHelper2(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> S) {
        if (S.size() == 0) {
            result.add(new ArrayList<Integer>(S));
        } else {
            int lastElement = S.get(S.size() - 1);
            ArrayList<Integer> STmp = new ArrayList<Integer>(S);
            STmp.remove(STmp.size() - 1);
            subsetsHelper2(result, STmp);
            ArrayList<ArrayList<Integer>> resultTmp = new ArrayList<ArrayList<Integer>>(result);
            ArrayList<Integer> list;
            for (int j = 0; j < resultTmp.size(); j++) {
                list = new ArrayList<Integer>(resultTmp.get(j));
                list.add(lastElement);
                result.add(new ArrayList<Integer>(list));
            }
        }
    }

    /**
     * @param S: A set of distinct integers.
     * @return: A list of lists. All valid subsets.
     * Solution: do not use recursion, use bitmap
     */
    public ArrayList<ArrayList<Integer>> subSets2(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int size = S.size();
        Collections.sort(S);
        if (size > 0) {
            char[] maxValue = new char[size];
            for (int i = 0; i < maxValue.length; i++) {
                maxValue[i] = '1';
            }
            int value = Integer.parseInt(String.valueOf(maxValue), 2);
            for (int i = 0; i <= value; i++) {
                String s = Integer.toBinaryString(i);
                char[] c = s.toCharArray();
                for (int j = 0; j < c.length; j++) {
                    if (c[j] != '0') {
                        list.add(S.get(size - (c.length - j)));
                    }
                }
                result.add(new ArrayList<Integer>(list));
                list.clear();
            }
        }
        return result;
    }

    /**
     * @param S: A set of numbers that may has duplicate numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Collections.sort(S);
        subsetsWithDupHelper(result, list, S, 0);
        return result;
    }

    private void subsetsWithDupHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list,
            ArrayList<Integer> S, int pos) {
        result.add(new ArrayList<Integer>(list));
        for (int i = pos; i < S.size(); i++) {
            if (i != pos && S.get(i - 1) == S.get(i)) {
                continue;
            }
            list.add(S.get(i));
            subsetsWithDupHelper(result, list, S, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
