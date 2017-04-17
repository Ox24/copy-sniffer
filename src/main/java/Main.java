import FileUtils.FileUtility;
import WatchDog.DirectoryWatchServiceImpl;
import WatchDog.IDirectoryWatchService;

import java.io.File;
import java.nio.file.Path;

/**
 * Created by Timur on 17.04.2017.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        if(args.length < 1){
            System.exit(0);
        }
        IDirectoryWatchService watchService = new DirectoryWatchServiceImpl();
        watchService.register(new IDirectoryWatchService.OnFileChangeListener() {
            @Override
            public void onFileCreate(String filePath) {
                System.out.println(args[0].concat(filePath));
                FileUtility.moveFile(args[0].concat(filePath), args[1]);
            }

            @Override
            public void onFileModify(String filePath) {

            }

            @Override
            public void onFileDelete(String filePath) {

            }
        }, args[0], "*.mkv");
        watchService.start();
    }
}
