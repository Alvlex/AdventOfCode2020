package Question14;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class AddressSpace2 {

    private HashMap<String, Integer> memory = new HashMap<>();
    private String mask = "";


    void updateMask(String mask){
        this.mask = mask;
    }

    void addMemory(int memoryAddress, int memoryValue){
        String binaryAddr = Integer.toBinaryString(memoryAddress);
        String bin32 = "000000000000000000000000000000000000";
        String padded = bin32.substring(binaryAddr.length()) + binaryAddr;
        String maskApplied = applyMask(padded, mask);
        Set<String> memoryAddresses = getPossibleVariations(maskApplied);
        for (String address: memoryAddresses){
            memory.put(address, memoryValue);
        }
    }

    long getMemorySum() {
        long sum = 0;
        for (int n: memory.values()){
            sum += n;
        }
        return sum;
    }

    private String applyMask(String padded, String mask) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= mask.length() - 1; i++) {
            if (mask.charAt(i) == '0')
                result.append(padded.charAt(i));
            else
                result.append(mask.charAt(i));
        }
        return result.toString();
    }

    private Set<String> getPossibleVariations(String binaryString) {
        Set<String> result = new HashSet<>();
        result.add(binaryString);
        while (true) {
            Set<String> stringToAddToResult = new HashSet<>();
            Set<String> stringToRemove = new HashSet<>();
            for (String stringToProcess : result) {
                if (stringToProcess.contains("X")) {
                    stringToRemove.add(stringToProcess);
                    stringToAddToResult.add(stringToProcess.replaceFirst("X", "1"));
                    stringToAddToResult.add(stringToProcess.replaceFirst("X", "0"));
                    break;
                }
            }
            result.addAll(stringToAddToResult);
            result.removeAll(stringToRemove);
            int numberOfResultsWithOutX = 0;
            for (String string : result) {
                if (!string.contains("X")) {
                    numberOfResultsWithOutX++;
                }
            }
            if (numberOfResultsWithOutX == result.size()) {
                break;
            }
        }
        return result;
    }

}