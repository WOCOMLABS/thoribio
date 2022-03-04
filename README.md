make sure the settings.gradle.kts has access to these properties a good way to do it is by adding this file at the
root of your gradle installation.


```text
C:\Users\<<<yours>>>\.gradle
```

```groovy
# https://docs.gradle.org/current/userguide/configuration_cache.html

org.gradle.configureondemand=true
org.gradle.caching=true
org.gradle.jvmargs=-XX:+UseParallelGC
org.gradle.unsafe.configuration-cache=true
org.gradle.console=verbose
org.gradle.logging.level=lifecycle
org.gradle.parallel=true
org.gradle.jvmargs=-Xmx2g -XX:MaxMetaspaceSize=2048m -XX:+HeapDumpOnOutOfMemoryError -Dfile.encoding=UTF-8

kotlinVersion=1.6.10
taskInfoVersion=1.3.1
thoribioPluginVersion=0.1.12-SNAPSHOT

```

the gradle projects require these 3  

```groovy
kotlinVersion=1.6.10
taskInfoVersion=1.3.1
thoribioPluginVersion=0.1.12-SNAPSHOT
```


at some point all this project will live under [www.thorib.io](http://thorib.io)
