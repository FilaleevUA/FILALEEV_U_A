public class controller {
    private model model;
    private view view;

    public controller(model model, view view) {
        this.model = model;
        this.view = view;
    }

    public void calculate() {
        String input = view.getInput();
        model = new model(input);

        double result = model.calculate();
        view.setResult(result);
    }
}
