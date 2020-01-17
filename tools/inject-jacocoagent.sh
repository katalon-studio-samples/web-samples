#!/bin/sh
PROJECT_SETTINGS_DIR="$1"
JACOCOAGENT="$2"
REPORT_FILE="$3"
LAUNCH_PROPERTY="execution.launch.vmArgs=\"-javaagent\:$JACOCOAGENT\=destfile\=$REPORT_FILE\""

cd $PROJECT_SETTINGS_DIR
echo $LAUNCH_PROPERTY > "com.kms.katalon.execution.setting.properties" 
