package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution2244 {

    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            if ( map.containsKey(task) ) {
                Integer count = map.get(task);
                count++;
            } else {
                map.put(task, 1);
            }
        }

        int result = 0;
        for (Integer count : map.values()) {
            if ( count == 1 ) {
                return -1;
            } else {
                if ( count % 3 == 0 ) {
                    result += count / 3;
                } else {
                    result += (count / 3) + 1;
                }
            }
        }

        return result;
    }

    public int minimumRounds2(int[] tasks) {
        Arrays.sort(tasks);

        int result = 0;
        int count;
        int upperPointer = 0;
        int lowerPointer = 0;
        while ( lowerPointer < tasks.length ) {
            if (tasks[upperPointer] == tasks[lowerPointer]) {
                lowerPointer++;
            } else {
                count = lowerPointer - upperPointer;

                if (count == 1) {
                    return -1;
                } else {
                    if (count % 3 == 0) {
                        result += count / 3;
                    } else {
                        result += (count / 3) + 1;
                    }
                }

                upperPointer = lowerPointer;
            }
        }

        count = lowerPointer-upperPointer;

        if ( count == 1 ) {
            return -1;
        } else {
            if ( count % 3 == 0 ) {
                result += count / 3;
            } else {
                result += (count / 3) + 1;
            }
        }

        return result;
    }

    public int minimumRounds3(int[] tasks) {
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(tasks);

        int result = 0;
        for (int task : tasks) {
            if (stack.isEmpty()) {
                stack.push(task);
            } else {
                if (task == stack.peek()) {
                    stack.push(task);
                } else {
                    if (stack.size() == 1) {
                        return -1;
                    } else {
                        result = execCurrentStack(stack, result);
                    }
                    stack.clear();
                    stack.push(task);
                }
            }
        }

        if ( stack.size() == 1 ) {
            return -1;
        } else {
            result = execCurrentStack(stack, result);
        }
        return result;
    }

    private static int execCurrentStack(Stack<Integer> stack, int result) {
        if ( stack.size() % 3 == 0 ) {
            result += stack.size() / 3;
        } else {
            result += (stack.size() / 3) + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2244 solution2244 = new Solution2244();
        System.out.println(solution2244.minimumRounds(new int[]{2}));
    }
}
