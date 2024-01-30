# Minecraft Modding Tutorial
This repo follows the tutorials given by KaupenJoe. It is hoped that by the time I finished with the tutorial that I can make minecraft mods.

## Tutorial #2: Custom Items
This episode focuses on adding items to the game, and creating a custom creative tab for it.
### Key Takeaways
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

## Tutorial #3: Custom Blocks
This episode focuses on adding basic blocks to minecraft.
### Key Takeaways
1. Blocks needs to be added to the Block registry so that it can be seen in the world, and to the item registry so that it can be used as an item.
   - KaupenJoe uses two helper methods to achieve this. One adds it to the blocks registry and another adds it to the item registry called from the block registry
   - Adding blocks to the game is very similar to adding items to the game, name block builder, creativemode tab. Though in this case the creative mod tab is created when the block is added to the item registry (resulting in the need for adding the blocks to two different registries)
2. There are numerous json files that needs to be added. It is good practice to name all the files the same as the name of the block
   - blockstates
     - The name of the file must match with the name of the block.
     - the model is referenced to the json file in the models.block folder
```json
{
   "variants": {
      "": { "model": "MOD_NAME:block/BLOCK_NAME" }
   }
}
```
   - models.block
     - The name of the file has to match with the name referenced in the blockstates json file
     - the file referenced in the all key is to the texture found in the textures.block folder.
```json
{
   "parent": "block/cube_all",
   "textures": {
      "all": "MOD_NAME:block/BLOCK_NAME"
   }
}

```
   - models.item
     - is used to represent the texture in the player's inventory.
```json
{
   "parent": "MOD_NAME:block/BLOCK_NAME"
}
```

## Tutorial #4 Recipes and Loot Tables
This tutorial shows how to create recipes and form a loot table

### Key Takeaways