/* https://leetcode.com/problems/expression-add-operators/ */
class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        if (num.length() == 0) {
            return new ArrayList<>();
        }
        
        List<String> result = new ArrayList<>();
        helper(num, target, result, 0, 0, "", 0);
        
        return result;
    }
    
    private void helper(String numStr, int target, List<String> result, int pos, long val, String path, long prev) {
        if (pos == numStr.length()) {
            if (val == target) {
                result.add(path);
            }
            return;
        }
        
        for (int i = pos; i < numStr.length(); i++) {
            long num = Long.parseLong(numStr.substring(pos, i + 1));
            if (pos == 0) {
                helper(numStr, target, result, i + 1, val + num, Long.toString(num), num);
            } else {
                helper(numStr, target, result, i + 1, val + num, path + "+" + num, num);
                helper(numStr, target, result, i + 1, val - num, path + "-" + num, -num);
                helper(numStr, target, result, i + 1, val - prev + prev * num, path + "*" + num, prev * num);   
            }
            
            if (i == pos && numStr.charAt(i) == '0') {
                break;
            }
        }
    }
}
