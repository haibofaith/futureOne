# futureOne
打算写点干货;

1、遇到一个问题：
请求：http://localhost:8080/hello其中参数为{"name":"19508","password":"123123"}的时候：
返回：Springmvc rest 传递json报415错误:The server refused this request because the request entity is in a format
解决方案：添加jar包依赖：
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>${jackson.version}</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>${jackson.version}</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-annotations</artifactId>
      <version>${jackson.version}</version>
    </dependency>

2、公共项目commonBean的使用:本地项目commonBean单独上传为github中commonBean；

3、 遇到问题：org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.web.servlet.mvc.support.ControllerBeanNameHandlerMapping#0' defined in class path resource
配置问题少
  <!-- 配置Spring2:配置Spring监听2 -->
  <listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  </listener>

4、No appenders could be found for logger (org.springframework.web.context.ContextLoader).
配置问题少
<!-- Log4j的监听器要放在spring监听器前面 -->
  <listener>
    <listener-class>org.springframework.web.util.Log4jConfigListener</listener-class>
  </listener>  

5、日志有了，但是不打印，提示Failed to load class "org.slf4j.impl.StaticLoggerBinder".
添加了依赖包  
<dependency>  
    <groupId>org.slf4j</groupId>  
    <artifactId>slf4j-simple</artifactId>  
    <version>1.7.25</version>  
</dependency>  

从中需要去掉  <scope>test</scope>





    