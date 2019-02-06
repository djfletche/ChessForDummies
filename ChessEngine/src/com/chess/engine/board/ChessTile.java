package com.chess.engine.board;

import java.util.HashMap;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

import com.chess.engine.Piece.*;

public abstract class ChessTile {

	protected final int tileLocation;
	
	private static final Map<Integer,EmptyTile> EMPTY_TILES = createAllEmptyTiles();
	
	private static Map<Integer, EmptyTile> createAllEmptyTiles()

	{
		final Map<Integer,EmptyTile> emptyTileMap = new HashMap<>();
		
			for (int i=0;i<64;i++)
			{
			emptyTileMap.put(i, new EmptyTile(i));
			}
			return ImmutableMap.copyOf(emptyTileMap);
		}
	
public static ChessTile createTile(final int tileLocation,Piece piece){
		return piece!=null ? new TakenTile(tileLocation,piece) : EMPTY_TILES.get(tileLocation);
		
	}
	
	private ChessTile(int tileLocation)
	{
		this.tileLocation= tileLocation;
	}
	
	public abstract boolean isTileOpen();
	
	public abstract Piece getPiece();
	
	public static final class EmptyTile extends  ChessTile
	{
		EmptyTile(final int tileLocation)
		{
			super(tileLocation);
		}
		@Override
		public boolean isTileOpen(){
			return false;
		}
		@Override
		public Piece getPiece(){
			return null;
		}
		
	}
	public static final class TakenTile extends ChessTile
	{
		private final Piece ontheTile;
		
		TakenTile(int tileLocation,Piece ontheTile) {
			super(tileLocation);
			// TODO Auto-generated constructor stub
			this.ontheTile=ontheTile;
		}
		@Override
		public boolean isTileOpen(){
			return true;
		}
		@Override
		public Piece getPiece(){
			return this.ontheTile;
		}
		

	}
}
