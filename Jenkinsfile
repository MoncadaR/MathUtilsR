pipeline {
  agent any
  options { timestamps() }

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }

    stage('Docker Sanity Check') {
      steps {
        sh 'docker version'
        sh 'docker ps'
      }
    }

    stage('Java: Test (Docker Maven)') {
      steps {
        dir('java') {
          script {
            docker.image('maven:3.9.9-eclipse-temurin-17').inside {
              sh 'mvn -B clean test'
            }
          }
        }
      }
      post {
        always {
          junit 'java/target/surefire-reports/*.*
