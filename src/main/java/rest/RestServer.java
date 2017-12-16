package rest;

import java.io.IOException;

public interface RestServer {

    void start() throws IOException;
    void stop();
}
