import React, { FC } from 'react';
import { IGame } from '../../models/IGame';
import { Link } from 'react-router-dom';
import { GamePrice } from '../games/game/GamePrice';
import { XMarkIcon } from '@heroicons/react/20/solid';
import { useAppDispatch, useAppSelector } from '../../hooks/redux';
import { deleteCartGame, fetchCartGames } from '../../store/actions/cartAction';

interface CartGameCardProps {
    game: IGame;
}

export const CartGameCard: FC<CartGameCardProps> = ({ game }) => {
    const dispatch = useAppDispatch();
    const { games } = useAppSelector((state) => state.cart);
    const { userId } = useAppSelector((state) => state.auth);
    const deleteFromCart = async () => {
        await dispatch(deleteCartGame({ games, gameToDelete: game, userId }));
        dispatch(fetchCartGames({ userId }));
    };
    return (
        <div className="flex md:px-2 py-4 border-slate-600/50">
            <Link
                to={`/games/${game.name}`}
                className="w-40 min-w-[100px] overflow-hidden rounded-lg flex justify-center bg-gray-200 mr-4 p-2 dark:bg-slate-800"
            >
                <img src={game.base64Image} />
            </Link>
            <div className="flex justify-between w-full">
                <div className="flex flex-col justify-between">
                    <div className="flex flex-col">
                        <div className="text-xl">{game.name}</div>
                        <div className="opacity-50 text-sm">
                            {game.releaseDate}
                        </div>
                    </div>
                    <div className="flex items-center">
                        <GamePrice
                            price={game.price}
                            discount={game.discount}
                        />
                    </div>
                </div>
                <XMarkIcon
                    className="w-6 h-6 cursor-pointer"
                    onClick={deleteFromCart}
                />
            </div>
        </div>
    );
};
