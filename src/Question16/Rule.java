package Question16;

class Rule {
    private int description;
    private int min1, min2, max1, max2;

    Rule(int description, int min1, int min2, int max1, int max2){
        this.description = description;
        this.max1 = max1;
        this.min1 = min1;
        this.min2 = min2;
        this.max2 = max2;
    }

    boolean inRange(int num){
        return (min1 <= num && num <= max1) || (min2 <= num && num <= max2);
    }

    boolean descriptionIncludes(int i){
        return description == i;
    }
}
