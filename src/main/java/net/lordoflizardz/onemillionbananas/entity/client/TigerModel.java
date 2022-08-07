package net.lordoflizardz.onemillionbananas.entity.client;

import net.lordoflizardz.onemillionbananas.OneMillionBananas;
import net.lordoflizardz.onemillionbananas.entity.custom.TigerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TigerModel extends AnimatedGeoModel<TigerEntity> {
    @Override
    public ResourceLocation getModelLocation(TigerEntity entity)	{
        return new ResourceLocation(OneMillionBananas.MOD_ID, "geo/tiger.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(TigerEntity entity) {
        return new ResourceLocation(OneMillionBananas.MOD_ID, "textures/entity/tiger/tiger.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(TigerEntity entity)	{
        return new ResourceLocation(OneMillionBananas.MOD_ID, "animations/tiger.animation.json");
    }
}