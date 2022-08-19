package net.lordoflizardz.onemillionbananas.entity.client.armor;

import net.lordoflizardz.onemillionbananas.OneMillionBananas;
import net.lordoflizardz.onemillionbananas.item.custom.CobaltArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CobaltArmorModel extends AnimatedGeoModel<CobaltArmorItem> {
    @Override
    public ResourceLocation getModelLocation(CobaltArmorItem object) {
        return new ResourceLocation(OneMillionBananas.MOD_ID, "geo/cobalt_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(CobaltArmorItem object) {
        return new ResourceLocation(OneMillionBananas.MOD_ID, "textures/models/armor/cobalt_armor_texture.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CobaltArmorItem animatable) {
        return new ResourceLocation(OneMillionBananas.MOD_ID, "animations/armor_animation.json");
    }
}
