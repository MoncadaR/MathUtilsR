pipeline {
  agent any

  tools {
    maven 'MavenNew'   // change this to your Jenkins Maven tool name
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Java: Build & Test') {
      steps {
        dir('java') {
          sh 'mvn -B clean test'
        }
      }
      post {
        always {
          junit 'java/target/surefire-reports/*.xml'
        }
      }
    }

    stage('Python: Install & Test') {
      steps {
        dir('python') {
          sh 'python3 -m pip install --user pytest'
          sh 'python3 -m pytest -q'
        }
      }
    }
  }

  post {
    always {
      echo "Pipeline finished: ${currentBuild.currentResult}"
    }
  }
}

