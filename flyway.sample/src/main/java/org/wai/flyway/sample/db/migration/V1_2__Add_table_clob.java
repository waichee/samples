package org.wai.flyway.sample.db.migration;


import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Java-based migration.
 */
public class V1_2__Add_table_clob {

    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
        String ddl = "CREATE TABLE java_migrated_table (  "+
                        "code        char(5) CONSTRAINT firstkey PRIMARY KEY, "+
                        "title       text(40) NOT NULL," +
                        "date_prod   date); ";

        jdbcTemplate.execute(ddl);
    }


}
