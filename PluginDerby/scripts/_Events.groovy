/*
 * Copyright 2004-2013 SpringSource.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


eventPluginInstalled = { String pluginName ->

		if(pluginName.toLowerCase().contains("plugin-derby")){
			println "Installing plugin-derby"
			
			String hibernateTargetDir = "$basedir/grails-app/conf/hibernate"
			String hibernateSrcDir = "$pluginDerbyPluginDir/grails-app/conf/hibernate"
			
			
			String dataSourceTargetFile = "$basedir/grails-app/conf/DataSource.groovy"
			String dataSourceSrcFile = "$pluginDerbyPluginDir/grails-app/conf/DataTemplate.groovy"
			
			copyFile(dataSourceSrcFile, dataSourceTargetFile, true)
			copyDir(hibernateSrcDir, hibernateTargetDir, true)
		}
}


void copyDir(String sourceDir, String targetDir, boolean overwrite){
	println "creates dir $targetDir"
	ant.mkdir(dir: targetDir)
	
	println "copy dir $sourceDir"
	
	ant.copy(todir: targetDir, verbose: true, overwrite: overwrite){
		fileset(dir: sourceDir)
	}
}

void copyFile(String sourceFile, String targetFile, boolean overwrite){
	//println "creates dir $targetDir"
	//ant.mkdir(dir: targetDir)
	
	println "copy file $sourceFile"
	ant.copy(file: sourceFile, tofile: targetFile, overwrite: overwrite)
	
}


