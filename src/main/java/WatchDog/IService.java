package WatchDog;

/**
 * Created by Timur on 17.04.2017.
 */
public interface IService {
    /**
     * Starts the service. This method blocks until the service has completely started.
     */
    void start() throws Exception;

    /**
     * Stops the service. This method blocks until the service has completely shut down.
     */
    void stop();
}
