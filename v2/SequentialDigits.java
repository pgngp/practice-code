/* https://leetcode.com/problems/sequential-digits/ */
class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        String ref = "123456789";
        List<Integer> result = new ArrayList<>();
        for (int len = 2; len <= 9; len++) {
            for (int i = 0; i < 9 - len + 1; i++) {
                int num = Integer.parseInt(ref.substring(i, i + len));
                if (num < low) {
                    continue;
                } else if (num > high) {
                    break;
                }
                result.add(num);
            }
        }
        
        return result;
    }
}
