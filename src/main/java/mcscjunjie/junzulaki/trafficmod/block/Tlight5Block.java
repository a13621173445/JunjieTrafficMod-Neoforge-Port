
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

public class Tlight5Block extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public Tlight5Block() {
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
			default -> Shapes.or(box(1, 0, 6, 2, 5, 10), box(14, 0, 6, 15, 5, 10), box(15, 15, 6, 16, 16, 10), box(0, 5, 6, 1, 6, 10), box(0, 15, 6, 1, 16, 10), box(15, 5, 6, 16, 6, 10), box(1, 5, 6, 15, 16, 10));
			case NORTH -> Shapes.or(box(14, 0, 6, 15, 5, 10), box(1, 0, 6, 2, 5, 10), box(0, 15, 6, 1, 16, 10), box(15, 5, 6, 16, 6, 10), box(15, 15, 6, 16, 16, 10), box(0, 5, 6, 1, 6, 10), box(1, 5, 6, 15, 16, 10));
			case EAST -> Shapes.or(box(6, 0, 14, 10, 5, 15), box(6, 0, 1, 10, 5, 2), box(6, 15, 0, 10, 16, 1), box(6, 5, 15, 10, 6, 16), box(6, 15, 15, 10, 16, 16), box(6, 5, 0, 10, 6, 1), box(6, 5, 1, 10, 16, 15));
			case WEST -> Shapes.or(box(6, 0, 1, 10, 5, 2), box(6, 0, 14, 10, 5, 15), box(6, 15, 15, 10, 16, 16), box(6, 5, 0, 10, 6, 1), box(6, 15, 0, 10, 16, 1), box(6, 5, 15, 10, 6, 16), box(6, 5, 1, 10, 16, 15));
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
