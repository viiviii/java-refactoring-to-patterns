package _06_creation.move_creation_knowledge_to_factory.query.example;

public class QueryClient {
    private final int sdVersion;

    public QueryClient(int sdVersion) {
        this.sdVersion = sdVersion;
    }

    public Query createQuery() {
        Query query;
        if (usingSDVersion52()) {
            query = new QuerySD52();
        } else {
            query = new QuerySD51();
        }
        return query;
    }

    private boolean usingSDVersion52() {
        return sdVersion == 52;
    }
}
