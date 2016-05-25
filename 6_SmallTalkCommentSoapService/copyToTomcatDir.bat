set tomcatHome="C:\dev\tomcat\apache-tomcat-8.0.33"
set serviceName="SmallTalkCommentService"

rd %tomcatHome%\webapps\%serviceName% /s /q

del %tomcatHome%\webapps\%serviceName%.war

copy target\%serviceName%.war %tomcatHome%\webapps\%serviceName%.war 