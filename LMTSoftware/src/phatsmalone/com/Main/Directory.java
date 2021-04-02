package phatsmalone.com.Main;

import java.io.File;

public class Directory {
    protected static String projectName;
    protected static String directoryLocation;

    public Directory(String pName, String dName){
        this.projectName = pName;
        this.directoryLocation = dName;
    }
    //start here
    public static void createNewDirectory(){
        String path = directoryLocation + "\\" + projectName;
        File file = new File(path);
        boolean check = file.mkdir();
        if (check) {
            System.out.println("Directory created");
        } else {
            System.out.println("Directory not created");
        }
    }
}
