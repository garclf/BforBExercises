package com.ex1.Main.Misc;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FileDirHandler {

    public static FileDirHandler fileDirHandler;
    private String osName = "";

    public static FileDirHandler getInstance() {
        if(fileDirHandler == null) {
            fileDirHandler = new FileDirHandler();
        }
        return fileDirHandler;
    }

    private FileDirHandler() {
        osName = System.getProperty("os.name").toLowerCase();
    }

    public File[] getDirContents(String dirName) {

        return new File(dirName).listFiles();

    }

    public void sortAndDisplay(ArrayList<File> files) {
        File[] aList = files.toArray(new File[files.size()]);
        Arrays.sort(aList, Comparator.comparing(File::length));
        for(File eachFile: aList) {
            System.out.printf("%s\t\t%s\t\t%s\t\t\n", eachFile.getAbsolutePath(), eachFile.getName(), eachFile.length());
        }
    }

}
