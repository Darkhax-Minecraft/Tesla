TESLA
=========
Tesla is a power API for minecraft that can be used by various mods to interact with eachother over power networks.

##Dependency Management
If you are using [Gradle](https://gradle.org) to manage your dependencies, add the following into your `build.gradle` file. Make sure to replace the version with the correct one. All versions can be viewed [here](http://maven.rubbix.net/net/darkhax/tesla/Tesla/).
```
repositories {

    maven { url 'http://maven.rubbix.net' }
}

dependencies {

    compile "net.darkhax.tesla:Tesla:PUT_VERSION_HERE"
}
```

Alternatively, if you are using [Maven](https://maven.apache.org/download.cgi) to manage your dependencies. Add the following into your `pom.xml` file. Make sure to replace the version with the correct one. Again, all versions can be found [here](http://maven.rubbix.net/net/darkhax/tesla/Tesla/).
```
<repositories>
    <repository>
        <id>Rubbix.net</id>
        <url>http://maven.rubbix.net</url>
    </repository>
</repositories>

<dependency>
     <groupId>net.darkhax.tesla</groupId>
     <artifactId>Tesla</artifactId>
     <version>PUT_VERSION_HERE</version>
</dependency>
```

Getting Started
===============
The best way to use the Tesla API is through the new [Capability system](http://mcforge.readthedocs.io/en/latest/datastorage/capabilities/) in Minecraft Forge. The idea for the capability system is that capability handlers can be attached to supported types (TileEntity, ItemStack, Entity). When a capability is attached, it has access to all of the [ITeslaHandler](https://github.com/Darkhax-Minecraft/Tesla/blob/master/src/main/java/net/darkhax/tesla/api/ITeslaHandler.java) code. The default ITeslaHandler is the [TeslaContainer](https://github.com/Darkhax-Minecraft/Tesla/blob/master/src/main/java/net/darkhax/tesla/api/TeslaContainer.java) which handles basic tesla power functionality. An example of this system in action can be found here. TODO actually add an example X)

Credits
=======
[Darkhax](https://twitter.com/Darkh4x)    
[lclc98](https://twitter.com/lclc98)  
