import org.junit.jupiter.api.Test

class HelloTests {
    @Test
    void test() {
        def hello = new helloTestUtils()
        hello.call()
    }
}
