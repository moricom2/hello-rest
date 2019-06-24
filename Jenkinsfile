node {
	stage('1. Source Code Pull'){
		git branch:'master', url:'https://github.com/moricom2/hello-rest.git'
	}
	stage('2. Source Code Package'){
		sh 'mvn clean package -DskipTests=true'
	}
	stage('3. Source Code JunitTest'){
		sh 'mvn surefire-report:report'
	}            
	stage('4. Container Build'){
		sh 'docker build -t moricom/hello-rest .'
	}  
	stage('5. Container Running'){
		def containerID = sh (script: 'docker ps -aq -f name=hello-rest', returnStdout: true)
		if (containerID != '') {
			sh 'docker stop ' + containerID
		}
		sh 'docker run -d -p 80:80 --rm --name hello-rest moricom/hello-rest'
	}
}
