import React, {useEffect} from 'react';
import GamesCategory from "../components/GamesCategory";
import MainLayout from "../components/layouts/MainLayout";
import {useAppDispatch, useAppSelector} from "../hooks/redux";
import {fetchGames} from "../store/actions/gameAction";

const Games = () => {
    const {games, isLoading, error} = useAppSelector(state => state.game)
    const dispatch = useAppDispatch()
    useEffect(() => {
        dispatch(fetchGames())
    }, [])
    if(isLoading) return <h1>Идёт загрузка</h1>
    if(error) return <h1>{error}</h1>
    return (
        <MainLayout>
            <GamesCategory title={"Популярные"} games={games}/>
            <GamesCategory title={"Распродажа"} games={games}/>
            <GamesCategory title={"Новинки"} games={games}/>
        </MainLayout>
    );
};

export default Games;