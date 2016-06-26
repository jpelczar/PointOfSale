package pl.jpelczar.pos_framework.database;

/**
 * Created by jpelczar on 26.06.16.
 */
public final class DatabaseManager {

    public static IDatabase database;

    public static IDatabase getRepositoryInstance() {
        return database;
    }

    public static void setRepositoryInstance(IDatabase instance) {
        database = instance;
    }
}
