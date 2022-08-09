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
        assertEquals(true, root1.deleteFolder("test1"));
    }

    @Test
    void deleteFile() {
        FileSystem root1 = new FileSystem("root1");
        root1.addFile("test1","word1");
        assertEquals(true, root1.deleteFile("test1","word1"));

    }

}