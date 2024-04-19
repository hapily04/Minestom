package net.minestom.server.item;

import net.kyori.adventure.nbt.BinaryTag;
import net.kyori.adventure.text.Component;
import net.minestom.server.color.Color;
import net.minestom.server.color.DyeColor;
import net.minestom.server.item.component.*;
import net.minestom.server.network.NetworkBuffer;
import net.minestom.server.registry.StaticProtocolObject;
import net.minestom.server.utils.NamespaceID;
import net.minestom.server.utils.nbt.BinaryTagSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.minestom.server.item.ItemComponentImpl.declare;

public sealed interface ItemComponent<T> extends StaticProtocolObject permits ItemComponentImpl {
    // Note that even non-networked components are declared here as they still contribute to the component ID counter.
    // The order in this file determines the component protocol IDs, so it is important to match the client.

    ItemComponent<CustomData> CUSTOM_DATA = declare("custom_data", CustomData.NETWORK_TYPE, CustomData.NBT_TYPE);
    ItemComponent<Integer> MAX_STACK_SIZE = declare("max_stack_size", NetworkBuffer.VAR_INT, BinaryTagSerializer.INT);
    ItemComponent<Integer> MAX_DAMAGE = declare("max_damage", NetworkBuffer.VAR_INT, BinaryTagSerializer.INT);
    ItemComponent<Integer> DAMAGE = declare("damage", NetworkBuffer.VAR_INT, BinaryTagSerializer.INT);
    ItemComponent<Unbreakable> UNBREAKABLE = declare("unbreakable", Unbreakable.NETWORK_TYPE, Unbreakable.NBT_TYPE);
    ItemComponent<Component> CUSTOM_NAME = declare("custom_name", NetworkBuffer.COMPONENT, BinaryTagSerializer.JSON_COMPONENT);
    ItemComponent<Component> ITEM_NAME = declare("item_name", NetworkBuffer.COMPONENT, BinaryTagSerializer.JSON_COMPONENT);
    ItemComponent<List<Component>> LORE = declare("lore", NetworkBuffer.COMPONENT.list(256), BinaryTagSerializer.JSON_COMPONENT.list());
    ItemComponent<ItemRarity> RARITY = declare("rarity", ItemRarity.NETWORK_TYPE, ItemRarity.NBT_TYPE);
    ItemComponent<EnchantmentList> ENCHANTMENTS = declare("enchantments", EnchantmentList.NETWORK_TYPE, EnchantmentList.NBT_TYPE);
    ItemComponent<BlockPredicates> CAN_PLACE_ON = declare("can_place_on", BlockPredicates.NETWORK_TYPE, BlockPredicates.NBT_TYPE);
    ItemComponent<BlockPredicates> CAN_BREAK = declare("can_break", BlockPredicates.NETWORK_TYPE, BlockPredicates.NBT_TYPE);
    ItemComponent<AttributeList> ATTRIBUTE_MODIFIERS = declare("attribute_modifiers", AttributeList.NETWORK_TYPE, AttributeList.NBT_TYPE);
    ItemComponent<Integer> CUSTOM_MODEL_DATA = declare("custom_model_data", NetworkBuffer.VAR_INT, BinaryTagSerializer.INT);
    ItemComponent<Void> HIDE_ADDITIONAL_TOOLTIP = declare("hide_additional_tooltip", NetworkBuffer.NOTHING, BinaryTagSerializer.NOTHING);
    ItemComponent<Void> HIDE_TOOLTIP = declare("hide_tooltip", NetworkBuffer.NOTHING, BinaryTagSerializer.NOTHING);
    ItemComponent<Integer> REPAIR_COST = declare("repair_cost", NetworkBuffer.VAR_INT, BinaryTagSerializer.INT);
    ItemComponent<Void> CREATIVE_SLOT_LOCK = declare("creative_slot_lock", NetworkBuffer.NOTHING, null);
    ItemComponent<Boolean> ENCHANTMENT_GLINT_OVERRIDE = declare("enchantment_glint_override", NetworkBuffer.BOOLEAN, BinaryTagSerializer.BOOLEAN);
    ItemComponent<Void> INTANGIBLE_PROJECTILE = declare("intangible_projectile", null, BinaryTagSerializer.NOTHING);
    ItemComponent<Food> FOOD = declare("food", Food.NETWORK_TYPE, Food.NBT_TYPE);
    ItemComponent<Void> FIRE_RESISTANT = declare("fire_resistant", NetworkBuffer.NOTHING, BinaryTagSerializer.NOTHING);
    ItemComponent<Tool> TOOL = declare("tool", Tool.NETWORK_TYPE, Tool.NBT_TYPE);
    ItemComponent<EnchantmentList> STORED_ENCHANTMENTS = declare("stored_enchantments", EnchantmentList.NETWORK_TYPE, EnchantmentList.NBT_TYPE);
    ItemComponent<DyedItemColor> DYED_COLOR = declare("dyed_color", DyedItemColor.NETWORK_TYPE, DyedItemColor.NBT_TYPE);
    ItemComponent<Color> MAP_COLOR = declare("map_color", NetworkBuffer.COLOR, BinaryTagSerializer.INT.map(Color::new, Color::asRGB));
    ItemComponent<Integer> MAP_ID = declare("map_id", NetworkBuffer.VAR_INT, BinaryTagSerializer.INT);
    ItemComponent<MapDecorations> MAP_DECORATIONS = declare("map_decorations", null, MapDecorations.NBT_TYPE);
    ItemComponent<MapPostProcessing> MAP_POST_PROCESSING = declare("map_post_processing", MapPostProcessing.NETWORK_TYPE, null);
    ItemComponent<List<ItemStack>> CHARGED_PROJECTILES = declare("charged_projectiles", ItemStack.NETWORK_TYPE.list(Short.MAX_VALUE), BinaryTagSerializer.ITEM.list());
    ItemComponent<List<ItemStack>> BUNDLE_CONTENTS = declare("bundle_contents", ItemStack.NETWORK_TYPE.list(Short.MAX_VALUE), BinaryTagSerializer.ITEM.list());
    ItemComponent<PotionContents> POTION_CONTENTS = declare("potion_contents", PotionContents.NETWORK_TYPE, PotionContents.NBT_TYPE);
    ItemComponent<SuspiciousStewEffects> SUSPICIOUS_STEW_EFFECTS = declare("suspicious_stew_effects", SuspiciousStewEffects.NETWORK_TYPE, SuspiciousStewEffects.NBT_TYPE);
    ItemComponent<WritableBookContent> WRITABLE_BOOK_CONTENT = declare("writable_book_content", WritableBookContent.NETWORK_TYPE, WritableBookContent.NBT_TYPE);
    ItemComponent<WrittenBookContent> WRITTEN_BOOK_CONTENT = declare("written_book_content", WrittenBookContent.NETWORK_TYPE, WrittenBookContent.NBT_TYPE);
    ItemComponent<ArmorTrim> TRIM = declare("trim", ArmorTrim.NETWORK_TYPE, ArmorTrim.NBT_TYPE);
    ItemComponent<DebugStickState> DEBUG_STICK_STATE = declare("debug_stick_state", null, DebugStickState.NBT_TYPE);
    ItemComponent<CustomData> ENTITY_DATA = declare("entity_data", CustomData.NETWORK_TYPE, CustomData.NBT_TYPE);
    ItemComponent<CustomData> BUCKET_ENTITY_DATA = declare("bucket_entity_data", CustomData.NETWORK_TYPE, CustomData.NBT_TYPE);
    ItemComponent<CustomData> BLOCK_ENTITY_DATA = declare("block_entity_data", CustomData.NETWORK_TYPE, CustomData.NBT_TYPE);
    ItemComponent<String> INSTRUMENT = declare("instrument", NetworkBuffer.STRING, BinaryTagSerializer.STRING);
    ItemComponent<Integer> OMINOUS_BOTTLE_AMPLIFIER = declare("ominous_bottle_amplifier", NetworkBuffer.VAR_INT, BinaryTagSerializer.INT);
    ItemComponent<List<String>> RECIPES = declare("recipes", NetworkBuffer.STRING.list(Short.MAX_VALUE), BinaryTagSerializer.STRING.list());
    ItemComponent<LodestoneTracker> LODESTONE_TRACKER = declare("lodestone_tracker", LodestoneTracker.NETWORK_TYPE, LodestoneTracker.NBT_TYPE);
    ItemComponent<FireworkExplosion> FIREWORK_EXPLOSION = declare("firework_explosion", FireworkExplosion.NETWORK_TYPE, FireworkExplosion.NBT_TYPE);
    ItemComponent<FireworkList> FIREWORKS = declare("fireworks", FireworkList.NETWORK_TYPE, FireworkList.NBT_TYPE);
    ItemComponent<HeadProfile> PROFILE = declare("profile", HeadProfile.NETWORK_TYPE, HeadProfile.NBT_TYPE);
    ItemComponent<String> NOTE_BLOCK_SOUND = declare("note_block_sound", NetworkBuffer.STRING, BinaryTagSerializer.STRING);
    ItemComponent<Void> BANNER_PATTERNS = declare("banner_patterns", null, null); //todo
    ItemComponent<DyeColor> BASE_COLOR = declare("base_color", DyeColor.NETWORK_TYPE, DyeColor.NBT_TYPE);
    ItemComponent<PotDecorations> POT_DECORATIONS = declare("pot_decorations", PotDecorations.NETWORK_TYPE, PotDecorations.NBT_TYPE);
    ItemComponent<List<ItemStack>> CONTAINER = declare("container", ItemStack.NETWORK_TYPE.list(256), BinaryTagSerializer.ITEM.list());
    ItemComponent<ItemBlockState> BLOCK_STATE = declare("block_state", ItemBlockState.NETWORK_TYPE, ItemBlockState.NBT_TYPE);
    ItemComponent<List<Bee>> BEES = declare("bees", Bee.NETWORK_TYPE.list(Short.MAX_VALUE), Bee.NBT_TYPE.list());
    ItemComponent<String> LOCK = declare("lock", null, BinaryTagSerializer.STRING);
    ItemComponent<SeededContainerLoot> CONTAINER_LOOT = declare("container_loot", null, SeededContainerLoot.NBT_TYPE);

    @NotNull T read(@NotNull BinaryTag tag);
    @NotNull BinaryTag write(@NotNull T value);

    @NotNull T read(@NotNull NetworkBuffer reader);
    void write(@NotNull NetworkBuffer writer, @NotNull T value);


    static @Nullable ItemComponent<?> fromNamespaceId(@NotNull String namespaceId) {
        return ItemComponentImpl.NAMESPACES.get(namespaceId);
    }

    static @Nullable ItemComponent<?> fromNamespaceId(@NotNull NamespaceID namespaceId) {
        return fromNamespaceId(namespaceId.asString());
    }

    static @Nullable ItemComponent<?> fromId(int id) {
        return ItemComponentImpl.IDS.get(id);
    }
}