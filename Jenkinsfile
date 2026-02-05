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
  agent {
    docker { image 'python:3.12-slim' }
  }
  steps {
    dir('python') {
      sh '''
        python -V
        pip install -q pytest
        pytest -q
      '''
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

