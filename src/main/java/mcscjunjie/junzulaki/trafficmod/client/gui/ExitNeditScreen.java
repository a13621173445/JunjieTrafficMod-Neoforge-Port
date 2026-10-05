package mcscjunjie.junzulaki.trafficmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import mcscjunjie.junzulaki.trafficmod.world.inventory.ExitNeditMenu;
import mcscjunjie.junzulaki.trafficmod.TextEngine;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ExitNeditScreen extends AbstractContainerScreen<ExitNeditMenu> {
	private final static HashMap<String, Object> guistate = ExitNeditMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox firstline;
	EditBox secondline;
	Button button_edit;

	public ExitNeditScreen(ExitNeditMenu container, Inventory inventory, Component text) {
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
		firstline.render(guiGraphics, mouseX, mouseY, partialTicks);
		secondline.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		firstline.tick();
		secondline.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.exit_nedit.label_sign_text_edit"), 9, 8, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.exit_nedit.label_first_line"), 9, 25, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.exit_nedit.label_second_line"), 9, 78, -1, false);
	}

	@Override
	public void init() {
		super.init();
		firstline = new EditBox(this.font, this.leftPos + 10, this.topPos + 43, 155, 18, Component.translatable("gui.junjietrafficmod.exit_nedit.firstline")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.junjietrafficmod.exit_nedit.firstline").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.junjietrafficmod.exit_nedit.firstline").getString());
				else
					setSuggestion(null);
			}
		};
		firstline.setSuggestion(Component.translatable("gui.junjietrafficmod.exit_nedit.firstline").getString());
		firstline.setMaxLength(32767);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 3, firstline);
		guistate.put("text:firstline", firstline);
		this.addWidget(this.firstline);
		secondline = new EditBox(this.font, this.leftPos + 10, this.topPos + 97, 155, 18, Component.translatable("gui.junjietrafficmod.exit_nedit.secondline")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.junjietrafficmod.exit_nedit.secondline").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.junjietrafficmod.exit_nedit.secondline").getString());
				else
					setSuggestion(null);
			}
		};
		secondline.setSuggestion(Component.translatable("gui.junjietrafficmod.exit_nedit.secondline").getString());
		secondline.setMaxLength(32767);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 4, secondline);
		guistate.put("text:secondline", secondline);
		this.addWidget(this.secondline);
		button_edit = Button.builder(Component.translatable("gui.junjietrafficmod.exit_nedit.button_edit"), e -> {
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 3, firstline.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 4, secondline.getValue());
			this.minecraft.player.closeContainer();
		}).bounds(this.leftPos + 9, this.topPos + 128, 73, 20).build();
		guistate.put("button:button_edit", button_edit);
		this.addRenderableWidget(button_edit);
	}
}
