package fileSystem1;

public class FileSystem {
    private Folder root;

    public FileSystem(String name) {
        root = new Folder(name);
        root.setFolderName(name);
    }

    public Folder getRoot() {
        return root;
    }

    public boolean addFolder(String newFolderName) {
       //Check if new folder name is valid.
        if (newFolderName.equals("")){
           System.out.println("Invalid name");
           return false;
       }
        FileSystem newFolder = new FileSystem(newFolderName);
       //Check if the folder already contains a folder with that name.
        if (root.getFolders().containsKey(newFolder.root.getFolderName())) {
            System.out.println("This name is already exists in this folder, please try another name.");
            return false;
        }
        // Add folder to folder.
        root.addFolder(newFolderName);
        System.out.println("This folder has been successfully added");
        return true;
    }

    public boolean addFile(String newFileName, String newFileExtention) {
        //Check that the strings are not null.
        if (newFileName.equals("") || newFileExtention.equals("")) {
            System.out.println("Invalid name");
            return false;
        }
        //Check if the folder already contains a file with that name.
        if (root.getFiles().containsKey(newFileName+"."+newFileExtention)) {
                System.out.println("This name is already exists in this folder, please try another name.");
                return false;
        }
        //Add file to folder.
        root.addFile(newFileName, newFileExtention);
        System.out.println("This file has been successfully added");
        return true;
    }

    public boolean deleteFolder(String folderToDelete) {
        //Search the folder  in the folder and delete if exists.
        if (root.getFolders().containsKey(folderToDelete)) {
            root.getFolders().remove(folderToDelete);
            System.out.println("The folder was successfully deleted");
            return true;
        }
        System.out.println("No folder found with this name");
        return false;
    }

    public boolean deleteFile(String fileName, String fileExtention) {
        //Search the file in the folder and delete if exists.
        if (root.getFiles().containsKey(fileName+"."+fileExtention)) {
            // The char 'a' is just to ensure that two files with the same name will not delete each other,
            // when 2 files have the same name but different value.
                root.getFiles().remove(fileName+"."+fileExtention, "a");
                System.out.println("The file was successfully deleted");
                return true;
        }
        System.out.println("No file found with this name");
        return false;
    }

    // The number 4 was chosen only because it gives the nicest spaces between lines.
    public void rootToString() {
        root.folderToString(4);
    }

}