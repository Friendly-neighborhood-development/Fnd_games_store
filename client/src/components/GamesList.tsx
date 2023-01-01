import React, {FC, memo, useEffect} from 'react';
import GameCard from "./GameCard";
import {useAppDispatch, useAppSelector} from "../hooks/redux";
import {fetchGames} from "../store/actions/gamesAction";
import {useNavigate} from "react-router-dom";
import Sidebar from "./Sidebar";
import {GamesFilter} from "./GamesFilter";
import {defaultFilterTitles} from "../constants/filter";


const GamesList: FC = memo(() => {
    const {games, loading, error} = useAppSelector(state => state.games)
    const navigate = useNavigate()
    const dispatch = useAppDispatch()
    useEffect(() => {
        dispatch(fetchGames(defaultFilterTitles))
    }, []);

    if (loading === "failed")
        navigate("/error")

    return (
        <section className={"w-full my-4"}>
            {games.length !== 0 &&
                <Sidebar>
                    <GamesFilter/>
                </Sidebar>
            }
            <div className={"lg:ml-64"}>
                <div className={""}>
                    <div className={"text-xl mb-2"}>Games</div>
                    <div className={"lg:hidden"}>filter</div>
                </div>
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
            </div>
        </section>
    );
})

export default GamesList;