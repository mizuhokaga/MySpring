1. @EnableAutoConfiguration里通过@Import导入了AutoConfigurationImportSelector

2. AutoConfigurationImportSelector类中有一个   selectImports(AnnotationMetadata annotationMetadata)方法, 
   这个方法调用了  :  getAutoConfigurationEntry(autoConfigurationMetadata,
        annotationMetadata);   
   在这个方法中调用了:  List<String> configurations = getCandidateConfigurations(annotationMetadata, attributes);  获取所有的配置项

那么它是怎么获取的呢?

再观察:  getCandidateConfigurations(annotationMetadata, attributes);
     其中有 List<String> configurations = SpringFactoriesLoader.loadFactoryNames(getSpringFactoriesLoaderFactoryClass(),
        getBeanClassLoader());

再进入SpringFactoriesLoader.loadFactoryNames(getSpringFactoriesLoaderFactoryClass(),
        getBeanClassLoader());

可以看到它取出工厂类型名后，调用了  loadSpringFactories(classLoader)
    它的返回值是一个Map,  在这个方法中有: 

    Enumeration<URL> urls = (classLoader != null ?
          classLoader.getResources(FACTORIES_RESOURCE_LOCATION) :
          ClassLoader.getSystemResources(FACTORIES_RESOURCE_LOCATION));

   请观察:    classLoader.getResources(FACTORIES_RESOURCE_LOCATION) :
        从这里可以看到 类加载器在加载  路径:   FACTORIES_RESOURCE_LOCATION="META-INF/spring.factories"

就这里了，  请到  "META-INF/spring.factories"  查看，在这个文件中，可以看到一系列Spring Boot自动配置的列表



如还要深入, 则可以看一下jdbc的



另外这个import注解的部分如何被 spring托管到的呢，请参考:   https://www.cnblogs.com/desertfish/p/11637933.html
