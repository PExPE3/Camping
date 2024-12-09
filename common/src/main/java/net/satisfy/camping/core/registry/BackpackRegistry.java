package net.satisfy.camping.core.registry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.item.Item;
import net.satisfy.camping.client.model.*;

import java.util.HashMap;
import java.util.Map;

public class BackpackRegistry {
    private static final Map<Item, BackpackModel> models = new HashMap<>();

    public static Model getBodyModel(Item item, ModelPart baseBody) {
        EntityModelSet modelSet = Minecraft.getInstance().getEntityModels();
        BackpackModel model = models.computeIfAbsent(item, key -> {
            if (key == ObjectRegistry.SMALL_BACKPACK_ITEM.get()) {
                return new SmallBackpackModel<>(modelSet.bakeLayer(SmallBackpackModel.LAYER_LOCATION));
            } else if (key == ObjectRegistry.LARGE_BACKPACK_ITEM.get()) {
                return new LargeBackpackModel<>(modelSet.bakeLayer(LargeBackpackModel.LAYER_LOCATION));
            } else if (key == ObjectRegistry.WANDERER_BACKPACK_ITEM.get()) {
                return new WandererBackpackModel<>(modelSet.bakeLayer(WandererBackpackModel.LAYER_LOCATION));
            } else if (key == ObjectRegistry.WANDERER_BAG_ITEM.get()) {
                return new WandererBagModel<>(modelSet.bakeLayer(WandererBagModel.LAYER_LOCATION));
            } else if (key == ObjectRegistry.GOODYBAG_ITEM.get()) {
                return new GoodybagModel<>(modelSet.bakeLayer(GoodybagModel.LAYER_LOCATION));
            } else if (key == ObjectRegistry.SHEEPBAG_ITEM.get()) {
                return new SheepbagModel<>(modelSet.bakeLayer(SheepbagModel.LAYER_LOCATION));
            } else if (key == ObjectRegistry.ENDERPACK_ITEM.get()) {
                return new EnderpackModel<>(modelSet.bakeLayer(EnderpackModel.LAYER_LOCATION));
            } else if (key == ObjectRegistry.ENDERBAG_ITEM.get()) {
                return new EnderbagModel<>(modelSet.bakeLayer(EnderbagModel.LAYER_LOCATION));
            } else {
                return null;
            }
        });

        assert model != null;
        model.copyBody(baseBody);

        return (Model) model;
    }
}
