package com.brainacad.hw.ThreadWork;

public class Progress {
    private static double progressPercent = 0.0;

    public static void progressBar(double progressPercentage) {
        final int width = 50; // progress bar width in chars

        System.out.print("\rProgress status [");
        int i = 0;
        for (; i <= (int) (progressPercentage * width); i++) {
            System.out.print(".");
        }
        for (; i < width; i++) {
            System.out.print(" ");
        }
        System.out.print("] " + (int)(progressPercentage*100) +"%");
    }

    public static void progressBar() {
        progressBar(progressPercent);
    }

    public static void setProgress(double progressPercent) {
        Progress.progressPercent = progressPercent;
    }
}
