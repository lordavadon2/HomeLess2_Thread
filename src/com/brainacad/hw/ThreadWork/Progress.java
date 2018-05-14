package com.brainacad.hw.ThreadWork;

public class Progress{

    private double progressPercentage;

    public Progress() {
        this.progressPercentage = 0.0;
    }

    synchronized public void progressBar(double progressPercentage, String threadName) {
        this.progressPercentage = progressPercentage;
        final int width = 50; // progress bar width in chars

        System.out.print(threadName + " Progress status [");
        int i = 0;
        for (; i <= (int) (progressPercentage * width); i++) {
            System.out.print(".");
        }
        for (; i < width; i++) {
            System.out.print(" ");
        }
        System.out.println("] " + (int)(progressPercentage*100) +"%");
    }

}

