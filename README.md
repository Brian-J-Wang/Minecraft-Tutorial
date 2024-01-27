This repo follows the tutorials given by KaupenJoe. It is hoped that by the time I finished with the tutorial that I can make minecraft mods.

# Tutorial # 2: Custom Items
The episode focuses on adding simple items to the game, and creating a custom creative tab for it.
## Key Takeaways
1. Registries are used to let minecraft be aware of its existence.
   - registries are used for anything new the user adds to minecraft.
   - there are separate registries for the different types of content the user adds.
   - Registry objects typically follow the pattern.
   
```
    public static final RegistryObject<RegistryType> "Item Name" = RegistryType.register("registry name*"),
        () -> ItemProperties**
        
    *   The registry name must be in lowercases with no spaces
    **  The item Properties is a builder class
```

2. json files are used to link different files together.
    - links textures, and localization using the registry name.

3. Creative mode tabs are created in a separate class called CreativeModeTab, each class creates a new tab but does not know what items are part of that class. Instead that is done when the item is created in the registry.
    - the creative tab localization is done using the same en_us.json file.