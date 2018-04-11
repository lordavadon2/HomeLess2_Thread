package com.brainacad.hw.FileWork;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class DirView implements IDirView {
    private File path;
    private File[] files;

    public DirView(String pathname) throws IOException {
        path = new File(pathname);
        if (!path.exists()) {
            throw new IOException("Cannot access " + pathname + ": No such file or directory");
        }
    }

    @Override
    public void getListOfFile() {
        if (path.isFile()) {
            files = new File[]{path};
        } else {
            files = path.listFiles();
            Arrays.sort(files, (f1, f2) -> {
                if (f1.isDirectory() && f2.isFile()) {
                    return -1;
                }
                if (f1.isFile() && f2.isDirectory()) {
                    return 1;
                }
                return 0;
            });
        }
    }

    @Override
    public void print() {
        for (File f : files) {
            System.out.println(f.getName() + ((f.isDirectory()) ? File.separator : ""));
        }
    }

    public File[] getArrayOfFileList() {
        return files;
    }
}
