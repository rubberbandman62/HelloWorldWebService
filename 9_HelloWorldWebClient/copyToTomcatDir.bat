set tomcatHome="C:\dev\tomcat\apache-tomcat-8.0.33"
set serviceName="HelloWorldWebClient"

rd %tomcatHome%\webapps\%serviceName% /s /q

del %tomcatHome%\webapps\%serviceName%.war

copy target\%serviceName%.war C:\dev\tomcat\apache-tomcat-8.0.33\webapps\%serviceName%.war 
