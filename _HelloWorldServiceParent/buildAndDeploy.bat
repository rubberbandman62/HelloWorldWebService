call mvn clean install

cd..

cd 4_HelloWorldServiceSoap

echo.
echo.
echo ########################################
echo.
echo.

echo Deploying HelloWorldService on Tomcat...

call copyToTomcatDir.bat

echo Done.