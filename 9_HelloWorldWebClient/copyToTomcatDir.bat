set tomcatHome="C:\Entwicklung\apache-tomcat-8.0.32"
set serviceName="HelloWorldWebClient"

rd %tomcatHome%\webapps\%serviceName% /s /q

del %tomcatHome%\webapps\%serviceName%.war

copy target\%serviceName%.war %tomcatHome%\webapps\%serviceName%.war 
