package FileUtils;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Logger;

/**
 * Created by Timur on 17.04.2017.
 */
public class FileUtility {
    private static final Logger LOGGER = Logger.getLogger(FileUtility.class.getName());

    public static void moveFile (String srcFilePath, String destPath){
        String fileName = srcFilePath.substring(srcFilePath.lastIndexOf("\\") + 1);
        File destFile = new File(destPath.concat(fileName));
        File srcFile = new File(srcFilePath);
        if (destFile.exists()){
            LOGGER.info("File already exists");
        } else {
            try {
                Files.move(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                LOGGER.info("Moved file " + fileName + " to " + destPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
