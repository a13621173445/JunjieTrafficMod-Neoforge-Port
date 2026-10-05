package mcscjunjie.junzulaki.trafficmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import mcscjunjie.junzulaki.trafficmod.world.inventory.ExpwySeditMenu;
import mcscjunjie.junzulaki.trafficmod.TextEngine;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ExpwySeditScreen extends AbstractContainerScreen<ExpwySeditMenu> {
	private final static HashMap<String, Object> guistate = ExpwySeditMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox firstline;
	EditBox secondline;
	EditBox province;
	Button button_edit;

	public ExpwySeditScreen(ExpwySeditMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 213;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		firstline.render(guiGraphics, mouseX, mouseY, partialTicks);
		secondline.render(guiGraphics, mouseX, mouseY, partialTicks);
		province.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (firstline.isFocused())
			return firstline.keyPressed(key, b, c);
		if (secondline.isFocused())
			return secondline.keyPressed(key, b, c);
		if (province.isFocused())
			return province.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		firstline.tick();
		secondline.tick();
		province.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.expwy_sedit.label_sign_text_edit"), 7, 8, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.expwy_sedit.label_expwy_number"), 7, 26, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.expwy_sedit.label_expwy_name"), 7, 80, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.expwy_sedit.label_province"), 7, 134, -1, false);
	}

	@Override
	public void init() {
		super.init();
		firstline = new EditBox(this.font, this.leftPos + 8, this.topPos + 45, 160, 18, Component.translatable("gui.junjietrafficmod.expwy_sedit.firstline")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.junjietrafficmod.expwy_sedit.firstline").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.junjietrafficmod.expwy_sedit.firstline").getString());
				else
					setSuggestion(null);
			}
		};
		firstline.setSuggestion(Component.translatable("gui.junjietrafficmod.expwy_sedit.firstline").getString());
		firstline.setMaxLength(32767);
		guistate.put("text:firstline", firstline);
		this.addWidget(this.firstline);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 1, firstline);
		secondline = new EditBox(this.font, this.leftPos + 8, this.topPos + 99, 160, 18, Component.translatable("gui.junjietrafficmod.expwy_sedit.secondline")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.junjietrafficmod.expwy_sedit.secondline").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.junjietrafficmod.expwy_sedit.secondline").getString());
				else
					setSuggestion(null);
			}
		};
		secondline.setSuggestion(Component.translatable("gui.junjietrafficmod.expwy_sedit.secondline").getString());
		secondline.setMaxLength(32767);
		guistate.put("text:secondline", secondline);
		this.addWidget(this.secondline);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 2, secondline);
		province = new EditBox(this.font, this.leftPos + 8, this.topPos + 153, 160, 18, Component.translatable("gui.junjietrafficmod.expwy_sedit.province"));
		province.setMaxLength(32767);
		guistate.put("text:province", province);
		this.addWidget(this.province);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 3, province);
		button_edit = Button.builder(Component.translatable("gui.junjietrafficmod.expwy_sedit.button_edit"), e -> {
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 1, firstline.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 2, secondline.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 3, province.getValue());
			this.minecraft.player.closeContainer();
		}).bounds(this.leftPos + 7, this.topPos + 188, 73, 20).build();
		guistate.put("button:button_edit", button_edit);
		this.addRenderableWidget(button_edit);
	}
}
