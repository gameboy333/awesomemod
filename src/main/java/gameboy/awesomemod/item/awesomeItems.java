package gameboy.awesomemod.item;

import gameboy.awesomemod.Awesomemod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class awesomeItems {
    public static final RegistryKey<ItemGroup> itemGroupKey = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Awesomemod.MOD_ID, "item_group"));
    public static final ItemGroup customItemGroup = FabricItemGroup.builder()
            .icon(() -> new ItemStack(awesomeItems.testingItem))
            .displayName(Text.translatable("itemGroup.awesomeMod"))
            .build();

    public static final Item testingItem = register("testing-item", Item::new, new Item.Settings());

    public static final ConsumableComponent berryEffects = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HASTE, 60 * 20, 10), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 60 * 20, 10), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 60 * 20, 5), 1.0f))
            .build();
    public static final FoodComponent berryFoodVals = new FoodComponent.Builder()
            .saturationModifier(3)
            .nutrition(5)
            .alwaysEdible()
            .build();
    public static final Item speedBerries = register("speed-berries", Item::new, new Item.Settings().food(berryFoodVals,berryEffects));
    public static final ConsumableComponent jumpberryEffects = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 60 * 20, 20), 1.0f))
            .build();
    public static final Item jumpBerries = register("jump-berries", Item::new, new Item.Settings().food(berryFoodVals,jumpberryEffects));
    public static final ConsumableComponent defenseberryEffects = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 60 * 20, 2), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 60 * 20, 2), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 60 * 20, 3), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 60 * 20, 1), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 60 * 20, 1), 1.0f))
            .build();
    public static final Item defenseBerries = register("defense-berries", Item::new, new Item.Settings().food(berryFoodVals,defenseberryEffects));
    public static final ConsumableComponent healingberryEffects = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 60 * 20, 5), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 60 * 20, 5), 1.0f))
            .build();
    public static final Item healingBerries = register("healing-berries", Item::new, new Item.Settings().food(berryFoodVals,healingberryEffects));
    public static final ConsumableComponent ultimateberryEffects = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HASTE, 120 * 20, 22), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 120 * 20, 22), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 120 * 20, 7), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 60 * 20, 7), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 60 * 20, 7), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 60 * 20, 7), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 60 * 20, 7), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 60 * 20, 7), 1.0f))
            .build();
    public static final Item ultimateBerries = register("ultimate-berries", Item::new, new Item.Settings().food(berryFoodVals,ultimateberryEffects));



    public static final ConsumableComponent superBerryEffects = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HASTE, 120 * 20, 20), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 120 * 20, 20), 1.0f))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 120 * 20, 10), 1.0f))
            .build();
    public static final Item condensedSpeedBerries = register("condensed-speed-berries", Item::new, new Item.Settings().food(berryFoodVals,superBerryEffects));

    public static final Item multiTool = register("multitool", Item::new, new Item.Settings().axe(ToolMaterial.IRON,0,0).sword(ToolMaterial.IRON,3,0).pickaxe(ToolMaterial.IRON,2,0).shovel(ToolMaterial.IRON,0,0));
    public static final Item bloxyCola = register("bloxycola", Item::new, new Item.Settings().food(new FoodComponent(100,100,false)));
    public static final Item minos = register("minos", Item::new, new Item.Settings().axe(ToolMaterial.NETHERITE,999999,999999));
    public static final ConsumableComponent evilBerryEffects = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 20, 50), 1.0f))
            .build();
    public static final Item evilBerries = register("evil-berries", Item::new, new Item.Settings().food(berryFoodVals,evilBerryEffects));
    public static final Item rawDeenin = register("raw-deenin", Item::new, new Item.Settings());
    public static final Item deeninIngot = register("deenin-ingot", Item::new, new Item.Settings());



    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Awesomemod.MOD_ID, name));

        Item item = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    private static void addItems(FabricItemGroupEntries entries) {
        entries.add(testingItem);
        entries.add(speedBerries);
        entries.add(jumpBerries);
        entries.add(defenseBerries);
        entries.add(healingBerries);
        entries.add(ultimateBerries);
        entries.add(condensedSpeedBerries);
        entries.add(multiTool);
        entries.add(bloxyCola);
        entries.add(minos);
        entries.add(evilBerries);
        entries.add(rawDeenin);
        entries.add(deeninIngot);
    }

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, itemGroupKey, customItemGroup);
        ItemGroupEvents.modifyEntriesEvent(itemGroupKey).register(awesomeItems::addItems);
    }
}