package services;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;

import java.util.List;

/**
 * Created by Vijay B on 1/6/2017.
 */
public interface IGoogleService {
    AbstractGoogleJsonClient getService() throws Exception;

    List<String> getScopes();
}
