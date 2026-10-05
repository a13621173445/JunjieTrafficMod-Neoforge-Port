package mcscjunjie.junzulaki.trafficmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import mcscjunjie.junzulaki.trafficmod.world.inventory.PlaceReportMenu;
import mcscjunjie.junzulaki.trafficmod.TextEngine;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class PlaceReportScreen extends AbstractContainerScreen<PlaceReportMenu> {
	private final static HashMap<String, Object> guistate = PlaceReportMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox placea;
	EditBox placebname;
	EditBox placecname;
	EditBox distancea;
	EditBox distanceb;
	EditBox distancec;
	Button button_edit;

	public PlaceReportScreen(PlaceReportMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 250;
		this.imageHeight = 213;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		placea.render(guiGraphics, mouseX, mouseY, partialTicks);
		placebname.render(guiGraphics, mouseX, mouseY, partialTicks);
		placecname.render(guiGraphics, mouseX, mouseY, partialTicks);
		distancea.render(guiGraphics, mouseX, mouseY, partialTicks);
		distanceb.render(guiGraphics, mouseX, mouseY, partialTicks);
		distancec.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (placea.isFocused())
			return placea.keyPressed(key, b, c);
		if (placebname.isFocused())
			return placebname.keyPressed(key, b, c);
		if (placecname.isFocused())
			return placecname.keyPressed(key, b, c);
		if (distancea.isFocused())
			return distancea.keyPressed(key, b, c);
		if (distanceb.isFocused())
			return distanceb.keyPressed(key, b, c);
		if (distancec.isFocused())
			return distancec.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		placea.tick();
		placebname.tick();
		placecname.tick();
		distancea.tick();
		distanceb.tick();
		distancec.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.place_report.label_sign_text_edit"), 8, 7, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.place_report.label_place_a"), 8, 28, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.place_report.label_place_b"), 8, 81, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.place_report.label_place_c"), 8, 133, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.place_report.label_distance"), 129, 28, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.place_report.label_distance1"), 129, 81, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.junjietrafficmod.place_report.label_distance2"), 129, 134, -1, false);
	}

	@Override
	public void init() {
		super.init();
		placea = new EditBox(this.font, this.leftPos + 9, this.topPos + 48, 110, 18, Component.translatable("gui.junjietrafficmod.place_report.placea"));
		placea.setMaxLength(32767);
		guistate.put("text:placea", placea);
		this.addWidget(this.placea);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 1, placea);
		placebname = new EditBox(this.font, this.leftPos + 9, this.topPos + 100, 110, 18, Component.translatable("gui.junjietrafficmod.place_report.placebname"));
		placebname.setMaxLength(32767);
		guistate.put("text:placebname", placebname);
		this.addWidget(this.placebname);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 2, placebname);
		placecname = new EditBox(this.font, this.leftPos + 9, this.topPos + 152, 110, 18, Component.translatable("gui.junjietrafficmod.place_report.placecname"));
		placecname.setMaxLength(32767);
		guistate.put("text:placecname", placecname);
		this.addWidget(this.placecname);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 3, placecname);
		distancea = new EditBox(this.font, this.leftPos + 130, this.topPos + 48, 110, 18, Component.translatable("gui.junjietrafficmod.place_report.distancea"));
		distancea.setMaxLength(32767);
		guistate.put("text:distancea", distancea);
		this.addWidget(this.distancea);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 4, distancea);
		distanceb = new EditBox(this.font, this.leftPos + 130, this.topPos + 100, 109, 18, Component.translatable("gui.junjietrafficmod.place_report.distanceb"));
		distanceb.setMaxLength(32767);
		guistate.put("text:distanceb", distanceb);
		this.addWidget(this.distanceb);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 5, distanceb);
		distancec = new EditBox(this.font, this.leftPos + 129, this.topPos + 152, 109, 18, Component.translatable("gui.junjietrafficmod.place_report.distancec"));
		distancec.setMaxLength(32767);
		guistate.put("text:distancec", distancec);
		this.addWidget(this.distancec);
		TextEngine.prefillEditBox(this.x, this.y, this.z, 6, distancec);
		button_edit = Button.builder(Component.translatable("gui.junjietrafficmod.place_report.button_edit"), e -> {
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 1, placea.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 2, placebname.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 3, placecname.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 4, distancea.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 5, distanceb.getValue());
			TextEngine.onEditButtonPressed(this.x, this.y, this.z, 6, distancec.getValue());
			this.minecraft.player.closeContainer();
		}).bounds(this.leftPos + 8, this.topPos + 186, 73, 20).build();
		guistate.put("button:button_edit", button_edit);
		this.addRenderableWidget(button_edit);
	}
}
