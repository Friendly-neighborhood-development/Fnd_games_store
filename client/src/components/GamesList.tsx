import React, {FC, memo, useEffect} from 'react';
import GameCard from "./GameCard";
import {useAppDispatch, useAppSelector} from "../hooks/redux";
import {fetchGames} from "../store/actions/gamesAction";
import {useNavigate} from "react-router-dom";


const GamesList: FC = memo(() => {
    const {games, loading, error} = useAppSelector(state => state.game)
    const navigate = useNavigate()
    const dispatch = useAppDispatch()
    useEffect(() => {
        dispatch(fetchGames({page: 0, pageSize: 6, sortField: "name", ascOrder: true}))
        if (loading === "failed")
            navigate("/error")
    }, []);


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
                            skeleton={loading === "succeeded"}
                        />)}
                </div>
            }
        </section>
    );
})

export default GamesList;