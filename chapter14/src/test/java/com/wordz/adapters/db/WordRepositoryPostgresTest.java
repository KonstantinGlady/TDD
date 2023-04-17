package com.wordz.adapters.db;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.connection.ConnectionHolder;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;
import com.wordz.domain.WordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@DBRider
@DBUnit(caseSensitiveTableNames = true, caseInsensitiveStrategy = Orthography.LOWERCASE)
class WordRepositoryPostgresTest {

    private DataSource dataSource;

    @SuppressWarnings("unused")
    private final ConnectionHolder connectionHolder = () -> dataSource.getConnection();

    @BeforeEach
    void setupConnection() {

        var ds = new PGSimpleDataSource();
        ds.setServerNames(new String[]{"localhost"});
        ds.setDatabaseName("wordzdb");
        ds.setCurrentSchema("public");
        ds.setUser("ciuser");
        ds.setPassword("cipassword");
        this.dataSource = ds;
    }

    @Test
    @DataSet("adapters.data/wordTable.json")
    void fetchesWord() {
        WordRepository wordRepository = new WordRepositoryPostgres(dataSource);
        var actual = wordRepository.fetchWordByNumber(27);

        assertThat(actual).isEqualTo("ARISE");
    }
}
