import WatchDog.DirectoryWatchServiceImpl;
import WatchDog.IDirectoryWatchService;

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
                System.out.println("Created");
            }

            @Override
            public void onFileModify(String filePath) {
                System.out.println("modified");
            }

            @Override
            public void onFileDelete(String filePath) {
                System.out.println("deleted");
            }
        }, args[0], "*.mkv");
        watchService.start();
    }
}
