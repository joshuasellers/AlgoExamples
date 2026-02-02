package javacode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class Stacks {
    
    public Stacks() {
    }

    /**
     * Given a list of logs, output their simplified logger levels. Each input log will have three components: timestamp, function name, entering/exiting flag.
     * The output log for each function will have three components: time used in the function, function name, function level.
     * 
     * Example input:
     * [["200","main","true"], ["300", "foo", "true"], ["400", "foo", "false"], ["500", "main", "false"]]
     * Example output:
     * [[300,"main",1], [100, "foo", 2]]
     * 
     * Explanation:
     * - main starts at 200 and ends at 500, total time = 300
     *   - It is the outside function, level = 1
     * - foo starts at 300 and ends at 400, total time = 100, 
     *   - It is inside main, level = 2
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * Steps:
     * 1. Convert input list to stack for processing.
     * 2. Iterate through the logs, using a stack to track function calls and their levels.
     * 3. For each log, calculate the time spent in the function and determine its level.
     * 4. Store the results in a list and return it.
     */
    public List<List<String>> outputLoggerLevels(List<List<String>> logs){
        Stack<List<String>> logStack = new Stack<>();
        for (List<String> log : logs){
            logStack.push(log);
        }


        List<List<String>> output = new ArrayList<>();
        int level = 0;
        Stack<List<String>> falseTracker = new Stack<>();
        while (!logStack.isEmpty()){
            List<String> log = logStack.pop();
            if (log.get(2).equals("false")){
                level++;
                falseTracker.push(log);
            } else {
                List<String> newOutput = new ArrayList<>();
                List<String> falseOutput = falseTracker.pop();
                int timeStamp = Integer.parseInt(falseOutput.get(0)) - Integer.parseInt(log.get(0));
                newOutput.add(Integer.toString(timeStamp));
                newOutput.add(log.get(1));
                newOutput.add(Integer.toString(level));
                output.add(newOutput);
                level--;
            }
        }
        Collections.sort(output, (a, b) -> {
            return Integer.compare(Integer.parseInt(a.get(2)), Integer.parseInt(b.get(2)));
        });

        return output;
    }
    
    /**
     * Checks if a string contains a valid set of opening and closing characters: '(', ')', '{', '}', '[' and '].'
     * 
     * Steps:
     * 1. Convert input to stack
     * 2. Create Opening stack for oopening chars
     * 3. While fullString stack is not empty:
     *   a. If opening char, add to other stack
     *   b. Else check if opening char on top of opening char stack for closing char (return false if not)
     * 4. return true
     * 
     * Steps:
     * Example:
     * Input: s = "(){({})}"
     * Output: true
     * 
     * Input: s = "(){({}})"
     * Output: false
     * 
     * Time complexity: O(n)
     * Space complexity: O(n)
     * 
     */

    public boolean validString(String inp){
        Stack<Character> fullString = new Stack<>();
        Stack<Character> closingChars = new Stack<>();

        for (int i = 0; i < inp.length(); i++){
            fullString.push(inp.charAt(i));
        }

        Map<Character, Character> charPairs = new HashMap<>();
        charPairs.put('(', ')');
        charPairs.put('{', '}');
        charPairs.put('[', ']');

        while (!fullString.isEmpty()){
            Character c = fullString.pop();
            if(c == '}' || c == ']' || c == ')'){
                closingChars.push(c);
            } else{
                if (closingChars.isEmpty() || charPairs.get(c) != closingChars.peek()){
                    return false;
                }
                closingChars.pop();
            }
        }
        return true && closingChars.isEmpty();
    }
}
