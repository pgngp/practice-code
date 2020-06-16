/* https://leetcode.com/problems/validate-ip-address/ */
class ValidateIPAddress {
    public String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0) {
            return "Neither";
        }
        
        // check for IPv4 address
        String[] items1 = IP.split("\\.", -1);
        // System.out.println("items1: " + Arrays.toString(items1));
        if (items1.length == 4) {
            for (String item : items1) {
                if (item.length() == 0 || item.length() > 3) {
                    return "Neither";
                }
                
                for (int i = 0; i < item.length(); i++) {
                    if (item.charAt(i) < '0' || item.charAt(i) > '9') {
                        return "Neither";
                    }
                }
                
                int num = Integer.parseInt(item);
                if (num < 0 || num > 255 || (item.length() > 1 && item.charAt(0) == '0')) {
                    return "Neither";
                }
            }
            
            return "IPv4";
        }
        
        // check for IPv6 address
        String[] items2 = IP.split(":", -1);
        // System.out.println("items2: " + Arrays.toString(items2));
        if (items2.length == 8) {
            for (String item : items2) {
                if (item.length() == 0 || item.length() > 4) {
                    return "Neither";
                }   
                
                for (int i = 0; i < item.length(); i++) {
                    if (
                        (item.charAt(i) >= '0' && item.charAt(i) <= '9') || 
                        (item.charAt(i) >= 'a' && item.charAt(i) <= 'f') || 
                        (item.charAt(i) >= 'A' && item.charAt(i) <= 'F')
                    ) {
                        continue;
                    }
                    
                    return "Neither";
                }
            }
            
            return "IPv6";
        }
        
        return "Neither";
    }
}
