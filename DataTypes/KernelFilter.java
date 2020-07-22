import java.awt.Color;

public class KernelFilter {
    // Returns a new picture that applies an arbitrary kernel filter to the given picture.
    private static Picture kernel(Picture picture, double[][] weights) {
        Picture target = new Picture(picture);

        for (int targetCol = 0; targetCol < picture.width(); targetCol++) {
            for (int targetRow = 0; targetRow < picture.height(); targetRow++) {
                double targetR = 0;
                double targetG = 0;
                double targetB = 0;
                int KernelLength = weights.length;
                int kernelCenter = KernelLength / 2;


                for (int i = 0; i < KernelLength; i++) {
                    for (int j = 0; j < KernelLength; j++) {
                        double coeff = weights[i][j];

                        // Periodic pixels & their colors.
                        int scol = Math.floorMod(targetCol - kernelCenter + i, picture.width());
                        int srow = Math.floorMod(targetRow - kernelCenter + j, picture.height());

                        Color color = picture.get(scol, srow);
                        int r = color.getRed();
                        int g = color.getGreen();
                        int b = color.getBlue();
                        targetR += r * coeff;
                        targetG += g * coeff;
                        targetB += b * coeff;
                    }
                }

                Color c = new Color(finalizeColourCode(targetR), finalizeColourCode(targetG),
                                    finalizeColourCode(targetB));
                target.set(targetCol, targetRow, c);
            }
        }
        return target;
    }

    // Helper function returns properly formated the colour code
    private static int finalizeColourCode(double v) {
        if (v < 0) return 0;
        if (v > 255) return 255;
        return (int) Math.round(v);
    }

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        double[][] weights = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 },
                };

        return kernel(picture, weights);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] weights = {
                { (double) 1 / 16, (double) 2 / 16, (double) 1 / 16 },
                { (double) 2 / 16, (double) 4 / 16, (double) 2 / 16 },
                { (double) 1 / 16, (double) 2 / 16, (double) 1 / 16 },
                };

        return kernel(picture, weights);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] weights = {
                { 0, -1, 0 },
                { -1, 5, -1 },
                { 0, -1, 0 },
                };

        return kernel(picture, weights);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] weights = {
                { -1, -1, -1 },
                { -1, 8, -1 },
                { -1, -1, -1 },
                };

        return kernel(picture, weights);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] weights = {
                { -2, -1, 0 },
                { -1, 1, 1 },
                { 0, 1, 2 },
                };

        return kernel(picture, weights);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] weights = {
                { (double) 1 / 9, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, (double) 1 / 9, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, (double) 1 / 9, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, (double) 1 / 9, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, (double) 1 / 9, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, (double) 1 / 9, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, (double) 1 / 9, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, (double) 1 / 9, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, (double) 1 / 9 },
                };

        return kernel(picture, weights);
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        String filename = args[0];
        Picture source = new Picture(filename);
        Picture i = identity(source);
        Picture g = gaussian(source);
        Picture s = sharpen(source);
        Picture lp = laplacian(source);
        Picture e = emboss(source);
        Picture m = motionBlur(source);

        System.out.println("identity");
        i.show();
        System.out.println("gaussian");
        g.show();
        System.out.println("sharpen");
        s.show();
        System.out.println("laplacian");
        lp.show();
        System.out.println("emboss");
        e.show();
        System.out.println("motionBlur");
        m.show();
    }
}
