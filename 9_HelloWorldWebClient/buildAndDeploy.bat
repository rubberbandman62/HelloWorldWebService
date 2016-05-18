call mvn clean install

echo.
echo.
echo ########################################
echo.
echo.

echo Deploying HelloWorldWebClient on Tomcat...
 
call copyToTomcatDir.bat

echo Done.