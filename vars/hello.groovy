def call() {
    pipeline {
        agent any
        stages {
            stage('Even Stage') {
                steps {
                    script {
                        def z = new org.foo.Zot()
                        z.checkOutFrom('openstack-cloud-plugin')
                    }
                }
            }
        }
    }
}
