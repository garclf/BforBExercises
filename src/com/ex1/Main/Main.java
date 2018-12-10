package com.ex1.Main;

import com.ex1.Main.Misc.FileDirHandler;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        if(args.length > 0) {
            Path getDir = Paths.get(args[0]);
            if (Files.exists(getDir) && Files.isDirectory(getDir)) {
                ArrayList<File> saveNames = new ArrayList<>();

                FileDirHandler fileDirHandler = FileDirHandler.getInstance();
                File[] filesInDir = fileDirHandler.getDirContents(args[0]);

                for (File file : filesInDir) {
                    if (file.isDirectory()) {
                        File[] subdirFiles = fileDirHandler.getDirContents(file.getAbsolutePath());

                        for (File sFile : subdirFiles) {
                            saveNames.add(sFile);
                        }
                    } else {
                        saveNames.add(file);
                    }
                }

                System.out.printf("%s\t\t\t\t%s\t\t\t\t%s\t\t\t\t\n", "Full Path", "Name", "Size");

                fileDirHandler.sortAndDisplay(saveNames);

            } else if (Files.isRegularFile(getDir)) {
                System.out.println("The path you provided " + getDir.toString() + " is a file");
            } else {
                System.out.println("The path to the directory you provided does not exist... \n" +
                        "Please provide an existent directory name");
            }
        } else {
            System.out.println("Please provide a path to a directory to list its files");
        }

    }
}
