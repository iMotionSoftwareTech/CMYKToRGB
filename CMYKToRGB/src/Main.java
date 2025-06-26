//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Example: Convert CMYK (100%, 50%, 0%, 10%) to RGB
        double c = Double.parseDouble(args[0]);
        double m = Double.parseDouble(args[1]);
        double y = Double.parseDouble(args[2]);
        double k = Double.parseDouble(args[3]);
        int[] rgb = convertCmykToRgb(c, m, y, k);
        System.out.println("red = " +  rgb[0] + " green = " + rgb[1] + " blue = " + rgb[2]);
    }

    public static int[] convertCmykToRgb(double c, double m, double y, double k) {
        // Validate input ranges (0-100)
        c = Math.max(0, Math.min(100, c));
        m = Math.max(0, Math.min(100, m));
        y = Math.max(0, Math.min(100, y));
        k = Math.max(0, Math.min(100, k));

        // Convert percentages to decimal (0.0-1.0)
        double cyan = c / 100.0;
        double magenta = m / 100.0;
        double yellow = y / 100.0;
        double black = k / 100.0;

        // Calculate RGB
        int white = (int) (1 - black);
        int red = (int) Math.round(255 * white * (1 - cyan));
        int green = (int) Math.round(255 * white * (1 - magenta));
        int blue = (int) Math.round(255 * white * (1 - yellow));

        return new int[]{red, green, blue};
    }
}