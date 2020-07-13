package ch05_01;

public class SimpleDotCom {
    int[] locationCells;
    int numOfHits = 0;

    public void setLocationCells(int[] locs) {
        this.locationCells = locs;
    }

    public String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";
        for(int cell: this.locationCells){
            if(guess==cell){
                result="hit";
                this.numOfHits++;
                break;
            }
        }

        if(this.numOfHits == this.locationCells.length){
            result="kill";
        }
        System.out.println(result);
        return result;
    }
}
