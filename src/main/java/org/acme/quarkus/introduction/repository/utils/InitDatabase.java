package org.acme.quarkus.introduction.repository.utils;


import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

@ApplicationScoped
public class InitDatabase {

    @Resource(lookup = "java:jboss/datasources/PortfolioDS")
    private DataSource ds;

    public void initDatasource(@Observes @Initialized(ApplicationScoped.class) Object init) {
        final InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("import.sql");
        final BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));

        try {
            while (reader.ready()) {
                executeSql(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void executeSql(final String sql) {
        if (Objects.nonNull(sql) && !"".equals(sql))
            try (final Connection connection = ds.getConnection();
                 final Statement statement = connection.createStatement()
            ) {
             //   System.out.println(sql);
                statement.execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

}
