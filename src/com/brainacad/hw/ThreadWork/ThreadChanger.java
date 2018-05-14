package com.brainacad.hw.ThreadWork;

import com.brainacad.hw.FileWork.DirView;
import com.brainacad.hw.FileWork.IDirView;

import java.io.IOException;

public class ThreadChanger extends Thread {

    private String name;
    private Progress progressBar;
    private IDirView dirView;

    public ThreadChanger(String name, IDirView dirView, Progress progressBar) {
        super(name);
        this.dirView = dirView;
        this.progressBar = progressBar;
        this.name = name;
    }

    @Override
    public void run() {
        int length = ((DirView)dirView).getFiles().length;
        double col = 0.0;
        try {
            for (int i = 0; i < length; i++){
                progressBar.progressBar(col, name);
                dirView.changerFiles(i);
                col += (1 / (double)length);
                Thread.sleep(2000);
            }
            progressBar.progressBar(1.0, name);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
