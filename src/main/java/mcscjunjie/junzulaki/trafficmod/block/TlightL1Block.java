
package mcscjunjie.junzulaki.trafficmod.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class TlightL1Block extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public TlightL1Block() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).mapColor(MapColor.TERRACOTTA_WHITE).sound(SoundType.STONE).strength(10f, 100f).requiresCorrectToolForDrops().noOcclusion()
				.isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(-16, 5, 6, 16, 6, 10), box(-16, 15, 6, 16, 16, 10), box(-16, 5, 6, -15, 16, 10), box(11, 5, 6, 12, 16, 10), box(-15, 6, 7, 11, 15, 9));
			case NORTH -> Shapes.or(box(0, 5, 6, 32, 6, 10), box(0, 15, 6, 32, 16, 10), box(31, 5, 6, 32, 16, 10), box(4, 5, 6, 5, 16, 10), box(5, 6, 7, 31, 15, 9));
			case EAST -> Shapes.or(box(6, 5, 0, 10, 6, 32), box(6, 15, 0, 10, 16, 32), box(6, 5, 31, 10, 16, 32), box(6, 5, 4, 10, 16, 5), box(7, 6, 5, 9, 15, 31));
			case WEST -> Shapes.or(box(6, 5, -16, 10, 6, 16), box(6, 15, -16, 10, 16, 16), box(6, 5, -16, 10, 16, -15), box(6, 5, 11, 10, 16, 12), box(7, 6, -15, 9, 15, 11));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}
}
