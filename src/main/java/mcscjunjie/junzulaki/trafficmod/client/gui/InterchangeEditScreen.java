package mcscjunjie.junzulaki.trafficmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import mcscjunjie.junzulaki.trafficmod.world.inventory.InterchangeEditMenu;
import mcscjunjie.junzulaki.trafficmod.TextEngine;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class InterchangeEditScreen extends AbstractContainerScreen<InterchangeEditMenu> {
	private final static HashMap<String, Object> guistate = InterchangeEditMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox inter1km;
	Button button_edit;

	public InterchangeEditScreen(InterchangeEditMenu container, Inventory inventory, Component text) {
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
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		inter1km.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (inter1km.isFocused())
			return inter1km.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		inter1km.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.interchange_edit.label_sign_text_edit"), 8, 7, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.interchange_edit.label_exit_number"), 8, 25, -1, false);
	}

	@Override
	public void init() {
		super.init();
		inter1km = new EditBox(this.font, this.leftPos + 10, this.topPos + 41, 158, 18, Component.translatable("gui.junjietrafficmod.interchange_edit.inter1km")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.junjietrafficmod.interchange_edit.inter1km").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.junjietrafficmod.interchange_edit.inter1km").getString());
				else
					setSuggestion(null);
			}
		};
		inter1km.setSuggestion(Component.translatable("gui.junjietrafficmod.interchange_edit.inter1km").getString());
		inter1km.setMaxLength(32767);
		TextEngine.prefillEditBox(this.x, this.y, this.z, inter1km);
		guistate.put("text:inter1km", inter1km);
		this.addWidget(this.inter1km);
		button_edit = Button.builder(Component.translatable("gui.junjietrafficmod.interchange_edit.button_edit"), e -> {
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, inter1km.getValue());
			this.minecraft.player.closeContainer();
		}).bounds(this.leftPos + 9, this.topPos + 70, 72, 20).build();
		guistate.put("button:button_edit", button_edit);
		this.addRenderableWidget(button_edit);
	}
}
