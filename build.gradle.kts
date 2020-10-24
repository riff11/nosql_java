plugins { 
  java
  eclipse
}

allprojects {
   group = "it.discovery"
}

subprojects {  
   apply(plugin = "java")

   java.sourceCompatibility = JavaVersion.VERSION_14
   java.targetCompatibility = JavaVersion.VERSION_14

   repositories {
     jcenter()
   }
   
   dependencies {
        val springBootVersion: String by project 
        implementation(platform("org.springframework.boot:spring-boot-dependencies:$springBootVersion"))
        testCompile("org.springframework.boot:spring-boot-starter-test")

        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.projectlombok:lombok:1.18.14")
   } 
   tasks.test {
       useJUnitPlatform()
   }
}

