package org.devops


//构建类型

def Build(buildType,buildShell){
    def build buildTools = ["mvn": "M3", "ant":"ANT", "gradle":"GRADLE", "npm":"NPM"]
  
    println("当前选择的构建类型为 ${buildType}")
    buildHome = tool buildTools[buildType]
    
    sh "${buildHome}/bin/${buildTYpe}  ${buildShell}"
    
}
