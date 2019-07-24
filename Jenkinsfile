node {
	def imgName = "localhost:5000/hello-rest:latest"
	def appName = "hello-rest"
	def gitURL = "http://192.168.99.100/bi/hello-rest.git"
	def sonarURL = "http://192.168.99.100:9000"
	stage('1. Source Code Pull'){
		git branch:'master', url:gitURL
	}
	stage('2. Source Code Package'){
		sh 'mvn clean package -DskipTests=true'
	}
	stage('3. Source Code JunitTest'){
		sh 'mvn surefire-report:report'
	}
	stage('4. Soce Code Analysis'){
	    sh 'mvn sonar:sonar -Dsonar.host.url=' + sonarURL + ' -Dsonar.projectKey=' + appName + ' -Dsonar.projectName=' + appName + ' -Dsonar.sources=./src/main/java -Dsonar.java.binaries=./target/classes -Dsonar.junit.reportPaths=./target/surefire-reports -DskipTests=true'
	}            
	stage('5. Container Image Build'){
		sh 'docker build -t ' + imgName + ' .'
	}  	
	stage('6. Container Image Share'){
		sh 'docker push ' + imgName
	}  	
	stage('7. Container Run'){
		def containerID = sh (script: 'docker ps -aq -f name=' + appName, returnStdout: true)
		if (containerID != '') {
			sh 'docker rm -f ' + containerID
		}
		sh 'docker run -d -p 88:80 --rm --name ' + appName + ' ' + imgName
	}
}
