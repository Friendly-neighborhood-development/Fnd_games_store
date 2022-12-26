import React, {FC, memo, useEffect} from 'react';
import GameCard from "./GameCard";
import {useAppDispatch, useAppSelector} from "../hooks/redux";


const GamesList: FC = memo(() => {
    const {games, isLoading, error} = useAppSelector(state => state.game)
    const dispatch = useAppDispatch()
    useEffect(() => {
        // TODO
    }, []);

    if (!games.length)
        return (
            <h1>Произошла ошибка при подгрузке игр, повторите позже</h1>
        )

    return (
        <section className={"w-full my-4"}>
            {error
                ? <h1>Ошибка: {error}</h1>
                : <div
                    className={"flex space-x-2 w-full overflow-x-auto lg:flex-none lg:space-x-0 lg:overflow-x-visible lg:grid lg:gap-x-4 lg:grid-cols-3 lg:gap-y-4 xl:grid-cols-4"}>
                    {games.map(game =>
                        <GameCard
                            {...game}
                            key={game.id}
                            skeleton={isLoading}
                        />)}
                </div>
            }
        </section>
    );
})

export default GamesList;