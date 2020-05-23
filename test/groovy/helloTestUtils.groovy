class helloTestUtils extends hello {
    def pipeline(closure) {
        closure()
    }

    def any
    def agent(any) {}

    def stages(c) {
        c()
    }

    def stage(s, c) {
        c()
    }

    def steps(c) {
        c()
    }

    def script(c) {
        c()
    }
}