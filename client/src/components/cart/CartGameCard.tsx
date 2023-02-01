import React, { FC, useState } from 'react';
import { IGame } from '../../models/IGame';
import { Link } from 'react-router-dom';
import { GamePrice } from '../games/game/GamePrice';
import { XMarkIcon } from '@heroicons/react/20/solid';
import { useAppDispatch, useAppSelector } from '../../hooks/redux';
import { deleteCartGame, fetchCartGames } from '../../store/actions/cartAction';
import { CheckIcon } from '@heroicons/react/24/outline';
import { selectGame, unselectGame } from '../../store/reducers/cartSlice';

interface CartGameCardProps {
    game: IGame;
    selected: boolean;
}

export const CartGameCard: FC<CartGameCardProps> = ({ game, selected }) => {
    const dispatch = useAppDispatch();
    const { games } = useAppSelector((state) => state.cart);
    const { userId } = useAppSelector((state) => state.auth);
    const deleteFromCart = async () => {
        await dispatch(deleteCartGame({ games, gameToDelete: game, userId }));
        dispatch(fetchCartGames({ userId }));
    };
    const selectGameHandler = () => {
        selected ? dispatch(unselectGame(game)) : dispatch(selectGame(game));
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
                <div className="flex flex-col justify-between items-end">
                    <div
                        className="w-6 h-6 border cursor-pointer rounded p-0.5 border-gray-800 bg-gray-50 hover:bg-gray-200/10 dark:border-slate-400/50 dark:bg-slate-800 dark:hover:bg-slate-700/80"
                        onClick={selectGameHandler}
                    >
                        {selected && <CheckIcon className="w-full h-full" />}
                    </div>
                    <div
                        className="flex space-x-2 cursor-pointer text-sm items-end hover:opacity-80"
                        onClick={deleteFromCart}
                    >
                        Remove
                        <XMarkIcon className="w-5 h-5" />
                    </div>
                </div>
            </div>
        </div>
    );
};
