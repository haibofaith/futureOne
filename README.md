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


6、JSR303不生效：jdk使用9，降低为7 且 Spring版本如果为4.3.3需要将为3.2.3.RELEASE

7、nested exception is javax.validation.ConstraintDefinitionException
@Target({METHOD,PARAMETER,FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {PwdValidatorImpl.class})
public @interface PwdValidator {
    //默认错误消息
    String message() default "不能包含空格";
    //分组
    Class<?>[] groups() default { };
    //负载
    Class<? extends Payload>[] payload() default { };
}

8、返回中文乱码

1）、加了filter之后依然存在着
且web.xml中提示错误The content of element type "web-app" must match
The content of element type "web-app" must match "(icon?,display-name?,description?,
distributable?,context-param*,filter*,filter-mapping*,listener*,servlet*,servlet- mapping*,
session-config?,mime-mapping*,welcome-file-list?,error-page*,taglib*,resource-env-ref*,
resource-ref*,security-constraint*,login-config?,security-role*,env-entry*,ejb-ref*,
ejb-local-ref*)".

<!-- 配置springMVC编码过滤器 -->
  <filter>
    <filter-name>CharacterEncodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <!-- 设置过滤器中的属性值 -->
    <init-param>
      <param-name>encoding</param-name>
      <param-value>UTF-8</param-value>
    </init-param>
    <!-- 启动过滤器 -->
    <init-param>
      <param-name>forceEncoding</param-name>
      <param-value>true</param-value>
    </init-param>
  </filter>
  <!-- 过滤所有请求 -->
  <filter-mapping>
    <filter-name>CharacterEncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>

2）、加了Interceptor也无效

3）、最终使用：
<!-- 加入注解驱动 -->
<mvc:annotation-driven>
    <mvc:message-converters register-defaults="true">
         <bean class="org.springframework.http.converter.StringHttpMessageConverter">
              <property name="supportedMediaTypes" value = "text/plain;charset=UTF-8" />
         </bean>
    </mvc:message-converters>
</mvc:annotation-driven>  

9、spring AspectJ的Execution表达式
例如定义切入点表达式 execution(* com.sample.service.impl..*.*(..))
execution()是最常用的切点函数，其语法如下所示：
 整个表达式可以分为五个部分：
    1、execution(): 表达式主体。
    2、第一个*号：表示返回类型，*号表示所有的类型。
    3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。
    4、第二个*号：表示类名，*号表示所有的类。
    5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。

10、java.lang.NoClassDefFoundError: org/aspectj/weaver/reflect/ReflectionWorld$ReflectionWorldException
<!-- begin AspectJ -->
<dependency>
       <groupId>org.aspectj</groupId>
       <artifactId>aspectjrt</artifactId>
       <version>${org.aspectj-version}</version>
     </dependency>
     <dependency>
       <groupId>org.aspectj</groupId>
       <artifactId>aspectjweaver</artifactId>
       <version>${org.aspectj-version}</version>
</dependency>
     <!-- end AspectJ -->   
 
11、包冲突
NotWritablePropertyException: Invalid property 'maxRedirects' of bean class [org.springframework.data.redis.connection.RedisClusterConfiguration]
     