package com.brainacad.hw.FileWork;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

public class DirView implements IDirView, FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        return false;
    }

    private File path;
    private File[] files;

    public DirView(String pathname) throws IOException {
        path = new File(pathname);
        files = null;
        if (!path.exists()) {
            throw new IOException("Cannot access " + pathname + ": No such file or directory");
        }
    }

    @Override
    public void getListOfMaskFile(String mask) {
        if (path.isFile()) {
            files = new File[]{path};
        } else {
            files = path.listFiles(getFilteredFiles(mask)); //getFilteredFiles(mask)
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
    public void getListOfFile() {
        getListOfMaskFile("*");
    }

    @Override
    public void print() {
        for (File f : files) {
            System.out.println(f.getName() + ((f.isDirectory()) ? File.separator : ""));
        }
    }

    public File[] getArrayOfFileList() {
        if (files == null){
            getListOfFile();
        }
        return files;
    }

    private FilenameFilter getFilteredFiles(String mask){
        return (dir, name) -> {
            if(mask.equals("*") || mask.equals("*.*")) {
                return true;
            }
            else {
                return (name.endsWith(mask));
            }
        };
    }
}