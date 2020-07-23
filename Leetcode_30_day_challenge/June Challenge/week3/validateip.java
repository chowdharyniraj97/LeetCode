class Solution {
    public String validIPAddress(String IP) {
        if (IP.contains(".") && IP.contains(":") || IP.contains("::")) return "Neither";
        if (IP.contains(".")) {
            String[] fr = IP.split("\\.", -1);
            if (fr.length != 4) return "Neither";
            for (String f : fr) {
                if (f.length() == 0 || f.length() > 3) return "Neither";
                for (char ch : f.toCharArray()) if (!Character.isDigit(ch)) return "Neither";
                if (f.charAt(0) == '0' && f.length() > 1) return "Neither";
                if (Integer.parseInt(f) < 0 || Integer.parseInt(f) > 255) return "Neither";
            }
            return "IPv4";
        } else if (IP.contains(":")) {
            String[] fr = IP.split(":", -1);
            if (fr.length != 8 || fr[0].charAt(0) == '0') return "Neither";
            String hexDigits = "0123456789abcdefABCDEF";
            for (String f : fr) {
                if (f.length() == 0 || f.length() > 4) return "Neither";
                for (Character ch : f.toCharArray()) if (hexDigits.indexOf(ch) == -1) return "Neither";
            }
            return "IPv6";
        }
        return "Neither";
    }
}
