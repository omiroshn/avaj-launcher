package avaj.simulator;

import avaj.exceptions.MD5_Exception;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5_Parser {

    private String fileData;

    public void loadFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();
        this.fileData = new String(data, "UTF-8");
    }

    public void checkString(String MD5Hash) throws NoSuchAlgorithmException, MD5_Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(this.fileData.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest).toLowerCase();
        if (!myHash.equals(MD5Hash)) {
            throw new MD5_Exception("File contents are wrong! Be careful");
        }
    }
}
