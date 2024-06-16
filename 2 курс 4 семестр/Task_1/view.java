public class view {
    private String input;
    private double result;
    public String returnInput(){
        return  input;
    }

    public void input(String input) {
        this.input = input;
    }

    public void inputResult(double result){this.result = result;}
    public double returnResult() {
        return result;
    }
}
