package mcscjunjie.junzulaki.trafficmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import mcscjunjie.junzulaki.trafficmod.world.inventory.GantryExpwyGEditMenu;
import mcscjunjie.junzulaki.trafficmod.TextEngine;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class GantryExpwyGEditScreen extends AbstractContainerScreen<GantryExpwyGEditMenu> {
	private final static HashMap<String, Object> guistate = GantryExpwyGEditMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox expwynumber;
	EditBox expwyname;
	Button button_edit;

	public GantryExpwyGEditScreen(GantryExpwyGEditMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 156;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		expwynumber.render(guiGraphics, mouseX, mouseY, partialTicks);
		expwyname.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (expwynumber.isFocused())
			return expwynumber.keyPressed(key, b, c);
		if (expwyname.isFocused())
			return expwyname.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		expwynumber.tick();
		expwyname.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.gantry_expwy_g_edit.label_sign_text_edit"), 9, 8, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.gantry_expwy_g_edit.label_expwy_number"), 9, 27, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.gantry_expwy_g_edit.label_expwy_name"), 9, 77, -1, false);
	}

	@Override
	public void init() {
		super.init();
		expwynumber = new EditBox(this.font, this.leftPos + 10, this.topPos + 46, 155, 18, Component.translatable("gui.junjietrafficmod.gantry_expwy_g_edit.expwynumber"));
		expwynumber.setMaxLength(32767);
		guistate.put("text:expwynumber", expwynumber);
		this.addWidget(this.expwynumber);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 1, expwynumber);
		expwyname = new EditBox(this.font, this.leftPos + 10, this.topPos + 96, 155, 18, Component.translatable("gui.junjietrafficmod.gantry_expwy_g_edit.expwyname"));
		expwyname.setMaxLength(32767);
		guistate.put("text:expwyname", expwyname);
		this.addWidget(this.expwyname);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 2, expwyname);
		button_edit = Button.builder(Component.translatable("gui.junjietrafficmod.gantry_expwy_g_edit.button_edit"), e -> {
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 1, expwynumber.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 2, expwyname.getValue());
			this.minecraft.player.closeContainer();
		}).bounds(this.leftPos + 9, this.topPos + 128, 73, 20).build();
		guistate.put("button:button_edit", button_edit);
		this.addRenderableWidget(button_edit);
	}
}
