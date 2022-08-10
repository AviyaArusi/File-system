package fileSystem1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {


    @Test
    void addFolder() {
        FileSystem root1 = new FileSystem("root1");
        root1.addFolder("test1");
        assertEquals(false, root1.addFolder(""));
        assertEquals(false, root1.addFolder("test1"));
    }

    @Test
    void addFile() {
        FileSystem root1 = new FileSystem("root1");
        root1.addFile("test1","word1");
        assertEquals(false, root1.addFile("test1",""));
        assertEquals(false, root1.addFile("","test1"));
        assertEquals(false, root1.addFile("",""));
        assertEquals(false, root1.addFile("test1","word1"));


    }
    @Test
    void deleteFolder() {
        FileSystem root1 = new FileSystem("root1");
        root1.addFolder("test1");
        root1.addFolder("root1_2");
        root1.getRoot().getFolders().get("root1_2").addFolder("testFolder2_3");
        root1.getRoot().getFolders().get("root1_2").addFile("test2", "java");
        assertEquals(true, root1.deleteFolder("test1"));
        // When you delete a folder, all the files and folders inside are also deleted.
        root1.rootToString();
        root1.deleteFolder("root1_2");
        root1.rootToString();

    }

    @Test
    void deleteFile() {
        FileSystem root1 = new FileSystem("root1");
        root1.addFile("test1","word1");
        assertEquals(true, root1.deleteFile("test1","word1"));

    }
    
        @Test
    void rootToString() {
        FileSystem root1 = new FileSystem("root1");
        root1.addFolder("root1_2");
        root1.getRoot().getFolders().get("root1_2").addFolder("testFolder2_3");
        root1.getRoot().getFolders().get("root1_2").addFile("test2", "java");
        root1.addFolder("testFolder1");
        root1.addFolder("testFolder2");
        root1.addFolder("testFolder3");
        root1.addFile("test1","word");
        root1.addFile("test1","java");
        root1.addFile("test1","pc");
        root1.addFile("test1","file2");
        root1.rootToString();
        //Another test of print folder from root folder:
        //root1.getRoot().getFolders().get("root1_2").rootToString();
    }

}
