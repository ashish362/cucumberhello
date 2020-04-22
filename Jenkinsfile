pipeline {
  environment {
    registry = "ashish362/docker-demo"
    registryCredential = 'dockerhub'
    dockerImage = ''
    PROJECT_ID = 'internal-investment-206615'
    CLUSTER_NAME = 'cucumber-hello'
    LOCATION = 'us-central1-f'
    CREDENTIALS_ID = ''
  }
  
  agent any
     tools {
      
      jdk "java"
      gradle "gradle"
      
      
   }
  stages {
    stage("Build the project") {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew build'
            }
        }
	 stage('Docker Image Build') {
    steps{
	   
      script {
        dockerImage = docker.build registry + ":cucumberhello"
      }
    }
  }

  stage('Push Image to DockerHub'){
    steps{
      script {
        docker.withRegistry( '', registryCredential ) {
          dockerImage.push()
        }
      }
    }
  }
  
  stage('Deploy Production') {
      steps{
	               sh "gcloud container clusters get-credentials ${CLUSTER_NAME} --zone ${LOCATION} --project ${PROJECT_ID}"


                            step([$class: 'KubernetesEngineBuilder', 
                            projectId: env.PROJECT_ID, 
                            clusterName: env.CLUSTER_NAME, 
                            zone: env.LOCATION, 
                            manifestPattern: 'deployment.yaml', 
                            credentialsId: "Internal Investment-206615", 
                            verifyDeployments: true])
            }
        }
 


  stage('Remove Unused docker image') {
    steps{
      sh "docker rmi $registry:cucumberhello"
    }
  }    
}
}
