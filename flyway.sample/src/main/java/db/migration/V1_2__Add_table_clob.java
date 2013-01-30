package db.migration;


import com.googlecode.flyway.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Java-based migration.
 */
public class V1_2__Add_table_clob implements SpringJdbcMigration {

    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
        String ddl = "CREATE TABLE java_migrated_table (  "+
                        "code        char(5) CONSTRAINT firstkey PRIMARY KEY, "+
                        "title       text NOT NULL," +
                        "date_prod   date); ";

        jdbcTemplate.execute(ddl);
    }


}
