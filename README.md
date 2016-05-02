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
The Tesla power API works similarly to other cross mod API systems. There are various interfaces which allow you to define classes as capable of certain things.

These three interfaces handle the basic input/output and storage of Tesla power. While they are typically used on a TileEntity, they can also be used on any other type such as Entity.
- [ITeslaHolder](https://github.com/Darkhax-Minecraft/Tesla/blob/master/src/main/java/net/darkhax/tesla/api/ITeslaHolder.java) interface allows an object to hold power within itself.
- [ITeslaProvider](https://github.com/Darkhax-Minecraft/Tesla/blob/master/src/main/java/net/darkhax/tesla/api/ITeslaProvider.java) interface allows other things to pull power from it.
- [ITeslaReceiver](https://github.com/Darkhax-Minecraft/Tesla/blob/master/src/main/java/net/darkhax/tesla/api/ITeslaReceiver.java) allows other things to send power to it.

[ITeslaContainer](https://github.com/Darkhax-Minecraft/Tesla/blob/master/src/main/java/net/darkhax/tesla/api/ITeslaContainer.java) is an interface for defining Tesla Containers. These are objects which actually handle the holding of the power. While not strictly required, they make things much easier. There is a base implementation already provided called [BaseTeslaContainer](https://github.com/Darkhax-Minecraft/Tesla/blob/master/src/main/java/net/darkhax/tesla/api/BaseTeslaContainer.java). This container handles input and output like one would expect, but it also allows for energy transfer limitations and NBT serialization.

[ITeslaTile](https://github.com/Darkhax-Minecraft/Tesla/blob/master/src/main/java/net/darkhax/tesla/api/ITeslaTile.java) is a special interface used to define a TileEntity which can accept power. This interface should be used by all TileEntity which can handle Tesla power. This interface provides the methods required to check if a side of a block is a valid input/output slot. 

[ITeslaItem](https://github.com/Darkhax-Minecraft/Tesla/blob/master/src/main/java/net/darkhax/tesla/api/ITeslaItem.java) is a special exception to the system. Items do not have access to their ItemStack instance, so they need to have it provided as a method argument if you want to support NBT or meta data, which is exactly what an item storing power wants. 

Credits
=======
[Darkhax](https://twitter.com/Darkh4x)    
[lclc98](https://twitter.com/lclc98)  