package services;

import java.io.File;

public class GoogleApiFactory {
    private static String jsonKeyFile;
    private static AbstractGAppService service;
    private static GoogleApiFactory factory;

    private GoogleApiFactory(String jsonKeyFilePath) {
        this.jsonKeyFile = jsonKeyFilePath;
    }

    public static GoogleApiFactory configureWithJsonKey(String jsonKeyFilePath) {
        factory = new GoogleApiFactory(jsonKeyFilePath);
        return factory;
    }

    /**
     * returns the instance of Google API service
     *
     * @param tClass Service class to pass
     * @param <T>    Service class type extending the
     * @return service instance
     * @throws Exception
     */
    public <T extends AbstractGAppService> T getInstance(Class<T> tClass) throws Exception {
        service = (T) (tClass.getConstructor(File.class)
                .newInstance(new File(jsonKeyFile)));
        return (T) service;
    }
}
