package Question14;

import java.util.HashMap;

public class AddressSpace {
    private HashMap<Integer, Long> values;
    private String mask;

    AddressSpace(String mask){
        values = new HashMap<>();
        this.mask = mask;
    }

    void updateMask(String mask){
        this.mask = mask;
    }

    private long findBinary(long value, int pos){
        return (value & (1 << pos)) >> pos;
    }

    void addValue(int address, int value){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mask.length(); i ++){
            if (mask.charAt(i) == 'X'){
                sb.append(findBinary(value, mask.length() - 1 - i));
            }
            else{
                sb.append(mask.charAt(i));
            }

        }
        values.put(address, Long.parseLong(sb.toString(), 2));
    }

    long getValue(int address){
        return values.get(address);
    }

    long sumAllVals(){
        long result = 0;
        for (long n: values.values()){
            result += n;
        }
        return result;
    }

}
