TESLA
=========
Tesla is a power API for minecraft that can be used by various mods to interact with eachother over power networks.

[![Nodecraft](https://i.imgur.com/sz9PUmK.png)](https://nodecraft.com/r/darkhax)    
This project is sponsored by Nodecraft. Use code [Darkhax](https://nodecraft.com/r/darkhax) for 30% off your first month of service!

## Dependency Management
If you are using [Gradle](https://gradle.org) to manage your dependencies, add the following into your `build.gradle` file. Make sure to replace the version with the correct one.
```
repositories {

    maven {
      
        url 'https://maven.blamejared.com'
    }
}

dependencies {

    compile "net.darkhax.tesla:Tesla-PUT_MC_VERSION_HERE:PUT_VERSION_HERE"
}
```

Frequently Asked Questions
==========================
**Where can people go to discuss the Tesla API?**   
We have a discord server to discuss the API [here](https://discord.gg/nN68J34).

**What makes Tesla different from other power APIs?**   
The Tesla API functions similarly to other well known power API, however there are several design choices that sets the Tesla API apart from the rest. One of these differences is the support for Forge's capability system. By using the capability system, mod authors can easily hook their blocks, items and mobs into the Tesla power system. The capability system also allows mod authors to hook vanilla content, or content from other mods into the Tesla power API as well. There are also several changes on the back end which allows the Tesla API to handle much larger units of power. Traditional power API only support 2.1 billion, while Tesla can support 9.2 quintillion. 

**Are there any standards for energy conversion?**   
The Tesla API does not enforce any energy standard, however for the sake of consistency, mod authors are encouraged to use the same energy scales as the RF system. Following this standard will allow for mods to easily support both power systems.

**Why did you make this API?**   
The Tesla API was originally made for the fun of it, however it recieved a lot of unexpected attention from others in the community. The RF API is currently in a limbo state, with only unofficial ports for the latest update, so I decided to publicly release the API to provide tech mods with a viable power solution for 1.9.

**Should the Tesla API be bundled with other mods?**   
Bundling the API of other mods has always seemed a bit weird to me. With the use of Gradle and the [Optional annotation](http://cazzar.net/tutorials/fml/optional-annotations-the-usages/) there really isn't a legitimate need to do so. SeargeDP summarized it up well in [this](https://twitter.com/seargedp/status/473895192387649536) tweet. That being said, the Tesla API can be bundled with other mods, and supports Minecraft Forge's [API system](https://github.com/Minalien/BlogArchive/blob/master/ForgeTutorials/Spotlight__API_Annotation.md). If you feel that you have a legitimate reason to bundle the API, or you are unfamiliar with adding support without bundling, don't hesistate to come and talk at the [#Tesla-API room on Esper.net](http://webchat.esper.net/?nick=&channels=tesla-api).

**How does soft dependency work if I can't bundle?**
Forge provides several tools which make soft dependency really simple. The first is the [Optional annoation](http://cazzar.net/tutorials/fml/optional-annotations-the-usages/). This annotation can be added to any class that implements an interface, and if a specified mod is not detected that annotation will be stripped from the class at runtime. This means that you can have classes in your mod that reference the interfaces in Tesla but not have Tesla be a hard dependency. So what about code that refers to the capability? The [CapabilityInject annoation](https://mcforge.readthedocs.io/en/latest/datastorage/capabilities/) solves this. When used on a field, that field will be initialized with the referenced Capability when it is registered. This means the field will remain null if the mod is not installed. You can also use this annotation on methods to have them be called when the capability is registered, allowing for you to safely initialize code. This annotation requires the class of the capability interface, which can be done by directly referencing the API class. Due to how the JVM handles annoatations it is safe to do this. As for everything else, Loader#isModLoaded from Forge can be used for additional checks to see if Tesla is installed. As long as Tesla classes are not being referenced while the mod is not installed, you will be fine.

Standards
=========
For a cross mod API to work, it is important that several standards are followed. These standards ensure that everything works well together and no two mods step on each others toes. While these standards are in no way enforced, it makes things better for everyone involved. 
- One Tesla should be equal to 1 RF. This is help existing RF mods convert over without rebalancing, and to allow mods to support multiple systems seemlessly. This is only applies to basic balancing. If someone wants to make a power conversion mod they can play around with the conversion efficiency ratio. 
- Only capability objects should use the capability interfaces. If you implement the interface to your TileEntity/Entity/Item it will not be compatible with other tesla content.
- All sided logic should be handled through the hasCapability and getCapability methods provided by forge. If something requests a power input on the top of your block, but you only allow power from the back of your block, do not give access to the power input, the thing requesting the input slot is not expected to know if it is acceptable or not.
- Power sources are responsible for pushing power to nearby machines. Machines and wires should NOT pull power from other sources. 

Getting Started
===============
The best way to use the Tesla API is through the new [Capability system](http://mcforge.readthedocs.io/en/latest/datastorage/capabilities/) in Minecraft Forge. The idea for the capability system is that capability handlers can be attached to supported types (TileEntity, ItemStack, Entity). When you attach a capability, it has access to all of the code for that capability. Tesla has 3 capabilities, ITeslaConsumer ITeslaHolder and ITeslaProducer, which can be seen how they are implemented [here](https://github.com/Darkhax-Minecraft/Tesla/blob/master/src/main/java/net/darkhax/tesla/api/implementation/BaseTeslaContainer.java). An example of a TileEntity which uses the Tesla API can be seen [here](https://github.com/Darkhax-Minecraft/Tesla/blob/master/src/test/java/net/darkhax/teslatest/tileentity/TileEntityAnalyzer.java).
