/*
 * The FML Forge Mod Loader suite.
 * Copyright (C) 2012 cpw
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 */

package cpw.mods.fml.client;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.ModMetadata;
import net.minecraft.client.Minecraft;
import net.minecraft.src.GuiLanguage;
import net.minecraft.src.GuiSlot;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.Tessellator;

/**
 * @author cpw
 *
 */
public class GuiSlotModList extends GuiScrollingList
{
    private GuiModList parent;

    public GuiSlotModList(GuiModList parent)
    {
        super(parent.getMinecraftInstance(), 120, parent.field_950_d, 32, parent.field_950_d - 65 + 4, 10, 18);
        this.parent=parent;
    }

    @Override
    protected int getSize()
    {
        return Loader.getModList().size();
    }

    @Override
    protected void elementClicked(int var1, boolean var2)
    {
        this.parent.selectModIndex(var1);
    }

    @Override
    protected boolean isSelected(int var1)
    {
        return this.parent.modIndexSelected(var1);
    }

    @Override
    protected void drawBackground()
    {
        this.parent.func_578_i();
    }

    @Override
    protected int getContentHeight()
    {
        return this.getSize() * 3 * (this.parent.getFontRenderer().field_41063_b +1);
    }
    
    @Override
    protected void drawSlot(int listIndex, int var2, int var3, int var4, Tessellator var5)
    {
        ModContainer mc=Loader.getModList().get(listIndex);
        ModMetadata meta=mc.getMetadata();
        this.parent.func_547_b(this.parent.getFontRenderer(), mc.getName(), this.left+3, var3 + 3, 16777215);
    }

}