package server;

import java.io.IOException;

/**
 *
 * @author nikalsh
 */
public class ServerMain {

    public static void main(String[] args) throws IOException {
        
        //SEVER ENTRY POINT
        //Run ServerMain to put server in listen & accept mode
        //See Acceptor.java
        Acceptor server = new Acceptor(55555);

    }
}
