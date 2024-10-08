package fartsol.insanitycraft.renderer;

import org.lwjgl.opengl.GL11;

import fartsol.insanitycraft.tileentity.RotatingTileEntity;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class RotatingTileEntityRenderer extends TileEntitySpecialRenderer<RotatingTileEntity>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation("insanitycraft:textures/blocks/kebab_grill.png");

    @Override
    public void render(RotatingTileEntity te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y + 0.5, z + 0.5);
        float angle = (System.currentTimeMillis() % 3600) / 10.f;
        GL11.glRotatef(angle, 0.f, 1.f, 0.f);
        bindTexture(TEXTURE);
        renderModel();
        GL11.glPopMatrix();
    }

    private void renderModel()
    {
        GL11.glBegin(GL11.GL_QUADS);

        GL11.glVertex3f(-0.5f, -0.5f, -0.5f);
        GL11.glVertex3f(-0.5f, 0.5f, -0.5f);
        GL11.glVertex3f(0.5f, 0.5f, -0.5f);
        GL11.glVertex3f(0.5f, -0.5f, -0.5f);

        GL11.glEnd();
    }
}
