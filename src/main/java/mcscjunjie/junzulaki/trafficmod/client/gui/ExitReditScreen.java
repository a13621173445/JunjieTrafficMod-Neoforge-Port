package mcscjunjie.junzulaki.trafficmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import mcscjunjie.junzulaki.trafficmod.world.inventory.ExitReditMenu;
import mcscjunjie.junzulaki.trafficmod.TextEngine;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ExitReditScreen extends AbstractContainerScreen<ExitReditMenu> {
	private final static HashMap<String, Object> guistate = ExitReditMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox exportname;
	EditBox roadname;
	Button button_edit;

	public ExitReditScreen(ExitReditMenu container, Inventory inventory, Component text) {
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
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		exportname.render(guiGraphics, mouseX, mouseY, partialTicks);
		roadname.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (exportname.isFocused())
			return exportname.keyPressed(key, b, c);
		if (roadname.isFocused())
			return roadname.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.exit_redit.label_sign_text_edit"), 9, 8, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.exit_redit.label_export_name"), 9, 78, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.exit_redit.label_road_name"), 9, 25, -1, false);
	}

	@Override
	public void init() {
		super.init();
		exportname = new EditBox(this.font, this.leftPos + 10, this.topPos + 98, 155, 18, Component.translatable("gui.junjietrafficmod.exit_redit.exportname")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.junjietrafficmod.exit_redit.exportname").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean updateCursorCounter) {
				super.moveCursorTo(pos, updateCursorCounter);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.junjietrafficmod.exit_redit.exportname").getString());
				else
					setSuggestion(null);
			}
		};
		exportname.setSuggestion(Component.translatable("gui.junjietrafficmod.exit_redit.exportname").getString());
		exportname.setMaxLength(32767);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 2, exportname);
		guistate.put("text:exportname", exportname);
		this.addWidget(this.exportname);
		roadname = new EditBox(this.font, this.leftPos + 10, this.topPos + 44, 155, 18, Component.translatable("gui.junjietrafficmod.exit_redit.roadname")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.junjietrafficmod.exit_redit.roadname").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean updateCursorCounter) {
				super.moveCursorTo(pos, updateCursorCounter);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.junjietrafficmod.exit_redit.roadname").getString());
				else
					setSuggestion(null);
			}
		};
		roadname.setSuggestion(Component.translatable("gui.junjietrafficmod.exit_redit.roadname").getString());
		roadname.setMaxLength(32767);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 1, roadname);
		guistate.put("text:roadname", roadname);
		this.addWidget(this.roadname);
		button_edit = Button.builder(Component.translatable("gui.junjietrafficmod.exit_redit.button_edit"), e -> {
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 1, roadname.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 2, exportname.getValue());
			this.minecraft.player.closeContainer();
		}).bounds(this.leftPos + 9, this.topPos + 128, 73, 20).build();
		guistate.put("button:button_edit", button_edit);
		this.addRenderableWidget(button_edit);
	}
}
