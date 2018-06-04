# futureOne
打算写点干货
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
    