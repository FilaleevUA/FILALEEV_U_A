public class controller {
    private model model;
    private view view;
    public controller(model model, view view) {
        this.model = model;
        this.view = view;
    }
    public void calculate() {
        model = new model(view.returnInput());

        double result = model.calculate();
        view.inputResult(result);
    }
}
