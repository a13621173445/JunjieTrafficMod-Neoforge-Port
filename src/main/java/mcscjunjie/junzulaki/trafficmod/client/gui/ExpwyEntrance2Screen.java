package mcscjunjie.junzulaki.trafficmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import mcscjunjie.junzulaki.trafficmod.world.inventory.ExpwyEntrance2Menu;
import mcscjunjie.junzulaki.trafficmod.TextEngine;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ExpwyEntrance2Screen extends AbstractContainerScreen<ExpwyEntrance2Menu> {
	private final static HashMap<String, Object> guistate = ExpwyEntrance2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox stardandend;
	Button button_edit;

	public ExpwyEntrance2Screen(ExpwyEntrance2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 98;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		stardandend.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (stardandend.isFocused())
			return stardandend.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.expwy_entrance_2.label_sign_text_edit"), 10, 7, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.expwy_entrance_2.label_start_end"), 9, 24, -1, false);
	}

	@Override
	public void init() {
		super.init();
		stardandend = new EditBox(this.font, this.leftPos + 10, this.topPos + 41, 158, 18, Component.translatable("gui.junjietrafficmod.expwy_entrance_2.stardandend"));
		stardandend.setMaxLength(32767);
		guistate.put("text:stardandend", stardandend);
		this.addWidget(this.stardandend);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 1, stardandend);
		button_edit = Button.builder(Component.translatable("gui.junjietrafficmod.expwy_entrance_2.button_edit"), e -> {
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 1, stardandend.getValue());
			this.minecraft.player.closeContainer();
		}).bounds(this.leftPos + 9, this.topPos + 70, 72, 20).build();
		guistate.put("button:button_edit", button_edit);
		this.addRenderableWidget(button_edit);
	}
}
