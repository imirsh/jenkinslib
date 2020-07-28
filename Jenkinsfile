#!groovy

@Library('jenkinslib') _ // 调用共享库

def tools = new org.devops.tools  // 定义方法

String workspace = "/var/lib/jenkins/workspace"

pipeline {
	agent { node { label "master"
				customWorkspace "${workspace}"
			}
	}

	options {
		timestamps() //显示日志时间
		skipDefaultCheckout() //删除隐式 checkout scm 语句
		disableConcurrentBuilds() // 禁止并行
		timeout(time: 1, unit: 'HOURS')
	}

	stages {
		//下载代码
		stage("GetCode") {
			steps{
				timeout(time:5, unit:"MINUTES"){
					script{ //填写运行代码
						println('获取代码')
						tools.PrintMes("获取代码","green") // 调用方法
					}
				}
			}
		}

		//构建
		stage("Build") {
			steps{
				timeout(time:20, unit:"MINUTES"){
					script{
						println('应用打包')
					}
				}
			}
		}

		//代码扫描
		stage("CodeScan") {
			steps{
				timeout(time:30, unit:"MINUTES"){
					script{
						println('代码扫描')
					}
				}
			}
		}
	}
	
	//构建后的操作
	post {
		always {
			script{
				println("always")
			}
		}

		success {
			script{
				currentBuild.description += "\n 构建成功!"
			}
		}

		failure {
			script{
				currentBuild.description += "\n 构建失败!"
			}
		}

		aborted {
			script{
				currentBuild.description += "\n 构建取消!"
			}
		}
	}
}
