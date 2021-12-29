package ch06_creation.move_creation_knowledge_to_factory.query.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueryClientTest {
    
    @Test
    public void testQueryWithSDVersion52() throws Exception {
        //given
        int sdVersion = 52;
        QueryClient queryClient = new QueryClient(sdVersion);

        //when
        Query query = queryClient.createQuery();

        //then
        assertTrue(query instanceof QuerySD52);
    }

    @Test
    public void testQueryWithSDVersion51() throws Exception {
        //given
        int sdVersion = 51;
        QueryClient queryClient = new QueryClient(sdVersion);

        //when
        Query query = queryClient.createQuery();

        //then
        assertTrue(query instanceof QuerySD51);
    }
}