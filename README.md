TESLA
=========
Tesla is a power API for minecraft that can be used by various mods to interact with eachother over power networks.

##Dependency Management
If you are using [Gradle](https://gradle.org) to manage your dependencies, add the following into your `build.gradle` file. Make sure to replace the version with the correct one. All versions can be viewed [here](http://maven.rubbix.net/net/darkhax/tesla/Tesla/).
```
repositories {

    maven {
      
        url 'http://maven.rubbix.net'
    }
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

Frequently Asked Questions
==========================
**Where can people go to discuss the Tesla API?**   
Current discussions are taking place over IRC chat. You can join us in [#Tesla-API on Esper.net](http://webchat.esper.net/?nick=&channels=tesla-api). A public Discord server and/or Curse server may also be openend up in the future. 

**What makes Tesla different from other power APIs?**   
The Tesla API functions similarly to other well known power API, however there are several design choices that sets the Tesla API apart from the rest. One of these differences is the support for Forge's capability system. By using the capability system, mod authors can easily hook their blocks, items and mobs into the Tesla power system. The capability system also allows mod authors to hook vanilla content, or content from other mods into the Tesla power API as well. There are also several changes on the back end which allows the Tesla API to handle much larger units of power. Traditional power API only support 2.1 billion, while Tesla can support 9.2 quintillion. 

**Are there any standards for energy conversion?**   
The Tesla API does not enforce any energy standard, however for the sake of consistency, mod authors are encouraged to use the same energy scales as the RF system. Following this standard will allow for mods to easily support both power systems.

**Why did you make this API?**   
The Tesla API was originally made for the fun of it, however it recieved a lot of unexpected attention from others in the community. The RF API is currently in a limbo state, with only unofficial ports for the latest update, so I decided to publicly release the API to provide tech mods with a viable power solution for 1.9.

**Should the Tesla API be bundled with other mods?**   
Bundling the API of other mods has always seemed a bit weird to me. With the use of Gradle and the [Optional annotation](http://cazzar.net/tutorials/fml/optional-annotations-the-usages/) there really isn't a legitimate need to do so. SeargeDP summarized it up well in [this](https://twitter.com/seargedp/status/473895192387649536) tweet. That being said, the Tesla API can be bundled with other mods, and supports Minecraft Forge's [API system](https://github.com/Minalien/BlogArchive/blob/master/ForgeTutorials/Spotlight__API_Annotation.md). If you feel that you have a legitimate reason to bundle the API, or you are unfamiliar with adding support without bundling, don't hesistate to come and talk at the [#Tesla-API room on Esper.net](http://webchat.esper.net/?nick=&channels=tesla-api).

Getting Started
===============
The best way to use the Tesla API is through the new [Capability system](http://mcforge.readthedocs.io/en/latest/datastorage/capabilities/) in Minecraft Forge. The idea for the capability system is that capability handlers can be attached to supported types (TileEntity, ItemStack, Entity). When a capability is attached, it has access to all of the [ITeslaHandler](https://github.com/Darkhax-Minecraft/Tesla/blob/master/src/main/java/net/darkhax/tesla/api/ITeslaHandler.java) code. The default ITeslaHandler is the [TeslaContainer](https://github.com/Darkhax-Minecraft/Tesla/blob/master/src/main/java/net/darkhax/tesla/api/TeslaContainer.java) which handles basic tesla power functionality. An example of this system in action can be found here. TODO actually add an example X)
