package com.chess.engine.Piece;

import java.util.ArrayList;
import java.util.List;

import com.chess.engine.Alliance.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.ChessTile;
import com.chess.engine.board.Move;

/*
 * The move locations for the knight are based on legal numberical changes in position.
 * We find the legal moves using the move list created and we allow our piece to see those moves.
 */

public class Knight extends Piece {

	private static int[] CANDIDATE_MOVE_LOCATIONS = {-17, -15,-10,-6,6,10,15,17};
	
	Knight(final int pieceLocation,final Alliance pieceAlliance) 
	{
		super(pieceLocation, pieceAlliance);
	}
	
	@Override
	public List<Move> findLegalMoves( Board board)
	{
		int candidateDestinationLocation;
		List<Move> legalMoves= new ArrayList<>();
		for(final int curentLocation : CANDIDATE_MOVE_LOCATIONS)
		{
			candidateDestinationLocation=this.pieceLocation + curentLocation;
			
			if(true)
			{
				final ChessTile candidateDestinationTile=board.getTile(candidateDestinationLocation);
				if(!candidateDestinationTile.isTileOpen())
				{
					legalMoves.add(new Move());
				}
			}
		}
			
		
		return null;
		
	}

}
