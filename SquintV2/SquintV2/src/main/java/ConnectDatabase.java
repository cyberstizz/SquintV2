import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import java.nio.file.Paths;

public class ConnectDatabase {

   public static void main(String[] args) {
       // Create the CqlSession object:
       try (CqlSession session = CqlSession.builder()     
           .withCloudSecureConnectBundle(Paths.get("/home/charleslambdev/projects/SquintV2/SquintV2/SquintV2/src/main/resources/secure-connect-squint.zip"))
           .withAuthCredentials("itawHceirGBSuSiOOcPYIvJL", "SGh,dJwgH,l_nnvI9FSEPpAu1Qc2TI7L0HBziyu0P8EUm5SvD,n1ysYBWZD4kZqpKqG0LF,FG6nWnNaw,GA6kDeN2R+LZqm_S+6T9qbIDhAft32PG0l51kn6R1D5Z029")
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