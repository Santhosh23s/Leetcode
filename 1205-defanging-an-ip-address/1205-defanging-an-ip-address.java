class Solution {
    public String defangIPaddr(String address) {
        String newText = address.replace(".","[.]");
        return newText;
    }
}