import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import java.nio.file.Paths;

public class ConnectDatabase {

   public static void main(String[] args) {
       // Create the CqlSession object:
       try (CqlSession session = CqlSession.builder()
           .withCloudSecureConnectBundle(Paths.get("../resources/secure-connect.zip"))
           .withAuthCredentials("MqQMFAROoZZruoWlMMkiRwlQ", "JyK8DQ03Arh72ifEWv7A22tTgmoaHFgBdW0cji+sRbrNyzQX9WWu6K2ZKSG6s,gkqo5lvQcb6TEuKI2LQwoResxs.dDI1STo2.REyBC515CPZMl,U_Eh6TJ4609JgGeA")
           .withKeyspace("squint")
           .build()) {
           // Select the release_version from the system.local table:
           ResultSet rs = session.execute("select release_version from system.local");
           Row row = rs.one();
           //Print the results of the CQL query to the console:
           if (row != null) {
               System.out.println(row.getString("release_version"));
           } else {
               System.out.println("An error occurred.");
           }
       }
       System.exit(0);
   }
}