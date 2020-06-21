/* https://leetcode.com/problems/text-justification/ */
//  vars start, end, length
//  for each word:
//      if adding word is possible:
//          end++
//      else if this is not the last word:
//          spacesPerWord = maxlength / length
//          add to result each word + spacesPerWord + 1
//          start = current word
//          end = current word
//      else:
//          add each word to result
    
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int start = 0, end = 0, length = 0;
        List<String> result = new ArrayList<>();
        while (end < words.length) {
            if (end == words.length - 1) {  // last word
                if (length == 0 || length + 1 + words[end].length() <= maxWidth) {  // maxWidth not reached
                    StringBuilder sb = new StringBuilder();
                    while (start < end) {
                        sb.append(words[start]).append(" ");
                        start++;
                    }
                    sb.append(words[start]);
                    while (sb.length() < maxWidth) {
                        sb.append(" ");
                    }
                    result.add(sb.toString());
                    break;
                } else if (length + words[end].length() == maxWidth) {  // maxWidth reached exactly
                    StringBuilder sb = new StringBuilder();
                    while (start < end) {
                        sb.append(words[start]).append(" ");
                        start++;
                    }
                    sb.append(words[start]);
                    result.add(sb.toString());
                    break;
                } else {  // maxWidth reached
                    result.add(getString(words, start, end - 1, length - 1, maxWidth));
                    start = end;
                    length = 0;
                }
            } else if (length == 0 || length + 1 + words[end].length() <= maxWidth) { // maxWidth not reached
                length += words[end].length() + 1;
                end++;
            } else if (length + words[end].length() == maxWidth) {  // maxWidth reached exactly
                length += words[end].length();
                result.add(getString(words, start, end, length, maxWidth));
                end++;
                start = end;
                length = 0;
            } else {  // maxWidth reached
                result.add(getString(words, start, end - 1, length - 1, maxWidth));
                start = end;
                length = 0;
            }
        }
        
        return result;
    }
    
    private String getString(String[] words, int start, int end, int length, int maxWidth) {
        int extraSpaces = maxWidth - length;
        int spacesPerWord = end == start ? 0 : extraSpaces / (end - start);
        extraSpaces = end == start ? extraSpaces : extraSpaces % (end - start);

        StringBuilder sb = new StringBuilder();
        while (start < end) {
            sb.append(words[start]).append(" ");
            start++;

            int i = 0;
            while (i < spacesPerWord) {
                sb.append(" ");
                i++;
            }

            if (extraSpaces > 0) {
                sb.append(" ");
                extraSpaces--;
            }
        }
        sb.append(words[start]);  // when start == end
        while (extraSpaces > 0) {
            sb.append(" ");
            extraSpaces--;
        }
        
        return sb.toString();
    }
}
